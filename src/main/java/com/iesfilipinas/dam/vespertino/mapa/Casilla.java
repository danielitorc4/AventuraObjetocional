package com.iesfilipinas.dam.vespertino.mapa;

import java.util.ArrayList;
import java.util.List;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Objeto;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Npc;

public class Casilla {

    private int x, y, z;
    private TiposDeTerreno terreno;
    private List<Npc> npcs;
    private List<Objeto> objetos;

    public Casilla(int x, int y, int z, TiposDeTerreno terreno) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.terreno = terreno;
        this.npcs = new ArrayList();
        this.objetos = new ArrayList();
    }

    public void agregarNPC(Npc npc) {
        npcs.add(npc);
    }

    public void eliminarNPC(Npc npc) {
        npcs.remove(npc);
    }

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public void eliminarObjeto(Objeto objeto) {
        objetos.remove(objeto);
    }

    // Getters y Setters
    public TiposDeTerreno getTerreno() {
        return terreno;
    }

    public List<Npc> getNPCs() {
        return npcs;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }
}
