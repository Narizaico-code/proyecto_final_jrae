package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteDto(
        Long codigoCliente,
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El apellido es obligatorio")
        String lastName,
        @NotBlank(message = "El apodo es obligatorio")
        String nickname,
        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        String password,
        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo debe ser válido")
        String email,
        @NotBlank(message = "El teléfono es obligatorio")
        @Size(min = 8, max = 15, message = "El teléfono debe tener entre 8 y 15 dígitos")
        String phoneNumber,
        @NotBlank(message = "La dirección es obligatoria")
        String address
){

}
