package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.dto.ModEmpleadoDto;
import org.jrae.carwashito.dominio.exception.EmpleadoNoExisteException;
import org.jrae.carwashito.dominio.exception.EmpleadoYaExisteException;
import org.jrae.carwashito.dominio.repository.EmpleadoRepository;
import org.jrae.carwashito.persistence.crud.CrudAdministradorEntity;
import org.jrae.carwashito.persistence.crud.CrudEmpleadoEntity;
import org.jrae.carwashito.persistence.entity.AdministradorEntity;
import org.jrae.carwashito.persistence.entity.EmpleadoEntity;
import org.jrae.carwashito.web.mapper.EmpleadoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoEntityRepository implements EmpleadoRepository {
    private final CrudEmpleadoEntity crudEmpleado;
    private final CrudAdministradorEntity crudAdministrador;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadoEntityRepository(CrudEmpleadoEntity crudEmpleados, CrudAdministradorEntity crudAdministrador, EmpleadoMapper empleadoMapper){
        this.crudEmpleado = crudEmpleados;
        this.crudAdministrador = crudAdministrador;
        this.empleadoMapper = empleadoMapper;
    }

    @Override
    public List<EmpleadoDto> obtenerTodo() {
        return this.empleadoMapper.toDto(this.crudEmpleado.findAll());
    }

    @Override
    public EmpleadoDto obtenerEmpleadoPorCodigo(Long codigEmpleado) {
        EmpleadoEntity empleado = this.crudEmpleado.findById(codigEmpleado).orElse(null);
        if (empleado == null) {
            throw new EmpleadoNoExisteException(codigEmpleado);
        }else {
            return this.empleadoMapper.toDto(empleado);
        }
    }

    @Override
    public EmpleadoDto guardarEmpleado(EmpleadoDto empleadoDto) {
        if (this.crudEmpleado.findFirstByNombre(empleadoDto.name()) != null) {
            throw new EmpleadoYaExisteException(empleadoDto.name());
        }

        // Convertir DTO a Entity usando Mapper
        EmpleadoEntity empleadoEntity = this.empleadoMapper.toEntity(empleadoDto);

        // Asignar el AdministradorEntity usando solo el ID (FK)
        if (empleadoDto.codigoAdministrador() != null) {
            empleadoEntity.setAdministrador(new AdministradorEntity(empleadoDto.codigoAdministrador()));
        }

        // Guardar en la base de datos y obtener la entidad guardada con ID generado
        this.crudEmpleado.save(empleadoEntity);

        // Devolver DTO con el registro guardado
        return empleadoMapper.toDto(empleadoEntity);
    }

    @Override
    public EmpleadoDto modificarEmpleado(Long codigoEmpleado, ModEmpleadoDto modEmpleadoDto) {
        EmpleadoEntity empleadoEntity = this.crudEmpleado.findById(codigoEmpleado).orElse(null);

        if (empleadoEntity == null) {
            throw new EmpleadoNoExisteException(codigoEmpleado);
        }else {
            // 2️⃣ Actualizar los campos con MapStruct
            this.empleadoMapper.updateEntityFromDto(modEmpleadoDto, empleadoEntity);

            // Actualizar la FK administrador manualmente
            if (modEmpleadoDto.codigoAdministrador() != null) {
                AdministradorEntity administrador = new AdministradorEntity();
                administrador.setCodigoAdministrador(modEmpleadoDto.codigoAdministrador());
                empleadoEntity.setAdministrador(administrador);
            }

            //  uardar la entidad actualizada en la base de datos
            EmpleadoEntity guardado = this.crudEmpleado.save(empleadoEntity);

            // Convertir de nuevo a DTO y devolver
            return this.empleadoMapper.toDto(guardado);
        }
    }

    @Override
    public void eliminarEmpleado(Long codigoEmpleado){
        EmpleadoEntity empleado = this.crudEmpleado.findById(codigoEmpleado).orElse(null);

        if (empleado == null) {
            throw new EmpleadoNoExisteException(codigoEmpleado);
        }else{
            this.crudEmpleado.deleteById(codigoEmpleado); // eliminar si existe
        }

    }
}
