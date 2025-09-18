package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Servicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_servicio")
    private Long codigoServicio;
    @Column(length = 100, nullable = false, unique = true)
    private String nombre;
    @Column(length = 500, nullable = false)
    private String descripcion;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;
}