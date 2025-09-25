package org.jrae.carwashito.web.mapper;


import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.web.view.ClienteView;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteViewMapper {
    ClienteView fromDto(ClienteDto dto);
    List<ClienteView> fromDto(Iterable<ClienteDto> dtos);
    // De View a DTO
    ClienteDto toDto(ClienteView view);
}
