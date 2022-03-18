package com.jonathan.ejemplo.modelo;

import com.jonathan.ejemplo.excepcion.ExcepcionValorInvalido;

public class Usuario {
    private static final String EL_NOMBRE_NO_TIENE_LA_LONGITUD_REQUERIDA = "El nombre debe tener como mínimo 3 carácteres";
    private static final String EL_USUARIO_NO_TIENE_LA_EDAD_REQUERIDA = "La persona es menor de edad";
    private Long id;
    private String nombre;
    private Integer edad;
    private String direccion;

    public Usuario(Long id, String nombre, Integer edad, String direccion) {
        validarDimension(nombre);
        validarEdad(edad);
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    private void validarDimension(String valor) {
        if (valor.length() < 3) {
            throw new ExcepcionValorInvalido(EL_NOMBRE_NO_TIENE_LA_LONGITUD_REQUERIDA);
        }
    }

    private void validarEdad(Integer edad) {
        if (edad < 18) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_TIENE_LA_EDAD_REQUERIDA);
        }
    }
}
