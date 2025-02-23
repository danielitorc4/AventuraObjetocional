package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Carne extends Objeto {

    public Carne(int x, int y, int z) {
        super("Carne", TipoObjeto.CARNE, x, y, z);
        this.setNombre("Carne");
    }

    public Carne() {
        super("Carne", TipoObjeto.CARNE);
    }


    @Override
    public void interactuar(Jugador jugador) {
        System.out.println("Es un trozo de carne.");
    }

}
