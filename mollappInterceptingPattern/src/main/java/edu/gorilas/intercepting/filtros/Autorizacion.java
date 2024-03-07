package edu.gorilas.intercepting.filtros;

public class Autorizacion implements Filtro {

    public Autorizacion() {
    }

    @Override
    public void execucion(String s) {
        System.out.println("Autorización OK para " + s);
    }

}
