package com.iesfilipinas.dam.vespertino;

public abstract class Npc extends Persona implements Interactuable {

    protected String tipo;

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract void hablar();

    @Override
    public void interactuar(Jugador jugador) {
        // Hay que implementarlo
    }

}
