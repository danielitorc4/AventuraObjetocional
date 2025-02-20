package com.iesfilipinas.dam.vespertino.entidades.objetos;

import java.util.ArrayList;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Inventario;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
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
           mostrarContenido(jugador);
       } else {
        Acertijo acertijoCongelador = new Acertijo();
        acertijoCongelador.inicializarMinijuego(jugador);
       }
        
    }

    private void mostrarContenido(Jugador jugador) {
        if (inventario.getObjetos().length > 0) {
            System.out.println("\n¿Qué objeto quieres coger?");
            inventario.mostrarInventario();
           
        } else {
            System.out.println("No hay nada en el congelador");
        }
    }

}
