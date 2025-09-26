package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ProveedorDto;
import org.jrae.carwashito.web.view.AdministradorView;
import org.jrae.carwashito.web.view.ProveedoresView;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProveedorViewMapper {
    ProveedoresView fromDto(ProveedorDto dto);
    List<ProveedoresView> fromDto(Iterable<ProveedorDto> dtos);
    // De View a DTO
    ProveedorDto toDto(ProveedoresView view);
}
