package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.InventarioDto;
import org.jrae.carwashito.dominio.dto.ModInventarioDto;
import java.util.List;

public interface InventarioRepository {
    // Firmas del mantenimiento de DTO
    // 1 Inicio
    List<InventarioDto> obtenerTodo();
    InventarioDto obtenerInventarioPorCodigo(Long codigo);
    InventarioDto guardarInventario(InventarioDto inventarioDto);
    InventarioDto modificarInventario(Long id, ModInventarioDto modInventarioDto);
    void eliminarInventario(Long id);
}
