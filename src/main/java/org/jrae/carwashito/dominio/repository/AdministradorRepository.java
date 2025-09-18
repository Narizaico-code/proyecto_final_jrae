package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ModAdministradorDto;

import java.util.List;

public interface AdministradorRepository {
    List<AdministradorDto> obtenerTodo();
    AdministradorDto obtenerAdministradoresPorCodigo(Long codigoAdministrador);
    AdministradorDto guardarAdministradores(AdministradorDto administradoresDto);
    AdministradorDto modificarAdministradores(Long codigoAdministrador, ModAdministradorDto modAdministradoresDto);
    void eliminarAdministradores(Long codigoAdministrador);

}
