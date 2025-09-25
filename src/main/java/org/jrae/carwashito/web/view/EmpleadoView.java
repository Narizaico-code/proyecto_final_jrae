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
    Long codigo;
    String name;
    String lastName;
    Integer age;
    boolean availability;
    BigDecimal salary;
    LocalDate hireDate;
    String email;
    String phoneNumber;
    String position;

    AdministradorView administrador;
}
