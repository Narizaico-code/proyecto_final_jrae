package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.dto.ModClientesDto;
import org.jrae.carwashito.dominio.repository.ClientesRepository;
import org.jrae.carwashito.persistence.crud.CrudClientesEntity;
import org.jrae.carwashito.persistence.entity.ClientesEntity;
import org.jrae.carwashito.web.mapper.ClientesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientesEntityRepository implements ClientesRepository {

    private final CrudClientesEntity crudClientes;
    private final ClientesMapper clientesMapper;

    public ClientesEntityRepository(CrudClientesEntity crudClientes, ClientesMapper clientesMapper){
        this.crudClientes = crudClientes;
        this.clientesMapper = clientesMapper;
    }

    @Override
    public List<ClientesDto> obtenerTodo() {
        return this.clientesMapper.toDto(this.crudClientes.findAll());
    }

    @Override
    public ClientesDto obtenerClientesPorCodigo(Long codigo) {
        return this.clientesMapper.toDto(this.crudClientes.findById(codigo).orElse(null));
    }

    @Override
    public ClientesDto guardarClientes(ClientesDto clientesDto) {
        // Instanciar clase de entidad
        ClientesEntity clientesEntity = new ClientesEntity();

        // Convertir de DTO a Entity usando Mapper
        clientesEntity = this.clientesMapper.toEntity(clientesDto);

        // Guardar en la base de datos JPA
        this.crudClientes.save(clientesEntity);

        // Retornar el valor guardado como DTO
        return this.clientesMapper.toDto(clientesEntity);
    }

    @Override
    public ClientesDto modificarClientes(Long codigo, ModClientesDto modClientesDto) {
        ClientesEntity clientesEntity = this.crudClientes.findById(codigo)
                .orElseThrow(() -> new RuntimeException("El Cliente con código " + codigo + " no existe"));

        this.clientesMapper.updateEntityFromDto(modClientesDto, clientesEntity);
        return this.clientesMapper.toDto(this.crudClientes.save(clientesEntity));
    }

    @Override
    public void eliminarClientes(Long codigo){
        ClientesEntity clientes = this.crudClientes.findById(codigo).orElse(null);

        if (clientes != null) {
            this.crudClientes.deleteById(codigo); // eliminar si existe
        }
    }
}
