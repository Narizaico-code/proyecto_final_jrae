package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.ClientesDto;

import java.util.List;

public interface ClientesRepository {
    List<ClientesDto> obtenerTodo();
}
