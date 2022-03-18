package com.jonathan.ejemplo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DtoTipoUsuario {
    private Long id;
    private String tipo;
    private List<String> permisos;
}
