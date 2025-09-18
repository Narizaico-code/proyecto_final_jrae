package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.ModProveedorDto;
import org.jrae.carwashito.dominio.dto.ProveedorDto;

import java.util.List;

public interface  ProveedorRepository {
    // Firmas del mantenimiento de DTO
    // 1 Inicio
    List<ProveedorDto> obtenerTodo();
    ProveedorDto obtenerProveedorPorCodigo(Long codigo);
    ProveedorDto guardarProveedor(ProveedorDto proveedorDto);
    ProveedorDto modificarProveedor(Long codigo, ModProveedorDto modProveedorDto);
    void eliminarProveedor(Long codigo);
}
