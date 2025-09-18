package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.ServicioDto;

import java.util.List;

public interface ServicioRepository {
    List<ServicioDto> obtenerTodo();
    ServicioDto obtenerServicioPorCodigo(Long codigoServicio);
    ServicioDto guardarServicio(ServicioDto servicioDTO);
    ServicioDto actualizarServicio(Long codigoServicio, ServicioDto servicioDTO);
    void eliminarServicio(Long codigoServicio);
}
