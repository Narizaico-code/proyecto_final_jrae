package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.jrae.carwashito.dominio.dto.ServiciosDto;
import org.jrae.carwashito.dominio.service.ServiciosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/servicios")
@Tag(name = "Servicios", description = "Opciones (CRUD) sobre los servicios de carWashito")
public class ServiciosController {
    private final ServiciosService serviciosService;

    public ServiciosController(ServiciosService serviciosService) {
        this.serviciosService = serviciosService;
    }

    @GetMapping
    public ResponseEntity<List<ServiciosDto>> obtenerTodo() {
        return ResponseEntity.ok(this.serviciosService.obtenerTodo());
    }
}
