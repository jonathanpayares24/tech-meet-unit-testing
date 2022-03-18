package com.jonathan.ejemplo.excepcion;

public class ExcepcionElementoExistente extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionElementoExistente(String message) {
        super(message);
    }
}
