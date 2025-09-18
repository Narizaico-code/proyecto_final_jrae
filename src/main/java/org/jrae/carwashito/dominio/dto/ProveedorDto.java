package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record  ProveedorDto(
        Long codigoProveedor,
        @NotBlank(message = "El nombre o nombre del proveedor es obligatorio")
        String name,
        @NotBlank(message = "El numero o number del proveedor es obligatorio")
        String number,
        @NotBlank(message = "El correo o email del proveedor es obligatorio")
        String email,
        @NotBlank(message = "La address o direccion del proveedor es obligatorio")
        String address
) {
}
