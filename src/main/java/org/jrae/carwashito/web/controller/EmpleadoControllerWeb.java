package org.jrae.carwashito.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.repository.EmpleadoRepository;
import org.jrae.carwashito.web.mapper.EmpleadoViewMapper;
import org.jrae.carwashito.web.view.EmpleadoView;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class EmpleadoControllerWeb {

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpleadoViewMapper empleadoViewMapper;
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControllerWeb.class);
    private List<EmpleadoView> empleados;
    private EmpleadoView empleadoSeleccionado;
    private final String sl = System.lineSeparator();
    @Autowired
    AdministradorControllerWeb administradorControllerWeb;
    private List<AdministradorDto> listaAdministradores;

    //String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.empleados = empleadoViewMapper.fromDto(empleadoRepository.obtenerTodo());
        this.empleados.forEach(emp -> logger.info(emp.toString() + sl));
    }

    public void agregarEmpleado() {
        this.empleadoSeleccionado = new EmpleadoView();
    }

    public void guardarEmpleado() {
        if (this.empleadoSeleccionado == null) return;

        var dto = empleadoViewMapper.toDto(this.empleadoSeleccionado);

        logger.info("Empleado a guardar: " + dto + sl);

        if (dto.codigo() == null) {
            empleadoRepository.guardarEmpleado(dto);
            this.empleados.add(this.empleadoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado agregado"));
        } else {
            empleadoRepository.guardarEmpleado(dto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalEmpleado').hide()");
        PrimeFaces.current().ajax().update(
                "formulario-empleados:mensaje_emergente",
                "formulario-empleados:tabla-empleados"
        );

        this.empleadoSeleccionado = null;
    }
}
