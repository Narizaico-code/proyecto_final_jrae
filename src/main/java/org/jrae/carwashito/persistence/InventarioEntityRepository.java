package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ModInventarioDto;
import org.jrae.carwashito.dominio.dto.InventarioDto;
import org.jrae.carwashito.dominio.exception.InventarioNoExisteException;
import org.jrae.carwashito.dominio.exception.InventarioYaExisteException;
import org.jrae.carwashito.dominio.repository.InventarioRepository;
import org.jrae.carwashito.persistence.crud.CrudInventarioEntity;
import org.jrae.carwashito.persistence.entity.InventarioEntity;
import org.jrae.carwashito.web.mapper.InventarioMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventarioEntityRepository implements InventarioRepository {
    private final CrudInventarioEntity crudInventario;
    private final InventarioMapper inventarioMapper;

    public InventarioEntityRepository(CrudInventarioEntity crudInventario, InventarioMapper inventarioMapper){
        this.crudInventario = crudInventario;
        this.inventarioMapper = inventarioMapper;
    }

    @Override
    public List<InventarioDto> obtenerTodo() {
        return this.inventarioMapper.toDto(this.crudInventario.findAll());
    }

    @Override
    public InventarioDto obtenerInventarioPorCodigo(Long codigo) {
        InventarioEntity inventario = this.crudInventario.findById(codigo).orElse(null);
        if (inventario == null) {
            throw new InventarioNoExisteException(codigo);
        }else{
        return this.inventarioMapper.toDto(inventario);
        }
    }

    @Override
    public InventarioDto guardarInventario(InventarioDto inventarioDto) {
        if (this.crudInventario.findFirstByNombre(inventarioDto.name()) != null) {
            throw new InventarioYaExisteException(inventarioDto.name());
        }
        InventarioEntity inventario = this.inventarioMapper.toEntity(inventarioDto);
        this.crudInventario.save(inventario);
        return this.inventarioMapper.toDto(inventario);
    }

    @Override
    public InventarioDto modificarInventario(Long id, ModInventarioDto modInventarioDto) {
        InventarioEntity inventario = this.crudInventario.findById(id).orElse(null);
        if (inventario == null) {
            throw new InventarioNoExisteException(id);
        }else{
            this.inventarioMapper.modificarEntityFromDto(modInventarioDto, inventario);
            return this.inventarioMapper.toDto(this.crudInventario.save(inventario));
        }

    }

    @Override
    public void eliminarInventario(Long id) {
        InventarioEntity inventario = this.crudInventario.findById(id).orElse(null);
        if (inventario == null) {
            throw new InventarioNoExisteException(id);
        }else{
            this.crudInventario.deleteById(id);
        }
    }
}
