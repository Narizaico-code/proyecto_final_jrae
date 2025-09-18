package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Reservas")
@Data
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoReserva;
    @ManyToOne
    @JoinColumn(name = "codigo_empleado", nullable = false)
    private EmpleadosEntity empleados;
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private ClientesEntity clientes;
    @ManyToOne
    @JoinColumn(name = "codigo_vehiculo", nullable = false)
    private PrecioVehiculo precioVehiculo;
    @Column(name = "metodo_pago", nullable = false, length = 15)
    private String metodoPago;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private Integer hora;
    @Column(nullable = false, length = 255)
    private String descripcion;
}
