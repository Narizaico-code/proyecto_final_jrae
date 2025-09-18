package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.persistence.entity.AdministradoresEntity;

import org.mapstruct.Mapping;

import java.util.List;

public interface AdministradoresMapper {
    // Firmas de metodos: toDto -> Convertir a DTO
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")

    public AdministradoresDto toDto(AdministradoresEntity entity);
    public List<AdministradoresDto> toDto(Iterable<AdministradoresEntity> entities);

}
