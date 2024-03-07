package edu.gorilas;

import java.util.AbstractMap;
import java.util.Map;

public class MapLetterCalculator implements DNILetterCalculator {

    private static final Map<Integer, Character> LETTER_MAP = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(0, 'T'),
            new AbstractMap.SimpleEntry<>(1, 'R'),
            new AbstractMap.SimpleEntry<>(2, 'W'),
            new AbstractMap.SimpleEntry<>(3, 'A'),
            new AbstractMap.SimpleEntry<>(4, 'G'),
            new AbstractMap.SimpleEntry<>(5, 'M'),
            new AbstractMap.SimpleEntry<>(6, 'Y'),
            new AbstractMap.SimpleEntry<>(7, 'F'),
            new AbstractMap.SimpleEntry<>(8, 'P'),
            new AbstractMap.SimpleEntry<>(9, 'D'),
            new AbstractMap.SimpleEntry<>(10, 'X'),
            new AbstractMap.SimpleEntry<>(11, 'B'),
            new AbstractMap.SimpleEntry<>(12, 'N'),
            new AbstractMap.SimpleEntry<>(13, 'J'),
            new AbstractMap.SimpleEntry<>(14, 'Z'),
            new AbstractMap.SimpleEntry<>(15, 'S'),
            new AbstractMap.SimpleEntry<>(16, 'Q'),
            new AbstractMap.SimpleEntry<>(17, 'V'),
            new AbstractMap.SimpleEntry<>(18, 'H'),
            new AbstractMap.SimpleEntry<>(19, 'L'),
            new AbstractMap.SimpleEntry<>(20, 'C'),
            new AbstractMap.SimpleEntry<>(21, 'K'),
            new AbstractMap.SimpleEntry<>(22, 'E'));

    @Override
    public char getLetter(int dni) {
        int index = dni % NUM_LETRAS;
        return LETTER_MAP.get(index);
    }

}
