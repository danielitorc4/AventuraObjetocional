package com.iesfilipinas.dam.vespertino.logica.minijuegos;

import com.iesfilipinas.dam.vespertino.entidades.personajes.Jugador;
import com.iesfilipinas.dam.vespertino.logica.ContenedorDeBooleanos;
import com.iesfilipinas.dam.vespertino.logica.InputReader;

public class Acertijo extends Minijuego{

    public Acertijo() {
        super("AcertijoCongelador");
    }

    public void inicializarMinijuego(Jugador jugador) {
        System.out.println("Parece haber un seguro congelado con una adivinanza escrita");
		String respuestaUsuario;
		int numIntentos = 0;
		activo = true;
        System.out.println("De un líquido nací y en frío me quedé; si me dejas salir, lágrimas dejaré. ¿Qué soy?");
		 do {
		        System.out.print("Tu respuesta (o escribe 'stop' para abandonar): ");
		        respuestaUsuario = InputReader.leerLineaMinusculas();
		        
		        if (respuestaUsuario.equals("hielo")) { 
		            System.out.println("¡Correcto! El congelador se ha abierto.");
		            ContenedorDeBooleanos.cambiarEstadoBooleano("acertijoCongeladorResuelto", true);
                    return;
                }

		        if (respuestaUsuario.equals("stop")) {
		            System.out.println("Has decidido abandonar el minijuego. El congelador sigue cerrado.");
		            return; 
		        }

                System.out.println("Respuesta incorrecta. Notas cómo los dedos se te congelan con cada intento");
                numIntentos++;
                if (numIntentos == 2) {
		
                    jugador.quitarVida(20);
                    numIntentos = 0;
				
                }

		    } while (activo && jugador.getVivo());   // Por algún motivo se está guardando algo en el buffer y al terminar el acertijo me pide escribir algo
	}
    
}
