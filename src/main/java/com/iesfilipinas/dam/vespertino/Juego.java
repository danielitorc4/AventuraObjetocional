package com.iesfilipinas.dam.vespertino;

public class Juego {
    
    private String nombre; // Aventura Conversacional
    private boolean jugando;

    Juego  (String nombre) {
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
        String nombreJugador = System.console().readLine();

        Jugador jugador = new Jugador(5, 3, 1, nombreJugador);
        Mapa mapa = new Mapa(jugador);
        inicializarNpcs(mapa);
        inicializarObjetos(mapa);

        bucleJuego(jugador, mapa);
 
    }

    private void bucleJuego(Jugador jugador, Mapa mapa) {
        while (jugando) {
            mapa.cargarCasillasVisibles();
            System.out.println("\n¿Qué vas a hacer?");
            mostrarMenuOpciones();
            String movimiento = System.console().readLine().toLowerCase();
    
            // Aquí procesarías el movimiento
            mapa.moverse(jugador, movimiento);
    
            // Opcional: agregar una condición de salida (ejemplo: "salir" para terminar el juego)
            if (movimiento.equalsIgnoreCase("salir")) {
                terminarJuego();
                System.out.println("Juego terminado.");
            }
        }
    }

    private void terminarJuego() {
        this.jugando = false;
    }

    private void mostrarMenuOpciones() {
        System.out.println();
        System.out.println("1. Arriba | W");
        System.out.println("2. Abajo | S");
        System.out.println("3. Izquierda | A");
        System.out.println("4. Derecha | D");
        System.out.println("5. Interactuar | E");
        System.out.println("6. Ver mapa | M");
        System.out.println("7. Salir | S");
        System.out.println();
    }

    private void inicializarNpcs(Mapa mapa) {
        Perro perro = new Perro(0, 0, 0);
        mapa.colocarNPC(0, 0, 1, perro); // Ajustar ambas coordenadas
        // Colocar npcs
    }

    private void inicializarObjetos(Mapa mapa) {

    }
}