package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.AdministradoresEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudAdministradorEntity extends CrudRepository<AdministradoresEntity, Long> {
    AdministradoresEntity findFirstByNombre(String nombre);

}
