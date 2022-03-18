package com.jonathan.ejemplo.adaptador;

import com.jonathan.ejemplo.puerto.RepositorioPago;
import org.springframework.stereotype.Component;

@Component
public class RepositorioPagoSQLServer implements RepositorioPago {

    @Override
    public Double consultarValorPago(String tipo) {
        return null;
    }

    @Override
    public void realizarPago(Double valor) {

    }
}
