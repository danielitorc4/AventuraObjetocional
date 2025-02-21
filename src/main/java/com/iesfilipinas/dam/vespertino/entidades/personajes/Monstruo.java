package com.iesfilipinas.dam.vespertino.entidades.personajes;

public class Monstruo extends Npc {
/*  No voy a programar todavía que el monstruo se dirija en cada iteración hasta el jugador 
 *  y que cuando sus coordenadas coincidan, el jugador muera. De momento voy a utilizar un contador.
*/
    private int contadorPersecucion;    

    public Monstruo(int x, int y, int z, String nombre) {
        super(nombre, x, y, z, TipoNPC.MONSTRUO);
        this.contadorPersecucion = 0;
    }
    
    public void incrementarContadorPersecucion() {
        this.contadorPersecucion++; // Se incrementa el contador de persecucion
    }

    public void hablar() {
        System.out.println("¡RAWR!");
    }

    // Getters y Setters
    
    public int getContadorPersecucion() {
        return contadorPersecucion;
    }

    public void setContadorPersecucion(int contadorPersecucion) {
        this.contadorPersecucion = contadorPersecucion;
    }

   

    

}
