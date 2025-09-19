package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.dto.ModEmpleadoDto;
import org.jrae.carwashito.persistence.entity.EmpleadoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    @Mapping(source = "codigoEmpleado", target = "codigo")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "edad", target = "age")
    @Mapping(source = "disponibilidad", target = "availability")
    @Mapping(source = "sueldo", target = "salary")
    @Mapping(source = "fechaContratacion", target = "hireDate")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")
    @Mapping(source = "cargo", target = "position")
    @Mapping(source = "administrador.codigoAdministrador", target = "codigoAdministrador")
    public EmpleadoDto toDto(EmpleadoEntity entity);
    public List<EmpleadoDto> toDto(Iterable<EmpleadoEntity> entities);

    @InheritInverseConfiguration
    EmpleadoEntity toEntity(EmpleadoDto dto);
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "lastName", target = "apellido")
    @Mapping(source = "age", target = "edad")
    @Mapping(source = "availability", target = "disponibilidad")
    @Mapping(source = "salary", target = "sueldo")
    @Mapping(source = "hireDate", target = "fechaContratacion")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "phoneNumber", target = "telefono")
    @Mapping(source = "position", target = "cargo")
    void updateEntityFromDto(ModEmpleadoDto modEmpleadoDto, @MappingTarget EmpleadoEntity entity);

}
