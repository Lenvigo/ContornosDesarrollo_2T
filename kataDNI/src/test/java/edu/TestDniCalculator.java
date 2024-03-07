package edu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDniCalculator {

    private final DniValidator validator = new DniValidator();
    private final LetterTable letterTable = LetterTable.getInstance();
    private final DniCalculator calculator = new DniCalculator(validator, letterTable);

    @Test
    public void testValidDni() {
        // Verifica si el cálculo de la letra para números de DNI válidos es correcto
        assertEquals('Z', calculator.calculateDni(12345678).getLetter());
        assertEquals('M', calculator.calculateDni(98765432).getLetter());
        //assertEquals('T', calculator.calculateDni(00000000).getLetter());
    }

    @Test
    public void testInvalidDniFormat() {

       assertThrows(IllegalArgumentException.class, () -> calculator.calculateDni(-123));
    }
}


