package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.dto.EmpleadosDto;

import java.util.List;

public interface EmpleadosRepository {
    List<EmpleadosDto> obtenerTodo();
}
