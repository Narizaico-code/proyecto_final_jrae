package org.jrae.carwashito.dominio.service;


import org.jrae.carwashito.dominio.dto.InventarioDto;
import org.jrae.carwashito.dominio.dto.ModInventarioDto;
import org.jrae.carwashito.dominio.repository.InventarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioService {
    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<InventarioDto> obtenerTodo() {
        return this.inventarioRepository.obtenerTodo();
    }

    public InventarioDto obtenerInventarioPorCodigo(Long codigo) {
        return this.inventarioRepository.obtenerInventarioPorCodigo(codigo);
    }

    public InventarioDto guardarInventario(InventarioDto inventarioDto) {
        return this.inventarioRepository.guardarInventario(inventarioDto);
    }

    public InventarioDto modificarInventario(Long id, ModInventarioDto modInventarioDto) {
        return this.inventarioRepository.modificarInventario(id, modInventarioDto);
    }

    public void eliminarInventario(Long id) {
        this.inventarioRepository.eliminarInventario(id);
    }
}