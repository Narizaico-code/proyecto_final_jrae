package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.service.ClientesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@Tag(name = "Clientes", description = "Opciones (CRUD) sobre los clientes de carWashito")
public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService ) {
        this.clientesService = clientesService;
    }


    @GetMapping
    public ResponseEntity<List<ClientesDto>> obtenerTodo(){
        return ResponseEntity.ok(this.clientesService.obtenerTodo());
    }
}
