package com.jonathan.ejemplo.puerto;

import com.jonathan.ejemplo.modelo.Usuario;
import com.jonathan.ejemplo.modelo.dto.DtoTipoUsuario;
import com.jonathan.ejemplo.modelo.dto.DtoUsuario;

import java.util.List;

public interface RepositorioUsuario {

    void crear(Usuario usuario);

    boolean existe(Long id);

    boolean activo(Long id);

    List<DtoUsuario> consultarUsuarios();

    DtoTipoUsuario consultarTipoUsuario(Long id);
}
