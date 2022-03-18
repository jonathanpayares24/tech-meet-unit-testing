package com.jonathan.ejemplo.servicio.pago;

import com.jonathan.ejemplo.puerto.RepositorioUsuario;

public class ServicioVerificarVigencia {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioVerificarVigencia(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
        boolean esVigente = repositorioUsuario.activo(id);
        if (!esVigente) {
            throw new RuntimeException(String.format("El usuario con ID %d no está vigente.", id));
        }
    }
}
