package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ModInventarioDto(
        @NotNull(message = "El costo es obligatorio")
        @Min(value = 1, message = "El costo debe ser mayor o igual a 1")
        Double cost,
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        LocalDate expirationDate,
        @NotNull(message = "El stock es obligatorio")
        @Min(value = 1, message = "El stock debe ser mayor o igual a 1")
        Integer stock,
        @NotNull(message = "El ID administrador es obligatorio")
        Long administratorId,
        @NotNull(message = "El ID proveedor es obligatorio")
        Long providerId
) {
}
