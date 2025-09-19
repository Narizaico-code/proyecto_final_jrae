package org.jrae.carwashito.dominio.exception;

public class EmpleadoYaExisteException extends RuntimeException {
    public EmpleadoYaExisteException(String empleadoNombre) {
        super("El EMPLEADO con nombre: " + empleadoNombre + " ya existe en el sistema");
    }
}
