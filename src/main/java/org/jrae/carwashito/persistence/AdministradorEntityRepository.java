package org.jrae.carwashito.persistence;

import org.hibernate.ObjectNotFoundException;
import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ModAdministradorDto;
import org.jrae.carwashito.dominio.exception.AdministradorNoExisteException;
import org.jrae.carwashito.dominio.exception.PrecioYaExisteException;
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
        AdministradorEntity administrador = this.crudAdministrador.findById(codigoAdministrador).orElse(null);
        if (administrador == null) {
            throw new AdministradorNoExisteException(codigoAdministrador);
        }else {
            return this.administradorMapper.toDto(administrador);
        }
    }

    @Override
    public AdministradorDto guardarAdministradores(AdministradorDto administradoresDto) {
        if (this.crudAdministrador.findFirstByNombre(administradoresDto.name()) != null) {
            throw new PrecioYaExisteException(administradoresDto.name());
        }
        // Instanciar clase de entidad
        AdministradorEntity administrador = this.administradorMapper.toEntity(administradoresDto);

        // Guardar en la base de datos JPA
        this.crudAdministrador.save(administrador);

        // Retornar el valor guardado como DTO
        return this.administradorMapper.toDto(administrador);
    }

    @Override
    public AdministradorDto modificarAdministradores(Long codigoAdministrador, ModAdministradorDto modAdministradoresDto) {
        AdministradorEntity administradoresEntity = crudAdministrador.findById(codigoAdministrador).orElse(null);

        if (administradoresEntity == null) {
            throw new AdministradorNoExisteException(codigoAdministrador);
        } else {
            this.administradorMapper.updateEntityFromDto(modAdministradoresDto, administradoresEntity);
            return this.administradorMapper.toDto(this.crudAdministrador.save(administradoresEntity));
        }
    }


    @Override
    public void eliminarAdministradores(Long codigoAdministrador){
        AdministradorEntity administrador = this.crudAdministrador.findById(codigoAdministrador).orElse(null);

        if (administrador == null) {
             throw new AdministradorNoExisteException(codigoAdministrador);
        }else{
            this.crudAdministrador.deleteById(codigoAdministrador);
        }

    }
}
