package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.dto.ModEmpleadoDto;
import org.jrae.carwashito.dominio.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empleados")
@Tag(name = "Empleados", description = "Opciones (CRUD) sobre los empleados de CarWashito")
public class EmpleadoController {
    private final EmpleadoService empleadosService;

    public EmpleadoController(EmpleadoService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @GetMapping
    @Operation(description = "Retorna los Empleados ")
    public ResponseEntity<List<EmpleadoDto>> obtenerTodo() {
        return ResponseEntity.ok(this.empleadosService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un Empleado a travez de su identificador",
            description = "Retorna el Empleado que conincida con el identificador envido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Empleado fue encontrado con exito "),
                    @ApiResponse(responseCode = "404", description = "Empleado no encontrado", content = @Content)
            }
    )
    public ResponseEntity<EmpleadoDto> obtenerEmpleadoPorCodigo
            (@Parameter(description = "Identificador de el Empleado a registrar", example = "5")
             @PathVariable Long codigo){
        return  ResponseEntity.ok(this.empleadosService.obtenerEmpleadoPorCodigo(codigo));
    }

    // Guardar Empleado
    @PostMapping
    @Operation(description = "Guarda los empleados ")
    public ResponseEntity<EmpleadoDto>guardarEmpleado
    (@RequestBody @Valid EmpleadoDto empleadoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.empleadosService.guardarEmpleado(empleadoDto));
    }

    // Modificar Empleado
    @PutMapping("{codigo}")
    @Operation(description = "modifica los empleados ")
    public ResponseEntity<EmpleadoDto> modificarEmpleado
    (@Parameter(description = "Id del empleado a modificar", example = "1")@PathVariable Long codigo, @RequestBody @Valid ModEmpleadoDto modEmpleadoDto){
        return ResponseEntity.ok(this.empleadosService.modificarEmpleado(codigo, modEmpleadoDto));
    }

    // Eliminar Empleado
    @DeleteMapping("{codigo}")
    @Operation(description = "elimina los empleados ")
    public ResponseEntity<EmpleadoDto> eliminarEmpleado (@Parameter(description = "Id del empleado a eliminar", example = "1")@PathVariable Long codigo) {
        empleadosService.eliminarEmpleado(codigo);
        return ResponseEntity.noContent().build();
    }
}
