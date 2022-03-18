package com.jonathan.ejemplo.builder.usuario;

import com.jonathan.ejemplo.modelo.Usuario;

public class UsuarioTestDataBuilder {
    private Long id;
    private String nombre;
    private Integer edad;
    private String direccion;

    public UsuarioTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder withEdad(Integer edad) {
        this.edad = edad;
        return this;
    }

    public UsuarioTestDataBuilder withDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Usuario build() {
        return new Usuario(this.id, this.nombre, this.edad, this.direccion);
    }
}
