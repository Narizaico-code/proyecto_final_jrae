package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.dto.ModEmpleadoDto;

import java.util.List;

public interface EmpleadoRepository {
    List<EmpleadoDto> obtenerTodo();
   /* EmpleadoDto obtenerEmpleadoPorCodigo(Long codigoEmpleado);
    EmpleadoDto guardarEmpleado(EmpleadoDto empleadosDto);
    EmpleadoDto modificarEmppleado(Long codigoEmpleado, ModEmpleadoDto modEmpleadosDto);
    void eliminarEmpleado(Long codigo);*/
}
