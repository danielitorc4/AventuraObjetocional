package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Armario extends Objeto {

    private static boolean jugadorEscondido;

    public Armario(String nombre, TipoObjeto tipo, int x, int y, int z) { 
        super(nombre, tipo, x, y, z);
        jugadorEscondido = false;
    }

    public boolean isJugadorEscondido() {
        return jugadorEscondido;
    }

    public void interactuar(Jugador jugador) {

        if (!jugadorEscondido) {
            System.out.println("Te escondes en el armario.");
            alternarEscondido();
        } else {
            System.out.println("Sales del armario.");
            alternarEscondido();
        }

    }

    public void alternarEscondido() {
        jugadorEscondido = !jugadorEscondido;
    }

    // Getters y Setters

    public static boolean isEscondido() {
        return jugadorEscondido;
    }
    
}
