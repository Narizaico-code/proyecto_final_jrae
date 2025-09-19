package org.jrae.carwashito.web.mapper;

import org.mapstruct.Named;
import org.jrae.carwashito.dominio.MetodoPago;

public class MetodoPagoMapper {
    @Named("generarMetodoPago")
    public static MetodoPago generarMetodoPago(String metodoPago){
        if (metodoPago == null) return null;
        return switch (metodoPago.toUpperCase()){
            case "EFECTIVO" -> MetodoPago.CASH;
            case "TARJETA" -> MetodoPago.CARD;
            case "TRANSFERENCIA" -> MetodoPago.TRANSFER;
            default -> null;
        };
    }

    @Named("generarPayMethod")
    public static String generarPayMethod(MetodoPago metodoPago){
        if (metodoPago == null) return null;
        return switch (metodoPago){
            case CARD -> "TARJETA";
            case CASH -> "EFECTIVO";
            case TRANSFER -> "TRANSFERENCIA";
            default -> null;
        };
    }
}
