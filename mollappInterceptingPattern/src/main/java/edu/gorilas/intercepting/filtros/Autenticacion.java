package edu.gorilas.intercepting.filtros;

public class Autenticacion implements Filtro {

    public Autenticacion() {
    }

    @Override
    public void execucion(String s) {
        System.out.println("Autenticación OK para " + s);
    }

}
