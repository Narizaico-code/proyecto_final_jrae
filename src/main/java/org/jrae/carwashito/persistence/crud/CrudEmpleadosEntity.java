package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.EmpleadosEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudEmpleadosEntity extends CrudRepository<EmpleadosEntity, Long> {
}
