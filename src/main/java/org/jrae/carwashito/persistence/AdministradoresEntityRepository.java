package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.repository.AdministradoresRepository;
import org.jrae.carwashito.persistence.crud.CrudAdministradoresEntity;
import org.jrae.carwashito.web.mapper.AdministradoresMapper;

import java.util.List;

public class AdministradoresEntityRepository implements AdministradoresRepository {

    private final CrudAdministradoresEntity crudAdministradores;
    private final AdministradoresMapper administradoresMapper;

    public AdministradoresEntityRepository(CrudAdministradoresEntity crudAdministradores, AdministradoresMapper administradoresMapper){
        this.crudAdministradores = crudAdministradores;
        this.administradoresMapper = administradoresMapper;
    }

    @Override
    public List<AdministradoresDto> obtenerTodo() {
        return this.administradoresMapper.toDto(this.crudAdministradores.findAll());
    }
}
