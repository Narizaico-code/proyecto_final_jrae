package org.jrae.carwashito.dominio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmpleadoDto(
        long codigoEmpleado,
        String name,
        String lastName,
        int age,
        boolean availability,
        BigDecimal salary,
        LocalDate hireDate,
        String email,
        String phoneNumber,
        String position
) {
}
