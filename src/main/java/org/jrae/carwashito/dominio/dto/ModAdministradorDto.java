package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.*;

public record ModAdministradorDto(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El apellido es Obligatorio")
        String lastName,
        @NotBlank(message = "El correo es Obligatorio")
        @Email(message = "El correo debe tener un formato valido")
        String email,
        @NotBlank(message = "La contraseña no puede ser vacia")
        @Size(min = 8, max = 255, message = "La contraseña debe de contener al menos 8 caracteres y no más de 255")
        String password,
        @NotBlank(message = "El numero de telefono es obligatorio")
        String phoneNumber
){
}
