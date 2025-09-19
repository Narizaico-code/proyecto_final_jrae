package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ModAdministradorDto;
import org.jrae.carwashito.dominio.repository.AdministradorRepository;
import org.jrae.carwashito.persistence.crud.CrudAdministradorEntity;
import org.jrae.carwashito.persistence.entity.AdministradorEntity;
import org.jrae.carwashito.web.mapper.AdministradorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministradorEntityRepository implements AdministradorRepository {

    private final CrudAdministradorEntity crudAdministrador;
    private final AdministradorMapper administradorMapper;

    public AdministradorEntityRepository(CrudAdministradorEntity crudAdministrador, AdministradorMapper administradorMapper){
        this.crudAdministrador = crudAdministrador;
        this.administradorMapper = administradorMapper;
    }

    @Override
    public List<AdministradorDto> obtenerTodo() {
        return this.administradorMapper.toDto(this.crudAdministrador.findAll());

    }

    @Override
    public AdministradorDto obtenerAdministradoresPorCodigo(Long codigoAdministrador) {
        return this.administradorMapper.toDto(this.crudAdministrador.findById(codigoAdministrador).orElse(null));

    }

    @Override
    public AdministradorDto guardarAdministradores(AdministradorDto administradoresDto) {
        // Instanciar clase de entidad
        AdministradorEntity administradoresEntity = new AdministradorEntity();

        // Convertir de DTO a Entity usando Mapper
        administradoresEntity = this.administradorMapper.toEntity(administradoresDto);

        // Guardar en la base de datos JPA
        this.crudAdministrador.save(administradoresEntity);

        // Retornar el valor guardado como DTO
        return this.administradorMapper.toDto(administradoresEntity);
    }

    @Override
    public AdministradorDto modificarAdministradores(Long codigoAdministrador, ModAdministradorDto modAdministradoresDto) {
        AdministradorEntity administradoresEntity = crudAdministrador.findById(codigoAdministrador)
                .orElseThrow(() -> new RuntimeException("El administrador con código " + codigoAdministrador + " no existe"));

        administradorMapper.updateEntityFromDto(modAdministradoresDto, administradoresEntity);
        return this.administradorMapper.toDto(this.crudAdministrador.save(administradoresEntity));
    }


    @Override
    public void eliminarAdministradores(Long codigoAdministrador){
        AdministradorEntity administrador = this.crudAdministrador.findById(codigoAdministrador).orElse(null);

        if (administrador != null) {
            this.crudAdministrador.deleteById(codigoAdministrador); // eliminar si existe
        }

    }
}
