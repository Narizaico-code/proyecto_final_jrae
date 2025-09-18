package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.service.AdministradoresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/administradores")
@Tag(name = "Administradores", description = "Opciones (CRUD) sobre los administradores de carWashito")
public class AdministradoresController {

    private final AdministradoresService administradoresService;

    public AdministradoresController(AdministradoresService administradoresService ) {
            this.administradoresService = administradoresService;
    }


    @GetMapping
    public ResponseEntity<List<AdministradoresDto>> obtenerTodo(){
        return ResponseEntity.ok(this.administradoresService.obtenerTodo());
    }
}
