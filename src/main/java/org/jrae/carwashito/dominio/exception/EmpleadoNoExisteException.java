package org.jrae.carwashito.dominio.exception;

public class EmpleadoNoExisteException extends RuntimeException {
    public EmpleadoNoExisteException(Long codigoEmpleado) {
        super("El EMPLEADO con codigo: " + codigoEmpleado + " no existe en el sistema");
    }
}