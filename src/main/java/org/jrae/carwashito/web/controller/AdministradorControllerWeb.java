package org.jrae.carwashito.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.repository.AdministradorRepository;
import org.jrae.carwashito.persistence.AdministradorEntityRepository;
import org.primefaces.PrimeFaces;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class AdministradorControllerWeb {

    @Autowired
    AdministradorRepository administradorRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdministradorControllerWeb.class);
    List<AdministradorDto> administradores;
    AdministradorDto administradorSeleccionado;
    String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.administradorRepository.obtenerTodo().forEach(administradorDto -> logger.info(administradorDto.toString() + sl));
    }

    public void agregarAdministrador() {
        this.administradorSeleccionado = new AdministradorDto(this.administradorSeleccionado.codigoAdministrador(), this.administradorSeleccionado.name(), this.administradorSeleccionado.lastName(), this.administradorSeleccionado.password(),this.administradorSeleccionado.email(), this.administradorSeleccionado.phoneNumber());
    }

    public void guardarAdministrador() {
        logger.info("Administrador a guardar: " + this.administradorSeleccionado + sl);

        if (this.administradorSeleccionado.codigoAdministrador() == null) {
            this.administradorRepository.guardarAdministradores(this.administradorSeleccionado);
            this.administradores.add(this.administradorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador agregado"));
        } else {
            this.administradorRepository.guardarAdministradores(this.administradorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalAdministrador').hide()");
        PrimeFaces.current().ajax().update(
                "formulario-administradores:mensaje_emergente",
                "formulario-administradores:tabla-administradores"
        );
        this.administradorSeleccionado = null;
    }

    public void eliminarAdministrador() {
        logger.info("Administrador a eliminar: " + this.administradorSeleccionado + sl);
        this.administradorRepository.eliminarAdministradores(administradorSeleccionado.codigoAdministrador());
        this.administradores.remove(administradorSeleccionado);
        this.administradorSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador eliminado"));
        PrimeFaces.current().ajax().update(
                "formulario-administradores:mensaje_emergente",
                "formulario-administradores:tabla-administradores"
        );
    }
}