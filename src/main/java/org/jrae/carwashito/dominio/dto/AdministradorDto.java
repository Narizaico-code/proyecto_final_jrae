package org.jrae.carwashito.dominio.dto;

public record AdministradorDto(
        long codigoAdministrador,
        String name,
        String lastName,
        String email,
        String phoneNumber

) {

}
