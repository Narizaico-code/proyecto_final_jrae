package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;
import org.jrae.carwashito.dominio.repository.AdministradorRepository;
import org.jrae.carwashito.persistence.crud.CrudAdministradorEntity;
import org.jrae.carwashito.persistence.entity.AdministradoresEntity;
import org.jrae.carwashito.web.mapper.AdministradoresMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministradorEntityRepository implements AdministradorRepository {

    private final CrudAdministradorEntity crudAdministradores;
    private final AdministradoresMapper administradoresMapper;

    public AdministradorEntityRepository(CrudAdministradorEntity crudAdministradores, AdministradoresMapper administradoresMapper){
        this.crudAdministradores = crudAdministradores;
        this.administradoresMapper = administradoresMapper;
    }

    @Override
    public List<AdministradoresDto> obtenerTodo() {
        return this.administradoresMapper.toDto(this.crudAdministradores.findAll());

    }

    @Override
    public AdministradoresDto obtenerAdministradoresPorCodigo(Long codigoAdministrador) {
        return this.administradoresMapper.toDto(this.crudAdministradores.findById(codigoAdministrador).orElse(null));

    }

    @Override
    public AdministradoresDto guardarAdministradores(AdministradoresDto administradoresDto) {
        // Instanciar clase de entidad
        AdministradoresEntity administradoresEntity = new AdministradoresEntity();

        // Convertir de DTO a Entity usando Mapper
        administradoresEntity = this.administradoresMapper.toEntity(administradoresDto);

        // Guardar en la base de datos JPA
        this.crudAdministradores.save(administradoresEntity);

        // Retornar el valor guardado como DTO
        return this.administradoresMapper.toDto(administradoresEntity);
    }

    @Override
    public AdministradoresDto modificarAdministradores(Long codigoAdministrador, ModAdministradoresDto modAdministradoresDto) {
        AdministradoresEntity administradoresEntity = this.crudAdministradores.findById(codigoAdministrador)
                .orElseThrow(() -> new RuntimeException("El administrador con código " + codigoAdministrador + " no existe"));

        this.administradoresMapper.updateEntityFromDto(modAdministradoresDto, administradoresEntity);
        return this.administradoresMapper.toDto(this.crudAdministradores.save(administradoresEntity));
    }


    @Override
    public void eliminarAdministradores(Long codigoAdministrador){
        AdministradoresEntity administrador = this.crudAdministradores.findById(codigoAdministrador).orElse(null);

        if (administrador != null) {
            this.crudAdministradores.deleteById(codigoAdministrador); // eliminar si existe
        }

    }
}
