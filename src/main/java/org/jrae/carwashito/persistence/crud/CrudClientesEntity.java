package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.ClientesEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudClientesEntity extends CrudRepository<ClientesEntity, Long> {
    ClientesEntity findFirstByNombre(String nombre);
}
