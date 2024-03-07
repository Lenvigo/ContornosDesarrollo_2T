import java.util.Scanner;

public class ArmstrongNumber {




    public static void main(String[] args) {
        System.out.println("--------Numero Armstrong------- ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero que deseas comprobar: ");
        int numeroIntroducido = sc.nextInt();
      /* if (isArmstrongNumber(numeroIntroducido)==true){
           System.out.println("El numero introducido es un numero Armstrong");
       }else{
           System.out.println("El numero introducido  no cumple los resquisitos exigidos para ser un numero Armstrong");
       }*/
        System.out.println(isArmstrongNumber(numeroIntroducido));
    }


    public static int longitudNumero (int numeroIntroducido){
        String numeroString=Integer.toString(numeroIntroducido);
       int longitud=numeroString.length();
       return longitud;
    }

   public static boolean isArmstrongNumber(int numeroIntroducido){
int numero=numeroIntroducido;
        int longitud= longitudNumero(numero);
int suma=0;
      while (numero!=0){
          int digito=numero%10;
          suma+=Math.pow(digito,longitud);
          numero/=10;
      }

        return suma==numeroIntroducido;
    }
}


