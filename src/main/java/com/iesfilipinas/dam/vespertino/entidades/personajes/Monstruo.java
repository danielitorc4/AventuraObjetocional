package com.iesfilipinas.dam.vespertino.entidades.personajes;

import java.util.ArrayList;
import java.util.List;

public class Monstruo extends Npc {
/*  No voy a programar todavía que el monstruo se dirija en cada iteración hasta el jugador 
 *  y que cuando sus coordenadas coincidan, el jugador muera. De momento voy a utilizar un contador.
*/
    private int contadorPersecucion;    
    private static List<Monstruo> todosLosMonstruos = new ArrayList<>(); // Lista de todas las instancias de Monstruo

    public Monstruo(int x, int y, int z, String nombre) {
        super(nombre, x, y, z, TipoNPC.MONSTRUO);
        this.contadorPersecucion = 0;
        todosLosMonstruos.add(this);
    }
    
    public void incrementarContadorPersecucion() {
        this.contadorPersecucion++; // Se incrementa el contador de persecucion
    }

    public void hablar() {
        System.out.println("¡RAWR!");
    }

    public static void actualizarCoordenadasDeTodos(int newX, int newY, int newZ) {
        for (Monstruo monstruo : todosLosMonstruos) {
            monstruo.setCoordenadas(newX, newY, newZ);
        }
    }
            
    // Getters y Setters
                
    private void setCoordenadas(int newX, int newY, int newZ) {
        this.x = newX;
        this.y = newY;
        this.z = newZ;
    }

    public int getContadorPersecucion() {
        return contadorPersecucion;
    }

    public void setContadorPersecucion(int contadorPersecucion) {
        this.contadorPersecucion = contadorPersecucion;
    }

    public static Monstruo[] getTodosLosMonstruos() {
        return todosLosMonstruos.toArray(new Monstruo[0]);
    }

   

    

}
