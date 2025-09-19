package org.jrae.carwashito.dominio.exception;

public class AdministradorYaExisteException extends RuntimeException {
    public AdministradorYaExisteException(String AdministradorNombre) {
        super("El ADMINISTRADOR con nombre: " + AdministradorNombre + " ya existe en el sistema");
    }
}
