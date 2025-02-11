package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.Interactuable;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public abstract class Objeto implements Interactuable {

    protected TipoObjeto tipo;
    
    public Objeto(TipoObjeto tipo) {
        this.tipo = tipo;
    }

    public abstract void interactuar(Jugador jugador);

}