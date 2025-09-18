package org.jrae.carwashito.dominio.dto;

import java.math.BigDecimal;

public record ServiciosDto(
        long codigo,
        String nombre,
        String descripcion,
        BigDecimal precio
) {
}
