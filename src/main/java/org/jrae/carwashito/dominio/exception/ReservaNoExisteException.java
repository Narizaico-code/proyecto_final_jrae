package org.jrae.carwashito.dominio.exception;

public class ReservaNoExisteException extends RuntimeException {
    public ReservaNoExisteException(Long codigoReserva) {
        super("La RESERVA con codigo: " + codigoReserva + " no existe en el sistema");
    }
}