public class Repaso {
    public static void main(String[] args) {

        System.out.println("Boletin repaso");
    }

    /*
    *Método countContainWords(String[] phrases, String words) : return int
	* Este método se le pasa un array de frases y una palabra. Tiene que devolver el número
	* de frases que contiene esa palabra.
	* Tiempo realizacion  max 20 minutos // real: 10 min
    * */
     public static  int  countContainWords(String[] phrases, String words){
          int contador=0;
         /*for (int i = 0; i < phrases.length; i++) { if (phrases[i].contains(words))contador++;}*/
         /* podriamos tener en cuenta la complicacion que supondrian mayusculas y minusculas convirtiendo ambas Strings en minusculas
         con el metodo ToString toLowerCase
            String palabraEnMinusculas = words.toLowerCase();
            String fraseEnMinusculas = phrase.toLowerCase();
          */

         for (String phrase : phrases) if (phrase.contains(words)) contador++;
       return contador;
     }

        /*
            Método getFinalNum(int num, double percentage) : return double
	* Este método recibe como parámetro un número y un porcentaje. El método tiene que devolver un número que será el porcentaje del número dado.
	* Si al realizar la operación el número es inferior a 1000 pero mayor que 100, el número se divide entre 3.
	* Si al realizar la operación el número es inferior a 100 pero mayor que 10, se deja tal cual.
	* Si al realizar la operación el número es menor que 10, se multiplica por 3.
	* Tiempo realizacion max 35 min // real: 24 min
        */
    public static double getFinalNum(int num, double percentage){
        double operacion= num*percentage/100;
        if (operacion < 1000 && operacion > 100) {
            operacion = (operacion / 3);
        } else
            if (operacion < 10) {
                operacion = (operacion * 3);
        }
        return operacion;
    }

    /*
        Método getFirstRow(int[][] matrix, int columns) return int[]
	* Este método se le pasa como parámetro una matriz y el número de columnas que va a tener.
	* Tiene que devolver la primera fila en un array.
	* El número de columnas nos dice que longitud tendrá el array que debemos devolver.
	* Tiempo maximo: 30 min// Real: 20.
     */
    public static int [] getFirstRow(int[][] matrix, int columns){


        int [] firstRow= new int[columns];

        for (int i = 0; i <columns ; i++) {
            firstRow[i]=matrix[0][i];
        }return firstRow;
    }

}
