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
        // Exterior
        if(jugador.getZ() == 1) {
            if(!abierta && abrirPuerta(jugador)) {
                System.out.println("Has abierto la puerta");
                jugador.setZ(2); // Entrar en cuanto la abres. QoL
                return;
            } else if (abierta) {
                jugador.setZ(2);
                return;
            } else {
                System.out.println("La puerta esta cerrada.");
            }
        }
        // Interior
        if (jugador.getZ() == 2) {
            jugador.setZ(1);
        }
    }

    private boolean abrirPuerta(Jugador jugador) {
        Objeto llave = jugador.getInventario().getObjetoInventario("Llave"); // Busco un objeto cuyo nombre sea llave
        if (llave != null && llave instanceof Llave) { // Si hay alguno
            jugador.getInventario().eliminarObjeto(llave); // Lo elimino y abro la puerta
            abierta = true;
            return true;
        } else {
            return false;}
    }
/* 
    private boolean abrirPuerta(Jugador jugador) {
    Inventario inventario = jugador.getInventario();
    for (Objeto objeto : inventario.getObjetos()) {
        if (objeto instanceof Llave) {
            inventario.eliminarObjeto(objeto);
            abierta = true;
            return true;
        }
    }
    return false;
  }
  */

}
