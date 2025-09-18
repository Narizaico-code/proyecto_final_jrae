package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;
import org.jrae.carwashito.dominio.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    private final AdministradorRepository administradoresRepository;


    public AdministradorService(AdministradorRepository administradoresRepository){
        this.administradoresRepository = administradoresRepository;
    }

    public List<AdministradoresDto> obtenerTodo(){
        return this.administradoresRepository.obtenerTodo();
    }

    public AdministradoresDto obtenerAdministradoresPorCodigo(Long codigoAdministrador){
        return this.administradoresRepository.obtenerAdministradoresPorCodigo(codigoAdministrador);
    }

    public AdministradoresDto guardarAdministradores(AdministradoresDto administradoresDto){
        return this.administradoresRepository.guardarAdministradores(administradoresDto);
    }

    public AdministradoresDto modificarAdministradores(Long codigoAdministrador, ModAdministradoresDto modAdministradoresDto) {
        return administradoresRepository.modificarAdministradores(codigoAdministrador, modAdministradoresDto);
    }

    public void eliminarAdministradores(Long codigoAdministrador){
        this.administradoresRepository.eliminarAdministradores(codigoAdministrador);
    }
}
