package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.GestorDeDialogos;

public class Nota extends Objeto {

    public Nota(int x, int y, int z) {
        super("Nota", TipoObjeto.NOTA, x, y, z);
    }

    public Nota(String nombre, int x, int y, int z ) {
        super(nombre,TipoObjeto.NOTA, x, y, z);
    }

    public void interactuar(Jugador jugador) {
        GestorDeDialogos.getDialogo("NotaPB");
    }

}
