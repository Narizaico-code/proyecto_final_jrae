package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {
    private final ClientesRepository clientesRepository;

    public ClientesService(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    public List<ClientesDto> obtenerTodo(){
        return this.clientesRepository.obtenerTodo();
    }
}
