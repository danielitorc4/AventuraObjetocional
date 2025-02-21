package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Llave extends Objeto {

    public Llave(int x, int y, int z) {
        super("Llave", TipoObjeto.LLAVE, x, y, z);
    }

    public Llave() {
        super("Llave", TipoObjeto.LLAVE);
    }

    public Llave(String nombre) {
        super(nombre, TipoObjeto.LLAVE);   
    }

    @Override
    public void interactuar(Jugador jugador) {
        System.out.println("Has recogido una llave.");
    }

}
