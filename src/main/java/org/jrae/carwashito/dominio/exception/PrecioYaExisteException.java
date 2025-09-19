package org.jrae.carwashito.dominio.exception;

public class PrecioYaExisteException extends RuntimeException {
    public PrecioYaExisteException(String tipoVehiculo) {
        super("El PRECIO VEHICULO con el tipo vehiculo: " + tipoVehiculo + " ya existe en el sistema");
    }
}
