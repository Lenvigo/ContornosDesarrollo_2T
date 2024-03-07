
import java.util.Random;
import java.util.Scanner;

public class VocalesConsonantes {

    //boletin1; Temas 3 a 5 Programacion en Java

    public static void main(String[] args) {
        System.out.println("EJERCICIO: realiza un programa que genere letras aleatoriamente y determine si son consonantes");

        //generar un numero de letras aleatorias:
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el numero de letras aletorias que quiere generar: ");
        int letrasGeneradas=sc.nextInt();

        //definicion de las letras del alfabeto
        String alfabeto="abcdefghijklmnopqrstuvwxyz";

        //generar las letras y determinar si son consonantes:
        for (int i = 0; i < letrasGeneradas ; i++) {
           char letraAleatoria=generarLetras(alfabeto);
            System.out.println("la letra generada: "+ letraAleatoria);

                if (esConsonante(letraAleatoria)){
                    System.out.println("Es una consonante.");
                }else{
                    System.out.println("Es una vocal.");
                }
        }

    }

    //metodo para generar una letra aleatoria
  public static char generarLetras(String alfabeto){
        Random random= new Random();

        //generar un indice aleatorio entre 0-25 (numero letras alfabeto sin la nh)
        int indice= random.nextInt(alfabeto.length());

        //obtenemos la letra
        return alfabeto.charAt(indice);
    }

    //metodo para determinar si la letra es consonante
    public static boolean esConsonante (char letra){

        //convertir letra a minuscula para simplificar verificacion
       letra=Character.toLowerCase(letra);

       //verificar si la letra es consonante
       return letra>= 'a' && letra <= 'z'&& !"aeiou".contains(String.valueOf(letra));
    }




}