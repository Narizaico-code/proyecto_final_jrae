package org.jrae.carwashito.persistence;

import org.jrae.carwashito.dominio.dto.ReservaDto;
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
        return this.reservaMapper.toDto((ReservaEntity) this.crudReservaEntity.findById(codigo).orElse(null));
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
        this.reservaMapper.updateEntityFromDto(modReservaDto,
                (ReservaEntity) this.crudReservaEntity.findById(codigo).orElse(null));
        return this.reservaMapper.toDto((ReservaEntity) this.crudReservaEntity.save(this.crudReservaEntity.findById(codigo).orElse(null))) ;
    }

    @Override
    public void eliminarReserva(Long codigo) {
        if (this.crudReservaEntity.findById(codigo).orElse(null) != null) this.crudReservaEntity.deleteById(codigo);
    }
}
