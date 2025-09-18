package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.dto.ModClienteDto;


import java.util.List;

public interface ClienteRepository {
    List<ClienteDto> obtenerTodo();
    ClienteDto obtenerClientesPorCodigo(Long codigoCliente);
    ClienteDto guardarClientes(ClienteDto clientesDto);
    ClienteDto modificarClientes(Long codigoCliente, ModClienteDto modClientesDto);
    void eliminarClientes(Long codigoCliente);
}
