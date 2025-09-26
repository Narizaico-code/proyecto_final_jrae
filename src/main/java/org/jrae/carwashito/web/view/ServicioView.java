package org.jrae.carwashito.web.view;

import lombok.Data;

@Data
public class ServicioView {
    private String name;
    private String description;
    private Double price;

    public ServicioView() {}
}