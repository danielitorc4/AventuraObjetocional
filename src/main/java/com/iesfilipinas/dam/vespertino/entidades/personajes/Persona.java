package com.iesfilipinas.dam.vespertino.entidades.personajes;

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

    // Getters y setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) { 
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

}