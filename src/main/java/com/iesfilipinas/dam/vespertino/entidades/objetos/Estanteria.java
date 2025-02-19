package com.iesfilipinas.dam.vespertino.entidades.objetos;

import java.util.ArrayList;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Inventario;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.InputReader;

public class Estanteria extends Objeto {

    private Inventario inventario;

    public Estanteria(int x, int y, int z) {
        super("Estanteria", TipoObjeto.ARMARIO, x, y, z);
        this.inventario = new Inventario(new ArrayList<>());
    }

    @Override
    public void interactuar(Jugador jugador) {
        mostrarContenido(jugador);
        String nombre = InputReader.leerLineaMinusculas();
        Objeto objeto = inventario.getObjetoInventario(nombre); // Busco por el nombre el objeto

        if(objeto != null) { // Si está en el inventario
           jugador.getInventario().agregarObjeto(objeto); // Se agrega al inventario del jugador
           inventario.eliminarObjeto(objeto); // Se elimina de la estanteria
           System.out.println("Has recogido: " + objeto.getNombre());

        } else {
            System.out.println("Ese objeto no está en la estantería");
        }
    }

    private void mostrarContenido(Jugador jugador) {
        if (inventario.getObjetos().length > 0) {
            System.out.println("\n¿Qué objeto quieres coger?");
            inventario.mostrarInventario();
           
        } else {
            System.out.println("No hay nada en la estantería");
        }
    }

/* 
    private void mostrarContenido(Jugador jugador) {
        if (inventario.getObjetos().length > 0) {
            System.out.println("¿Qué objeto quieres coger?");
            inventario.mostrarInventario();
            
            String input = InputReader.leerLineaMinusculas();
            for (Objeto objeto : inventario.getObjetos()) {
                if (objeto.getNombre().equalsIgnoreCase(input)) {
                    jugador.getInventario().agregarObjeto(objeto);
                    inventario.eliminarObjeto(objeto);
                    System.out.println("Has recogido: " + objeto.getNombre());
                    return;
                }
            }
            System.out.println("Ese objeto no está en la estantería");
        } else {
            System.out.println("No hay nada en la estantería");
        }
    }
    */
    // Getters y Setters
    
    public Inventario getInventario() {
        return inventario;
    }
    


}
