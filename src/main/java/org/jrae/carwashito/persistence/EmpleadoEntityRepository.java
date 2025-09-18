package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.dto.ModEmpleadoDto;
import org.jrae.carwashito.dominio.repository.EmpleadoRepository;
import org.jrae.carwashito.persistence.crud.CrudEmpleadoEntity;
import org.jrae.carwashito.persistence.entity.EmpleadoEntity;
import org.jrae.carwashito.web.mapper.EmpleadoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoEntityRepository implements EmpleadoRepository {
    private final CrudEmpleadoEntity crudEmpleado;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadoEntityRepository(CrudEmpleadoEntity crudEmpleados, EmpleadoMapper empleadoMapper){
        this.crudEmpleado = crudEmpleados;
        this.empleadoMapper = empleadoMapper;
    }

    @Override
    public List<EmpleadoDto> obtenerTodo() {
        return this.empleadoMapper.toDto(this.crudEmpleado.findAll());
    }

    @Override
    public EmpleadoDto obtenerEmpleadoPorCodigo(Long codigEmpleado) {
        return this.empleadoMapper.toDto(this.crudEmpleado.findById(codigEmpleado).orElse(null));

    }

    @Override
    public EmpleadoDto guardarEmpleado(EmpleadoDto empleadoDto) {
        // Instanciar clase de entidad
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();

        // Convertir de DTO a Entity usando Mapper
        empleadoEntity = this.empleadoMapper.toEntity(empleadoDto);

        // Guardar en la base de datos JPA
        this.crudEmpleado.save(empleadoEntity);

        // Retornar el valor guardado como DTO
        return this.empleadoMapper.toDto(empleadoEntity);
    }

    @Override
    public EmpleadoDto modificarEmpleado(Long codigoEmpleado, ModEmpleadoDto modEmpleadoDto) {
        EmpleadoEntity empleadoEntity = this.crudEmpleado.findById(codigoEmpleado)
                .orElseThrow(() -> new RuntimeException("El empleado con código " + codigoEmpleado + " no existe"));

        this.empleadoMapper.updateEntityFromDto(modEmpleadoDto, empleadoEntity);
        return this.empleadoMapper.toDto(this.crudEmpleado.save(empleadoEntity));
    }


    @Override
    public void eliminarEmpleado(Long codigoEmpleado){
        EmpleadoEntity empleado = this.crudEmpleado.findById(codigoEmpleado).orElse(null);

        if (empleado != null) {
            this.crudEmpleado.deleteById(codigoEmpleado); // eliminar si existe
        }

    }
}
