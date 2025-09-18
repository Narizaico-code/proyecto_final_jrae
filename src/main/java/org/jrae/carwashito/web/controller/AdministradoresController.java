package org.jrae.carwashito.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;
import org.jrae.carwashito.dominio.service.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/administradores")
@Tag(name = "Administradores", description = "Opciones (CRUD) sobre los administradores de carWashito")
public class AdministradoresController {

    private final AdministradorService administradoresService;

    public AdministradoresController(AdministradorService administradoresService ) {
            this.administradoresService = administradoresService;
    }


    @GetMapping
    public ResponseEntity<List<AdministradoresDto>> obtenerTodo(){
        return ResponseEntity.ok(this.administradoresService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un Administrador a travez de su identificador",
            description = "Retorna el Administrador que conincida con el identificador envido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula fue encontrada conexito"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no encontrada", content = @Content)
            }
    )
    public ResponseEntity<AdministradoresDto> obtenerAdministradoresPorCodigo
            (@Parameter(description = "Identificador de el Administrador a registrar", example = "5")
             @PathVariable Long codigoAdministrador){
        return  ResponseEntity.ok(this.administradoresService.obtenerAdministradoresPorCodigo(codigoAdministrador));
    }

    // Guardar película
    @PostMapping
    public ResponseEntity<AdministradoresDto>guardarAdministradores
    (@RequestBody AdministradoresDto administradoresDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.administradoresService.guardarAdministradores(administradoresDto));
    }

    // Modificar Administrador
    @PutMapping("{codigo}")
    public ResponseEntity<AdministradoresDto> modificarAdministradores
    (@PathVariable Long codigoAdministrador, @RequestBody @Valid ModAdministradoresDto modAdministradoresDto){
        return ResponseEntity.ok(this.administradoresService.modificarAdministradores(codigoAdministrador, modAdministradoresDto));
    }

    // Eliminar película
    @DeleteMapping("{codigo}")
    public ResponseEntity<AdministradoresDto> eliminarPelicula(@PathVariable Long codigoAdministrador) {
        administradoresService.eliminarAdministradores(codigoAdministrador);
        return ResponseEntity.noContent().build();
    }
}