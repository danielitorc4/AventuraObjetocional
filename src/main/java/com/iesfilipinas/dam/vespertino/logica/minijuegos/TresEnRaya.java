package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;

public class TresEnRaya extends Minijuego {

    public TresEnRaya() {
        super("Tres en Raya");
    }

    @Override
    public void inicializarMinijuego(Jugador jugador) {
        System.out.println("Iniciando el minijuego: " + nombre);
    }

}
