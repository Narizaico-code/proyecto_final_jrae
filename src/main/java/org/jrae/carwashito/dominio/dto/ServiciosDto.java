package org.jrae.carwashito.dominio.dto;

import java.math.BigDecimal;

public record ServiciosDto(
        long codigo,
        String name,
        String description,
        BigDecimal price
) {
}
