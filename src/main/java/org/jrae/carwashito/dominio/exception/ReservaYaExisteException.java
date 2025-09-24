package org.jrae.carwashito.dominio.exception;

public class ReservaYaExisteException extends RuntimeException {
    public ReservaYaExisteException(Long reservaCodigo) {
        super("La RESERVA con codigo: " + reservaCodigo + " ya existe en el sistema");
    }
}
