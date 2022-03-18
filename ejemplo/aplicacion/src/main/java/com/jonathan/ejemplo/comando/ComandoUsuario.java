package com.jonathan.ejemplo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComandoUsuario {
    private Long id;
    private String nombre;
    private int edad;
    private String direccion;
}
