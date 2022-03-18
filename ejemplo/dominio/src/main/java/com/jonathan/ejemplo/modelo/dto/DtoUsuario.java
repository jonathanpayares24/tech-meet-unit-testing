package com.jonathan.ejemplo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoUsuario {
    private Long id;
    private String nombre;
    private Integer edad;
    private String direccion;
}
