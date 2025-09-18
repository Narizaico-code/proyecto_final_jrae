package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Proveedores")
@Data
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProveedor;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(length = 16, nullable = false)
    private String numero;
    @Column(length = 256, unique = true, nullable = false)
    private String correo;
    @Column(length = 150, nullable = false)
    private String direccion;
}
