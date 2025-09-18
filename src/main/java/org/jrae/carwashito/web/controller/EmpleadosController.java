package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.jrae.carwashito.dominio.dto.EmpleadosDto;
import org.jrae.carwashito.dominio.service.EmpleadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/empleados")
@Tag(name = "Empleados", description = "Opciones (CRUD) sobre los empleados de CarWashito")
public class EmpleadosController {
    private final EmpleadosService empleadosService;

    public EmpleadosController(EmpleadosService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadosDto>> obtenerTodo() {
        return ResponseEntity.ok(this.empleadosService.obtenerTodo());
    }
}
