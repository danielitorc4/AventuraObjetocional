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
        textosDialogos.add("Te despiertas desconcertado en la orilla de una playa. Miras a tus alrededores. \n" + //
                        "Hacia el norte ves una gran mansión un tanto espeluznante. \n" + //
                        "Hacia el este parece haber solo mar, pero avistas en la orilla una lancha. \n" + //
                        "Hacia el oeste parece haber una especie de cobertizo o trastero. \n" + //
                        "Miras detrás de tí hacia el sur, pero solo está el océano... \n" + //
                        "Todo esto me resulta extrañamente familiar \n" + //
                        "¿Qué deberías hacer primero? Te preguntas mientras te levantas del suelo.");

        nombresDialogos.add("NotaPB");
        textosDialogos.add("Nota de Daniel\r\n" +
                "Hoy, me encuentro al borde del abismo. He decidido consumir el brebaje que he creado, un elixir que promete borrar los recuerdos de mis experimentos.\n" +
                "Cada día, la culpa me consume más, y las sombras de mi pasado se ciernen sobre mí, susurrando verdades que preferiría olvidar.\n" +
                "He cruzado líneas que nunca debí tocar, manipulando la vida misma en busca de respuestas.\n" +
                "Pero lo que he descubierto es una carga demasiado pesada para llevar. Antes de que la locura me atrape, debo olvidar.\n" +
                "Solo entonces podré encontrar un resquicio de paz en este laberinto de dolor.\n");

        nombresDialogos.add("NotaP1");
        textosDialogos.add("Nota de Daniel\r\n" +  
                "No puedo huir de la verdad, por mucho que lo desee. Al repasar mis experimentos, una imagen se clava en mi mente: la de mi esposa y mi hijo, atrapados\n"
                + "en un horror que yo mismo creé. La desesperación me llevó a cruzar un límite inimaginable.\n"
                + "Cuando la ciencia se volvió mi única compañía, utilicé a los que más amaba como sujetos de prueba, convencido de que podría salvarlos de una muerte inminente.\n"
                + "Ahora, cada momento de lucidez es un recordatorio de mi traición. Ellos pagaron el precio de mis ambiciones, y sus rostros persiguen mis pensamientos, incluso\n"
                + "en mi intento por olvidar. Este brebaje es mi última esperanza para liberarme de esta pesadilla, aunque sé que la culpa jamás me abandonará.\n\n"
                );
    
        nombresDialogos.add("Instrucciones");
        textosDialogos.add(" -- Instrucciones y consejos -- \n" +
                "Para moverte, utiliza las teclas WASD como inputs. \n" +
                "Para interactuar con los objetos, utiliza la tecla E. \n" +
                "Si al lado de una casilla ves un asterisco '*' significa que hay algo con lo que interactuar. \n" +
                "Interactúa varias veces con las cosas para asegurarte de que no te dejas nada. \n" +
                "¡Disfruta del juego!" + "\n---------------------------------------------------------------------------");

        nombresDialogos.add("normalEnding");
        textosDialogos.add("El motor de la lancha resonaba sobre el silencio del océano mientras Daniel se alejaba de la isla. La oscuridad \n" + 
                        "envolvía el horizonte, y las luces de la costa aún estaban lejos.\\r\\n" + 
                        "Había logrado escapar. No quedaba rastro del terror que lo había perseguido, ni de los secretos que la isla escondía. \n" + 
                        "Pero mientras las olas lo llevaban cada vez más lejos, un vacío inexplicable se asentaba en su pecho, como si algo importante hubiera quedado atrás.\r\n" + 
                        "La isla desapareció entre la niebla, llevándose consigo las respuestas que Daniel nunca llegó a buscar.\r\n" + 
                        "FIN");
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
