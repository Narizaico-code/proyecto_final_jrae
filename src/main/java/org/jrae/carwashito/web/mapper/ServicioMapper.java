package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.ServicioDto;
import org.jrae.carwashito.persistence.entity.Servicio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    @Mapping(source = "codigoServicio", target = "codigo")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "precio", target = "price")
    ServicioDto toDto(Servicio entity);
    List<ServicioDto> toDto(Iterable<Servicio> entities);

    @InheritInverseConfiguration
    Servicio toEntity(ServicioDto dto);

    @Mapping(source = "codigo", target = "codigoServicio")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "price", target = "precio")
    void updateEntityFromDto(ServicioDto dto, @MappingTarget Servicio entity);
}