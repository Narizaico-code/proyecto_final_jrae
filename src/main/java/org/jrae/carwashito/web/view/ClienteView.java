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
    private String name;
    private String lastName;
    private String nickname;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
}