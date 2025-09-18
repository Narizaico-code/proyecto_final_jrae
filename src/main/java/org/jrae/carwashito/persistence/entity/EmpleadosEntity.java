package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Empleados")
@Data
public class EmpleadosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(length = 150, unique = true, nullable = false)
    private String apellido;
    @Column(nullable = false)
    private Integer edad;
    @Column(nullable = false)
    private boolean disponibilidad;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal sueldo;
    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fechaContratacion;
    @Column(length = 100, unique = true, nullable = false)
    private String correo;
    @Column(length = 8, nullable = false)
    private String telefono;
    @Column(length = 100, nullable = false)
    private String cargo;
    // Relación con Administrador
    @ManyToOne
    @JoinColumn(name = "administrador_id", nullable = false)
    private AdministradoresEntity administradores;
}

