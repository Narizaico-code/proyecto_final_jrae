package org.jrae.carwashito.dominio.exception;

public class ProveedorYaExisteException extends RuntimeException {
    public ProveedorYaExisteException(String proveedorNombre) {
        super("El PROVEEDOR con nombre: " + proveedorNombre + " ya existe en el sistema");
    }
}
