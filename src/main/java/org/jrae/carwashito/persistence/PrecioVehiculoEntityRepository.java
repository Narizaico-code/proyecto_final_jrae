package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;
import org.jrae.carwashito.dominio.repository.PrecioVehiculoRepository;
import org.jrae.carwashito.persistence.crud.CrudPrecioVehiculoEntity;
import org.jrae.carwashito.persistence.entity.PrecioVehiculo;
import org.jrae.carwashito.web.mapper.PrecioVehiculoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrecioVehiculoEntityRepository implements PrecioVehiculoRepository {
    private final CrudPrecioVehiculoEntity crudPrecioVehiculoEntity;
    private final PrecioVehiculoMapper precioVehiculoMapper;

    public PrecioVehiculoEntityRepository(CrudPrecioVehiculoEntity crudPrecioVehiculoEntity,
                                      PrecioVehiculoMapper precioVehiculoMapper) {
        this.crudPrecioVehiculoEntity = crudPrecioVehiculoEntity;
        this.precioVehiculoMapper = precioVehiculoMapper;
    }

    @Override
    public List<PrecioVehiculoDto> obtenerTodos() {
        return this.precioVehiculoMapper.toDto(this.crudPrecioVehiculoEntity.findAll());
    }

    @Override
    public PrecioVehiculoDto obtenerPrecioVehiculoPorCodigo(Long codigoVehiculo) {
        PrecioVehiculo precioVehiculo = this.crudPrecioVehiculoEntity.findById(codigoVehiculo)
                .orElseThrow(() -> new RuntimeException("El precio de vehículo con código " + codigoVehiculo + " no existe"));
        return this.precioVehiculoMapper.toDto(precioVehiculo);
    }

    @Override
    public PrecioVehiculoDto guardarPrecioVehiculo(PrecioVehiculoDto PrecioVehiculoDto) {
        // Verificar si ya existe un precio para ese tipo de vehículo
        if (this.crudPrecioVehiculoEntity.findFirstByTipoVehiculo(PrecioVehiculoDto.typeVehicle()) != null) {
            throw new RuntimeException("Ya existe un precio para el tipo de vehículo '" +
                    PrecioVehiculoDto.typeVehicle() + "'");
        }

        PrecioVehiculo precioVehiculo = this.precioVehiculoMapper.toEntity(PrecioVehiculoDto);
        precioVehiculo = this.crudPrecioVehiculoEntity.save(precioVehiculo);
        return this.precioVehiculoMapper.toDto(precioVehiculo);
    }

    @Override
    public PrecioVehiculoDto actualizarPrecioVehiculo(Long codigoVehiculo, PrecioVehiculoDto PrecioVehiculoDto) {
        PrecioVehiculo precioVehiculo = this.crudPrecioVehiculoEntity.findById(codigoVehiculo)
                .orElseThrow(() -> new RuntimeException("El precio de vehículo con código " + codigoVehiculo + " no existe"));

        this.precioVehiculoMapper.updateEntityFromDto(PrecioVehiculoDto, precioVehiculo);
        return this.precioVehiculoMapper.toDto(this.crudPrecioVehiculoEntity.save(precioVehiculo));
    }

    @Override
    public void eliminarPrecioVehiculo(Long codigoVehiculo) {
        if (!this.crudPrecioVehiculoEntity.existsById(codigoVehiculo)) {
            throw new RuntimeException("El precio de vehículo con código " + codigoVehiculo + " no existe");
        }
        this.crudPrecioVehiculoEntity.deleteById(codigoVehiculo);
    }
}
