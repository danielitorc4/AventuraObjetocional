package com.iesfilipinas.dam.vespertino.logica;

import java.util.ArrayList;

public class ContenedorDeBooleanos {

    private static ArrayList<String> claves = new ArrayList<String>();
    private static ArrayList<Boolean> valores = new ArrayList<Boolean>();

    public static void inicializarBooleanos() {
        claves.add("tresEnRayaGanado");
        claves.add("acertijoCongeladorResuelto");
        claves.add("notaPBleida");
        claves.add("persecucionCompleta");
        claves.add("ruletaRusaCompleta");
        claves.add("lanchaEncendida");
        // Añadir el resto
        for (int i = 0; i < claves.size(); i++) { // Por cada clave crea un valor y lo pone en falso
            valores.add(false);
        }
    }

    public static boolean getEstadoBooleano(String booleano) {
        int index = claves.indexOf(booleano);
        return index != -1 && valores.get(index); // Comprueba que el boolean está en la lista y devuelve su valor
    }

    public static void cambiarEstadoBooleano(String booleano, boolean nuevoEstado) {
        int index = claves.indexOf(booleano);
        if (index != -1) {
            valores.set(index, nuevoEstado);
        }
    }

}
