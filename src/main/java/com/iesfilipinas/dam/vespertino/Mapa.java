package com.iesfilipinas.dam.vespertino;

public class Mapa {
    private static final int mapaMaxX = 11; // Ancho 
    private static final int mapaMaxY = 9; // Alto 
    private static final int mapaMaxZ = 4; // Profundidad 

    private Jugador jugador;
    private Casilla[][][] terrenos;

    Mapa(Jugador jugador) {
        this.jugador = jugador;
        this.terrenos = new Casilla[mapaMaxX][mapaMaxY][mapaMaxZ];
    }

    // Plantilla del mapa
    private String[][][] plantillaTerrenos = {
        { // Sótano
            {"A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A"}, // 0
            {"S", "S", "A", "A", "A", "C", "C", "A", "S", "S", "E"}, // 1
            {"S", "S", "S", "A", "A", "C", "C", "A", "S", "S", "E"}, // 2
            {"S", "S", "S", "S", "A", "A", "A", "A", "A", "S", "S"}, // 3
            {"A", "S", "S", "S", "A", "A", "A", "A", "A", "S", "S"}, // 4
            {"A", "A", "S", "S", "S", "A", "C", "C", "A", "S", "S"}, // 5
            {"A", "C", "C", "S", "S", "S", "C", "C", "A", "S", "S"}, // 6
            {"A", "C", "C", "A", "S", "S", "S", "S", "S", "S", "S"}, // 7
            {"A", "C", "C", "A", "S", "S", "S", "S", "S", "S", "S"}  // 8
        },
        { // Exterior
            {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"}, // 0
            {"C", "C", "C", "C", "C", "EN", "C", "C", "C", "C", "C"}, // 1
            {"CP", "CP", "J", "J", "J", "J", "J", "J", "J", "J", "J"}, // 2
            {"CP", "CP", "J", "J", "J", "J", "J", "J", "J", "J", "J"}, // 3
            {"J", "J", "J", "J", "J", "J", "J", "J", "J", "J", "J"}, // 4
            {"CO", "CO", "J", "J", "J", "I", "J", "J", "A", "A", "A"}, // 5
            {"A", "A", "A", "A", "A", "A", "A", "A", "A", "CN", "CN"}, // 6
            {"A", "A", "A", "A", "A", "A", "A", "A", "A", "CN", "CN"}, // 7
            {"CN", "CN", "CN", "CN", "CN", "CN", "CN", "CN", "CN", "CN", "CN"}  // 8 
        },
        { // Interior PB
            {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"}, // 0
            {"H", "H", "C", "SA", "SA", "EN", "SA", "SA", "SA", "SA", "E"}, // 1
            {"H", "H", "H", "SA", "SA", "SA", "SA", "SA", "SA", "SA", "E"}, // 2
            {"H", "H", "H", "SA", "SA", "SA", "SA", "C", "C", "C", "C"}, // 3
            {"H", "H", "C", "SA", "SA", "SA", "SA", "C", "C", "C", "C"}, // 4
            {"C", "C", "C", "CC", "C", "CM", "CM", "C", "C", "C", "C"}, // 5
            {"CC", "CC", "CC", "CC", "C", "CM", "CM", "CM", "CM", "CM", "CM"}, // 6
            {"CC", "CC", "CC", "CC", "C", "CM", "CM", "CM", "CM", "CM", "CM"}, // 7
            {"CC", "CC", "CC", "CC", "C", "CM", "CM", "CM", "CM", "CM", "CM"}  // 8
        },
        { // Interior P1
            {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"}, // 0
            {"C", "CD", "CD", "CD", "C", "C", "SA", "SA", "SA", "SA", "E"}, // 1
            {"C", "CD", "CD", "CD", "PA", "PA", "SA", "SA", "SA", "SA", "E"}, // 2
            {"C", "CD", "CD", "CD", "PA", "PA", "SA", "SA", "SA", "SA", "C"}, // 3
            {"C", "C", "C", "C", "PA", "PA", "C", "C", "C", "C", "C"}, // 4
            {"C", "HN", "HN", "C", "PA", "PA", "C", "HP", "HP", "HP", "C"}, // 5
            {"C", "HN", "HM", "HN", "PA", "PA", "HP", "HP", "HP", "HP", "C"}, // 6
            {"C", "HN", "HN", "HN", "PA", "PA", "HP", "HP", "HP", "HP", "C"}, // 7
            {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"}  // 8
        }
    };

    // Cargar la casilla del jugador y las que la rodean en el mismo piso (Lazy Initialization) (Un 3x3)
    public void cargarCasillasVisibles() {
        System.out.println("\nCasillas visibles:");
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = jugador.getX() + i;
                int ny = jugador.getY() + j;
                if (nx >= 0 && ny >= 0 && nx < mapaMaxX && ny < mapaMaxY) {
                    if (nx == jugador.getX() && ny == jugador.getY()) { // Carga el jugador
                        System.out.print(" (jugador) ");
                    } else {
                        Casilla casilla = obtenerOCrearCasilla(nx, ny, jugador.getZ());
                        System.out.print("[" + nx + "," + ny + "," + jugador.getZ() + "] ");
                        System.out.print(casilla.getTerreno());
                        if (casilla.getNPCs() != null && !casilla.getNPCs().isEmpty() || 
                        casilla.getObjetos() != null && !casilla.getObjetos().isEmpty()) {
                             System.out.print("*");
                        }
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
    public void moverse(Jugador jugador, String input) {
        switch (input) {
            case "arriba","w" -> {
                if (!esUnMovimientoValido(jugador, input)) { 
                    break;
                }
                jugador.setY(jugador.getY() - 1);
            }
            case "abajo", "s" -> {
                 if (!esUnMovimientoValido(jugador, input)) { 
                     break;
                 }
                 jugador.setY(jugador.getY() + 1);
             }
            case "izquierda", "a" -> {
                 if (!esUnMovimientoValido(jugador, input)) { 
                     break;
                 }
                 jugador.setX(jugador.getX() - 1);
             }
            case "derecha", "d" -> { 
                 if (!esUnMovimientoValido(jugador, input)) { 
                     break;
                 }
                 jugador.setX(jugador.getX() + 1);
             }
        }
    }
    public void colocarNPC(int x, int y, int z, Npc npc) {
        Casilla casilla = obtenerOCrearCasilla(x, y, z);
        if (casilla != null) {
            casilla.agregarNPC(npc);
        }
    }
    public void colocarObjeto(int x, int y, int z, Objeto objeto) {
        Casilla casilla = obtenerOCrearCasilla(x, y, z);
        if (casilla != null) {
            casilla.agregarObjeto(objeto);
        }
    }
    private TiposDeTerreno sacarTerrenoCasilla(String tipo) {
        switch (tipo) {
            // Generales
            case "A": return TiposDeTerreno.AGUA;
            case "C": return TiposDeTerreno.CASA;
            case "E": return TiposDeTerreno.ESCALERA;
            // Sótano
            case "S": return TiposDeTerreno.SOTANO;
            // Exterior
            case "P": return TiposDeTerreno.CASETAPERRO;
            case "J": return TiposDeTerreno.JARDIN;
            case "CO": return TiposDeTerreno.COBERTIZO;
            case "CN": return TiposDeTerreno.CONTINENTE;
            // Planta baja
            case "EN": return TiposDeTerreno.ENTRADA; // Es del exterior también
            case "SA": return TiposDeTerreno.SALON; // Es del P1 también
            case "CC": return TiposDeTerreno.COCINA;
            case "CM": return TiposDeTerreno.COMEDOR;
            // Piso 1
            case "H": return TiposDeTerreno.HABITACION; // Es del P1 también
            case "CD": return TiposDeTerreno.SALACUADRO;
            case "PA": return TiposDeTerreno.PASILLO;
            case "HN": return TiposDeTerreno.HABITACIONNINO;
            case "HP": return TiposDeTerreno.HABITACIONPADRE;
            // Desconocido
            default: return TiposDeTerreno.DESCONOCIDO;
        }
    }
    private Casilla obtenerOCrearCasilla(int x, int y, int z) {
        if (x >= 0 && y >= 0 && z >= 0 && x < mapaMaxX && y < mapaMaxY && z < mapaMaxZ) { // Límites del mapa
            if (terrenos[x][y][z] == null) { // Si no está creada, la instanciamos
                terrenos[x][y][z] = new Casilla(x, y, z, sacarTerrenoCasilla(plantillaTerrenos[z][x][y])); // Primero indexa por la profundidad y luego las dimensiones
            }
            return terrenos[x][y][z];
        }
        return null; // Casilla fuera del mapa
    }
    private boolean esUnMovimientoValido(Jugador jugador, String direccion) {
        int newX = jugador.getX();
        int newY = jugador.getY();
        int newZ = jugador.getZ();
        
        switch (direccion) { // Nueva posición
            case "arriba", "w" -> newY--;
            case "abajo", "s" -> newY++;
            case "izquierda", "a" -> newX--;
            case "derecha", "d" -> newX++;
        }
        
        if (newX < 0 || newX >= mapaMaxX || newY < 0 || newY >= mapaMaxY || newZ < 0 || newZ >= mapaMaxZ) { // Out of bounds
            return false;
        }
        
        Casilla newCasilla = obtenerOCrearCasilla(newX, newY, newZ);
        if (newCasilla == null) { // Casilla out of bounds, es un if de seguridad por si sucede algo extraño
            return false;
        }
        if (newCasilla.getTerreno().equals(TiposDeTerreno.CASA)) { // Casilla de casa
            jugador.quitarVida(1);;
            System.out.println("¡Ouch! Te has chocado con una pared.");
            System.out.println("Vida restante: " + jugador.getVida());
            return false;
        }
        // Añadir otro if para el agua con y sin lancha
        
        return true;
    }


}
