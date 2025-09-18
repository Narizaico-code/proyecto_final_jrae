package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.repository.ClientesRepository;
import org.jrae.carwashito.persistence.crud.CrudClientesEntity;
import org.jrae.carwashito.web.mapper.ClientesMapper;

import java.util.List;

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
}
