package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;
import org.jrae.carwashito.persistence.entity.AdministradoresEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministradoresMapper {
    // Firmas de metodos: toDto -> Convertir a DTO
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")

    public AdministradoresDto toDto(AdministradoresEntity entity);
    public List<AdministradoresDto> toDto(Iterable<AdministradoresEntity> entities);

    @Mapping( source = "name", target = "nombre")
    @Mapping( source = "lastName", target = "apellido")
    @Mapping( source = "email", target = "correo")
    @Mapping( source = "phoneNumber", target = "telefono")
    AdministradoresEntity toEntity(AdministradoresDto dto);
    void updateEntityFromDto(ModAdministradoresDto modAdministradoresDto, @MappingTarget AdministradoresEntity entity);

    //void modificarEntityFromDto(ModAdministradoresDto modAdministradoresDto, @MappingTarget AdministradoresEntity administradoresEntity);
}
