package edu.gorilas.intercepting.clients;

import edu.gorilas.intercepting.tarefas.ProgramadorTarefas;

public interface Client {

    public void setProgramadorTarefas(ProgramadorTarefas programadorTarefas);

    public void enviarPeticion(String peticion);
}
