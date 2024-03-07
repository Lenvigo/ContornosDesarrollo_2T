package edu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDni {

    @Test
    public void testDniCreation() {
        // Verifica si la creación de un DNI es correcta
        Dni dni = new Dni(12345678, 'Z');
        assertEquals(12345678, dni.getNumber());
        assertEquals('Z', dni.getLetter());
    }

    @Test
    public void testDniToString() {
        // Verifica si el método toString() devuelve el formato esperado
        Dni dni = new Dni(98765432, 'M');
        assertEquals("98765432-M", dni.toString());
    }
}

