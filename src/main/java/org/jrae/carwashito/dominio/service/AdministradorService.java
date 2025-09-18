package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ModAdministradorDto;
import org.jrae.carwashito.dominio.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    private final AdministradorRepository administradorRepository;


    public AdministradorService(AdministradorRepository administradorRepository){
        this.administradorRepository = administradorRepository;
    }

    public List<AdministradorDto> obtenerTodo(){
        return this.administradorRepository.obtenerTodo();
    }

    public AdministradorDto obtenerAdministradoresPorCodigo(Long codigoAdministrador){
        return this.administradorRepository.obtenerAdministradoresPorCodigo(codigoAdministrador);
    }

    public AdministradorDto guardarAdministradores(AdministradorDto administradoresDto){
        return this.administradorRepository.guardarAdministradores(administradoresDto);
    }

    public AdministradorDto modificarAdministradores(Long codigoAdministrador, ModAdministradorDto modAdministradoresDto) {
        return administradorRepository.modificarAdministradores(codigoAdministrador, modAdministradoresDto);
    }

    public void eliminarAdministradores(Long codigoAdministrador){
        this.administradorRepository.eliminarAdministradores(codigoAdministrador);
    }
}
