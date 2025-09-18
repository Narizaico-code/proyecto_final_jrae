package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.EmpleadosDto;
import org.jrae.carwashito.dominio.repository.EmpleadosRepository;
import org.jrae.carwashito.persistence.crud.CrudEmpleadosEntity;
import org.jrae.carwashito.web.mapper.EmpleadosMapper;

import java.util.List;

public class EmpleadosEntityRepository implements EmpleadosRepository {
    private final CrudEmpleadosEntity crudEmpleados;
    private final EmpleadosMapper empleadosMapper;

    public EmpleadosEntityRepository(CrudEmpleadosEntity crudEmpleados, EmpleadosMapper empleadosMapper){
        this.crudEmpleados = crudEmpleados;
        this.empleadosMapper = empleadosMapper;
    }

    @Override
    public List<EmpleadosDto> obtenerTodo() {
        return this.empleadosMapper.toDto(this.crudEmpleados.findAll());
    }
}
