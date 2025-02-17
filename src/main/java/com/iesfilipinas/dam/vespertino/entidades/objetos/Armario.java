package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Armario extends Objeto {

    public Armario(int x, int y, int z) {
        super("Armario",TipoObjeto.ARMARIO, x, y, z);
    }

    @Override
    public void interactuar(Jugador jugador) {
        return;
    }



}
