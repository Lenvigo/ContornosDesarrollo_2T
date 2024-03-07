package edu;
//clase encargada del objeto DNI numero-letra;
public class Dni {

    private final long number;
    private final char letter;

    public Dni(long number, char letter) {
        this.number = number;
        this.letter = letter;
    }

    public long getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return String.format("%d-%c", number, letter);
    }
}
