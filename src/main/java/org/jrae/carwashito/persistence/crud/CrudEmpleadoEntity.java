package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudEmpleadoEntity extends CrudRepository<EmpleadoEntity, Long> {
}
