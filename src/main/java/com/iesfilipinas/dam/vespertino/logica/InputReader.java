package com.iesfilipinas.dam.vespertino.logica;

import java.util.Scanner;
public class InputReader {
    
    private static Scanner scan = new Scanner(System.in);

    public static String leerLineaMinusculas() {
        return scan.nextLine().toLowerCase();
    }

    public static int leerEntero() {
        return scan.nextInt();
    }
    
}
