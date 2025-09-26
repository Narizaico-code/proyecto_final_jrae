package org.jrae.carwashito.web.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProveedoresView {
    Long codigoProveedor;
    String name;
    String number;
    String email;
    String address;
}
