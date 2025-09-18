package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;

import java.util.List;

public interface AdministradoresRepository {
    List<AdministradoresDto> obtenerTodo();
    AdministradoresDto obtenerAdministradoresPorCodigo(Long codigo);
    AdministradoresDto guardarAdministradores(AdministradoresDto administradoresDto);
    AdministradoresDto modificarAdministradores(Long codigo, ModAdministradoresDto modAdministradoresDto);
    void eliminarAdministradores(Long codigo);

}
