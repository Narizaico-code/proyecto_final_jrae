package org.jrae.carwashito.web.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.jrae.carwashito.dominio.dto.ModProveedorDto;
import org.jrae.carwashito.dominio.dto.ProveedorDto;
import org.jrae.carwashito.dominio.service.ProveedorService;
import org.jrae.carwashito.persistence.entity.ProveedorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/proveedores")
@Tag(name = "proveedores", description = "Operaciones (CRUD) sobre los proveedores de CarWashito")
public class ProveedorController {
    private final ProveedorService proveedorService;
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> obtenerTodo(){
        return ResponseEntity.ok(this.proveedorService.obtenerTodo());
    }

    @GetMapping("{codigoProveedor}")
    @Operation(
            summary = "Obtener un proveedor a partir de su identificador",
            description = "Retorna el proveedor que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "proveedor fue encontrado con exito"),
                    @ApiResponse(responseCode = "404" , description = "proveedor no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500" , description = "Hubo un problema con el servidor, revise el mensaje")
            }
    )
    public ResponseEntity<ProveedorDto> obtenerProveedorPorCodigo
            (@Parameter(description = "Identificador del proveedor a recuperar", example = "1") @PathVariable Long codigo){
        return ResponseEntity.ok(this.proveedorService.obtenerProveedorPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<ProveedorDto> guardarProveedor(@RequestBody ProveedorDto proveedorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.proveedorService.guardarProveedor(proveedorDto));
    }


    @PutMapping("{codigoProveedor}")
    public ResponseEntity<ProveedorDto> modificarProveedor(@PathVariable Long codigo, @RequestBody @Valid ModProveedorDto modProveedorDto){
        return ResponseEntity.ok(this.proveedorService.modificarProveedor(codigo, modProveedorDto));
    }

    @DeleteMapping("{codigoProveedor}")
    public ResponseEntity<ProveedorDto> eliminarProveedor(@PathVariable Long codigo){
        this.proveedorService.eliminarProveedor(codigo);
        return ResponseEntity.ok().build();
    }

}
