package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.AdministradorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudAdministradorEntity extends CrudRepository<AdministradorEntity, Long> {
    AdministradorEntity findFirstByNombre(String nombre);

}
