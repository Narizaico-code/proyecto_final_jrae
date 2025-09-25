package org.jrae.carwashito.web.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteView {
    Long codigoCliente;
    String name;
    String lastName;
    String nickname;
    String password;
    String email;
    String phoneNumber;
    String address;

}
