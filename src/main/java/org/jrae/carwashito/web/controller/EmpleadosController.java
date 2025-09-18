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
public class EmpleadosController {
    private final EmpleadoService empleadosService;

    public EmpleadosController(EmpleadoService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @GetMapping
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
    public ResponseEntity<EmpleadoDto>guardarEmpleado
    (@RequestBody EmpleadoDto empleadoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.empleadosService.guardarEmpleado(empleadoDto));
    }

    // Modificar Empleado
    @PutMapping("{codigo}")
    public ResponseEntity<EmpleadoDto> modificarEmpleado
    (@PathVariable Long codigo, @RequestBody ModEmpleadoDto modEmpleadoDto){
        return ResponseEntity.ok(this.empleadosService.modificarEmpleado(codigo, modEmpleadoDto));
    }

    // Eliminar Empleado
    @DeleteMapping("{codigo}")
    public ResponseEntity<EmpleadoDto> eliminarEmpleado (@PathVariable Long codigo) {
        empleadosService.eliminarEmpleado(codigo);
        return ResponseEntity.noContent().build();
    }
}
