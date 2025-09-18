package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Servicios")
@Data
public class ServiciosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(length = 150, unique = true, nullable = false)
    private String descripcion;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;
}
