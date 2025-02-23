package com.iesfilipinas.dam.vespertino;

import com.iesfilipinas.dam.vespertino.logica.Juego;

public class Main {

    public static void main(String[] args) {
        Juego aventuraConversacional = new Juego("Aventura Conversacional, por Daniel Redondo Castaño");
        aventuraConversacional.iniciarJuego();
    }

    /* Funcionalidades por añadir:
     * - Acceso a los objetos por su índice en lugar de pedir al jugador que escriba "Estanteria" por ejemplo.
     */

}
