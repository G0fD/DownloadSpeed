package calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ICalculateTest {
    ICalculate calc = new Calculate();

    @Test
    void calculateTest() {
        assertEquals(8.0, calc.calculate(1.0,"B",1.0,"b/s"));
        assertEquals(1.0, calc.calculate(1.0,"B",1.0,"B/s"));
        assertEquals(8.0, calc.calculate(1.0,"KB",1.0,"Kb/s"));
        assertEquals(1.0, calc.calculate(1.0,"KB",1.0,"KB/s"));
        assertEquals(8.0, calc.calculate(1.0,"MB",1.0,"Mb/s"));
        assertEquals(1.0, calc.calculate(360,"MB",360,"MB/s"));
        assertEquals(8.0, calc.calculate(1.0,"GB",1.0,"Gb/s"));
        assertEquals(1.0, calc.calculate(1.0,"GB",1.0,"GB/s"));
        assertEquals(80,calc.calculate(1,"KB",0.1,"Kb/s"));
        assertEquals(80,calc.calculate(1,"GB",0.1,"Gb/s"));
        assertEquals(60.0, calc.calculate(60,"B",1.0,"B/s"));
        assertEquals(0.5, calc.calculate(0.5,"B",1,"B/s"));
        assertEquals(0.25, calc.calculate(0.5,"B",2,"B/s"));
    }

    @Test
    void itShouldThrowNumberFormatException(){
        assertThrows(NumberFormatException.class, ()->{
            calc.calculate(Double.parseDouble("a"),"b",1.0,"B/S");
            calc.calculate(1.0,"B",Double.parseDouble("a"),"b/s");
            calc.calculate(-1,"B",1,"b/s");
            calc.calculate(1,"B",-1,"b/s");
            calc.calculate(0,"B",1,"b/s");
            calc.calculate(1,"B",0,"b/s");
        });
    }
}