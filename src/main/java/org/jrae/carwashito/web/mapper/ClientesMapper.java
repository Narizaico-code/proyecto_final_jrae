package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.persistence.entity.ClientesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// @Mapper(componentModel = "spring")
public interface ClientesMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "apodo", target = "nickname")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")
    @Mapping(source = "direccion", target = "address")

    public ClientesDto toDto(ClientesEntity entity);
    public List<ClientesDto> toDto(Iterable<ClientesEntity> entities);
}
