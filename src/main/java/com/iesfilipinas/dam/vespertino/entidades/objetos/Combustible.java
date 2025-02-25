package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Combustible extends Objeto {

    public Combustible(String nombre, TipoObjeto tipo, int x, int y, int z) {
        super(nombre, tipo, x, y, z);
    }

    public Combustible(String nombre, TipoObjeto tipo) {
        super(nombre, tipo);
    }

    public void interactuar(Jugador jugador) {
        System.out.println("Con esto podría escapar de la isla.");
    }

}
