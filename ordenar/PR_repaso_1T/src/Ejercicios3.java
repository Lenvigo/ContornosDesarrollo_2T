import java.util.Arrays;

public class Ejercicios3 {
    public static void main(String[] args) {


    }

    /*
    Crea una función que sea getSalaryMean(double[] salaries) que devuelva el salario medio de la empresa.
    */
    public static double getSalaryMean(double[] salaries){
        double sum = Arrays.stream(salaries).sum();
        return (sum/salaries.length);
    }

    /*
    Crea una función que sea getSalaryMedian(double[] salaries) que devuelva la mediana de la empresa.
    Recuerda que la mediana es el valor del centro de un conjunto de datos. Esto quiere decir que si la longitud del array es Impar (por ejemplo 7) el valor que se pide es el de la posición 4, ya que tiene 3 valores antes (1,2,3) y 3 valores después (5,6,7). Pero si la longitud del array es par (por ejemplo 8),
    para conseguir la mediana tenemos que sumar el valor (mitad + mitad+1) /2 o lo que es decir (valor de la posición 4 + valor de la posición 5 y todo esto partido entre 2)
    */
    public static double getSalaryMedian(double[] salaries){
        if (salaries.length%2!=0){

            return salaries[(salaries.length/2)];

        }
        double medianaA =salaries[(salaries.length/2)-1];
        double medianaB = salaries[(salaries.length/2)];

        return (medianaA+medianaB)/2;

    }

    /* Crea una función getPayroll(double salary, int children, double percentage, boolean disability)
    que devuelva el importe a pagar a un empleado en base a todos los atributos.
    El porcentaje será la aportación a la seguridad social, con lo cual se descontará del salario total. Además, por cada hijo, se le descontará un 1% del porcentaje enviado como parámetro, pero a partir del tercer hijo (este inclusive), será de un 3%. Por último, si el empleado tiene alguna discapacidad, se le abonará 500€ a mayores.
    */
    public static double getPayroll (double salary, int children,
                                     double percentage, boolean disability){
        if (children < 3){
            percentage= percentage-(children);
        }else {
            percentage= percentage-(2+(3*(children-2)));
        }

        double salarioSalary= salary - (salary*percentage/100);

        if (disability){
            salarioSalary=salarioSalary+500;
        }

        return salarioSalary;
    }

    /*RRHH nos pide que les creemos una función para realizarles la Matriz transpuesta de los salarios de algunos
    empleados. No sabemos porqué, pero sus razones tendrán! --> transposeMatrix(double[][] matrix).
     */
    public static double[][] transposeMatrix(double[][] matrix){

        double[][]  neoMatrix =new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                neoMatrix[i][j] = matrix[j][i];
            }

        }

        return neoMatrix;
    }
}
