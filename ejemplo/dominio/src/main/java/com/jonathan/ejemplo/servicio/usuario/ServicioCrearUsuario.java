package com.jonathan.ejemplo.servicio.usuario;

import com.jonathan.ejemplo.excepcion.ExcepcionElementoExistente;
import com.jonathan.ejemplo.modelo.Usuario;
import com.jonathan.ejemplo.puerto.RepositorioUsuario;

public class ServicioCrearUsuario {

    private static final String EL_USUARIO_YA_EXISTE = "El usuario con id %d ya existe.";
    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Usuario usuario) {
        validarExistenciaUsuario(usuario.getId());
        this.repositorioUsuario.crear(usuario);
    }

    private void validarExistenciaUsuario(Long idUsuario) {
        boolean usuarioExiste = this.repositorioUsuario.existe(idUsuario);
        if (usuarioExiste) {
            throw new ExcepcionElementoExistente(String.format(EL_USUARIO_YA_EXISTE, idUsuario));
        }
    }
}
