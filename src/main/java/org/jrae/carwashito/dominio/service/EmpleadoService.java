package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.dto.ModEmpleadoDto;
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

    public EmpleadoDto obtenerEmpleadoPorCodigo(Long codigoEmpleado){
        return this.empleadoRepository.obtenerEmpleadoPorCodigo(codigoEmpleado);
    }

    public EmpleadoDto guardarEmpleado(EmpleadoDto empleadoDto){
        return this.empleadoRepository.guardarEmpleado(empleadoDto);
    }

    public EmpleadoDto modificarEmpleado(Long codigoEmpleado, ModEmpleadoDto modEmpleadoDto) {
        return empleadoRepository.modificarEmpleado(codigoEmpleado, modEmpleadoDto);
    }

    public void eliminarEmpleado(Long codigoEmpleado){
        this.empleadoRepository.eliminarEmpleado(codigoEmpleado);
    }
}
