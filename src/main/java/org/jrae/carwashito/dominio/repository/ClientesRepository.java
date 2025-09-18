package org.jrae.carwashito.dominio.repository;

import org.jrae.carwashito.dominio.dto.ClientesDto;
import org.jrae.carwashito.dominio.dto.ModClientesDto;


import java.util.List;

public interface ClientesRepository {
    List<ClientesDto> obtenerTodo();
    ClientesDto obtenerClientesPorCodigo(Long codigo);
    ClientesDto guardarClientes(ClientesDto clientesDto);
    ClientesDto modificarClientes(Long codigo, ModClientesDto modClientesDto);
    void eliminarClientes(Long codigo);
}
