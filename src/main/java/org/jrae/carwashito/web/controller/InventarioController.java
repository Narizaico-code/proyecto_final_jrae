package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.ModInventarioDto;
import org.jrae.carwashito.dominio.dto.InventarioDto;
import org.jrae.carwashito.dominio.service.InventarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@RestController
@RequestMapping("/v1/inventarios")
@Tag(name = "inventarios", description = "Operaciones (CRUD) sobre el inventario de CarWashito")
public class InventarioController {
    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    @Operation(description = "Retorna los inventarios ")
    public ResponseEntity<List<InventarioDto>> obtenerTodo(){
        return ResponseEntity.ok(this.inventarioService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un inventario a partir de su identificador",
            description = "Retorna el inventario que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Inventario fue encontrado con éxito"),
                    @ApiResponse(responseCode = "404" , description = "Inventario no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500" , description = "Hubo un problema con el servidor, revise el mensaje")
            }
    )
    public ResponseEntity<InventarioDto> obtenerInventarioPorCodigo
            (@Parameter(description = "Identificador del inventario a recuperar", example = "1") @PathVariable Long codigo){
        return ResponseEntity.ok(this.inventarioService.obtenerInventarioPorCodigo(codigo));
    }

    @PostMapping
    @Operation(description = "guarda los inventarios ")
    public ResponseEntity<InventarioDto> guardarInventario(@RequestBody @Valid InventarioDto inventarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.inventarioService.guardarInventario(inventarioDto));
    }

    @PutMapping("{codigo}")
    @Operation(description = "modifica los invevntarios ")
    public ResponseEntity<InventarioDto> modificarInventario(@Parameter(description = "Id del inventario a modificar", example = "1")@PathVariable Long codigo, @RequestBody @Valid ModInventarioDto modInventarioDto){
        return ResponseEntity.ok(this.inventarioService.modificarInventario(codigo, modInventarioDto));
    }

    @DeleteMapping("{codigo}")
    @Operation(description = "Elimina los inventarios ")
    public ResponseEntity<Void> eliminarInventario(@Parameter(description = "Id del inventario a eliminar", example = "1")@PathVariable Long codigo){
        this.inventarioService.eliminarInventario(codigo);
        return ResponseEntity.ok().build();
    }

}
