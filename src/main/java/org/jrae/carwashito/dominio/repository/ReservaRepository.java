package org.jrae.carwashito.dominio.repository;


import org.jrae.carwashito.dominio.dto.ReservaDto;

import java.util.List;

public interface ReservaRepository {
    List<ReservaDto> obtenerTodo();
    ReservaDto obtenerReservaPorCodigo(Long codigo);
    ReservaDto guardarReserva(ReservaDto reservaDto);
    ReservaDto modificarReserva(Long codigo, ReservaDto modReservaDto);
    void eliminarReserva(Long codigo);
}
