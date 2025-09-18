package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.dto.ServiciosDto;
import org.jrae.carwashito.dominio.repository.ClientesRepository;
import org.jrae.carwashito.dominio.repository.ServiciosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosService {
    private final ServiciosRepository serviciosRepository;

    public ServiciosService(ServiciosRepository serviciosRepository){
        this.serviciosRepository = serviciosRepository;
    }

    public List<ServiciosDto> obtenerTodo(){
        return this.serviciosRepository.obtenerTodo();
    }
}
