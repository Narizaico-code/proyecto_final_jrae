package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.EmpleadosDto;
import org.jrae.carwashito.dominio.repository.EmpleadosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    public EmpleadosService(EmpleadosRepository empleadosRepository){
        this.empleadosRepository = empleadosRepository;
    }

    public List<EmpleadosDto> obtenerTodo(){
        return this.empleadosRepository.obtenerTodo();
    }
}
