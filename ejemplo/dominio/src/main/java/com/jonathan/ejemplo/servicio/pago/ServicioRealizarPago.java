package com.jonathan.ejemplo.servicio.pago;

import com.jonathan.ejemplo.modelo.TipoUsuario;
import com.jonathan.ejemplo.modelo.dto.DtoTipoUsuario;
import com.jonathan.ejemplo.modelo.dto.DtoUsuario;
import com.jonathan.ejemplo.puerto.RepositorioPago;
import com.jonathan.ejemplo.puerto.RepositorioUsuario;

public class ServicioRealizarPago {

    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioPago repositorioPago;
    private final ServicioVerificarVigencia servicioVerificarVigencia;

    public ServicioRealizarPago(RepositorioUsuario repositorioUsuario, RepositorioPago repositorioPago, ServicioVerificarVigencia servicioVerificarVigencia) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPago = repositorioPago;
        this.servicioVerificarVigencia = servicioVerificarVigencia;
    }

    public void ejecutar(DtoUsuario usuario) {
        validarExistencia(usuario.getId());
        servicioVerificarVigencia.ejecutar(usuario.getId());
        DtoTipoUsuario tipoUsuario = repositorioUsuario.consultarTipoUsuario(usuario.getId());
        Double valorPago = repositorioPago.consultarValorPago(tipoUsuario.getTipo());
        if (tipoUsuario.getTipo().equals(TipoUsuario.OBRERO.getValue())) {
             valorPago = valorPago + (valorPago * 0.02);
        } else if (tipoUsuario.getTipo().equals(TipoUsuario.MENSAJERO.getValue())) {
            valorPago = valorPago - (valorPago * 0.05);
        } else if (tipoUsuario.getTipo().equals(TipoUsuario.SECRETARIA.getValue())) {
            double pagoMasBono = valorPago + obtenerBono(usuario.getEdad());
            valorPago = pagoMasBono - (pagoMasBono * 0.1);
        } else if (tipoUsuario.getTipo().equals(TipoUsuario.GERENTE.getValue())) {
            valorPago = convertirADolares(valorPago) + (valorPago * 0.05);
        }
        repositorioPago.realizarPago(valorPago);
    }

    private void validarExistencia(Long id) {
        boolean existe = repositorioUsuario.existe(id);
        if (!existe) {
            throw new RuntimeException(String.format("El usuario con ID %d no existe.", id));
        }
    }

    private Double convertirADolares(Double valor) {
        double valorEnDolares = valor * 3.800;
        return valorEnDolares - (valorEnDolares * 0.02);
    }

    private Double obtenerBono(Integer edad) {
        double valorBono;
        if (edad >= 18 && edad < 30) {
            valorBono = 0.05;
        } else if (edad >= 30 && edad < 45) {
            valorBono = 0.1;
        } else {
            valorBono = 0.15;
        }
        return valorBono;
    }
}
