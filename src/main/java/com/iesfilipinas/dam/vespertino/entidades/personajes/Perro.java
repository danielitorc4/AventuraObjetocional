package com.iesfilipinas.dam.vespertino.entidades.personajes;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Carne;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Objeto;

public class Perro extends Npc{

    private boolean ladrando;

    public Perro(int x, int y, int z) {
        super("Perro", x, y, z, TipoNPC.PERRO);
        this.ladrando = false;
    }
    @Override
    public void hablar() {
        System.out.println("Woof!");
    }

    @Override
    public void interactuar(Jugador jugador) {
        if (!vivo) {
            System.out.println("El perro está muerto");
            return;
        }

        // Revisar si tienes carne en el inventario
        Inventario inventario = jugador.getInventario();
        for (Objeto objeto : inventario.getObjetos()) {
            if(objeto instanceof Carne) {
                inventario.eliminarObjeto(objeto);
                System.out.println("El perro se come la carne y comienza a ladrar");
                ladrando = true;
                return;
            }
        }

        // Si no
        if (!ladrando) {
            System.out.println("El perro te muerde");
            jugador.quitarVida(20);
        } else {
            hablar();
        }

    }   


}