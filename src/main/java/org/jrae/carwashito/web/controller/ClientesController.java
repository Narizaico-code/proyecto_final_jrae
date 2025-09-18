package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.dto.ModClientesDto;
import org.jrae.carwashito.dominio.service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un Cliente a travez de su identificador",
            description = "Retorna el Cliente que conincida con el identificador envido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente fue encontrado"),
                    @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
            }
    )
    public ResponseEntity<ClientesDto> obtenerClientesPorCodigo
            (@Parameter(description = "Identificador del Cliente a registrar", example = "5")
             @PathVariable Long codigo){
        return  ResponseEntity.ok(this.clientesService.obtenerClientesPorCodigo(codigo));
    }

    // Guardar Cliente
    @PostMapping
    public ResponseEntity<ClientesDto>guardarClientes
    (@RequestBody ClientesDto clientesDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.clientesService.guardarClientes(clientesDto));
    }

    // Modificar Cliente
    @PutMapping("{codigo}")
    public ResponseEntity<ClientesDto> modificarClientes
    (@PathVariable Long codigo, @RequestBody @Valid ModClientesDto modClientesDto){
        return ResponseEntity.ok(this.clientesService.modificarClientes(codigo, modClientesDto));
    }

    // Eliminar Clientes
    @DeleteMapping("{codigo}")
    public ResponseEntity<ClientesDto> eliminarClientes(@PathVariable Long codigo) {
        clientesService.eliminarClientes(codigo);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
