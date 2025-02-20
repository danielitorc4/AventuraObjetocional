package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import java.util.Random;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
import com.iesfilipinas.dam.vespertino.logica.GestorDeDialogos;
import com.iesfilipinas.dam.vespertino.logica.InputReader;

public class TresEnRaya extends Minijuego {

    private final char[][] tablero = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    private static final char simboloJugador = 'X';

    public TresEnRaya() {
        super("TresEnRaya");
    }

    @Override
    public void inicializarMinijuego(Jugador jugador) {
        activo = true;

        while (activo) {
            imprimirTablero();
            System.out.print("Elige una posición (1-9): ");
            int posicion;
            int fila;		// Calculo la posición de la i en la matriz
            int columna;   // Calculo la posición de la j en la matriz
            boolean movimientoValido = false;
            
            do { 	// Bucle hasta que se realice un movimiento válido
                System.out.print("Elige una posición (1-9): ");
                posicion = InputReader.leerEntero();

                if (posicion < 1 || posicion > 9) {
                    System.out.println("Posición inválida. Elige un número entre 1 y 9.");
                    continue; // Pedir otra entrada
                }

                fila = (posicion - 1) / 3;
                columna = (posicion - 1) % 3;

            	if (tablero[fila][columna] != 'X' && tablero[fila][columna] != 'O') {
            		tablero[fila][columna] = simboloJugador; 	// Marcar la casilla con 'X'
            		movimientoValido = true;
            	} else {
            		System.out.println("Movimiento inválido, intenta de nuevo.");
            		movimientoValido = false;
            	}
            } while (!movimientoValido);

            // Comprobar si el jugador ha ganado
            if (comprobarGanador(simboloJugador)) {
                System.out.println("¡Has ganado!\n");
                ContenedorDeBooleanos.cambiarEstadoBooleano("tresEnRayaGanado", true);
                activo = false;
             
            }

            if (tableroLleno() && activo) {
                imprimirTablero();
                System.out.println("¡Es un empate!\n");
                activo = false;
                return; // Evitar que empiece el turno del NPC, evitando un bucle infinito
            }
          
         // Turno del NPC
            Random random = new Random();

            do {
                int npcPosicion = random.nextInt(9) + 1; // Genera un número del 1 al 9
                fila = (npcPosicion - 1) / 3;
                columna = (npcPosicion - 1) % 3;
            } while (tablero[fila][columna] == 'X' || tablero[fila][columna] == 'O'); // Busca una casilla libre

            tablero[fila][columna] = 'O'; // El NPC coloca su ficha
            
            // Comprobamos si el NPC ha ganado
            if (comprobarGanador('O')) {    
                System.out.println("¡El chico ha ganado!\n");
                System.out.println(GestorDeDialogos.getDialogo("jugadorPierdeTresEnRaya"));
                activo = false;
            } 

            if (tableroLleno() && activo) {
                imprimirTablero();
                System.out.println("¡Es un empate!\n");
                activo = false;
            }
        }        
    }

    private void imprimirTablero() {
        System.out.println("Tablero:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2]);
            if (i < 2) {
                System.out.println("---|---|---"); // Los separadores de filas
            }
        }
    }

    private boolean comprobarGanador(char simbolo) {
	
	    for (int i = 0; i < 3; i++) { // Comprobar filas
	        if (tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo) {
	            return true; // Devuelve true si el simbolo ha ganado
	        }
	    }
	
	    for (int i = 0; i < 3; i++) {  // Comprobar columnas
	        if (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo) {
	            return true; // Devuelve true si el simbolo ha ganado
	        }
	    }
	    
	    // Comprobar diagonales
	    if (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) {
	        return true; // Devuelve true si el simbolo ha ganado
	    }
	    if (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo) {
	        return true; // Devuelve true si el simbolo ha ganado
	    }
	    return false; // No hay ganador
	}

    private boolean tableroLleno() {
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (tablero[i][j] != 'X' && tablero[i][j] != 'O') {
	                return false; // Si hay al menos una posición libre
	            }
	        }
	    }
	    return true; // El tablero está lleno
	}
}
