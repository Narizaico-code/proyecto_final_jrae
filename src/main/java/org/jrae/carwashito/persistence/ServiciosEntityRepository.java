package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ServiciosDto;
import org.jrae.carwashito.dominio.repository.ServiciosRepository;
import org.jrae.carwashito.persistence.crud.CrudServiciosEntity;
import org.jrae.carwashito.web.mapper.ServiciosMapper;

import java.util.List;

public class ServiciosEntityRepository implements ServiciosRepository {
    private final CrudServiciosEntity crudServicios;
    private final ServiciosMapper serviciosMapper;

    public ServiciosEntityRepository(CrudServiciosEntity crudServicios, ServiciosMapper serviciosMapper){
        this.crudServicios = crudServicios;
        this.serviciosMapper = serviciosMapper;
    }

    @Override
    public List<ServiciosDto> obtenerTodo() {
        return this.serviciosMapper.toDto(this.crudServicios.findAll());
    }
}
