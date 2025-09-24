package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.dto.ModClienteDto;
import org.jrae.carwashito.dominio.exception.ClienteNoExisteException;
import org.jrae.carwashito.dominio.exception.ClienteYaExisteException;
import org.jrae.carwashito.dominio.repository.ClienteRepository;
import org.jrae.carwashito.persistence.crud.CrudClienteEntity;
import org.jrae.carwashito.persistence.entity.ClienteEntity;
import org.jrae.carwashito.web.mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteEntityRepository implements ClienteRepository {

    private final CrudClienteEntity crudClientes;
    private final ClienteMapper clienteMapper;

    public ClienteEntityRepository(CrudClienteEntity crudClientes, ClienteMapper clienteMapper){
        this.crudClientes = crudClientes;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDto> obtenerTodo() {
        return this.clienteMapper.toDto(this.crudClientes.findAll());
    }

    @Override
    public ClienteDto obtenerClientesPorCodigo(Long codigoCliente) {
        ClienteEntity clienteEntity = this.crudClientes.findById(codigoCliente).orElse(null);
        if (clienteEntity == null) {
            throw new ClienteNoExisteException(codigoCliente);
        }
        return this.clienteMapper.toDto(clienteEntity);
    }

    @Override
    public ClienteDto guardarClientes(ClienteDto clientesDto) {
        // Instanciar clase de entidad
        if (this.crudClientes.findFirstByNombre(clientesDto.name() ) != null) {
            throw new ClienteYaExisteException(clientesDto.name());
        }

        // Convertir de DTO a Entity usando Mapper

        ClienteEntity clientesEntity = this.clienteMapper.toEntity(clientesDto);

        // Guardar en la base de datos JPA
        this.crudClientes.save(clientesEntity);

        // Retornar el valor guardado como DTO
        return this.clienteMapper.toDto(clientesEntity);
    }

    @Override
    public ClienteDto modificarClientes(Long codigoCliente, ModClienteDto modClientesDto) {
        ClienteEntity clientesEntity = crudClientes.findById(codigoCliente).orElse(null);
        if (clientesEntity == null) {
            throw new ClienteNoExisteException(codigoCliente);
        }else {
            this.clienteMapper.updateEntityFromDto(modClientesDto, clientesEntity);
            return clienteMapper.toDto(this.crudClientes.save(clientesEntity));
        }
    }

    @Override
    public void eliminarClientes(Long codigoCliente){
        ClienteEntity clientes = this.crudClientes.findById(codigoCliente).orElse(null);
        if (clientes == null) {
            throw new ClienteNoExisteException(codigoCliente);
        }else{
            this.crudClientes.deleteById(codigoCliente);
        }
    }
}
