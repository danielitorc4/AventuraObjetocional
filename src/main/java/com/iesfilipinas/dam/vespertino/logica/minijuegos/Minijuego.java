package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public abstract class Minijuego {

    protected String nombre;
    protected boolean activo;

    public Minijuego(String nombre) {
        this.nombre = nombre;
        this.activo = false;
    }

    public void inicializarMinijuego(Jugador jugador) {}

}