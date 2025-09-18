package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.dto.ModClientesDto;
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

    public ClientesDto obtenerClientesPorCodigo(Long codigo){
        return this.clientesRepository.obtenerClientesPorCodigo(codigo);
    }

    public ClientesDto guardarClientes(ClientesDto clientesDto){
        return this.clientesRepository.guardarClientes(clientesDto);
    }

    public ClientesDto modificarClientes(Long codigo, ModClientesDto modClientesDto) {
        return clientesRepository.modificarClientes(codigo, modClientesDto);
    }

    public void eliminarClientes(Long codigo){
        this.clientesRepository.eliminarClientes(codigo);
    }
}
