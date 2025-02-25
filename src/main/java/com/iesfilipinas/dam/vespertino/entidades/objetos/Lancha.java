package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;

public class Lancha extends Objeto {
 
    private boolean encendida;

    public Lancha(int x, int y, int z) {
        super("Lancha", TipoObjeto.LANCHA, x, y, z);
        encendida = false;
    }

    public void interactuar(Jugador jugador) {
        if (jugador.getInventario().getObjetoInventario("Combustible") != null && !encendida) {
            jugador.getInventario().eliminarObjeto(jugador.getInventario().getObjetoInventario("Combustible")); 
            System.out.println("Te has subido en la lancha, ahora puedes navegar."); 
            encendida = true;
            ContenedorDeBooleanos.cambiarEstadoBooleano("lanchaEncendida", encendida);
        } else if (!encendida) {
            System.out.println("No tienes combustible.");
        } else {
            System.out.println("Ya estas en la lancha.");
        }
    }

}
