package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.dto.ModClientesDto;
import org.jrae.carwashito.persistence.entity.ClientesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientesMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "apodo", target = "nickname")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")
    @Mapping(source = "direccion", target = "address")

    public ClientesDto toDto(ClientesEntity entity);
    public List<ClientesDto> toDto(Iterable<ClientesEntity> entities);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "lastName", target = "apellido")
    @Mapping(source = "nickname", target = "apodo")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "phoneNumber", target = "telefono")
    @Mapping(source = "address", target = "direccion")
    ClientesEntity toEntity(ClientesDto dto);
    void updateEntityFromDto(ModClientesDto modClientesDto, @MappingTarget ClientesEntity entity);

}
