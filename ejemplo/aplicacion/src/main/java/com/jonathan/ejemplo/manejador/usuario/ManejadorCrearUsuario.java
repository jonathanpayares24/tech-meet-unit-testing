package com.jonathan.ejemplo.manejador.usuario;

import com.jonathan.ejemplo.comando.ComandoUsuario;
import com.jonathan.ejemplo.fabrica.FabricaUsuario;
import com.jonathan.ejemplo.servicio.usuario.ServicioCrearUsuario;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearUsuario {

    private final ServicioCrearUsuario servicioCrearUsuario;
    private final FabricaUsuario fabricaUsuario;

    public ManejadorCrearUsuario(ServicioCrearUsuario servicioCrearUsuario, FabricaUsuario fabricaUsuario) {
        this.servicioCrearUsuario = servicioCrearUsuario;
        this.fabricaUsuario = fabricaUsuario;
    }

    @Transactional
    public void ejecutar(ComandoUsuario comandoUsuario) {
        this.servicioCrearUsuario.ejecutar(fabricaUsuario.crearUsuario(comandoUsuario));
    }
}
