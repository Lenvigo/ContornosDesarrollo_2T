package edu.gorilas.intercepting.tarefas;

import java.util.ArrayList;

import edu.gorilas.intercepting.filtros.Filtro;
import edu.gorilas.intercepting.targets.Target;

public class Tarefas {
    private Target target = null;
    private ArrayList<Filtro> filtros = new ArrayList<>();

    Tarefas() {
    }

    ArrayList<Filtro> getTarefas() {
        return this.filtros;
    }

    Target getTarget() {
        return this.target;
    }

    void engadirTarefa(Filtro filtro) {
        this.filtros.add(filtro);
    }

    void execucion(String s) {
        this.filtros.forEach(e -> e.execucion(s));
    }

    void setTarget(Target target) {
        this.target = target;
    }

}
