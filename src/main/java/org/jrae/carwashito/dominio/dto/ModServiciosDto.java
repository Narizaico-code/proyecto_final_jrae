package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ModServiciosDto(
        @NotBlank(message = "El nombre del servicio es obligatorio")
        String nombre,
        @NotBlank(message = "La descripción del servicio es obligatoria")
        String descripcion,
        @Positive(message = "El precio debe ser un número positivo")
        @Digits(integer = 8, fraction = 2, message = "El precio debe tener como máximo 8 enteros y 2 decimales")
        BigDecimal precio
) {
}
