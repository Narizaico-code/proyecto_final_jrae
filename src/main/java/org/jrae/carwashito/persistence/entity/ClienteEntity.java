package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Clientes")
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoCliente;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(length = 150, unique = true, nullable = false)
    private String apellido;
    @Column(length = 50, unique = true, nullable = false)
    private String apodo;
    @Column(length = 100, unique = true, nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contrasena;
    @Column(length = 8, nullable = false)
    private String telefono;
    @Column(length = 150, unique = true, nullable = false)
    private String direccion;

}
