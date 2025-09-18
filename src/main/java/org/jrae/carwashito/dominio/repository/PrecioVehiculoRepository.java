package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;

import java.util.List;

public interface PrecioVehiculoRepository {
    List<PrecioVehiculoDto> obtenerTodos();
    PrecioVehiculoDto obtenerPrecioVehiculoPorCodigo(Long codigoVehiculo);
    PrecioVehiculoDto guardarPrecioVehiculo(PrecioVehiculoDto precioVehiculoDTO);
    PrecioVehiculoDto actualizarPrecioVehiculo(Long codigoVehiculo, PrecioVehiculoDto precioVehiculoDTO);
    void eliminarPrecioVehiculo(Long codigoVehiculo);
}