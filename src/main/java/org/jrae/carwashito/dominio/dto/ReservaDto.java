package org.jrae.carwashito.dominio.dto;

import jakarta.validation.constraints.*;
import org.jrae.carwashito.dominio.MetodoPago;

import java.time.LocalDate;

public record ReservaDto (
        Long codigo,
        @NotNull(message = "El codigo del vehiculo no debe ser null")
        Long vehicleId,
        @NotNull(message = "El codigo cliente no debe ser nulo")
        Long clientId,
        @NotNull(message = "El codigo empleado no debe ser nulo")
        Long employeeId,
        @NotNull(message = "Metodo de pago invalido")
        MetodoPago payMethod,
        @Future(message = "La fecha de la reserva no debe de ser anterior a hoy")
        LocalDate date,
        @Min(value = 7, message = "La hora de inicio es a las 07")
        @Max(value = 19, message = "La hora de cierre es a las 19")
        Integer hour,
        @NotBlank(message = "La descripcion no puede ir vacia")
        @Size(min = 8, max = 255, message = "La descripcion no debe de ser ni menor a 8 ni mayor a 255")
        String description
){

}
