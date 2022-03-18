package com.jonathan.ejemplo.excepcion;

import java.time.LocalDateTime;

public class Error {
    private String nombre;
    private String mensaje;
    private LocalDateTime fecha;

    public Error(String nombre, String mensaje, LocalDateTime fecha) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
