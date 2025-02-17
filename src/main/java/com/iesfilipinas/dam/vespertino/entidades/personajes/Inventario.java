package com.iesfilipinas.dam.vespertino.entidades.personajes;

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
        System.out.println("Objetos en el inventario:");
        for (Objeto objeto : objetos) {
            System.out.println("- " + objeto.getNombre());
        }
    }

    public boolean contieneObjeto(Objeto objeto) {
        return objetos.contains(objeto);
    }

    public Objeto getObjetoInventario (Objeto objeto) {
        int index = objetos.indexOf(objeto);
        if (index == -1) {
            System.out.println("El objeto no se encuentra en el inventario.");
            return null;
        }
        return objetos.get(objetos.indexOf(objeto));
    }

    public Objeto[] getObjetos() {
        return objetos.toArray(new Objeto[0]);
    }

}
