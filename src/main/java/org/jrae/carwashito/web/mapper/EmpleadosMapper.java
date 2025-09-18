package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.EmpleadosDto;
import org.jrae.carwashito.persistence.entity.EmpleadosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// @Mapper(componentModel = "spring")
public interface EmpleadosMapper {
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "edad", target = "age")
    @Mapping(source = "disponibilidad", target = "availability")
    @Mapping(source = "sueldo", target = "salary")
    @Mapping(source = "fechaContratacion", target = "hiringDate")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")
    @Mapping(source = "cargo", target = "position")
    public EmpleadosDto toDto(EmpleadosEntity entity);

    public List<EmpleadosDto> toDto(Iterable<EmpleadosEntity> entities);
}
