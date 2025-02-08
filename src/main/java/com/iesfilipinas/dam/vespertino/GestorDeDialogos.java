package com.iesfilipinas.dam.vespertino;

import java.util.ArrayList;

public class GestorDeDialogos {

    private ArrayList<String> dialogos = new ArrayList<String>();

    public void inicializarDialogos() {
        dialogos.add("Woof!");
    }

    public String getDialogo(int indice) {
        return dialogos.get(indice);
    }
}
