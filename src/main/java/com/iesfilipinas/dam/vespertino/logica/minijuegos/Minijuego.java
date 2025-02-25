package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public abstract class Minijuego {

    protected String nombre;
    protected boolean activo;
    // Pensé en añadir un atributo "resuelto" pero no terminé de ver cómo implementarlo correctamente

    public Minijuego(String nombre) {
        this.nombre = nombre;
        this.activo = false;
    }

    public abstract void inicializarMinijuego(Jugador jugador);

}