package edu.gorilas;

public class DNI {
    
    private int numero;
    private DNILetterCalculator letterCalculator = new MapLetterCalculator();

    public DNI(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public char getLetter(){
        return this.letterCalculator.getLetter(this.numero);
    }
}
