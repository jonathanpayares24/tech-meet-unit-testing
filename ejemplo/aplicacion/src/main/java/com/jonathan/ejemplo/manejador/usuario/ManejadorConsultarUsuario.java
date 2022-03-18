package com.jonathan.ejemplo.manejador.usuario;

import com.jonathan.ejemplo.modelo.dto.DtoUsuario;
import com.jonathan.ejemplo.puerto.RepositorioUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ManejadorConsultarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<DtoUsuario> ejecutar() {
        return this.repositorioUsuario.consultarUsuarios();
    }
}
