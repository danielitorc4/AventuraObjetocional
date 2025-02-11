package com.iesfilipinas.dam.vespertino.logica;

import java.util.ArrayList;

public class GestorDeDialogos {

    private ArrayList<String> dialogos = new ArrayList<String>();

    public void inicializarDialogos() {
        // Historia y demás
    }

    public String getDialogo(int indice) {
        return dialogos.get(indice);
    }
}
