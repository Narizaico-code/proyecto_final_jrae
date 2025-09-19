package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "PrecioVehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecioVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_vehiculo")
    private Long codigoVehiculo;
    @Column(name = "tipo_vehiculo", length = 50, nullable = false, unique = true)
    private String tipoVehiculo;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;
}
