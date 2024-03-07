public class Ejercicios2 {
    public static void main(String[] args) {
    }
    /*
    Crea una función que sea checkWordLength(String word) que devuelva la longitud de cada palabra que se le envíe como parámetro.
    */
    public static int checkWordLength(String word){
        return word.length();
    }

    /*
    Crea una función NumOfVowels(String word) que devuelva el número de vocales que contiene esa palabra.
    Para poder realizar este ejercicio, deberás descomponer el String en un array de char[] con la función: toCharArray();
    */
    public static int NumOfVowels(String word){
        char[] chars = word.toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if((chars[i] == 'a') || (chars[i] == 'e') || (chars[i] == 'i') || (chars[i] == 'o') || (chars[i] == 'u')){
                count++;
            }
        }
        return count;
    }

    /* Crea una función llamada checkNumberOfPrimes(int[] numbers) la cual se le envíe como parámetro un array de números y
    nos devuelva cuantos números primos hay. Crea otra función que sea isPrime(int i) que devuelva un boolean.
    Úsala en la primera función.
     */
    public static int checkNumberOfPrimes(int[] numbers){
        int count = 0;
        for (int num: numbers) {
            if(isPrime(num)){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num){
        for (int i = 2; i < num ; i++) {
            if(num%i == 0){
                return false;
            }
        }
        if(num <= 1){
            return false;
        }
        return true;
    }

    /*
    Crea una función llamada isIdentityMatrix(int[][] matrix) que devuelva un booleano conforme si una matriz es identidad o no.
    Recuerda que una matriz identidad es aquella que su diagonal de izquierda a derecha son todo 1 y el resto son todo 0.
    */
    public static boolean isIdentityMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                } else if (i != j &&matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
