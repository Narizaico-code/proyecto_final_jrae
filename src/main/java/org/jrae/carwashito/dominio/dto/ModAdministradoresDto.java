package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ModAdministradoresDto (
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El apellido es Obligatorio")
        String lastName,
        @NotBlank(message = "El correo es Obligatorio")
        @Email(message = "El correo debe tener un formato valido")
        String email,
        @NotBlank(message = "El numero de telefono es obligatorio")
        String phoneNumber
){
}
