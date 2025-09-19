package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.InventarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudInventarioEntity extends CrudRepository<InventarioEntity, Long> {
    InventarioEntity findFirstByNombre(String nombre);
}