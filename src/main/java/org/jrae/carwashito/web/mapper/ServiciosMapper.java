package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.ServiciosDto;
import org.jrae.carwashito.persistence.entity.ServiciosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// @Mapper(componentModel = "spring")
public interface ServiciosMapper {
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "precio", target = "price")

    public ServiciosDto toDto(ServiciosEntity entity);
    public List<ServiciosDto> toDto(Iterable<ServiciosEntity> entities);
}
