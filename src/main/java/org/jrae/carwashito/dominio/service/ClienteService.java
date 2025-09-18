package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.dto.ModClienteDto;
import org.jrae.carwashito.dominio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clientesRepository;

    public ClienteService(ClienteRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    public List<ClienteDto> obtenerTodo(){
        return this.clientesRepository.obtenerTodo();
    }

    public ClienteDto obtenerClientesPorCodigo(Long codigoCliente){
        return this.clientesRepository.obtenerClientesPorCodigo(codigoCliente);
    }

    public ClienteDto guardarClientes(ClienteDto clientesDto){
        return this.clientesRepository.guardarClientes(clientesDto);
    }

    public ClienteDto modificarClientes(Long codigoCliente, ModClienteDto modClientesDto) {
        return clientesRepository.modificarClientes(codigoCliente, modClientesDto);
    }

    public void eliminarClientes(Long codigoCliente){
        this.clientesRepository.eliminarClientes(codigoCliente);
    }
}
