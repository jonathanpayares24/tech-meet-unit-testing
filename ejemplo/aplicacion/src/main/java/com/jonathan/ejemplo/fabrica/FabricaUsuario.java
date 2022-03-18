package com.jonathan.ejemplo.fabrica;

import com.jonathan.ejemplo.comando.ComandoUsuario;
import com.jonathan.ejemplo.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    public Usuario crearUsuario(ComandoUsuario comandoUsuario) {
        return new Usuario(comandoUsuario.getId(), comandoUsuario.getNombre(), comandoUsuario.getEdad(), comandoUsuario.getDireccion());
    }
}
