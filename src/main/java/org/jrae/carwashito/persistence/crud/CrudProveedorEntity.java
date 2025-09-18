package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.dominio.dto.ProveedorDto;
import org.jrae.carwashito.persistence.entity.ProveedorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudProveedorEntity extends CrudRepository<ProveedorEntity, Long> {
    ProveedorEntity findFirstByNombre(String nombre);
}
