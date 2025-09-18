package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.ServiciosEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudServiciosEntity extends CrudRepository<ServiciosEntity, Long> {
}
