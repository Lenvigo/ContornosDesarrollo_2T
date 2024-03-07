package edu.gorilas.intercepting;

import edu.gorilas.intercepting.clients.Client;
import edu.gorilas.intercepting.clients.Mollapp;
import edu.gorilas.intercepting.filtros.Autenticacion;
import edu.gorilas.intercepting.filtros.Autorizacion;
import edu.gorilas.intercepting.tarefas.ProgramadorTarefas;
import edu.gorilas.intercepting.targets.Vehiculo;

public final class App {
    public static void main(String[] args) {

        /**
         * Configuracion del programador de tareas
         * del sistema con el tipo de target elegido:
         * desde vehiculos a cualquier cosa que admita
         * la recepcion de un mensaje.
         */
        ProgramadorTarefas programadorTarefas = new ProgramadorTarefas(new Vehiculo());

        /**
         * Añadir al sistema las tareas que queremos que el sistema
         * ejecute al recibir la peticion del cliente.
         */
        programadorTarefas.setTarefa(new Autenticacion());
        programadorTarefas.setTarefa(new Autorizacion());

        /**
         * Configuracion de la app cliente para que
         * ejecute las tareas programades y
         * envie el mensaje al sistema.
         */
        Client mollapp = new Mollapp();
        mollapp.setProgramadorTarefas(programadorTarefas);
        mollapp.enviarPeticion("Francesc");
    }
}
