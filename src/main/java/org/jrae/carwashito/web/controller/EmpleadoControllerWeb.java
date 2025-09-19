package org.jrae.carwashito.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.repository.EmpleadoRepository;
import org.primefaces.PrimeFaces;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class EmpleadoControllerWeb {

    @Autowired
    EmpleadoRepository empleadoRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControllerWeb.class);
    List<EmpleadoDto> empleados;
    EmpleadoDto empleadoSeleccionado;
    String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.empleadoRepository.obtenerTodo().forEach(empleadoDto -> logger.info(empleadoDto.toString() + sl));
    }

    public void agregarEmpleado() {
        this.empleadoSeleccionado = new EmpleadoDto(this.empleadoSeleccionado.codigo(), this.empleadoSeleccionado.name(), this.empleadoSeleccionado.lastName(), this.empleadoSeleccionado.age(), this.empleadoSeleccionado.availability(), this.empleadoSeleccionado.salary(), this.empleadoSeleccionado.hireDate(), this.empleadoSeleccionado.email(), this.empleadoSeleccionado.phoneNumber(), this.empleadoSeleccionado.position(), this.empleadoSeleccionado.codigoAdministrador());
    }

    public void guardarEmpleado() {
        logger.info("Empleado a guardar: " + this.empleadoSeleccionado + sl);

        if (this.empleadoSeleccionado.codigo() == null) {
            this.empleadoRepository.guardarEmpleado(this.empleadoSeleccionado);
            this.empleados.add(this.empleadoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado agregado"));
        } else {
            this.empleadoRepository.guardarEmpleado(this.empleadoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalEmpleado').hide()");
        PrimeFaces.current().ajax().update(
                "formulario-empleados:mensaje_emergente",
                "formulario-empleados:tabla-empleados"
        );
        this.empleadoSeleccionado = null;
    }

    public void eliminarEmpleado() {
        logger.info("Empleado a eliminar: " + this.empleadoSeleccionado + sl);
        this.empleadoRepository.eliminarEmpleado(empleadoSeleccionado.codigo());
        this.empleados.remove(empleadoSeleccionado);
        this.empleadoSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado eliminado"));
        PrimeFaces.current().ajax().update(
                "formulario-empleados:mensaje_emergente",
                "formulario-empleados:tabla-empleados"
        );
    }
}