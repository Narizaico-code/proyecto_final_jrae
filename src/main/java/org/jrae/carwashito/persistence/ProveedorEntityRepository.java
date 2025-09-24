package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ModProveedorDto;
import org.jrae.carwashito.dominio.dto.ProveedorDto;
import org.jrae.carwashito.dominio.exception.ProveedorNoExisteException;
import org.jrae.carwashito.dominio.exception.ProveedorYaExisteException;
import org.jrae.carwashito.dominio.repository.ProveedorRepository;
import org.jrae.carwashito.persistence.crud.CrudProveedorEntity;
import org.jrae.carwashito.persistence.entity.ProveedorEntity;
import org.jrae.carwashito.web.mapper.ProveedorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorEntityRepository implements ProveedorRepository {

    private final CrudProveedorEntity crudProveedor;
    private final ProveedorMapper proveedorMapper;

    public ProveedorEntityRepository(CrudProveedorEntity crudProveedor, ProveedorMapper proveedorMapper){
        this.crudProveedor = crudProveedor;
        this.proveedorMapper = proveedorMapper;
    }

    @Override
    public List<ProveedorDto> obtenerTodo() {
        return this.proveedorMapper.toDto(this.crudProveedor.findAll());
    }


    @Override
    public ProveedorDto obtenerProveedorPorCodigo(Long codigo) {
        ProveedorEntity proveedor = this.crudProveedor.findById(codigo).orElse(null);

        if (proveedor == null){
            throw new ProveedorNoExisteException(codigo);
        }else{
            return this.proveedorMapper.toDto(proveedor);
        }
    }

    @Override
    public ProveedorDto guardarProveedor(ProveedorDto proveedorDto) {
        if (this.crudProveedor.findFirstByNombre(proveedorDto.name()) != null) {
            throw new ProveedorYaExisteException(proveedorDto.name());
        }
        ProveedorEntity proveedor = this.proveedorMapper.toEntity(proveedorDto);
        this.crudProveedor.save(proveedor);
        return this.proveedorMapper.toDto(proveedor);
    }

    @Override
    public ProveedorDto modificarProveedor(Long codigo, ModProveedorDto modProveedorDto) {
        ProveedorEntity proveedor = this.crudProveedor.findById(codigo).orElse(null);
        if (proveedor == null) {
            throw new ProveedorNoExisteException(codigo);
        }else{
            this.proveedorMapper.modificarEntityFromDto(modProveedorDto, proveedor);
            return this.proveedorMapper.toDto(this.crudProveedor.save(proveedor));
        }
    }

    @Override
    public void eliminarProveedor(Long codigo) {
        ProveedorEntity proveedorEntity = this.crudProveedor.findById(codigo).orElse(null);
        if (proveedorEntity == null) {
            throw new ProveedorNoExisteException(codigo);
        }
        this.crudProveedor.deleteById(codigo);
    }
}
