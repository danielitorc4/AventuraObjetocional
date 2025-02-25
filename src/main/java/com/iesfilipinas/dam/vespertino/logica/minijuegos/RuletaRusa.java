package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import java.util.Random;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.InputReader;

public class RuletaRusa extends Minijuego {

    public RuletaRusa(String nombre) {
        super(nombre);
    }

    public void inicializarMinijuego(Jugador jugador) { // Este código es "reciclado", podría ligar un npc al minijuego y quitarle vida a este en lugar de simplemente decir que he ganado
        activo = true;
        Random random = new Random();

	    int decision;        
	    System.out.println("¡Bienvenido a la ruleta rusa!");
	    while (activo) {
	        do {
	        	System.out.println("Es tu turno. Elige: 1. Dispararte a ti mismo, 2. Disparar al oponente");
                    decision = InputReader.leerEntero();	
                    if (decision == 1 || decision == 2) {
                        break;
                    } else {
                        System.out.println("Numero no válido. Solo puedes elegir 1 o 2.");
                    }
	        } while (true);
	     
	        boolean bala = random.nextBoolean(); // true significa que hay bala.
	        
	        if (decision == 1) {
	            if (bala) {
	                System.out.println("Te disparaste y perdiste");
	                jugador.quitarVida(75);
	            } else {
	                System.out.println("El tambor está vacío. Sobreviviste.");
	            }
	        } else if (decision == 2) {
	            if (bala) {
	                System.out.println("¡Le disparaste al oponente y ganaste!");
	                activo = false;
	                return;
	            } else {
	                System.out.println("El tambor está vacío. El oponente sobrevivió.");
	            }
	        } else {
	            System.out.println("Opción no válida. Intenta de nuevo.");
	        }
	        
	     // Turno del oponente
	        System.out.println("Es el turno del oponente...");
	        int decisionOponente = random.nextInt(2) + 1;
	        boolean balaOponente = random.nextBoolean();

	        if (decisionOponente == 1) {
	            System.out.println("El oponente decidió dispararse a sí mismo.");
	            if (balaOponente) {
	                System.out.println("El oponente se disparó y murió.");
	                System.out.println("¡Has ganado el juego!");
	                activo = false;
	                return;
	            } else {
	                System.out.println("El tambor está vacío. El oponente sobrevivió.");
	            }
	        } else {
	            System.out.println("El oponente decidió dispararte a ti.");
	            if (balaOponente) {
	                System.out.println("El oponente te disparó y perdiste.");
	                jugador.quitarVida(75);
	            } else {
	                System.out.println("El tambor está vacío. Sobreviviste.");
	            }
	        } 
	    } 
    }

}
