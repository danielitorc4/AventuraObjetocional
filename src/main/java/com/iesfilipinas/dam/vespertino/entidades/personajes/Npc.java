package com.iesfilipinas.dam.vespertino.entidades.personajes;

import com.iesfilipinas.dam.vespertino.entidades.Interactuable;

public abstract class Npc extends Persona implements Interactuable {

    protected TipoNPC tipo;

    public Npc(String nombre, int x, int y, int z, TipoNPC tipo) {
        super(x, y, z, nombre);
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoNPC getTipo() {
        return tipo;
    }

    public abstract void hablar();

    @Override
    public void interactuar(Jugador jugador) {
        // Hay que implementarlo
    }

}
