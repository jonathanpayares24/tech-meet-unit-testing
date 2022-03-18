package com.jonathan.ejemplo.adaptador;

import com.jonathan.ejemplo.configuracion.jdbc.SqlStatement;
import com.jonathan.ejemplo.modelo.Usuario;
import com.jonathan.ejemplo.modelo.dto.DtoTipoUsuario;
import com.jonathan.ejemplo.modelo.dto.DtoUsuario;
import com.jonathan.ejemplo.puerto.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioSQLServer implements RepositorioUsuario {

    @SqlStatement(namespace = "usuario", value = "crearUsuario.sql")
    private String sqlCrearUsuario;
    @SqlStatement(namespace = "usuario", value = "consultarUsuarios.sql")
    private String sqlConsultarUsuarios;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RepositorioUsuarioSQLServer(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void crear(Usuario usuario) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nombre", usuario.getNombre());
        parameterSource.addValue("edad", usuario.getEdad());
        parameterSource.addValue("direccion", usuario.getDireccion());
        this.namedParameterJdbcTemplate.update(sqlCrearUsuario, parameterSource);
    }

    @Override
    public boolean existe(Long id) {
        return false;
    }

    @Override
    public boolean activo(Long id) {
        return false;
    }

    @Override
    public List<DtoUsuario> consultarUsuarios() {
        return this.namedParameterJdbcTemplate.query(sqlConsultarUsuarios, new MapeoDtoUsuario());
    }

    @Override
    public DtoTipoUsuario consultarTipoUsuario(Long id) {
        return null;
    }
}
