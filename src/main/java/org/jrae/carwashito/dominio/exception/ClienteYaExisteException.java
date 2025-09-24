package org.jrae.carwashito.dominio.exception;

public class ClienteYaExisteException extends RuntimeException {
    public ClienteYaExisteException(String clienteNombre) {
        super("El CLIENTE con nombre: " + clienteNombre + " ya existe en el sistema");
    }
}
