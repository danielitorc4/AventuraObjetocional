package com.iesfilipinas.dam.vespertino.entidades.objetos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Inventario;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.InputReader;

public class Escalera extends Objeto {

    private Inventario inventario;

    public Escalera(int x, int y, int z) {
        super("Escalera", TipoObjeto.ESCALERA, x, y, z);
    }

    public void interactuar(Jugador jugador) {
        System.out.print("Qué quieres hacer? ");
        if(z == 2) {  // Puedes elegir siempre las 2 opciones pero dependiendo del piso te imprime las que harán algo
            System.out.println("(Subir/Bajar)");
        }
        if(z == 0) {
            System.out.println("(Subir)");
        }
        if(z == 3) {
            System.out.println("(Bajar)");
        }

        String movimiento = InputReader.leerLineaMinusculas();

        if (movimiento.equalsIgnoreCase("subir")) {
            if(subirEscalera(jugador)) {
                System.out.println("Has subido la escalera.");
            } else {
                System.out.println("No puedes subir.");
            }
        }

        if (movimiento.equalsIgnoreCase("bajar")) {
            if(bajarEscalera(jugador)) {
                System.out.println("Has bajado la escalera.");
            } else {
                System.out.println("No puedes bajar.");
            }
        }
    }

    private boolean subirEscalera(Jugador jugador) {  // Saltamos el piso 1 porque es el exterior
        if (z == 0) { 
            jugador.setZ(2); // Del piso 0 pasas al 2
            return true;
        }
        if (z == 2) {
            jugador.setZ(3); // Del piso 2 pasas al 3
            return true;
        }
        return false;
    }

    private boolean bajarEscalera(Jugador jugador) {
     
        if (z == 3) {
            jugador.setZ(2); // Del piso 3 pasas al 2
            return true;
        }

        Objeto puerta = inventario.getObjetoInventario("Puerta_Sotano");
        Puerta puerta_sotano = (Puerta) puerta;
        
        if (z == 2 && puerta_sotano.isAbierta()) {
            jugador.setZ(0); // Del piso 2 pasas al 0
            return true;
        }
        return false;
    }

    // Getters y setters

    public Inventario getInventario() {
        return inventario;
    }
}
