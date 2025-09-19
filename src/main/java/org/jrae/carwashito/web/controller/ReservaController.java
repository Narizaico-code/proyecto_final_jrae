package org.jrae.carwashito.web.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;
import org.jrae.carwashito.dominio.dto.ReservaDto;
import org.jrae.carwashito.dominio.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/reservas")
@Tag(name = "Reservas", description = "Operaciones (CRUD) sobre las reservas de CarWashito")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // ---- OBTENER TODOS ----
    @GetMapping
    @Operation(description = "Retorna los Reservas ")
    public ResponseEntity<List<ReservaDto>> obtenerTodo(){
        return ResponseEntity.ok(this.reservaService.obtenerTodo());
    }

    // ---- OBTENER POR ID ----
    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener una reserva a partir de su identificador",
            description = "Retorna una reserva que coincida con el id enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva fue encontrada con exito"),
                    @ApiResponse(responseCode = "404", description = "Reserva no encontrada", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Hubo un problema con el servidor, revise el mensaje")
            }
    )
    public ResponseEntity<ReservaDto> obtenerReservaPorCodigo
    (@Parameter(description = "Id de la reserva a buscar", example = "1") @PathVariable Long codigo)
    {
        return ResponseEntity.ok(this.reservaService.obtenerReservaPorCodigo(codigo));
    }

    // ---- GUARDAR ----
    @PostMapping
    @Operation(description = "Guarda los Reservas ")
    public ResponseEntity<ReservaDto> guardarReserva
    (@RequestBody @Valid ReservaDto reservaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.reservaService.guardarReserva(reservaDto));
    }

    // ---- MODIFICAR ----
    @PutMapping("{codigo}")
    @Operation(description = "Modifica los Reservas ")
    public ResponseEntity<ReservaDto> modificarReserva
    (@PathVariable Long codigo, @RequestBody @Valid ReservaDto reservaDto)
    {
        return ResponseEntity.ok(this.reservaService.modificarReserva(codigo, reservaDto));
    }

    // ---- ELIMINAR ----
    @DeleteMapping("{codigo}")
    @Operation(description = "Elimina los Reservas ")
    public ResponseEntity<ReservaDto> eliminarReserva
    (@PathVariable Long codigo)
    {
        this.reservaService.eliminarReserva(codigo);
        return ResponseEntity.ok().build();
    }
}
