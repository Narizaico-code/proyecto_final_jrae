package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModClienteDto(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El apellido es Obligatorio")
        String lastName,
        @NotBlank(message = "El apodo es obligatorio")
        @Size(max = 50, message = "El apodo no debe exceder los 50 caracteres")
        String nickname,
        @NotBlank(message = "El correo es Obligatorio")
        @Email(message = "El correo debe tener un formato valido")
        String email,
        @NotBlank(message = "La contraseña no puede ser vacia")
        @Size(min = 8, max = 255, message = "La contraseña debe de contener al menos 8 caracteres y no más de 255")
        String password,
        @NotBlank(message = "El número de teléfono es obligatorio")
        @Size(min = 8, max = 8, message = "El número de teléfono debe tener 8 dígitos")
        String phoneNumber,
        @NotBlank(message = "La dirección es obligatoria")
        String address

){

}
