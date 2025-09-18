package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;
import org.jrae.carwashito.dominio.repository.AdministradoresRepository;
import org.jrae.carwashito.persistence.crud.CrudAdministradoresEntity;
import org.jrae.carwashito.persistence.entity.AdministradoresEntity;
import org.jrae.carwashito.web.mapper.AdministradoresMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradoresService {
    private final AdministradoresRepository administradoresRepository;


    public AdministradoresService(AdministradoresRepository administradoresRepository){
        this.administradoresRepository = administradoresRepository;
    }

    public List<AdministradoresDto> obtenerTodo(){
        return this.administradoresRepository.obtenerTodo();
    }

    public AdministradoresDto obtenerAdministradoresPorCodigo(Long codigo){
        return this.administradoresRepository.obtenerAdministradoresPorCodigo(codigo);
    }

    public AdministradoresDto guardarAdministradores(AdministradoresDto administradoresDto){
        return this.administradoresRepository.guardarAdministradores(administradoresDto);
    }

    public AdministradoresDto modificarAdministradores(Long codigo, ModAdministradoresDto modAdministradoresDto) {
        return administradoresRepository.modificarAdministradores(codigo, modAdministradoresDto);
    }

    public void eliminarAdministradores(Long codigo){
        this.administradoresRepository.eliminarAdministradores(codigo);
    }
}
