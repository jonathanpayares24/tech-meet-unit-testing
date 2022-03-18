package com.jonathan.ejemplo.configuracion;

import com.jonathan.ejemplo.excepcion.Error;
import com.jonathan.ejemplo.excepcion.ExcepcionTecnica;
import com.jonathan.ejemplo.excepcion.ExcepcionValorInvalido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ConfiguracionError {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ConfiguracionError.class);
    private static final String HUBO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Hubo un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ConfiguracionError() {
        CODIGOS_ESTADO.put(ExcepcionValorInvalido.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionValorInvalido.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        CODIGOS_ESTADO.put(ExcepcionTecnica.class.getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> manejarTodasLasExcepciones(Exception exception) {
        ResponseEntity<Error> resultado;

        String nombreExcepcion = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(nombreExcepcion);
        LocalDateTime tiempoLocal = LocalDateTime.now();
        if (codigo != null) {
            Error error = new Error(nombreExcepcion, mensaje, tiempoLocal);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
            LOGGER_ERROR.error(nombreExcepcion + " - " + mensaje);
        } else {
            LOGGER_ERROR.error(nombreExcepcion, exception);
            Error error = new Error(nombreExcepcion, HUBO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR, tiempoLocal);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultado;
    }
}
