package com.iesfilipinas.dam.vespertino.logica.minijuegos;

public class GestorMinijuegos {

    private static Minijuego minijuegoActual = null;

    public static Minijuego getMinijuegoActual() {
        if (minijuegoActual == null) {
           return null;
        }
        return minijuegoActual;
    }

    public static void setMinijuegoActual(Minijuego minijuegoActual) {
        GestorMinijuegos.minijuegoActual = minijuegoActual;
    }

    



}
