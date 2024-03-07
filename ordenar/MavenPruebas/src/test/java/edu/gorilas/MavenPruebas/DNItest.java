package edu.gorilas.MavenPruebas;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


public class DNItest {

    @Test
    public void test1CalcularLetraDNI() {
        assertEquals('Z',DNI.calcularLetraDNI(12345678));
    }
    @Test
    public void test2CalcularLetraDNI() {
        assertEquals('T',DNI.calcularLetraDNI(00000000));
    }
}
