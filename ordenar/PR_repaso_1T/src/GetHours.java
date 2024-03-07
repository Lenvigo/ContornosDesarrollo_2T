import java.util.Scanner;

public class GetHours {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("-------Inicio programa--------");

   int  HORAS = 3600;
   int MINUTOS = 60;

        System.out.println("Ingrese la cantidad de segundos que quiere convertir:  ");

    int segundosIntroducidos = sc.nextInt();
    int horitas = segundosIntroducidos / HORAS;
    int minutitos = segundosIntroducidos / MINUTOS - (horitas * 60);
    int segunditos = segundosIntroducidos - (minutitos * 60) - (horitas * 3600);


  System.out.println("El resultado de los segundos introducidos: "+segundosIntroducidos +" es de: "+horitas +
            " hora/s, "+minutitos+" minuto/s y  "+segunditos+" segundo/s.");


        System.out.println("-------Fin programa--------");}


}
