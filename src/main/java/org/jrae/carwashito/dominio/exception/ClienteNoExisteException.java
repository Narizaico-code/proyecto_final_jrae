package org.jrae.carwashito.dominio.exception;

public class ClienteNoExisteException extends RuntimeException {
    public ClienteNoExisteException(Long codigoCliente) {
        super("El CLIENTE con codigo: " + codigoCliente + " no existe en el sistema");
    }
}
