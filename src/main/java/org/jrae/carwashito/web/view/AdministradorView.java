package org.jrae.carwashito.web.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AdministradorView {
    Long codigoAdministrador;
    String name;
    String lastName;
    String password;
    String email;
    String phoneNumber;
}
