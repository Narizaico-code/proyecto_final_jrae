package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.web.view.AdministradorView;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministradorViewMapper {
    AdministradorView fromDto(AdministradorDto dto);
    List<AdministradorView> fromDto(Iterable<AdministradorDto> dtos);
    // De View a DTO
    AdministradorDto toDto(AdministradorView view);
}
