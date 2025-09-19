package org.jrae.carwashito.dominio.exception;

public class ServicioYaExisteException extends RuntimeException {
    public ServicioYaExisteException(String servicioNombre) {
        super("El SERVICIO con nombre: " + servicioNombre + " ya existe en el sistema");
    }
}
