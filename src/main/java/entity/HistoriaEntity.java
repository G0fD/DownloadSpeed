package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "historia", schema = "java", catalog = "")
public class HistoriaEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "h_id")
    private int hId;
    @Basic
    @Column(name = "h_rozmiar")
    private double hRozmiar;
    @Basic
    @Column(name = "h_rozmiar_jednostka")
    private String hRozmiarJednostka;
    @Basic
    @Column(name = "h_predkosc")
    private double hPredkosc;
    @Basic
    @Column(name = "h_predkosc_jednostka")
    private String hPredkoscJednostka;
    @Basic
    @Column(name = "h_czas")
    private String hCzas;
    @Basic
    @Column(name = "h_data")
    private Timestamp hData;

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public double gethRozmiar() {
        return hRozmiar;
    }

    public void sethRozmiar(double hRozmiar) {
        this.hRozmiar = hRozmiar;
    }

    public String gethRozmiarJednostka() {
        return hRozmiarJednostka;
    }

    public void sethRozmiarJednostka(String hRozmiarJednostka) {
        this.hRozmiarJednostka = hRozmiarJednostka;
    }

    public double gethPredkosc() {
        return hPredkosc;
    }

    public void sethPredkosc(double hPredkosc) {
        this.hPredkosc = hPredkosc;
    }

    public String gethPredkoscJednostka() {
        return hPredkoscJednostka;
    }

    public void sethPredkoscJednostka(String hPredkoscJednostka) {
        this.hPredkoscJednostka = hPredkoscJednostka;
    }

    public String gethCzas() {
        return hCzas;
    }

    public void sethCzas(String hCzas) {
        this.hCzas = hCzas;
    }

    public Timestamp gethData() {
        return hData;
    }

    public void sethData(Timestamp hData) {
        this.hData = hData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaEntity that = (HistoriaEntity) o;
        return hId == that.hId && Double.compare(that.hRozmiar, hRozmiar) == 0 && Double.compare(that.hPredkosc, hPredkosc) == 0 && Objects.equals(hRozmiarJednostka, that.hRozmiarJednostka) && Objects.equals(hPredkoscJednostka, that.hPredkoscJednostka) && Objects.equals(hCzas, that.hCzas) && Objects.equals(hData, that.hData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hId, hRozmiar, hRozmiarJednostka, hPredkosc, hPredkoscJednostka, hCzas, hData);
    }
}
