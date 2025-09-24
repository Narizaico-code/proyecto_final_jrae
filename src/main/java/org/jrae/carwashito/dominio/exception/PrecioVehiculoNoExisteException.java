package org.jrae.carwashito.dominio.exception;

public class PrecioVehiculoNoExisteException extends RuntimeException {
    public PrecioVehiculoNoExisteException(Long codigoPrecioVehiculo) {
        super("El PRECIO VEHICULO con codigo: " + codigoPrecioVehiculo + " no existe en el sistema");
    }
}