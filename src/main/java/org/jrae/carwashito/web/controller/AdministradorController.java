package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ModAdministradorDto;
import org.jrae.carwashito.dominio.service.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/administradores")
@Tag(name = "Administradores", description = "Opciones (CRUD) sobre los administradores de carWashito")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
            this.administradorService = administradorService;
    }

    @GetMapping
    @Operation(description = "Retorna los Administrador ")
    public ResponseEntity<List<AdministradorDto>> obtenerTodo(){
        return ResponseEntity.ok(this.administradorService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un Administrador a travez de su identificador",
            description = "Retorna el Administrador que conincida con el identificador envido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Administrador fue encontrado con exito"),
                    @ApiResponse(responseCode = "404", description = "Administrador no encontrado", content = @Content)
            }
    )
    public ResponseEntity<AdministradorDto> obtenerAdministradoresPorCodigo
            (@Parameter(description = "Identificador de el Administrador a registrar", example = "5")
             @PathVariable Long codigo){
        return  ResponseEntity.ok(this.administradorService.obtenerAdministradoresPorCodigo(codigo));
    }

    // Guardar película
    @PostMapping
    @Operation(description = "Guarda los Administrador ")
    public ResponseEntity<AdministradorDto>guardarAdministradores
    (@RequestBody @Valid AdministradorDto administradoresDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.administradorService.guardarAdministradores(administradoresDto));
    }

    // Modificar Administrador
    @PutMapping("{codigo}")
    @Operation(description = "Edita los Administrador ")
    public ResponseEntity<AdministradorDto> modificarAdministradores
    (@Parameter(description = "Id del administrador a modificar", example = "1")@PathVariable Long codigo, @RequestBody @Valid ModAdministradorDto modAdministradoresDto){
        return ResponseEntity.ok(this.administradorService.modificarAdministradores(codigo, modAdministradoresDto));
    }

    // Eliminar película
    @DeleteMapping("{codigo}")
    @Operation(description = "Elimina los Administrador ")
    public ResponseEntity<AdministradorDto> eliminarAdministrador(@Parameter(description = "Id del administrador a eliminar", example = "1")@PathVariable Long codigo) {
        administradorService.eliminarAdministradores(codigo);
        return ResponseEntity.noContent().build();
    }
}