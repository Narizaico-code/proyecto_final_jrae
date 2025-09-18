package org.jrae.carwashito.persistence.crud;

import org.jrae.carwashito.persistence.entity.PrecioVehiculo;
import org.springframework.data.repository.CrudRepository;

public interface CrudPrecioVehiculoEntity extends CrudRepository<PrecioVehiculo, Long> {
    PrecioVehiculo findFirstByTipoVehiculo(String tipoVehiculo);
}
