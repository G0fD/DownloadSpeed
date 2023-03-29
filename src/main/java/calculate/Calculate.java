package calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate implements ICalculate{
    private enum enumSize{
        B(1e-6),KB(0.001),MB(1), GB(1000), TB(1000000);
        private double value;
        private enumSize(double value){this.value=value;}
        public double toDouble(){return value;}
    }

    private enum enumSpeed{
        bs(8000000), Bs(1000000),Kbs(8000),KBs(1000),Mbs(8),MBs(1),Gbs(0.008),GBs(0.001),Tbs(1e-6),TBs(8e-6);
        private double value;
        private enumSpeed(double value){this.value=value;}
        public double toDouble(){return value;}
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public double calculate(double size, String sizeUnit, double speed, String speedUnit) {
        double result = 0;
        try {
            if (size<=0 || speed<=0){
                throw new NumberFormatException("");
            }
            String[] tmp = speedUnit.split("/");
            speedUnit = tmp[0] + tmp[1];
            double xn1 = enumSize.valueOf(sizeUnit).toDouble();
            double xn2 = enumSpeed.valueOf(speedUnit).toDouble();
            result = ((size * xn1) / speed) * xn2;
            result=round(result,2);
        }catch (NumberFormatException ex){
            //ignore
        }
        return result;
    }

}
