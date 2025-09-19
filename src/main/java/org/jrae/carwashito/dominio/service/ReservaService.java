package org.jrae.carwashito.dominio.service;

import org.jrae.carwashito.dominio.dto.ReservaDto;
import org.jrae.carwashito.dominio.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaDto> obtenerTodo(){
        return this.reservaRepository.obtenerTodo();
    }

    public ReservaDto obtenerReservaPorCodigo(Long codigo){
        return this.reservaRepository.obtenerReservaPorCodigo(codigo);
    }

    public ReservaDto guardarReserva(ReservaDto reservaDto){
        return this.reservaRepository.guardarReserva(reservaDto);
    }

    public ReservaDto modificarReserva(Long codigo, ReservaDto reservaDto){
        return this.reservaRepository.modificarReserva(codigo, reservaDto);
    }

    public void eliminarReserva(Long codigo){
        this.reservaRepository.eliminarReserva(codigo);
    }
}
