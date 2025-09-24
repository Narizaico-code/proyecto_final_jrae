package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ReservaDto;
import org.jrae.carwashito.dominio.exception.ReservaNoExisteException;
import org.jrae.carwashito.dominio.repository.ReservaRepository;
import org.jrae.carwashito.persistence.crud.CrudReservaEntity;
import org.jrae.carwashito.persistence.entity.ReservaEntity;
import org.jrae.carwashito.web.mapper.MetodoPagoMapper;
import org.jrae.carwashito.web.mapper.ReservaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaEntityRepository implements ReservaRepository {

    private CrudReservaEntity crudReservaEntity;
    private ReservaMapper reservaMapper;

    public ReservaEntityRepository(CrudReservaEntity crudReservaEntity, ReservaMapper reservaMapper){
        this.reservaMapper = reservaMapper;
        this.crudReservaEntity = crudReservaEntity;
    }
    @Override
    public List<ReservaDto> obtenerTodo() {
        return this.reservaMapper.toDto(this.crudReservaEntity.findAll());
    }

    @Override
    public ReservaDto obtenerReservaPorCodigo(Long codigo) {
        ReservaEntity reservaEntity = this.crudReservaEntity.findById(codigo).orElse(null);
        if (reservaEntity == null) {
            throw new ReservaNoExisteException(codigo);
        }else{
            return this.reservaMapper.toDto(reservaEntity);
        }
    }

    @Override
    public ReservaDto guardarReserva(ReservaDto reservaDto) {
        ReservaEntity reserva = this.reservaMapper.toEntity(reservaDto);
        reserva.setMetodoPago(!MetodoPagoMapper.generarPayMethod(reservaDto.payMethod()).isEmpty() ? MetodoPagoMapper.generarPayMethod(reservaDto.payMethod()) : reserva.getMetodoPago());
        this.crudReservaEntity.save(reserva);
        return this.reservaMapper.toDto(reserva);
    }

    @Override
    public ReservaDto modificarReserva(Long codigo, ReservaDto modReservaDto) {
        ReservaEntity reservaEntity = this.crudReservaEntity.findById(codigo).orElse(null);
        if (reservaEntity == null) {
            throw new ReservaNoExisteException(codigo);
        }else{
            this.reservaMapper.updateEntityFromDto(modReservaDto,
                    this.crudReservaEntity.findById(codigo).orElse(null));
            return this.reservaMapper.toDto(this.crudReservaEntity.save(reservaEntity));
        }

    }

    @Override
    public void eliminarReserva(Long codigo) {
        if (this.crudReservaEntity.findById(codigo).orElse(null) == null){
            throw new ReservaNoExisteException(codigo);
        }else{
            this.crudReservaEntity.deleteById(codigo);
        }
    }
}
