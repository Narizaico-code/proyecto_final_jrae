package org.jrae.carwashito.web.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jrae.carwashito.dominio.dto.AdministradorDto;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmpleadoView {
    private Long codigo;
    private String name;
    private String lastName;
    private Integer age;
    private boolean availability;
    private BigDecimal salary;
    private LocalDate hireDate;
    private String email;
    private String phoneNumber;
    private String position;
    private AdministradorDto administrador;
}
