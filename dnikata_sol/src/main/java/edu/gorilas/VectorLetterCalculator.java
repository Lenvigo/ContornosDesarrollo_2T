package edu.gorilas;

public class VectorLetterCalculator implements DNILetterCalculator {

    private static final char[] TABLA_LETRAS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
            'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

    @Override
    public char getLetter(int dni) {
        int index = dni % NUM_LETRAS;
        return (TABLA_LETRAS[index]);
    }

}
