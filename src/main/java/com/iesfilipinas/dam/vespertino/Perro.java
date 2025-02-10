package com.iesfilipinas.dam.vespertino;

public class Perro extends Npc{

    public Perro(int x, int y, int z) {
        super("Perro", x, y, z, TipoNPC.PERRO);
    }
    @Override
    public void hablar() {
        System.out.println("Woof!");
    }

    public void interactuar(Jugador jugador) {
        // Hay que implementarlo
    }

}