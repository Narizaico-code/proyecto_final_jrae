package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.ModProveedorDto;
import org.jrae.carwashito.dominio.dto.ProveedorDto;
import org.jrae.carwashito.dominio.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<ProveedorDto> obtenerTodo() {
        return this.proveedorRepository.obtenerTodo();
    }

    // 2 Continua con el servicio
    public ProveedorDto obtenerProveedorPorCodigo(Long codigo){
        return this.proveedorRepository.obtenerProveedorPorCodigo(codigo);
    }

    public ProveedorDto guardarProveedor(ProveedorDto proveedorDto){
        return this.proveedorRepository.guardarProveedor(proveedorDto);
    }

    public ProveedorDto modificarProveedor(Long codigo, ModProveedorDto modProveedorDto){
        return this.proveedorRepository.modificarProveedor(codigo, modProveedorDto);
    }

    public void eliminarProveedor(Long codigo){
        this.proveedorRepository.eliminarProveedor(codigo);
    }
}
