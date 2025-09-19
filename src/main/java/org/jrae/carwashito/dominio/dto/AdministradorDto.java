package org.jrae.carwashito.dominio.dto;

public record AdministradorDto(
        Long codigoAdministrador,
        String name,
        String lastName,
        String email,
        String phoneNumber

) {

}
