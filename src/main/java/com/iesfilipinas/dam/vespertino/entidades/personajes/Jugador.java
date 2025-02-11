package com.iesfilipinas.dam.vespertino.entidades.personajes;

public class Jugador extends Persona {
 
    private int vida;

    public Jugador(int x, int y, int z, String nombre) {
        super(x, y, z, nombre);
        this.vida = 100;
    }

    private void actualizarVivo() {
        if (vida <= 0) {
            vivo = false;
        }
    }

    public void quitarVida(int cantidad) {
        this.vida -= cantidad;
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

}
