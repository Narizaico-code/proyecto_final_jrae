package org.jrae.carwashito.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.repository.AdministradorRepository;
import org.jrae.carwashito.persistence.AdministradorEntityRepository;
import org.jrae.carwashito.web.mapper.AdministradorViewMapper;
import org.jrae.carwashito.web.view.AdministradorView;
import org.primefaces.PrimeFaces;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
@ViewScoped
public class AdministradorControllerWeb implements Serializable {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private AdministradorViewMapper administradorViewMapper;

    private static final Logger logger = LoggerFactory.getLogger(AdministradorControllerWeb.class);

    private List<AdministradorView> administradores;
    private AdministradorView administradorSeleccionado;
    private final String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.administradores = administradorViewMapper.fromDto(administradorRepository.obtenerTodo());
        this.administradores.forEach(adm -> logger.info(adm.toString() + sl));
    }

    public void agregarAdministrador() {
        this.administradorSeleccionado = new AdministradorView();
    }

    public void guardarAdministrador() {
        if (this.administradorSeleccionado == null) return;

        var dto = administradorViewMapper.toDto(this.administradorSeleccionado);

        logger.info("Administrador a guardar: " + dto + sl);

        if (dto.codigoAdministrador() == null) {
            AdministradorDto guardado = administradorRepository.guardarAdministradores(dto);
            this.administradorSeleccionado.setCodigoAdministrador(guardado.codigoAdministrador());
           // administradorRepository.guardarAdministradores(dto);
            this.administradores.add(this.administradorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador agregado"));
        } else {
            administradorRepository.guardarAdministradores(dto);
            this.cargarDatos();
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
        if (this.administradorSeleccionado == null) return;

        var dto = administradorViewMapper.toDto(this.administradorSeleccionado);

        logger.info("Administrador a eliminar: " + dto + sl);

        administradorRepository.eliminarAdministradores(dto.codigoAdministrador());
        this.administradores.remove(this.administradorSeleccionado);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador eliminado"));

        PrimeFaces.current().ajax().update(
                "formulario-administradores:mensaje_emergente",
                "formulario-administradores:tabla-administrador"
        );

        this.administradorSeleccionado = null;
    }
}