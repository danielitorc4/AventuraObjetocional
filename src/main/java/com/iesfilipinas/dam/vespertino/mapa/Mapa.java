package com.iesfilipinas.dam.vespertino.mapa;

import com.iesfilipinas.dam.vespertino.entidades.objetos.Armario;
import com.iesfilipinas.dam.vespertino.entidades.objetos.Objeto;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Monstruo;
import com.iesfilipinas.dam.vespertino.entidades.personajes.Npc;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
import com.iesfilipinas.dam.vespertino.logica.InputReader;

public class Mapa {
    // Los ejes están pensados para funcionar con un array
    private static final int mapaMaxX = 9; // Alto
    private static final int mapaMaxY = 11; // Ancho
    private static final int mapaMaxZ = 4; // Profundidad 

    private Jugador jugador;
    private Casilla[][][] terrenos;

    public Mapa(Jugador jugador) {
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
                    System.out.print(formatearCasilla(nx, ny));
                }
            }
            System.out.println();
        }
    }

    private String formatearCasilla(int nx, int ny) {
        if (nx == jugador.getX() && ny == jugador.getY()) {
            // Representar al jugador
            return String.format("%-20s", "(jugador)");
        } else {
            Casilla casilla = obtenerOCrearCasilla(nx, ny, jugador.getZ());
            StringBuilder contenido = new StringBuilder();
            // append es para concatenar
            contenido.append("[").append(nx).append(",").append(ny).append(",").append(jugador.getZ()).append("] ");
            contenido.append(casilla.getTerreno());
            if (casilla.getNPCs() != null && !casilla.getNPCs().isEmpty() ||  // Añadir un * a las casillas con NPCs u objetos
                casilla.getObjetos() != null && !casilla.getObjetos().isEmpty()) {
                contenido.append("*");
            }
            return String.format("%-20s", contenido.toString());
        }
    }


    public void realizarAccionOMovimiento(Jugador jugador, String input) {
        switch (input) {
            case "arriba","w" -> {
                if (!esUnMovimientoValido(jugador, input)) { 
                    return;
                }
                jugador.setX(jugador.getX() - 1);
            }
            case "abajo", "s" -> {
                 if (!esUnMovimientoValido(jugador, input)) { 
                     return;
                 }
                 jugador.setX(jugador.getX() + 1);
             }
            case "izquierda", "a" -> {
                 if (!esUnMovimientoValido(jugador, input)) { 
                     return;
                 }
                 jugador.setY(jugador.getY() - 1);
             }
            case "derecha", "d" -> { 
                 if (!esUnMovimientoValido(jugador, input)) { 
                     return;
                 }
                 jugador.setY(jugador.getY() + 1);
             }
             case "interactuar", "e" -> {
                 Casilla casilla = obtenerOCrearCasilla(jugador.getX(), jugador.getY(), jugador.getZ());
                 mostrarInteractuablesEInteractuar(casilla);

             }
             case "inventario", "i" -> {
                if (jugador.getInventario().getObjetos().length == 0) {
                    System.out.println("El inventario está vacío.");
                    return;
                }
                
                System.out.println("Qué objeto quieres usar?");
                jugador.getInventario().mostrarInventario();
                String respuesta = InputReader.leerLineaMinusculas();
                for (Objeto objeto : jugador.getInventario().getObjetos()) {
                    if(objeto.getNombre().equalsIgnoreCase(respuesta)) {
                        objeto.interactuar(jugador);
                    }
                }
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
            case "CP": return TiposDeTerreno.CASETA;
            case "J": return TiposDeTerreno.JARDIN;
            case "CO": return TiposDeTerreno.COBERTIZO;
            case "CN": return TiposDeTerreno.CONTINENTE;
            case "I": return TiposDeTerreno.INICIO;
            // Planta baja
            case "EN": return TiposDeTerreno.ENTRADA; // Es del exterior también
            case "SA": return TiposDeTerreno.SALON; // Es del P1 también
            case "CC": return TiposDeTerreno.COCINA;
            case "CM": return TiposDeTerreno.COMEDOR;
            // Piso 1
            case "H": return TiposDeTerreno.HABITACION; 
            case "CD": return TiposDeTerreno.MUSEO;
            case "PA": return TiposDeTerreno.PASILLO;
            case "HN": return TiposDeTerreno.DORM_INFANTIL;
            case "HP": return TiposDeTerreno.DORMITORIO;
            // Desconocido
            default: return TiposDeTerreno.DESCONOCIDO;
        }
    }
    public Casilla obtenerOCrearCasilla(int x, int y, int z) { // Lo hice public para acceder desde Juego para detectar casillas de continente y terminar el juego
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

        if (Armario.isEscondido()) {    
            System.out.println("No puedes moverte mientras estés en el armario.");
            return false;
        }
        
        switch (direccion) { // Nueva posición
            case "arriba", "w" -> newX--;
            case "abajo", "s" -> newX++;
            case "izquierda", "a" -> newY--;
            case "derecha", "d" -> newY++;
        }
        
        if (newX < 0 || newX >= mapaMaxX || newY < 0 || newY >= mapaMaxY || newZ < 0 || newZ >= mapaMaxZ) { // Out of bounds
            return false;
        }
        
        Casilla newCasilla = obtenerOCrearCasilla(newX, newY, newZ);
        if (newCasilla == null) { // Casilla out of bounds, es un if de seguridad por si sucede algo extraño
            return false;
        }
        if (newCasilla.getTerreno().equals(TiposDeTerreno.CASA)) { // Casilla de casa
            jugador.quitarVida(1);
            System.out.println("¡Ouch! Te has chocado con una pared.");
            jugador.mostrarVida();
            return false;
        }

        if(newCasilla.getTerreno().equals(TiposDeTerreno.AGUA)) {
            if (jugador.getZ() == 1 && ContenedorDeBooleanos.getEstadoBooleano("lanchaEncendida")) {
                return true;
            }
            System.out.println("No puedes meterte en el agua.");

            return false;
        }
        
        return true;
    }

    private void mostrarInteractuablesEInteractuar(Casilla casilla) {
        if ((casilla.getNPCs() == null || casilla.getNPCs().isEmpty()) && (casilla.getObjetos() == null || casilla.getObjetos().isEmpty())) {
            System.out.println("No hay nada ni nadie con lo que interactuar.");
            return;
        }

        // Mostrar los interactuables
        System.out.println("¿Con qué quieres interactuar?");
        if (casilla.getNPCs() != null && !casilla.getNPCs().isEmpty()) {
            for (Npc npc : casilla.getNPCs()) {
                System.out.println("-" + npc.getNombre());
            }
        }
        if (casilla.getObjetos() != null && !casilla.getObjetos().isEmpty()) {
            for (Objeto objeto : casilla.getObjetos()) {
                System.out.println("+ " + objeto.getNombre());
            }
        }

        // Pedir con qué interactuar y llamar al método de interactuar de dicho objeto o npc
        String input = InputReader.leerLineaMinusculas();
      
        for (Npc npc : casilla.getNPCs()) {
            if (npc.getNombre().toLowerCase().equals(input)) {
                npc.interactuar(jugador);
                return;
            }
        }

        for (Objeto objeto : casilla.getObjetos()) {
            if (objeto.getNombre().toLowerCase().equals(input)) {
                objeto.interactuar(jugador);
                return;
            }
        }

    }

    public boolean hayMonstruoEn(int x, int y, int z) { // Revisa si hay una instancia del monstruo en la casilla
        for (Monstruo monstruo : Monstruo.getTodosLosMonstruos()) {
            if (monstruo.getX() == x && monstruo.getY() == y && monstruo.getZ() == z) {
                return true;
            }
        }
        return false;
    }

}
