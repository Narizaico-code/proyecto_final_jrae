package org.jrae.carwashito.dominio.dto;

public record ClientesDto (
        long codigo,
        String name,
        String lastName,
        String nickname,
        String email,
        String phoneNumber,
        String address
){

}
