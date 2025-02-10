package com.iesfilipinas.dam.vespertino;

public abstract class Objeto implements Interactuable {

    protected TipoObjeto tipo;
    
    public Objeto(TipoObjeto tipo) {
        this.tipo = tipo;
    }

    public abstract void interactuar(Jugador jugador);

}