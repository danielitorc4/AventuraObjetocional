package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Puerta extends Objeto {

    private boolean abierta;

    public Puerta(int x, int y, int z) {
        super("Puerta", TipoObjeto.PUERTA, x, y, z);
        this.abierta = false;
    }

    @Override
    public void interactuar(Jugador jugador) {
        
    }
    
 /*  private boolean abrirPuerta(Jugador jugador) {
     
  }

    private boolean buscarLlave(Jugador jugador, Llave llave) {

    }
*/
}
