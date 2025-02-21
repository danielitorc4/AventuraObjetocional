package com.iesfilipinas.dam.vespertino.logica;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Carne;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Congelador;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Escalera;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Estanteria;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Llave;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Puerta;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Hijo;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Monstruo;
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
        inicializarJuego(mapa);
        System.out.println(GestorDeDialogos.getDialogo("inicioJuego"));

        bucleJuego(jugador, mapa);
 
    }

    private void inicializarJuego(Mapa mapa) {
        inicializarNpcs(mapa);
        inicializarObjetos(mapa);
        GestorDeDialogos.inicializarDialogos();
        ContenedorDeBooleanos.inicializarBooleanos();
    }

    private void bucleJuego(Jugador jugador, Mapa mapa) {
        while (jugando) {
            if (mapa.hayMonstruoEn(jugador.getX(), jugador.getY(), jugador.getZ())) {
                System.out.println("\nTe ha atacado un monstruo.");
                jugador.setVida(0);
            } 

            if (!jugador.getVivo()) {
                System.out.println("Has muerto.");
                terminarJuego();
            }

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

        Monstruo monstruo = new Monstruo(1, 10, 3, "Monstruo");
        Monstruo monstruoAux = new Monstruo(2, 10, 3, "Monstruo");

        // No voy a colocarlos en casillas
        /*  
        mapa.colocarNPC(monstruo.getX(), monstruo.getY(), monstruo.getZ(), monstruo);
        mapa.colocarNPC(monstruoAux.getX(), monstruoAux.getY(), monstruoAux.getZ(), monstruoAux);
        */
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

            Carne carne = new Carne();
            congelador.getInventario().agregarObjeto(carne);

        Escalera escaleraPB = new Escalera(1, 10, 2);
        Escalera escaleraPB_2 = new Escalera(2, 10, 2);
        mapa.colocarObjeto(escaleraPB.getX(), escaleraPB.getY(), escaleraPB.getZ(), escaleraPB);
        mapa.colocarObjeto(escaleraPB_2.getX(), escaleraPB_2.getY(), escaleraPB_2.getZ(), escaleraPB_2);

            Puerta puertaSotano = new Puerta(1, 10, 2, "Puerta_Sotano");
            Puerta puertaSotano2 = new Puerta(2, 10, 2, "Puerta_Sotano");
            escaleraPB.getInventario().agregarObjeto(puertaSotano);
            escaleraPB_2.getInventario().agregarObjeto(puertaSotano2);

        Escalera escaleraP1 = new Escalera(1, 10, 3);
        Escalera escaleraP1_2 = new Escalera(2, 10, 3);
        mapa.colocarObjeto(escaleraP1.getX(), escaleraP1.getY(), escaleraP1.getZ(), escaleraP1);
        mapa.colocarObjeto(escaleraP1_2.getX(), escaleraP1_2.getY(), escaleraP1_2.getZ(), escaleraP1_2);

        Escalera escaleraSotano = new Escalera(1, 10, 0);
        Escalera escaleparSotano_2 = new Escalera(2, 10, 0);
        mapa.colocarObjeto(escaleraSotano.getX(), escaleraSotano.getY(), escaleraSotano.getZ(), escaleraSotano);
        mapa.colocarObjeto(escaleparSotano_2.getX(), escaleparSotano_2.getY(), escaleparSotano_2.getZ(), escaleparSotano_2);
    }

    private int random(int min, int max) { // Método para simplificar el uso de random (así no uso .nextInt en cada llamada)
        return random.nextInt(max - min + 1) + min;
    }

}