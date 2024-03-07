public class UltimoRepaso {
    public static void main(String[] args) {
        System.out.println("Ultimo Repaso!");
    }

    /*
    getMinColumNum(int[][] matrix) : return int[]
    Esta función recibo como argumento una matriz. Se debe devolver el número más pequeño de cada
    columna.
    Tiempo: 35 min
    */

    public static int []  getMinColumNum(int[][] matrix) {

       int [] minColumNum= new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int minNumCol= Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]<minNumCol){
                    minColumNum[j]=matrix[i][j];}
            }

        }return minColumNum;



    }

    /*
    getMaxNums(int[][] matrix) : return int[]
	Esta función recibe como parámetro una matriz. Debe devolver todos los números mayores de 10 que
	contenta la matriz. Recuerda que primero debes saber cuantos elementos debes devolver para crear
	el array que debes devolver con la longitud correcta.
	Tiempo: 40 min
	*/




    /* getMax(int[] array) : return int
	Dado un array unidimensional, devolver el número mayor.
	Tiempo: 20 min
	*/

    public static int getMax(int[] array) {

        int mayor=0;
        /*for (int i = 0; i < array.length; i++) {
            if (array[i]>mayor){mayor=array[i];}
                    }return mayor;*/

        for (int j : array) {
            if (j > mayor) {
                mayor = j;
            }
        }
        return mayor;
    }

}
