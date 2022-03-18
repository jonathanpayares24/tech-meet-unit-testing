package com.jonathan.ejemplo.configuracion.jdbc;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

public class SqlStatementFieldCallback implements ReflectionUtils.FieldCallback {

    private static final String SLASL = "/";
    private static final String RUTA_BASE = "sql/";
    private Object bean;

    public SqlStatementFieldCallback(Object bean) {
        this.bean = bean;
    }

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        if (!field.isAnnotationPresent(SqlStatement.class)) {
            return;
        }
        ReflectionUtils.makeAccessible(field);
        String value = field.getDeclaredAnnotation(SqlStatement.class).value();
        String namespace = field.getDeclaredAnnotation(SqlStatement.class).namespace();
        if (StringUtils.isBlank(value)) {
            throw new RuntimeException("El nombre del archivo no puede estar vacío.");
        }
        String rutaRelativa = namespace.replace(".", SLASL);
        String nombreArchivo = RUTA_BASE + rutaRelativa + SLASL + value;
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(nombreArchivo)) {
            if (inputStream == null) {
                throw new RuntimeException(String.format("No se encontró el archivo [ %s ]", nombreArchivo));
            }
            field.set(bean, IOUtils.toString(inputStream, StandardCharsets.UTF_8.name()));
        } catch (IOException e) {
            throw new RuntimeException(String.format("No se encontró el archivo [ %s ]", nombreArchivo));
        }
    }
}
