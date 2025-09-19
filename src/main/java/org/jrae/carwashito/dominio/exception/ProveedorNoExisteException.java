package org.jrae.carwashito.dominio.exception;

public class ProveedorNoExisteException extends RuntimeException {
    public ProveedorNoExisteException(Long codigoProveedor) {
        super("El PROVEEDOR con codigo: " + codigoProveedor + " no existe en el sistema");
    }
}