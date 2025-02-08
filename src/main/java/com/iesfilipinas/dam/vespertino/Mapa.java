package com.iesfilipinas.dam.vespertino;

public class Mapa {
    private static final int mapaMaxX = 11; // Ancho 
    private static final int mapaMaxY = 9; // Alto 
    private static final int mapaMaxZ = 4; // Profundidad 

    private Casilla[][][] terrenos = new Casilla[mapaMaxX][mapaMaxY][mapaMaxZ];

    private Jugador jugador;

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


    private static String sacarTerrenoCasilla(String tipo) {
        switch (tipo) {
            // Generales
            case "A": return "Agua";
            case "C": return "Casa";
            case "E": return "Escalera";
            // Sótano
            case "S": return "Sotano";
            // Exterior
            case "P": return "CasetaPerro";
            case "J": return "Jardin";
            case "CO": return "Cobertizo";
            case "CN": return "Continente";
            // Planta baja
            case "EN": return "Entrada"; // Es del exterior también
            case "SA": return "Salon"; // Es del P1 también
            case "H": return "Habitacion";
            case "CC": return "Cocina";
            case "CM": return "Comedor";
            // Piso 1
            case "CD": return "Cuadro";
            case "PA": return "Pasillo";
            case "HN": return "HabitacionNino";
            case "HP": return "HabitacionPadre";
            // Desconocido
            default: return "Desconocido";
        }
    }


    private Casilla getCasilla(int x, int y, int z) {
        if (x >= 0 && y >= 0 && z >= 0 && x < mapaMaxX && y < mapaMaxY && z < mapaMaxZ) { // Límites del mapa
            if (terrenos[z][x][y] == null) { // Si no está creada, la instanciamos
                terrenos[z][x][y] = new Casilla(x, y, z, sacarTerrenoCasilla(plantillaTerrenos[x][y][z]));
            }
            return terrenos[z][x][y];
        }
        return null; // Casilla fuera del mapa
    }

    // Cargar la casilla del jugador y las 4 adyacentes en el mismo piso (Lazy Initialization)
    public void cargarCasillasVisibles() {
        System.out.println("Casillas visibles:");
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = jugador.getX() + i;
                int ny = jugador.getY() + j;
                if (nx >= 0 && ny >= 0 && nx < mapaMaxX && ny < mapaMaxY) {
                    getCasilla(nx, ny, jugador.getZ()); // Carga las casillas
                }
            }
        }
    }

   public void moverse(Jugador jugador, String input) {
       switch (input) {
           case "w":
               if(getCasilla(jugador.getX(), jugador.getY() - 1, jugador.getZ()) == null || 
               getCasilla(jugador.getX(), jugador.getY() - 1, jugador.getZ()).getTerreno().equals("C") || 
               (jugador.getY() - 1 < 0)) {
                   break;
               }
               jugador.setY(jugador.getY() - 1);
               break;
           case "s":
               jugador.setY(jugador.getY() + 1);
               break;
           case "a":
               jugador.setX(jugador.getX() - 1);
               break;
           case "d":
               jugador.setX(jugador.getX() + 1);
               break;
       }
   }

   private boolean esUnMovimientoValido(Jugador jugador, String direccion) {
    int newX = jugador.getX();
    int newY = jugador.getY();
    int newZ = jugador.getZ();
    
    switch (direccion) {
        case "w":
            newY--;
            break;
        case "s":
            newY++;
            break;
        case "a":
            newX--;
            break;
        case "d":
            newX++;
            break;
    }
    
    if (newX < 0 || newX >= mapaMaxX || newY < 0 || newY >= mapaMaxY || newZ < 0 || newZ >= mapaMaxZ) {
        return false;
    }
    
    Casilla newCasilla = getCasilla(newX, newY, newZ);
    if (newCasilla == null || newCasilla.getTerreno().equals("C")) {
        return false;
    }
    // Añadir otro if para el agua con y sin lancha
    
    return true;
}


}
