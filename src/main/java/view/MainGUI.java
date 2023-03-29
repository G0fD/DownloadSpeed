package view;

import calculate.Calculate;
import calculate.ICalculate;
import entity.HistoriaEntity;
import entity.PredkosciEntity;
import entity.RozmiarEntity;
import org.hibernate.service.spi.ServiceException;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;

public class MainGUI {
    private JPanel mainPanel;
    private JTextField sizeTextField;
    private JComboBox fileSizeComboBox;
    private JTextField speedTextField;
    private JComboBox speedUnitsComboBox;
    private JButton executeButton;
    private JTextArea resultTextArea;
    private static MainGUI form;

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public MainGUI() {
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date date;
                ICalculate calc = new Calculate();
                EntityManagerFactory fac = Persistence.createEntityManagerFactory("default");
                EntityManager man = fac.createEntityManager();
                EntityTransaction tr = man.getTransaction();
                String tmp = "s";
                try {
                    String sizeVal=sizeTextField.getText();
                    String speedVal = speedTextField.getText();
                    String from = fileSizeComboBox.getSelectedItem().toString();
                    String to = speedUnitsComboBox.getSelectedItem().toString();
                    if (Double.parseDouble(sizeVal)<=0 || Double.parseDouble(speedVal)<=0){
                        throw new NumberFormatException("");
                    }
                    double result = calc.calculate(Double.parseDouble(sizeVal), from, Double.parseDouble(speedVal), to);
                    resultTextArea.setText("Pobranie pliku "+sizeVal+from+" przy prędkości "+speedVal+to+" zajmie "+result+" sekund");
                    if((result/60)>1) {
                        result = result/60;
                        result = round(result,2);
                        tmp="min";
                        resultTextArea.setText(resultTextArea.getText() + "\n" + "odpowiada to " + result+ " minut");
                        if ((result/60)>1){
                            result = result/60;
                            result = round(result,2);
                            tmp="h";
                            resultTextArea.setText(resultTextArea.getText() + "\n" + "odpowiada to " + result+ " godzin");
                            if((result/24)>1){
                                result = result/24;
                                result = round(result,2);
                                tmp="dni";
                                resultTextArea.setText(resultTextArea.getText() + "\n" + "odpowiada to " + result+ " dni");
                            }
                        }
                    }
                    tr.begin();
                    HistoriaEntity logi = new HistoriaEntity();
                    logi.sethRozmiar(Double.parseDouble(sizeVal));
                    logi.sethRozmiarJednostka(from);
                    logi.sethPredkosc(Double.parseDouble(speedVal));
                    logi.sethPredkoscJednostka(to);
                    logi.sethCzas(String.valueOf(result)+tmp);
                    date = new java.util.Date();
                    logi.sethData(new Timestamp(date.getTime()));
                    man.persist(logi);
                    tr.commit();
                }catch (IllegalStateException | ServiceException exception){
                    JOptionPane.showMessageDialog(null,"Brak połączenia z bazą danych");
                } catch (NullPointerException exception){
                    JOptionPane.showMessageDialog(null, "Nie znaleziono jednostki do przeliczenia, sprawdź połączenie");
                } catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Błędna liczba");
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Stało się coś czego nie przewidziałem");
                } finally {
                    if(tr.isActive())tr.rollback();
                    man.close();
                    fac.close();
                }
            }
        });
    }

    public static void initForm(MainGUI frm){
        frm.fileSizeComboBox.setMinimumSize(new Dimension(100,10));
        frm.speedUnitsComboBox.setMinimumSize(new Dimension(100,10));
        int i =0;
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("default");
        EntityManager man = fac.createEntityManager();
        EntityTransaction tr = man.getTransaction();

        try{
            tr.begin();

            TypedQuery<RozmiarEntity> rozmiar = man.createNamedQuery("jednostkirozmiar",RozmiarEntity.class);
            for(RozmiarEntity r:rozmiar.getResultList()){
                frm.fileSizeComboBox.addItem(r);
            }
            TypedQuery<PredkosciEntity> predkosc = man.createNamedQuery("jednostkipredkosc", PredkosciEntity.class);
            for(PredkosciEntity p:predkosc.getResultList()){
                frm.speedUnitsComboBox.addItem(p);
            }

            tr.commit();
        }finally {
            if(tr.isActive())tr.rollback();
            man.close();
            fac.close();
        }
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Sprawdź czas pobierania");
        form = new MainGUI();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200,500);
        mainFrame.setVisible(true);
        initForm(form);
    }
}
