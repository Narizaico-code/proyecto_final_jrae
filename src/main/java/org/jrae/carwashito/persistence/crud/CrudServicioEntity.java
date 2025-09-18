package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.Servicio;
import org.springframework.data.repository.CrudRepository;

public interface CrudServicioEntity extends CrudRepository<Servicio, Long> {
        Servicio findFirstByNombre(String nombre);
}