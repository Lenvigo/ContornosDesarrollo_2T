package edu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Crear una instancia de LetterTable
        LetterTable letterTable = LetterTable.getInstance();

        // Crear una instancia de DniValidator
        DniValidator validator = new DniValidator();

        // Crear una instancia de DniCalculator
        DniCalculator calculator = new DniCalculator(validator, letterTable);

        Scanner scanner = new Scanner(System.in);
        long dniNumber;
        Dni dni;


        // Calcular el DNI completo
        try {
            System.out.print("Ingrese el numero de DNI: ");
            dniNumber = scanner.nextLong();
            dni = calculator.calculateDni(dniNumber);
            System.out.println("Numero de DNI: " + dni.getNumber());
            System.out.println("Letra del DNI: " + dni.getLetter());

        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("El formato del numero de DNI no es valido." + e.getMessage());
        } finally{
                        System.out.println("Fin programa!");
                }

        }
}
