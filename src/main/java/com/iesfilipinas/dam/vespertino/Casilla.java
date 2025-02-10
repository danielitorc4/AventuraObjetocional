package com.iesfilipinas.dam.vespertino;

import com.iesfilipinas.dam.TiposDeTerreno;

public class Casilla {

    private int x, y, z;
    private TiposDeTerreno terreno;
    private Npc npc;

    public Casilla(int x, int y, int z, TiposDeTerreno terreno) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.terreno = terreno;
        this.npc = null;
    }

    // Getters y Setters
    public TiposDeTerreno getTerreno() {
        return terreno;
    }

    public void setNPC(Npc npc) {
        this.npc = npc;
    }
}
