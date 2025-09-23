package org.jrae.carwashito.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Administradores")
@Data
public class AdministradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoAdministrador;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(length = 150, unique = true, nullable = false)
    private String apellido;
    @Column(length = 100, unique = true, nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contrasena;
    @Column(length = 8, nullable = false)
    private String telefono;

    // Constructor vacío necesario para JPA
    public AdministradorEntity() {}

    // Constructor que recibe solo el ID
    public AdministradorEntity(Long codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }
}
