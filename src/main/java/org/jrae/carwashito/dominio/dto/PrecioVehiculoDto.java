package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PrecioVehiculoDto(
        Long codigo,
        @NotBlank(message = "El tipo de vehículo es obligatorio")
        @Size(min = 3, max = 50, message = "El tipo debe tener entre 3 y 50 caracteres")
        String typeVehicle,
        @NotNull(message = "El valor es obligatorio")
        @Positive(message = "El valor debe ser mayor a 0")
        Double value
) {
}
