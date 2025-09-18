package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.ReservaDto;
import org.jrae.carwashito.persistence.entity.ReservaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel ="spring", uses = {MetodoPagoMapper.class})
public interface ReservaMapper {

    @Mapping(source = "codigoReserva", target = "codigo")
    @Mapping(source = "precioVehiculo.codigoVehiculo", target = "vehicleId")
    @Mapping(source = "empleados.codigo", target = "employeeId")
    @Mapping(source = "clientes.codigo", target = "clientId")
    @Mapping(source = "metodoPago", target = "payMethod", qualifiedByName = "generarMetodoPago")
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "hora", target = "hour")
    @Mapping(source = "descripcion", target = "description")
    ReservaDto toDto(ReservaEntity entity);
    List<ReservaDto> toDto(Iterable<ReservaEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "payMethod", target = "metodoPago", qualifiedByName = "generarPayMethod")
    ReservaEntity toEntity(ReservaDto reservaDto);
    void updateEntityFromDto(ReservaDto reservaDto, @MappingTarget ReservaEntity reservaEntity);
}
