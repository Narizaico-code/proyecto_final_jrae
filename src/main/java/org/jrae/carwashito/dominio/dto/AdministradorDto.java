package org.jrae.carwashito.dominio.dto;

public record AdministradorDto(
        Long codigoAdministrador,
        String name,
        String lastName,
        String password,
        String email,
        String phoneNumber

) {

}
