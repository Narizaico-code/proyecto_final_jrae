package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.ServicioDto;
import org.jrae.carwashito.dominio.service.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/servicios")
@Tag(name = "Servicios" , description = "Operaciones (CRUD) sobre los servicios de CarWashito")
public class ServicioController {
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    // ---- OBTENER TODOS ----
    @GetMapping
    @Operation(description = "Retorna los Servicios ")
    public ResponseEntity<List<ServicioDto>> obtenerTodos(){
        return ResponseEntity.ok(this.servicioService.obtenerTodos());
    }

    // ---- OBTENER POR ID ----
    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un servicio a partir de su identificador",
            description = "Retorna un servicio que coincida con el id enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Servicio fue encontrado con exito"),
                    @ApiResponse(responseCode = "404", description = "Servicio no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Hubo un problema con el servidor, revise el mensaje")
            }
    )
    public ResponseEntity<ServicioDto> obtenerServicioPorCodigo
            (@Parameter(description = "Id del servicio a recuperar", example = "1") @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioService.obtenerServicioPorCodigo(codigo));
    }

    // ---- GUARDAR ----
    @PostMapping
    @Operation(description = "Guarda los Servicios ")
    public ResponseEntity<ServicioDto> guardarServicio
            (@RequestBody @Valid ServicioDto servicioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.servicioService.guardarServicio(servicioDto));
    }

    // ---- MODIFICAR ----
    @PutMapping("{codigo}")
    @Operation(description = "Modifica los Servicios ")
    public ResponseEntity<ServicioDto> modificarServicio
    (@Parameter(description = "Id del servicio a modificar", example = "1")@PathVariable Long codigo, @RequestBody @Valid ServicioDto servicioDto){
        return ResponseEntity.ok(this.servicioService.actualizarServicio(codigo, servicioDto));
    }

    // ---- ELIMINAR ----
    @DeleteMapping("{codigo}")
    @Operation(description = "Elimina los Servicios ")
    public ResponseEntity<ServicioDto> eliminarServicio
    (@Parameter(description = "Id del servicio a eliminar", example = "1")@PathVariable Long codigo){
        this.servicioService.eliminarServicio(codigo);
        return ResponseEntity.ok().build();
    }
}