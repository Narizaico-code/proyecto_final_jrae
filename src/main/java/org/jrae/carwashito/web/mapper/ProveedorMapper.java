package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.ModProveedorDto;
import org.jrae.carwashito.dominio.dto.ProveedorDto;
import org.jrae.carwashito.persistence.entity.ProveedorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProveedorMapper {
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "numero", target = "number")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "direccion", target = "address")
    ProveedorDto toDto(ProveedorEntity entity);
    List<ProveedorDto> toDto(Iterable<ProveedorEntity> entities);

    @InheritInverseConfiguration
    ProveedorEntity toEntity (ProveedorDto proveedorDto);

    @Mapping(source = "number", target = "numero")
    @Mapping(source = "email", target = "correo")
    void modificarEntityFromDto(ModProveedorDto modProveedorDto, @MappingTarget ProveedorEntity proveedorEntity);
}
