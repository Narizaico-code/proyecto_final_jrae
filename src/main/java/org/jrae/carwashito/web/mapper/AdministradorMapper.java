package org.jrae.carwashito.web.mapper;

import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ModAdministradorDto;
import org.jrae.carwashito.persistence.entity.AdministradorEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {
    // Firmas de metodos: toDto -> Convertir a DTO
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellido", target = "lastName")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phoneNumber")

    public AdministradorDto toDto(AdministradorEntity entity);
    public List<AdministradorDto> toDto(Iterable<AdministradorEntity> entities);

    @InheritInverseConfiguration
    AdministradorEntity toEntity(AdministradorDto dto);
    @Mapping( source = "name", target = "nombre")
    @Mapping( source = "lastName", target = "apellido")
    @Mapping( source = "email", target = "correo")
    @Mapping( source = "phoneNumber", target = "telefono")
    void updateEntityFromDto(ModAdministradorDto modAdministradorDto, @MappingTarget AdministradorEntity entity);

    //void modificarEntityFromDto(ModAdministradorDto modAdministradoresDto, @MappingTarget AdministradorEntity administradoresEntity);
}
