package com.jonathan.ejemplo.adaptador;

import com.jonathan.ejemplo.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDtoUsuario implements RowMapper<DtoUsuario> {

    @Override
    public DtoUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        Integer edad = rs.getInt("edad");
        String direccion = rs.getString("direccion");
        return new DtoUsuario(id, nombre, edad, direccion);
    }
}
