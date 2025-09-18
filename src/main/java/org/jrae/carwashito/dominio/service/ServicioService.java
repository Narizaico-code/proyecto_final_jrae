package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.ServicioDto;
import org.jrae.carwashito.dominio.repository.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepositorio) {
        this.servicioRepository = servicioRepositorio;
    }

    public List<ServicioDto> obtenerTodos() {
        return this.servicioRepository.obtenerTodo();
    }

    public ServicioDto obtenerServicioPorCodigo(Long codigoServicio) {
        return this.servicioRepository.obtenerServicioPorCodigo(codigoServicio);
    }

    public ServicioDto guardarServicio(ServicioDto servicioDto) {
        return this.servicioRepository.guardarServicio(servicioDto);
    }

    public ServicioDto actualizarServicio(Long codigoServicio, ServicioDto servicioDto) {
        return this.servicioRepository.actualizarServicio(codigoServicio, servicioDto);
    }

    public void eliminarServicio(Long codigoServicio) {
        this.servicioRepository.eliminarServicio(codigoServicio);
    }
}