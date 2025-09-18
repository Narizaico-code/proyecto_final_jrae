package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;

import java.util.List;

public interface AdministradoresRepository {
    List<AdministradoresDto> obtenerTodo();

}
