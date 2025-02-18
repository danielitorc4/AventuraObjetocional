package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public abstract class Minijuego {

    protected String nombre;

    public Minijuego(String nombre) {
        this.nombre = nombre;
    }

    public void inicializarMinijuego(Jugador jugador) {}

}