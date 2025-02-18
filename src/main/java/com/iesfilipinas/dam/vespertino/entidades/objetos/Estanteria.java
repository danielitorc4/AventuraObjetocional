package com.iesfilipinas.dam.vespertino.entidades.objetos;

import java.util.ArrayList;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Inventario;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class Estanteria extends Objeto {

    private Inventario inventario;

    public Estanteria(int x, int y, int z) {
        super("Armario",TipoObjeto.ARMARIO, x, y, z);
        this.inventario = new Inventario(new ArrayList<>());
    }

    @Override
    public void interactuar(Jugador jugador) {
        if(inventario != null && inventario.getObjetos().length > 0) {
            inventario.mostrarInventario();
            System.out.println("¿Que quieres sacar del armario?");
            String input = scan.nextLine().toLowerCase();
        } else {
            System.out.println("No hay nada en la estantería");
        }
    }
    
    // Getters y Setters
    
    public Inventario getInventario() {
        return inventario;
    }
    


}
