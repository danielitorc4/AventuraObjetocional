package com.iesfilipinas.dam.vespertino.entidades.personajes;

import java.util.ArrayList;

import com.iesfilipinas.dam.vespertino.entidades.Inventario;

public class Jugador extends Persona {
 
    private int vida;
    private Inventario inventario;

    public Jugador(int x, int y, int z, String nombre) { // Añadir inventario (objeto, clase Inventario)
        super(x, y, z, nombre);
        this.vida = 100;
        this.inventario = new Inventario(new ArrayList<>());
    }

    private void actualizarVivo() {
        if (vida <= 0) {
            vivo = false;
        }
    }

    public void quitarVida(int cantidad) {
        this.vida -= cantidad;
        mostrarVida();
        actualizarVivo();
    }

    public void mostrarVida() {
        System.out.println("Vida restante: " + vida);
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
        mostrarVida();
        actualizarVivo();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public boolean getVivo() {
        return vivo;
    }

    public String getNombre() {
        return nombre;
    }

}
