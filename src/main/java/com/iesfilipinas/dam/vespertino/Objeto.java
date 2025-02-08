package com.iesfilipinas.dam.vespertino;

public abstract class Objeto implements Interactuable {

    protected String nombre;
    
    public abstract void interactuar(Jugador jugador);

}