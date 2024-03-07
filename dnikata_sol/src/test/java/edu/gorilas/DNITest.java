package edu.gorilas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DNITest {

    @Test
    public void DNIgetLetter() {
        DNI[] dni = {
                new DNI(65730448), // J
                new DNI(44080194), // G
                new DNI(42552650), // M
        };
        assertEquals(Character.toLowerCase('J'), Character.toLowerCase(dni[0].getLetter()));
        assertEquals(Character.toLowerCase('G'), Character.toLowerCase(dni[1].getLetter()));
        assertEquals(Character.toLowerCase('M'), Character.toLowerCase(dni[2].getLetter()));

    }
}
