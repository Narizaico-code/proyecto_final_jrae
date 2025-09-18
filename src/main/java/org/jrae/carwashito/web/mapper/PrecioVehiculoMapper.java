package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;
import org.jrae.carwashito.persistence.entity.PrecioVehiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrecioVehiculoMapper {

    @Mapping(source = "codigoVehiculo", target = "codigo")
    @Mapping(source = "tipoVehiculo", target = "typeVehicle")
    @Mapping(source = "valor", target = "value")
    PrecioVehiculoDto toDto(PrecioVehiculo entity);

    List<PrecioVehiculoDto> toDto(Iterable<PrecioVehiculo> entities);

    @Mapping(source = "codigo", target = "codigoVehiculo")
    @Mapping(source = "typeVehicle", target = "tipoVehiculo")
    @Mapping(source = "value", target = "valor")
    PrecioVehiculo toEntity(PrecioVehiculoDto dto);

    @Mapping(source = "codigo", target = "codigoVehiculo")
    @Mapping(source = "typeVehicle", target = "tipoVehiculo")
    @Mapping(source = "value", target = "valor")
    void updateEntityFromDto(PrecioVehiculoDto dto, @MappingTarget PrecioVehiculo entity);
}