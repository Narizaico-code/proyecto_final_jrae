package org.jrae.carwashito.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.PrecioVehiculoDto;
import org.jrae.carwashito.dominio.repository.PrecioVehiculoRepository;
import org.jrae.carwashito.persistence.PrecioVehiculoEntityRepository;
import org.jrae.carwashito.persistence.entity.PrecioVehiculo;
import org.jrae.carwashito.web.mapper.PrecioVehiculoMapper;
import org.primefaces.PrimeFaces;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class PrecioVehiculoControllerWeb {

    @Autowired
    PrecioVehiculoRepository precioVehiculoRepository;
    private static final Logger logger = LoggerFactory.getLogger(PrecioVehiculoControllerWeb.class);
    List<PrecioVehiculoDto> precioVehiculos;
    PrecioVehiculoDto precioVehiculoSeleccionado;
    String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.precioVehiculoRepository.obtenerTodos().forEach(precioVehiculoDto -> logger.info(precioVehiculoDto.toString() + sl));
    }

    public void agregarPrecioVehiculo() {
        this.precioVehiculoSeleccionado = new PrecioVehiculoDto(this.precioVehiculoSeleccionado.codigo(), this.precioVehiculoSeleccionado.typeVehicle(), this.precioVehiculoSeleccionado.value());
    }

    public void guardarPrecioVehiculo() {
        logger.info("Precio de vehiculo a guardar: " + this.precioVehiculoSeleccionado + sl);

        if (this.precioVehiculoSeleccionado.codigo() == null) {
            this.precioVehiculoRepository.guardarPrecioVehiculo(this.precioVehiculoSeleccionado);
            this.precioVehiculos.add(this.precioVehiculoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Precio de vehiculo agregado"));
        } else {
            this.precioVehiculoRepository.guardarPrecioVehiculo(this.precioVehiculoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Precio de vehiculo actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalPrecioVehiculo').hide()");
        PrimeFaces.current().ajax().update(
                "formulario-precioVehiculos:mensaje_emergente",
                "formulario-precioVehiculos:tabla-precioVehiculos"
        );
        this.precioVehiculoSeleccionado = null;
    }

    public void eliminarPrecioVehiculo() {
        logger.info("Precio a eliminar: " + this.precioVehiculoSeleccionado + sl);
        this.precioVehiculoRepository.eliminarPrecioVehiculo(precioVehiculoSeleccionado.codigo());
        this.precioVehiculos.remove(precioVehiculoSeleccionado);
        this.precioVehiculoSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Precio eliminado"));
        PrimeFaces.current().ajax().update(
                "formulario-precioVehiculos:mensaje_emergente",
                "formulario-precioVehiculos:tabla-precioVehiculos"
        );
    }
}