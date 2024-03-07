package edu;
// clase que gestiona la cadena de letras de dni españoles.

/*Principio de responsabilidad única (SRP):
 La clase DniCalculator se encarga de calcular la letra del DNI,
 mientras que la clase LetterTable se encarga de almacenar y gestionar la cadena de letras.
 Esto cumple con el SRP al separar las responsabilidades en dos clases diferentes.
 */
 /* Principio de apertura-cerrado (OCP):
 La clase LetterTable encapsula la cadena de letras y la lógica de acceso a la misma.
  Esto permite modificar la cadena de letras sin necesidad de modificar la clase DniCalculator.
  */
/* singleton: patrón de diseño utilizado en POO. El término “singleton” proviene del inglés y significa “único”.
Veamos los detalles:
¿Qué es un singleton?
El patrón singleton se utiliza para diseñar clases que solo pueden ser instanciadas una vez. En otras palabras, de una clase dada,
durante toda la ejecución del programa, únicamente se puede crear un objeto.
Esto garantiza que la instancia de la clase sea globalmente accesible.
Para lograrlo, se impide que los usuarios creen nuevas instancias declarando el constructor como privado. Solo el código dentro del singleton puede instanciarlo.
En resumen, el singleton asegura que una clase tenga exactamente una copia y proporciona un punto de acceso global a ella12.
Características principales del patrón singleton:
El patrón garantiza que solo permanezca con una instancia única.
Diferentes lenguajes de programación ofrecen diferentes métodos para lograr esto, pero el enfoque general es evitar que los usuarios creen nuevas instancias1.*/
public class LetterTable {

    private final char[] LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray();

    // Singleton instance
    private static final LetterTable INSTANCE = new LetterTable();

    private LetterTable() {
        //constructor privado para evitar que se cree una instancia adicional de LetterTable
    }


    public static LetterTable getInstance() {
        // El método getInstance() devuelve siempre la misma instancia de LetterTable
        return INSTANCE;
    }


    public char getLetter(int remainder) {
        if (remainder < 0 || remainder >= LETTERS.length) {
            throw new IllegalArgumentException("Invalid remainder: " + remainder);
        }
        return LETTERS[remainder];
    }
}
