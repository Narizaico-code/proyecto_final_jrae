package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModProveedorDto(
        @NotBlank(message = "El numero o number del proveedor es obligatorio")
        String number,
        @NotBlank(message = "El correo o email del proveedor es obligatorio")
        String email
) {
}
