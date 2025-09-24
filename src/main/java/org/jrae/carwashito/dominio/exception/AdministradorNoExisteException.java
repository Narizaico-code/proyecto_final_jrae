package org.jrae.carwashito.dominio.exception;

public class AdministradorNoExisteException extends RuntimeException{
    public AdministradorNoExisteException(Long codigoAdministrador){
        super("El ADMINISTRADOR con codigo: " + codigoAdministrador + " no existe en el sistema");
    }
}
