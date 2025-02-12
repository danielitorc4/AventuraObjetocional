package com.iesfilipinas.dam.vespertino.logica;

import java.util.ArrayList;

public class ContenedorDeBooleanos {

    private static ArrayList<String> claves = new ArrayList<String>();
    private static ArrayList<Boolean> valores = new ArrayList<Boolean>();

    public static void inicializarBooleanos() {
        claves.add("tieneLancha"); // Es un ejemplo pero este boolean pertenecerá a un objeto como atributo
        // Añadir el resto
        for (int i = 0; i < claves.size(); i++) { // Por cada clave crea un valor y lo pone en falso
            valores.add(false);
        }
    }

    public boolean getEstadoBooleano(String trigger) {
        int index = claves.indexOf(trigger);
        return index != -1 && valores.get(index); // Comprueba que el trigger está en la lista y devuelve su valor
    }

    public void cambiarEstadoBooleano(String trigger, boolean nuevoEstado) {
        int index = claves.indexOf(trigger);
        if (index != -1) {
            valores.set(index, nuevoEstado);
        }
    }

}
