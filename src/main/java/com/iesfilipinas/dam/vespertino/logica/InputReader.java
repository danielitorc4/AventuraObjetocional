package com.iesfilipinas.dam.vespertino.logica;

import java.util.Scanner;
public class InputReader {
    
    private static Scanner scan = new Scanner(System.in);

    public static String leerLineaMinusculas() {
        return scan.nextLine().toLowerCase();
    }

    public static int leerEntero() {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Por favor, introduce un número.");
        }
        int entero = scan.nextInt(); 
        scan.nextLine(); 
        return entero;
    }
    
}
