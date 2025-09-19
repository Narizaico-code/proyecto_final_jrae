package org.jrae.carwashito.dominio.exception;

public class InventarioNoExisteException extends RuntimeException {
    public InventarioNoExisteException(Long codigoInventario) {
        super("El INVENTARIO con codigo: " + codigoInventario + " no existe en el sistema");
    }
}
