package com.iesfilipinas.dam.vespertino.entidades.personajes;

import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
import com.iesfilipinas.dam.vespertino.logica.minijuegos.TresEnRaya;

public class Hijo extends Npc{

    public Hijo(String nombre, int x, int y, int z) {
        super(nombre, x, y, z, TipoNPC.HIJO);
        this.tipo = TipoNPC.HIJO;
    }

    public void hablar() {
        System.out.println("Hola");
    }

    /* Mantengo el booleano en el contenedor para no instanciar un tres en raya que no vaya a usar
     * Si usara tresEnRaya.getResuelto(), siempre que interactue con el hijo se crearía una instancia
     * que igual no se utiliza para nada.
     * 
     * De hecho el atributo "resuelto" que heredaban de minijuego ha sido desechado por no ser necesario */
    public void interactuar(Jugador jugador) {
        if(!ContenedorDeBooleanos.getEstadoBooleano("tresEnRayaGanado")) { 
            System.out.println("Ves un par de cuchillos tirados por el suelo y unas marcas como de tres en raya en las tablas\n"
                                + "Decides jugar a ver si llamas la atención del chico\n");
            TresEnRaya tresEnRaya = new TresEnRaya();
            tresEnRaya.inicializarMinijuego(jugador);
        } else {
            System.out.println("El niño te ignora.");
        }
    }
}
