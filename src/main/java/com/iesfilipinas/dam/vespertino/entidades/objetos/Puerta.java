package com.iesfilipinas.dam.vespertino.entidades.objetos;

import java.util.ArrayList;
import java.util.List;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Puerta extends Objeto {

    private boolean abierta;
     private static List<Puerta> todasLasPuertas = new ArrayList<>();

    public Puerta(int x, int y, int z) {
        super("Puerta", TipoObjeto.PUERTA, x, y, z);
        this.abierta = false;
        todasLasPuertas.add(this);

    }

    public Puerta(int x, int y, int z, String nombre) {
        super(nombre, TipoObjeto.PUERTA, x, y, z);
        this.abierta = false;
        todasLasPuertas.add(this);

    }

    @Override
    public void interactuar(Jugador jugador) {  // Los return de este método evitan que se acceda a otro if
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
                return;
            }
        }
        // Interior
        if (jugador.getZ() == 2 && this.nombre.equals("Puerta")) {
            jugador.setZ(1);
            return;
        }

        if (jugador.getZ() == 2 && this.nombre.equals("Puerta_Sotano")) {
            if (!abierta && abrirPuerta(jugador)) {
                System.out.println("Has abierto la puerta del sótano.");
                jugador.setZ(0);
                return;
            } else if (!abierta) {
                System.out.println("La puerta del sótano está cerrada.");
                return;
            } else {
                jugador.setZ(0);
                return;
            }
        }
    }

    private boolean abrirPuerta(Jugador jugador) {
        if (this.nombre.equals("Puerta_Sotano")) {
            Objeto llaveSotano = jugador.getInventario().getObjetoInventario("LlaveSotano");
            if (llaveSotano instanceof Llave) {
                for (Puerta puerta : todasLasPuertas) {
                    if (puerta.nombre.equals("Puerta_Sotano")) {
                        puerta.abierta = true;
                    }
                }
                return true;
            }
            return false;
        }

        Objeto llave = jugador.getInventario().getObjetoInventario("Llave"); // Busco un objeto cuyo nombre sea llave

        if (llave != null && llave instanceof Llave) { // Si hay alguno
            jugador.getInventario().eliminarObjeto(llave); // Lo elimino y abro la puerta
            abierta = true;
            return true;
        } else {
            return false;
        }
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

    // Getters y Setters
   
    public boolean isAbierta() {
        return abierta;
    }

}
