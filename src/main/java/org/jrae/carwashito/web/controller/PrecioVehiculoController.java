package org.jrae.carwashito.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;
import org.jrae.carwashito.dominio.service.PrecioVehiculoService;
import org.jrae.carwashito.persistence.entity.PrecioVehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/precioVehiculo")
@Tag(name = "PrecioVehiculo", description = "Operaciones (CRUD) sobre los precios de vehiculos de CarWashito")
public class PrecioVehiculoController {
    private final PrecioVehiculoService precioVehiculoService;

    public PrecioVehiculoController(PrecioVehiculoService precioVehiculoService) {
        this.precioVehiculoService = precioVehiculoService;
    }

    // ---- OBTENER TODOS ----
    @GetMapping
    @Operation(description = "Retorna los PrecioVehiculos ")
    public ResponseEntity<List<PrecioVehiculoDto>> obtenerTodos(){
        return ResponseEntity.ok(this.precioVehiculoService.obtenerTodos());
    }

    // ---- OBTENER POR CODIGO ----
    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un precio vehiculo a partir de su identificador",
            description = "Retorna un precioVehiculo que coincida con el id enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "PrecioVehiculo fue encontrado con exito"),
                    @ApiResponse(responseCode = "404", description = "PrecioVehiculo no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Hubo un problema con el servidor, revise el mensaje")
            }
    )
    public ResponseEntity<PrecioVehiculoDto> obtenerPrecioVehiculoPorCodigo
            (@Parameter(description = "Id del precio vehiculo a recuperar", example = "1") @PathVariable Long codigo){
        return ResponseEntity.ok(this.precioVehiculoService.obtenerPrecioVehiculoPorCodigo(codigo));
    }

    // ---- GUARDAR ----
    @PostMapping
    @Operation(description = "Guarda los PrecioVehiculos ")
    public ResponseEntity<PrecioVehiculoDto> guardarPrecioVehiculo
            (@RequestBody @Valid PrecioVehiculoDto precioVehiculoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.precioVehiculoService.guardarPrecioVehiculo(precioVehiculoDto));
    }

    // ---- MODIFICAR ----
    @PutMapping("{codigo}")
    @Operation(description = "Modifica los PrecioVehiculos ")
    public ResponseEntity<PrecioVehiculoDto> modificarPrecioVehiculo
    (@PathVariable Long codigo, @RequestBody @Valid PrecioVehiculoDto precioVehiculoDto){
        return ResponseEntity.ok(this.precioVehiculoService.actualizarPrecioVehiculo(codigo, precioVehiculoDto));
    }

    // ---- ELIMINAR ----
    @DeleteMapping("{codigo}")
    @Operation(description = "Elimina los PrecioVehiculos ")
    public ResponseEntity<PrecioVehiculoDto> eliminarPrecioVehiculo
    (@PathVariable Long codigo){
        this.precioVehiculoService.eliminarPrecioVehiculo(codigo);
        return ResponseEntity.ok().build();
    }


}
