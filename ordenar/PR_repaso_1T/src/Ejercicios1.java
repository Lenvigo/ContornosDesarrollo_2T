import java.util.Scanner;
// ESTE EJERCICIO DE PROGRAMACION ESTA INCOMPLETO
public class Ejercicios1 {

    public static final int NUMERO_DE_REPETICIONES = 10;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        //declaramos un valor de variable constante


        // pedimos los numeros por pantalla
        Scanner sc = new Scanner(System.in);
        int []numeros = new int[NUMERO_DE_REPETICIONES];
        for (int i = 0; i < NUMERO_DE_REPETICIONES; i++) {
            System.out.println("Introduce el numero  de la posicion: " + (i + 1));

            numeros [i]= sc.nextInt();
        }
       // System.out.println(cambiarNumeros(numeros));



    }
    // funcion sin terminar
    /*public static int [] cambiarNumeros(int [] numbers){
    int resultado[]= new int[NUMERO_DE_REPETICIONES];
        for (int i = 0; i < NUMERO_DE_REPETICIONES; i++) {
         //resultado= resultado.replace(numbers[i],numbers[i+1]) ;

        }
    }*/


}

