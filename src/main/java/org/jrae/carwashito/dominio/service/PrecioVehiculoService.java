package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;
import org.jrae.carwashito.dominio.repository.PrecioVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecioVehiculoService {

    private final PrecioVehiculoRepository precioVehiculoRepository;

    public PrecioVehiculoService(PrecioVehiculoRepository precioVehiculoRepository) {
        this.precioVehiculoRepository = precioVehiculoRepository;
    }

    public List<PrecioVehiculoDto> obtenerTodos() {
        return this.precioVehiculoRepository.obtenerTodos();
    }

    public PrecioVehiculoDto obtenerPrecioVehiculoPorCodigo(Long codigoVehiculo) {
        return this.precioVehiculoRepository.obtenerPrecioVehiculoPorCodigo(codigoVehiculo);
    }

    public PrecioVehiculoDto guardarPrecioVehiculo(PrecioVehiculoDto precioVehiculoDto) {
        return this.precioVehiculoRepository.guardarPrecioVehiculo(precioVehiculoDto);
    }

    public PrecioVehiculoDto actualizarPrecioVehiculo(Long codigoVehiculo, PrecioVehiculoDto precioVehiculoDto) {
        return this.precioVehiculoRepository.actualizarPrecioVehiculo(codigoVehiculo, precioVehiculoDto);
    }

    public void eliminarPrecioVehiculo(Long codigoVehiculo) {
        this.precioVehiculoRepository.eliminarPrecioVehiculo(codigoVehiculo);
    }
}