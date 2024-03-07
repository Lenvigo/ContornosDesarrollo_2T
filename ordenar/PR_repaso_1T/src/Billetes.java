import java.util.Arrays;

public class Billetes {
    public static void main(String[] args) {
        //declaracion de variables
        int[] bills = {500, 200, 100, 50, 20, 10, 5};
        int dinero = 190;
        int[] resultado = convertCoinsToBills(bills, dinero);

        //Impresion resultado en Array
        System.out.println(Arrays.toString(resultado));

        //Impresion del resultado por lineas
        for (int i = 0; i < resultado.length; i++) {
            System.out.println("Billetes de  " + bills[i] + " : " + resultado[i]);
        }
    }

    // declaracion de la funcion que vamos a usar
    public static int[] convertCoinsToBills(int[] bills, int coins) {

        int[] coinToBill = new int[bills.length];

        for (int i = 0; i < bills.length; i++) {
            //  int suma=0;
            coinToBill[i] = coins / bills[i];
            coins = coins % bills[i];

        }return coinToBill;
    }


}
