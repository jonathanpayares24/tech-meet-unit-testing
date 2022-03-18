package com.jonathan.ejemplo.controlador;

import com.jonathan.ejemplo.comando.ComandoUsuario;
import com.jonathan.ejemplo.manejador.usuario.ManejadorConsultarUsuario;
import com.jonathan.ejemplo.manejador.usuario.ManejadorCrearUsuario;
import com.jonathan.ejemplo.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Controlador Usuario")
public class ControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorConsultarUsuario manejadorConsultarUsuario;

    public ControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario, ManejadorConsultarUsuario manejadorConsultarUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorConsultarUsuario = manejadorConsultarUsuario;
    }

    @GetMapping
    @ApiOperation(value = "Permite consultar los usuarios")
    public List<DtoUsuario> consultarUsuarios() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getAuthorities());
        return this.manejadorConsultarUsuario.ejecutar();
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un usuario nuevo")
    public void crearUsuario(@RequestBody ComandoUsuario usuario) {
        this.manejadorCrearUsuario.ejecutar(usuario);
    }
}
