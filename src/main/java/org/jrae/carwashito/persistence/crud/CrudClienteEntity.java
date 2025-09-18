package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudClienteEntity extends CrudRepository<ClienteEntity, Long> {
    ClienteEntity findFirstByNombre(String nombre);
}
