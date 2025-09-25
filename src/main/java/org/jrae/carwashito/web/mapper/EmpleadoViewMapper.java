package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.web.view.EmpleadoView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AdministradorViewMapper.class})
public interface EmpleadoViewMapper {
    @Mapping(source = "codigoAdministrador", target = "administrador")
    EmpleadoView fromDto(EmpleadoDto dto);
    List<EmpleadoView> fromDto(Iterable<EmpleadoDto> dtos);
    // De View a DTO
    @Mapping(source = "administrador", target = "codigoAdministrador")
    EmpleadoDto toDto(EmpleadoView view);
}
