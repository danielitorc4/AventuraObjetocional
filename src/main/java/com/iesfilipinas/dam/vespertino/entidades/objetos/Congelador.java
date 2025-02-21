package com.iesfilipinas.dam.vespertino.entidades.objetos;

import java.util.ArrayList;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Inventario;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
import com.iesfilipinas.dam.vespertino.logica.InputReader;
import com.iesfilipinas.dam.vespertino.logica.minijuegos.Acertijo;

public class Congelador extends Objeto {

    private Inventario inventario;

    public Congelador(int x, int y, int z) {
        super("Congelador", TipoObjeto.CONGELADOR, x, y, z);
        this.inventario = new Inventario(new ArrayList<>());
    }

    @Override
    public void interactuar(Jugador jugador) {
       if(ContenedorDeBooleanos.getEstadoBooleano("acertijoCongeladorResuelto")) {
            if(!mostrarContenido(jugador)) {    // Si no hay nada que no pida input al usuario
                return;
            }
            
            String nombre = InputReader.leerLineaMinusculas();
            Objeto objeto = inventario.getObjetoInventario(nombre); // Busco por el nombre el objeto

            if(objeto != null) { // Si está en el inventario
                jugador.getInventario().agregarObjeto(objeto); // Se agrega al inventario del jugador
                inventario.eliminarObjeto(objeto); // Se elimina de la estanteria
                System.out.println("Has recogido: " + objeto.getNombre());
           } else {
                System.out.println("Ese objeto no está en el congelador");
           }
       } else {
        Acertijo acertijoCongelador = new Acertijo();
        acertijoCongelador.inicializarMinijuego(jugador);
       }
        
    }

    private boolean mostrarContenido(Jugador jugador) {
        if (inventario.getObjetos().length > 0) {
            System.out.println("\n¿Qué objeto quieres coger?");
            inventario.mostrarInventario();
            return true;
           
        } else {
            System.out.println("No hay nada en el congelador");
            return false;
        }
    }

    // Getters y Setters

    public Inventario getInventario() {
        return inventario;
    }

}
