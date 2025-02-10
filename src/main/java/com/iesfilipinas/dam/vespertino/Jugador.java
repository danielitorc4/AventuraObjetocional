package com.iesfilipinas.dam.vespertino;

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

    public boolean isVivo() {
        actualizarVivo();
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

}
