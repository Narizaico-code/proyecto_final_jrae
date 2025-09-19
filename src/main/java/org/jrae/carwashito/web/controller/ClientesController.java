package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.dto.ModClienteDto;
import org.jrae.carwashito.dominio.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@Tag(name = "Clientes", description = "Opciones (CRUD) sobre los clientes de carWashito")
public class ClientesController {
    private final ClienteService clientesService;

    public ClientesController(ClienteService clientesService ) {
        this.clientesService = clientesService;
    }

    @GetMapping
    @Operation(description = "Retorna los clientes ")
    public ResponseEntity<List<ClienteDto>> obtenerTodo(){
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
    public ResponseEntity<ClienteDto> obtenerClientesPorCodigo
            (@Parameter(description = "Identificador del Cliente a registrar", example = "5")
             @PathVariable Long codigo){
        return  ResponseEntity.ok(this.clientesService.obtenerClientesPorCodigo(codigo));
    }

    // Guardar Cliente
    @PostMapping
    @Operation(description = "Guarda los clientes ")
    public ResponseEntity<ClienteDto>guardarClientes
    (@RequestBody @Valid ClienteDto clientesDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.clientesService.guardarClientes(clientesDto));
    }

    // Modificar Cliente
    @PutMapping("{codigo}")
    @Operation(description = "Modifica los clientes ")
    public ResponseEntity<ClienteDto> modificarClientes
    (@Parameter(description = "Id del cliente a modificar", example = "1")@PathVariable Long codigo, @RequestBody @Valid ModClienteDto modClientesDto){
        return ResponseEntity.ok(this.clientesService.modificarClientes(codigo, modClientesDto));
    }

    // Eliminar Clientes
    @DeleteMapping("{codigo}")
    @Operation(description = "Elimina los clientes ")
    public ResponseEntity<ClienteDto> eliminarClientes(@Parameter(description = "Id del cliente a eliminar", example = "1")@PathVariable Long codigo) {
        clientesService.eliminarClientes(codigo);
        return ResponseEntity.noContent().build();
    }
}
