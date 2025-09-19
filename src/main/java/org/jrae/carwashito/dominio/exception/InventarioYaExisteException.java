package org.jrae.carwashito.dominio.exception;

public class InventarioYaExisteException extends RuntimeException {
    public InventarioYaExisteException(String inventarioNombre) {
        super("El INVENTARIO con nombre: " + inventarioNombre + " ya existe en el sistema");
    }
}
