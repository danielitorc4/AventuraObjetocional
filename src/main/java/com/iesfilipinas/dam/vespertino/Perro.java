package com.iesfilipinas.dam.vespertino;

public class Perro extends Npc{

    public Perro(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void hablar() {
        System.out.println("Woof!");
    }

    public void interactuar(Jugador jugador) {
        // Hay que implementarlo
    }

}