package com.jonathan.ejemplo.puerto;

public interface RepositorioPago {

    Double consultarValorPago(String tipo);

    void realizarPago(Double valor);
}
