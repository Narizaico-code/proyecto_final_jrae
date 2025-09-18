package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.repository.EmpleadoRepository;
import org.jrae.carwashito.persistence.crud.CrudEmpleadoEntity;
import org.jrae.carwashito.web.mapper.EmpleadosMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoEntityRepository implements EmpleadoRepository {
    private final CrudEmpleadoEntity crudEmpleados;
    private final EmpleadosMapper empleadosMapper;

    public EmpleadoEntityRepository(CrudEmpleadoEntity crudEmpleados, EmpleadosMapper empleadosMapper){
        this.crudEmpleados = crudEmpleados;
        this.empleadosMapper = empleadosMapper;
    }

    @Override
    public List<EmpleadoDto> obtenerTodo() {
        return this.empleadosMapper.toDto(this.crudEmpleados.findAll());
    }
}
