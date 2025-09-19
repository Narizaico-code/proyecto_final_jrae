package org.jrae.carwashito.web.mapper;


import org.jrae.carwashito.dominio.dto.InventarioDto;
import org.jrae.carwashito.dominio.dto.ModInventarioDto;
import org.jrae.carwashito.dominio.dto.ModProveedorDto;
import org.jrae.carwashito.persistence.entity.InventarioEntity;
import org.jrae.carwashito.persistence.entity.ProveedorEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventarioMapper {
    @Mapping(source = "codigoInventario", target = "inventoryId")
    @Mapping(source = "costo", target = "cost")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "fechaCaducidad", target = "expirationDate")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "administrador.codigoAdministrador", target = "administratorId")
    @Mapping(source = "proveedor.codigoProveedor", target = "providerId")
    InventarioDto toDto(InventarioEntity entity);

    List<InventarioDto> toDto(Iterable<InventarioEntity> entities);

    @InheritInverseConfiguration
    InventarioEntity toEntity(InventarioDto inventarioDto);

    @Mapping(source = "cost", target = "costo")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "expirationDate", target = "fechaCaducidad")
    @Mapping(source = "stock", target = "stock")
    void modificarEntityFromDto(ModInventarioDto modInventarioDto, @MappingTarget InventarioEntity inventarioEntity);
}
