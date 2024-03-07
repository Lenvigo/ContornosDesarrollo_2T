package edu.gorilas.intercepting.targets;

public class Vehiculo implements Target {

    public Vehiculo() {
    }

    @Override
    public void execucion(String s) {
        System.out.println("Puerta abierta " + s + "!");
    }

}
