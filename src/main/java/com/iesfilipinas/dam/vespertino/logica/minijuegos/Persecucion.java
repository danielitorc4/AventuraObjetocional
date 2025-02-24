package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Armario;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;

public class Persecucion extends Minijuego{
 
    private static int turnosMax = 7;
    private int turnos;
    
    public Persecucion() {
        super("Persecucion");
        this.turnos = 0;
    }

    public void inicializarMinijuego(Jugador jugador) {
        GestorMinijuegos.setMinijuegoActual(this);
        activo = true;
    }

    public void buclePersecucion(Jugador jugador) {
        turnos++;
        if ((turnos > turnosMax)) {
            System.out.println("El monstruo te ha atrapado.");
            jugador.setVida(0);
            activo = false;
        }
        if ((Armario.isEscondido())) {
            System.out.println("El monstruo pasa de largo.");
            ContenedorDeBooleanos.cambiarEstadoBooleano("persecucionCompleta", true);
            activo = false;
        }

    }

    // Getters y Setters

    public boolean isActivo() {
        return activo;
    }

    public String getNombre() {
        return nombre;
    }
    

}
