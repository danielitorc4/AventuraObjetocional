package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.Interactuable;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public abstract class Objeto implements Interactuable {

    protected String nombre;
    protected TipoObjeto tipo;
    protected int x, y, z;

    public Objeto(String nombre, TipoObjeto tipo, int x, int y, int z) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Objeto(String nombre, TipoObjeto tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public abstract void interactuar(Jugador jugador);

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}