package com.iesfilipinas.dam.vespertino;

public abstract class Persona {

    protected int x;
    protected int y;
    protected int z;
    protected String nombre;
    protected boolean vivo;

    public Persona(int x, int y, int z, String nombre) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.nombre = nombre;
        this.vivo = true;
    }

    public void interactuar(Jugador jugador) {}

}