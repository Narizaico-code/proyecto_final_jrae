package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.dto.ModClienteDto;
import org.jrae.carwashito.dominio.repository.ClienteRepository;
import org.jrae.carwashito.persistence.crud.CrudClienteEntity;
import org.jrae.carwashito.persistence.entity.ClienteEntity;
import org.jrae.carwashito.web.mapper.ClientesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteEntityRepository implements ClienteRepository {

    private final CrudClienteEntity crudClientes;
    private final ClientesMapper clientesMapper;

    public ClienteEntityRepository(CrudClienteEntity crudClientes, ClientesMapper clientesMapper){
        this.crudClientes = crudClientes;
        this.clientesMapper = clientesMapper;
    }

    @Override
    public List<ClienteDto> obtenerTodo() {
        return this.clientesMapper.toDto(this.crudClientes.findAll());
    }

    @Override
    public ClienteDto obtenerClientesPorCodigo(Long codigoCliente) {
        return this.clientesMapper.toDto(this.crudClientes.findById(codigoCliente).orElse(null));
    }

    @Override
    public ClienteDto guardarClientes(ClienteDto clientesDto) {
        // Instanciar clase de entidad
        ClienteEntity clientesEntity = new ClienteEntity();

        // Convertir de DTO a Entity usando Mapper
        clientesEntity = this.clientesMapper.toEntity(clientesDto);

        // Guardar en la base de datos JPA
        this.crudClientes.save(clientesEntity);

        // Retornar el valor guardado como DTO
        return this.clientesMapper.toDto(clientesEntity);
    }

    @Override
    public ClienteDto modificarClientes(Long codigoCliente, ModClienteDto modClientesDto) {
        ClienteEntity clientesEntity = this.crudClientes.findById(codigoCliente)
                .orElseThrow(() -> new RuntimeException("El Cliente con código " + codigoCliente + " no existe"));

        this.clientesMapper.updateEntityFromDto(modClientesDto, clientesEntity);
        return this.clientesMapper.toDto(this.crudClientes.save(clientesEntity));
    }

    @Override
    public void eliminarClientes(Long codigoCliente){
        ClienteEntity clientes = this.crudClientes.findById(codigoCliente).orElse(null);

        if (clientes != null) {
            this.crudClientes.deleteById(codigoCliente); // eliminar si existe
        }
    }
}
