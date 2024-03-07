package edu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLetterTable {

    private final LetterTable letterTable = LetterTable.getInstance();

    @Test
    public void testGetLetter() {
        assertEquals('T', letterTable.getLetter(0));
        assertEquals('N', letterTable.getLetter(12));
        assertEquals('E', letterTable.getLetter(22));
    }

    @Test
    public void testInvalidRemainder() {
        assertThrows(IllegalArgumentException.class, () -> letterTable.getLetter(-1));
        assertThrows(IllegalArgumentException.class, () -> letterTable.getLetter(23));
    }
}

