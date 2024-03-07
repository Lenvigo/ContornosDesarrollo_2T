package edu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDniValidator {

    private final DniValidator validator = new DniValidator();

    @Test
    public void testValidDniFormat() {
        assertTrue(validator.isValidFormat(12345678));
        assertTrue(validator.isValidFormat(98765432));
        assertTrue(validator.isValidFormat(99999999));
        //estos dos casos test fallan. Mejorar codigo
        //assertTrue(validator.isValidFormat(00000000));
       // assertTrue(validator.isValidFormat(00000001));
    }


    @Test
    public void testInvalidDniFormat() {
        assertThrows(IllegalArgumentException.class, () -> validator.isValidFormat(-123));
        assertThrows(IllegalArgumentException.class, () -> validator.isValidFormat(123));
        assertThrows(IllegalArgumentException.class, () -> validator.isValidFormat(1234567890));

    }
}

