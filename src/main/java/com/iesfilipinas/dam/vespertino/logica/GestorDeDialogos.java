package com.iesfilipinas.dam.vespertino.logica;

import java.util.ArrayList;

public class GestorDeDialogos {

    private static ArrayList<String> dialogos = new ArrayList<String>();

    public static void inicializarDialogos() {
        String jugadorGanaTresEnRaya = " \\n" + 
                        "\nNiño: Me gustaría poder volver a mi habitación... pero mamá está muy enfadada y no me atrevo a subir..."
                        + "\nTiene que haber alguna forma de llamar su atención, algún ruido o algo.";

        String jugadorPierdeTresEnRaya = "Niño: Nunca consigues ganarme.";

        String jugadorEmpataTresEnRaya = "El niño se queda en silencio.";
    }

    public static String getDialogo(String dialogo) {
        if (!dialogos.contains(dialogo)) {
            return "El diálogo no existe";
        }

        int indice = getIndexDialogo(dialogo);
        return dialogos.get(indice);
    }

    public static int getIndexDialogo(String dialogo) {
        return dialogos.indexOf(dialogo);
    }
}
