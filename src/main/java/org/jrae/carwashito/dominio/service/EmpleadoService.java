package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;
import org.jrae.carwashito.dominio.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    public List<EmpleadoDto> obtenerTodo(){
        return this.empleadoRepository.obtenerTodo();
    }
/*
    public EmpleadoDto obtenerEmpleadoPorCodigo(Long codigoEmpleado){
        return this.empleadoRepository.obtenerAdministradoresPorCodigo(codigo);
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
}*/
}
