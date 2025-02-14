package com.iesfilipinas.dam.vespertino.entidades.personajes;

import java.util.ArrayList;
import java.util.List;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Objeto;

public class Jugador extends Persona {
 
    private int vida;
    private List<Objeto> inventario;

    public Jugador(int x, int y, int z, String nombre) { // Añadir inventario (objeto, clase Inventario)
        super(x, y, z, nombre);
        this.vida = 100;
        this.inventario = new ArrayList<Objeto>();
    }

    private void actualizarVivo() {
        if (vida <= 0) {
            vivo = false;
        }
    }

    public void quitarVida(int cantidad) {
        this.vida -= cantidad;
    }

    public void mostrarInventario() {
        int n = 1;
        for (Objeto objeto : inventario) {
            System.out.println(n++ + ". " + objeto.getNombre());
        }
    }

    public void agregarObjetoInventario(Objeto objeto) {
        inventario.add(objeto);
    }

    public void eliminarObjetoIventario(Objeto objeto) {
        inventario.remove(objeto);
    }
    
    // Getters y Setters

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if (vida > 100) {
            this.vida = 100;
        }
        actualizarVivo();
    }

    public List<Objeto> getInventario() {
        return inventario;
    }

}
