package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
import com.iesfilipinas.dam.vespertino.logica.GestorDeDialogos;

public class Nota extends Objeto {

    public Nota(int x, int y, int z) {
        super("Nota", TipoObjeto.NOTA, x, y, z);
    }

    public Nota(String nombre, int x, int y, int z ) {
        super(nombre,TipoObjeto.NOTA, x, y, z);
    }

    public Nota(String nombre) {
        super(nombre, TipoObjeto.NOTA);
    }

    public void interactuar(Jugador jugador) {
        System.out.println(GestorDeDialogos.getDialogo(nombre));
        ContenedorDeBooleanos.cambiarEstadoBooleano("notaPBleida", true);
    }

}
