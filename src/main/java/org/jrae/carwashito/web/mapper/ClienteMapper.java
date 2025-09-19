package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.dto.ModClienteDto;
import org.jrae.carwashito.persistence.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "apodo", target = "nickname")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")
    @Mapping(source = "direccion", target = "address")

    public ClienteDto toDto(ClienteEntity entity);
    public List<ClienteDto> toDto(Iterable<ClienteEntity> entities);

    @InheritInverseConfiguration
    ClienteEntity toEntity(ClienteDto dto);
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "lastName", target = "apellido")
    @Mapping(source = "nickname", target = "apodo")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "phoneNumber", target = "telefono")
    @Mapping(source = "address", target = "direccion")
    void updateEntityFromDto(ModClienteDto modClientesDto, @MappingTarget ClienteEntity entity);

}
