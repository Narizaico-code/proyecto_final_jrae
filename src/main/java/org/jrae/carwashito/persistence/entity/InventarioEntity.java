package org.jrae.carwashito.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Inventarios")
@Data
public class InventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoInventario;
    @Column(nullable = false)
    private Double costo;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(name = "fecha_caducidad")
    private LocalDate fechaCaducidad;
    @Column(nullable = false)
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "codigo_administrador", nullable = false)
    private AdministradoresEntity administrador;

    @ManyToOne
    @JoinColumn(name = "codigo_proveedor", nullable = false)
    private ProveedorEntity proveedor;
}
