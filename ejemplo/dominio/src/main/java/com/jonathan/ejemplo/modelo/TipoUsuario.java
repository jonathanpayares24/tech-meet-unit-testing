package com.jonathan.ejemplo.modelo;

public enum TipoUsuario {
    OBRERO("obrero"),
    SECRETARIA("secretaria"),
    MENSAJERO("mensajero"),
    GERENTE("gerente");

    private String value;

    TipoUsuario(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
