package com.iesfilipinas.dam.vespertino.logica;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Congelador;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Estanteria;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Llave;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Puerta;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Hijo;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Perro;
import com.iesfilipinas.dam.vespertino.mapa.Mapa;

import java.util.Random;

public class Juego {
    
    private String nombre; // Aventura Conversacional
    private boolean jugando;

    private static Random random = new Random(); 

    public Juego (String nombre) {
        this.nombre = nombre;
        this.jugando = false;
    }

    // Getters y setters

    public boolean isJugando() {
        return jugando;
    }

    public void iniciarJuego() {
        this.jugando = true;
        System.out.println("¡Bienvenido a " + this.nombre + "!");
        System.out.println("¿Cuál es tu nombre?");
        String nombreJugador = InputReader.leerLineaMinusculas();

        Jugador jugador = new Jugador(5, 5, 1, nombreJugador);
        Mapa mapa = new Mapa(jugador);
        inicializarNpcs(mapa);
        inicializarObjetos(mapa);
        GestorDeDialogos.inicializarDialogos();
        System.out.println(GestorDeDialogos.getDialogo("inicioJuego"));

        bucleJuego(jugador, mapa);
 
    }

    private void bucleJuego(Jugador jugador, Mapa mapa) {
        while (jugando && jugador.getVivo()) {
            mapa.cargarCasillasVisibles();
            System.out.println("\n¿Qué vas a hacer?");
            mostrarMenuOpciones();
            String movimiento = InputReader.leerLineaMinusculas();
            System.out.println();

            mapa.realizarAccionOMovimiento(jugador, movimiento);
    
            // Comprobaciones para terminar el juego
            if (movimiento.equalsIgnoreCase("salir")) {
                terminarJuego();
                System.out.println("Juego terminado.");
            }

            if (!jugador.getVivo()) {
                terminarJuego();
                System.out.println("Has muerto.");
            }
        }
    }

    private void terminarJuego() {
        this.jugando = false;
        InputReader.leerLineaMinusculas();
    }

    private void mostrarMenuOpciones() {
        System.out.println();
        System.out.println("Arriba | W");
        System.out.println("Abajo | S");
        System.out.println("Izquierda | A");
        System.out.println("Derecha | D");
        System.out.println("Interactuar | E");
        System.out.println("Salir");
        System.out.println();
    }

    private void inicializarNpcs(Mapa mapa) {
        // Colocar npcs
        Perro perro = new Perro(random(2, 3), random(0, 1), 1);
        mapa.colocarNPC(perro.getX(), perro.getY(), perro.getZ(), perro); // Ajustar ambas coordenadas

         Hijo hijo = new Hijo("Chaval", random(6, 8), random(5, 10), 2);
        mapa.colocarNPC(hijo.getX(), hijo.getY(), hijo.getZ(), hijo);
    }

    private void inicializarObjetos(Mapa mapa) {
        // Colocar objetos
        Estanteria estanteriaCobertizo = new Estanteria(5, random(0,1), 1);
        mapa.colocarObjeto(estanteriaCobertizo.getX(), estanteriaCobertizo.getY(), estanteriaCobertizo.getZ(), estanteriaCobertizo);

            Llave llave = new Llave();
            estanteriaCobertizo.getInventario().agregarObjeto(llave);

        Puerta puertaEntradaExterior = new Puerta(1, 5, 1);
        mapa.colocarObjeto(puertaEntradaExterior.getX(), puertaEntradaExterior.getY(), puertaEntradaExterior.getZ(), puertaEntradaExterior);

        Puerta puertaEntradaInterior = new Puerta(1, 5, 2);
        mapa.colocarObjeto(puertaEntradaInterior.getX(), puertaEntradaInterior.getY(), puertaEntradaInterior.getZ(), puertaEntradaInterior);
   
        Congelador congelador = new Congelador(random(6, 8), random(0, 3), 2);
        mapa.colocarObjeto(congelador.getX(), congelador.getY(), congelador.getZ(), congelador);

    }

    private int random(int min, int max) { // Método para simplificar el uso de random (así no uso .nextInt en cada llamada)
        return random.nextInt(max - min + 1) + min;
    }

}