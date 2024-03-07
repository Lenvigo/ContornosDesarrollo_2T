import java.util.Arrays;
import java.util.Scanner;

public class LuckyNumber {

    public static void main (String[] args) {

        System.out.println("Se desea conocer el lucky number (numero de la suerte) de cualquier persona.\n" +
                "El numero de la suerte se consigue reduciendo la fecha de nacimiento a un numero de un solo\n" +
                "digito!");

        Scanner sc = new Scanner(System.in);

        // Solicitar la fecha de nacimiento
        System.out.println("Introduce tu fecha de nacimiento separada por guiones: ");
        String fechaNacimiento = sc.next();

        // Calcular el número de la suerte
        int numeroSuerte = calcularNumeroSuerte(fechaNacimiento);

        //Mostrar el resultado
        System.out.println("Tu numero de la suerte es : " + numeroSuerte);
    }
 public static int calcularNumeroSuerte (String fecha){

        //eliminar lo guiones y convertir la array a caracteres
char [] caracteresFecha=fecha.replace("-","").toCharArray();

// inicializamos suma
     int suma=0;

     //sumar los digitos de la fecha
     for (char c: caracteresFecha){
         suma+=Character.getNumericValue(c);
     }

     //reducimos el numero a un solo digito
     while (suma>9){
         suma=suma%10+suma/10;
     }
     //recuperamos el valor de la variable
     return suma;
 }


    }


