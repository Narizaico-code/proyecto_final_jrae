package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ModEmpleadosDto(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El apellido es obligatorio")
        String lastName,
        @Min(value = 18, message = "La edad debe ser mayor o igual a 18")
        @Max(value = 100, message = "La edad debe ser menor o igual a 100")
        int age,
        @NotNull(message = "La disponibilidad es obligatoria")
        Boolean availability,
        @DecimalMin(value = "0.0", inclusive = false, message = "El sueldo debe ser mayor a 0")
        BigDecimal salary,
        @PastOrPresent(message = "La fecha de contratación debe ser anterior o igual a la fecha actual")
        LocalDate hireDate,
        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo debe tener un formato válido")
        String email,
        @NotBlank(message = "El número de teléfono es obligatorio")
        @Size(min = 8, max = 8, message = "El teléfono debe tener 8 dígitos")
        String phoneNumber,
        @NotBlank(message = "El cargo es obligatorio")
        String position
) {
}
