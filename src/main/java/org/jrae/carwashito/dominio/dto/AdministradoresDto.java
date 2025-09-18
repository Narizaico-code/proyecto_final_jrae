package org.jrae.carwashito.dominio.dto;

public record AdministradoresDto(
        long codigoAdministrador,
        String name,
        String lastName,
        String email,
        String phoneNumber

) {

}
