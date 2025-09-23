package org.jrae.carwashito.dominio.dto;

public record ClienteDto(
        long codigoCliente,
        String name,
        String lastName,
        String nickname,
        String password,
        String email,
        String phoneNumber,
        String address
){

}
