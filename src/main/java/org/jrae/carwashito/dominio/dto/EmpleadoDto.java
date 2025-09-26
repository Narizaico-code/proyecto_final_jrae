package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmpleadoDto(
        Long codigo,
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El apellido es obligatorio")
        String lastName,
        @Min(value = 18, message = "La edad mínima es 18 años")
        int age,
        boolean availability,
        @NotNull(message = "El salario es obligatorio")
        @Min(value = 1, message = "El salario debe ser mayor que 0")
        BigDecimal salary,
        @NotNull(message = "La fecha de contratación es obligatoria")
        LocalDate hireDate,
        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo debe ser válido")
        String email,
        @NotBlank(message = "El teléfono es obligatorio")
        @Size(min = 8, max = 15, message = "El teléfono debe tener entre 8 y 15 dígitos")
        String phoneNumber,
        @NotBlank(message = "El puesto es obligatorio")
        String position,
        @NotNull(message = "El código del administrador es obligatorio")
        Long codigoAdministrador
) {
}
