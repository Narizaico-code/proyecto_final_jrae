package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;

import java.util.List;

public interface AdministradorRepository {
    List<AdministradoresDto> obtenerTodo();
    AdministradoresDto obtenerAdministradoresPorCodigo(Long codigoAdministrador);
    AdministradoresDto guardarAdministradores(AdministradoresDto administradoresDto);
    AdministradoresDto modificarAdministradores(Long codigoAdministrador, ModAdministradoresDto modAdministradoresDto);
    void eliminarAdministradores(Long codigoAdministrador);

}
