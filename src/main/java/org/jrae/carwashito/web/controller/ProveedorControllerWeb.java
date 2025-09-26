package org.jrae.carwashito.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.ModProveedorDto;
import org.jrae.carwashito.dominio.dto.ProveedorDto;
import org.jrae.carwashito.dominio.repository.ProveedorRepository;
import org.jrae.carwashito.web.mapper.ProveedorViewMapper;
import org.jrae.carwashito.web.view.ProveedoresView;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
@ViewScoped
public class ProveedorControllerWeb implements Serializable {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorViewMapper proveedorViewMapper;

    private static final Logger logger = LoggerFactory.getLogger(ProveedorControllerWeb.class);

    private List<ProveedoresView> proveedores;
    private ProveedoresView proveedorSeleccionado;
    private final String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.proveedores = proveedorViewMapper.fromDto(proveedorRepository.obtenerTodo());
        this.proveedores.forEach(prov -> logger.info(prov.toString() + sl));
    }

    public void agregarProveedor() {
        this.proveedorSeleccionado = new ProveedoresView();
    }

    public void guardarProveedor() {
        if (this.proveedorSeleccionado == null) return;

        var dto = proveedorViewMapper.toDto(this.proveedorSeleccionado);

        logger.info("Proveedor a guardar: " + dto + sl);

        if (dto.codigoProveedor() == null) { // Nuevo proveedor
            ProveedorDto guardado = proveedorRepository.guardarProveedor(dto);
            this.proveedorSeleccionado.setCodigoProveedor(guardado.codigoProveedor());
            this.proveedores.add(this.proveedorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proveedor agregado"));
        } else { // Actualizar proveedor existente
            proveedorRepository.guardarProveedor(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proveedor actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalProveedor').hide()");
        PrimeFaces.current().ajax().update(
                "formulario-proveedores:mensaje_emergente",
                "formulario-proveedores:tabla-proveedores"
        );

        this.proveedorSeleccionado = null;
    }

    public void eliminarProveedor() {
        if (this.proveedorSeleccionado == null) return;

        var dto = proveedorViewMapper.toDto(this.proveedorSeleccionado);

        logger.info("Proveedor a eliminar: " + dto + sl);

        proveedorRepository.eliminarProveedor(dto.codigoProveedor());
        this.proveedores.remove(this.proveedorSeleccionado);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proveedor eliminado"));

        PrimeFaces.current().ajax().update(
                "formulario-proveedores:mensaje_emergente",
                "formulario-proveedores:tabla-proveedores"
        );

        this.proveedorSeleccionado = null;
    }
}