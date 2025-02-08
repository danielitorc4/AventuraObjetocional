package com.iesfilipinas.dam.vespertino;

public class Casilla {

    private int x, y, z;
    private String terreno;
    private Npc npc;

    public Casilla(int x, int y, int z, String terreno) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.terreno = terreno;
        this.npc = null;
    }


    // Getters y Setters
    public String getTerreno() {
        return terreno;
    }

    public void setNPC(Npc npc) {
        this.npc = npc;
    }
}
