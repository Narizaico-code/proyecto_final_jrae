package org.jrae.carwashito.persistence.crud;
import org.jrae.carwashito.persistence.entity.ReservaEntity;
import org.springframework.data.repository.CrudRepository;


public interface CrudReservaEntity extends CrudRepository<ReservaEntity, Long> {
}