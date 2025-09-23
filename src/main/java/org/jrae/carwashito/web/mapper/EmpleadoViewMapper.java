package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.web.view.EmpleadoView;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoViewMapper {
    EmpleadoView fromDto(EmpleadoDto dto);
    List<EmpleadoView> fromDto(Iterable<EmpleadoDto> dtos);
    // De View a DTO
    EmpleadoDto toDto(EmpleadoView view);
}
