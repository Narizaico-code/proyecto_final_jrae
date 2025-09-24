package org.jrae.carwashito.dominio.exception;

public class ServicioNoExisteException extends RuntimeException {
    public ServicioNoExisteException(Long codigoServicio) {
        super("El SERVICIO con codigo: " + codigoServicio + " no existe en el sistema");
    }
}