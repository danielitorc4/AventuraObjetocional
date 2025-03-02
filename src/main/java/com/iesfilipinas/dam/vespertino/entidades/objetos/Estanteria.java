package com.iesfilipinas.dam.vespertino.entidades.objetos;

import java.util.ArrayList;

import com.iesfilipinas.dam.vespertino.entidades.Inventario;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
import com.iesfilipinas.dam.vespertino.logica.InputReader;
import com.iesfilipinas.dam.vespertino.logica.minijuegos.Persecucion;
import com.iesfilipinas.dam.vespertino.logica.minijuegos.RuletaRusa;

public class Estanteria extends Objeto {

    private Inventario inventario;

    public Estanteria(int x, int y, int z, TipoObjeto tipo) {
        super("Estanteria", tipo, x, y, z);
        this.inventario = new Inventario(new ArrayList<>());
    }

    public Estanteria(int x, int y, int z, String nombre, TipoObjeto tipo) {
        super(nombre, tipo, x, y, z);
        this.inventario = new Inventario(new ArrayList<>());
    }

    @Override
    public void interactuar(Jugador jugador) {
        
        if (this.tipo == TipoObjeto.ESTANTERIA) {
            if (this.nombre.equals("EstanteriaSotano") && !ContenedorDeBooleanos.getEstadoBooleano("ruletaRusaCompleta")) {
                RuletaRusa ruletaRusa = new RuletaRusa("RuletaRusa");
                ruletaRusa.inicializarMinijuego(jugador);
            }
            if(!mostrarContenido(jugador)) {    // Si no hay nada que no pida input al usuario
                return;
            }
            recogerObjeto(jugador);
            return;
        }
        
        if(!mostrarContenido(jugador)) {    // Si no hay nada que no pida input al usuario
            return;
        }

        if (this.tipo == TipoObjeto.MESITA) {   // Los diferencio por si es un futuro quisiera añadir un puzzle por ejemplo
            recogerObjeto(jugador);
            if (this.z == 3 && !ContenedorDeBooleanos.getEstadoBooleano("persecucionCompleta")) {
                Persecucion persecucion = new Persecucion();
                persecucion.inicializarMinijuego(jugador);
            }
            return;
        }


    }

    private void recogerObjeto(Jugador jugador) {
        String nombre = InputReader.leerLineaMinusculas();
        Objeto objeto = inventario.getObjetoInventario(nombre); // Busco por el nombre el objeto

        if(objeto != null) { // Si está en el inventario
           jugador.getInventario().agregarObjeto(objeto); // Se agrega al inventario del jugador
           inventario.eliminarObjeto(objeto); // Se elimina de la estanteria
           System.out.println("Has recogido: " + objeto.getNombre());

        } else {
            System.out.println("No se encuentra el objeto");
        }
    }

    private boolean mostrarContenido(Jugador jugador) {
        if (inventario.getObjetos().length > 0) {
            System.out.println("\n¿Qué objeto quieres coger?");
            inventario.mostrarInventario();
            return true;
           
        } else {
            System.out.println("No hay nada...");
            return false;
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
