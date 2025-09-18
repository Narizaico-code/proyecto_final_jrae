package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ServicioDto;
import org.jrae.carwashito.dominio.repository.ServicioRepository;
import org.jrae.carwashito.persistence.crud.CrudServicioEntity;
import org.jrae.carwashito.persistence.entity.Servicio;
import org.jrae.carwashito.web.mapper.ServicioMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServicioEntityRepository implements ServicioRepository {
    private final CrudServicioEntity crudServicioEntity;
    private final ServicioMapper servicioMapper;

    public ServicioEntityRepository(CrudServicioEntity crudServicioEntity, ServicioMapper servicioMapper) {
        this.crudServicioEntity = crudServicioEntity;
        this.servicioMapper = servicioMapper;
    }

    @Override
    public List<ServicioDto> obtenerTodo() {
        return this.servicioMapper.toDto(this.crudServicioEntity.findAll());
    }

    @Override
    public ServicioDto obtenerServicioPorCodigo(Long codigoServicio) {
        Servicio servicio = this.crudServicioEntity.findById(codigoServicio)
                .orElseThrow(() -> new RuntimeException("El servicio con código " + codigoServicio + " no existe"));
        return this.servicioMapper.toDto(servicio);
    }

    @Override
    public ServicioDto guardarServicio(ServicioDto servicioDto) {
        // Verificar si ya existe un servicio con ese nombre
        if (this.crudServicioEntity.findFirstByNombre(servicioDto.name()) != null) {
            throw new RuntimeException("El servicio '" + servicioDto.name() + "' ya existe en el sistema");
        }

        Servicio servicio = this.servicioMapper.toEntity(servicioDto);
        servicio = this.crudServicioEntity.save(servicio);
        return this.servicioMapper.toDto(servicio);
    }

    @Override
    public ServicioDto actualizarServicio(Long codigoServicio, ServicioDto servicioDto) {
        Servicio servicio = this.crudServicioEntity.findById(codigoServicio)
                .orElseThrow(() -> new RuntimeException("El servicio con código " + codigoServicio + " no existe"));

        this.servicioMapper.updateEntityFromDto(servicioDto, servicio);
        servicio = this.crudServicioEntity.save(servicio);
        return this.servicioMapper.toDto(servicio);
    }

    @Override
    public void eliminarServicio(Long codigoServicio) {
        if (!this.crudServicioEntity.existsById(codigoServicio)) {
            throw new RuntimeException("El servicio con código " + codigoServicio + " no existe");
        }
        this.crudServicioEntity.deleteById(codigoServicio);
    }
}
