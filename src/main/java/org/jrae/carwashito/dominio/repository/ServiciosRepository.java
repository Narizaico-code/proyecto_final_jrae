package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.ServiciosDto;

import java.util.List;

public interface ServiciosRepository {
    List<ServiciosDto> obtenerTodo();
}
