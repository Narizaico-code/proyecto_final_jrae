package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.repository.AdministradoresRepository;
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
}
