package edu.gorilas.intercepting.clients;

import edu.gorilas.intercepting.tarefas.ProgramadorTarefas;

public class Mollapp implements Client {

    private ProgramadorTarefas programadorTarefas;

    public Mollapp() {
    }

    @Override
    public void setProgramadorTarefas(ProgramadorTarefas programadorTarefas) {
        this.programadorTarefas = programadorTarefas;
    }

    @Override
    public void enviarPeticion(String peticion) {
        this.programadorTarefas.executarTarefas(peticion);
    }

}
