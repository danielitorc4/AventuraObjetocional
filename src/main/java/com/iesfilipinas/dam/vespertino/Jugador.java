package com.iesfilipinas.dam.vespertino;

public class Jugador extends Persona {
 
    private int vida;

    public Jugador(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.vida = 100;
        this.vivo = true;
    }

    private void actualizarVivo() {
        if (vida <= 0) {
            vivo = false;
        }
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
