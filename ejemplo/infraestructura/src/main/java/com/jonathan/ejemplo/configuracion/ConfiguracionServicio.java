package com.jonathan.ejemplo.configuracion;

import com.jonathan.ejemplo.puerto.RepositorioPago;
import com.jonathan.ejemplo.puerto.RepositorioUsuario;
import com.jonathan.ejemplo.servicio.pago.ServicioRealizarPago;
import com.jonathan.ejemplo.servicio.pago.ServicioVerificarVigencia;
import com.jonathan.ejemplo.servicio.usuario.ServicioCrearUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioVerificarVigencia servicioVerificarVigencia(RepositorioUsuario repositorioUsuario) {
        return new ServicioVerificarVigencia(repositorioUsuario);
    }

    @Bean
    public ServicioRealizarPago servicioRealizarPago(RepositorioUsuario repositorioUsuario,
                                                     RepositorioPago repositorioPago,
                                                     ServicioVerificarVigencia servicioVerificarVigencia) {
        return new ServicioRealizarPago(repositorioUsuario, repositorioPago, servicioVerificarVigencia);
    }
}
