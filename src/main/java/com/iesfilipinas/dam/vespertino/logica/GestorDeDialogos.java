package com.iesfilipinas.dam.vespertino.logica;

import java.util.ArrayList;

public class GestorDeDialogos {

    private static ArrayList<String> nombresDialogos = new ArrayList<>();
    private static ArrayList<String> textosDialogos = new ArrayList<>();


    public static void inicializarDialogos() {
        nombresDialogos.add("jugadorGanaTresEnRaya");
        textosDialogos.add("\nNiño: Me gustaría poder volver a mi habitación... pero mamá está muy enfadada y no me atrevo a subir..."
                + "\nTiene que haber alguna forma de llamar su atención, algún ruido o algo.");

        nombresDialogos.add("jugadorPierdeTresEnRaya");
        textosDialogos.add("Niño: Nunca consigues ganarme.");

        nombresDialogos.add("jugadorEmpataTresEnRaya");
        textosDialogos.add("El niño se queda en silencio.");

        nombresDialogos.add("inicioJuego");
        textosDialogos.add("Te despiertas desconcertado..."); // Terminar este diálogo
    
    }

    public static String getDialogo(String dialogo) {
        int indice = nombresDialogos.indexOf(dialogo);
        if (indice != -1) {
            return textosDialogos.get(indice);
        } else {
            return "El diálogo no existe";
        }
    }
}
