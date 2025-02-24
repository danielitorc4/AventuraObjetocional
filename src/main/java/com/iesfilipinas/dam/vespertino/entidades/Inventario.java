package com.iesfilipinas.dam.vespertino.entidades;

import java.util.ArrayList;
import java.util.List;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Objeto;

public class Inventario {

    private List<Objeto> objetos;

    public Inventario(List<Objeto> objetos) {
        this.objetos = new ArrayList<>();
    }

    public boolean agregarObjeto(Objeto objeto) {
        return objetos.add(objeto);
    }

    public boolean eliminarObjeto(Objeto objeto) {
        return objetos.remove(objeto);
    }

    public void mostrarInventario() {
        for (Objeto objeto : objetos) {
            System.out.println("- " + objeto.getNombre());
        }
    }

    public Objeto getObjetoInventario(String nombre) {
        for (Objeto objeto : objetos) {
            if (objeto.getNombre().equalsIgnoreCase(nombre)) {
                return objeto;
            }
        }
        return null;
    }

    public Objeto[] getObjetos() {
        return objetos.toArray(new Objeto[0]);
    }

}
