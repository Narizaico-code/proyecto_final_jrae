package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.AdministradoresDto;
import org.jrae.carwashito.dominio.dto.ModAdministradoresDto;
import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;
import org.jrae.carwashito.dominio.repository.AdministradoresRepository;
import org.jrae.carwashito.persistence.crud.CrudAdministradoresEntity;
import org.jrae.carwashito.persistence.entity.AdministradoresEntity;
import org.jrae.carwashito.persistence.entity.PrecioVehiculo;
import org.jrae.carwashito.web.mapper.AdministradoresMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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

    @Override
    public AdministradoresDto obtenerAdministradoresPorCodigo(Long codigo) {
        return this.administradoresMapper.toDto(this.crudAdministradores.findById(codigo).orElse(null));

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
    public AdministradoresDto modificarAdministradores(Long codigo, ModAdministradoresDto modAdministradoresDto) {
        AdministradoresEntity administradoresEntity = this.crudAdministradores.findById(codigo)
                .orElseThrow(() -> new RuntimeException("El administrador con código " + codigo + " no existe"));

        this.administradoresMapper.updateEntityFromDto(modAdministradoresDto, administradoresEntity);
        return this.administradoresMapper.toDto(this.crudAdministradores.save(administradoresEntity));
    }


    @Override
    public void eliminarAdministradores(Long codigo){
        AdministradoresEntity administrador = this.crudAdministradores.findById(codigo).orElse(null);

        if (administrador != null) {
            this.crudAdministradores.deleteById(codigo); // eliminar si existe
        }

    }
}
