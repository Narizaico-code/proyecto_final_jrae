package org.jrae.carwashito.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.EmpleadoDto;
import org.jrae.carwashito.dominio.repository.EmpleadoRepository;
import org.jrae.carwashito.persistence.entity.AdministradorEntity;
import org.jrae.carwashito.web.mapper.EmpleadoViewMapper;
import org.jrae.carwashito.web.view.AdministradorView;
import org.jrae.carwashito.web.view.EmpleadoView;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Component
@Data
@ViewScoped
public class EmpleadoControllerWeb {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpleadoViewMapper empleadoViewMapper;
    @Autowired
    private AdministradorControllerWeb administradorControllerWeb;

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControllerWeb.class);

    private List<EmpleadoView> empleados;
    private EmpleadoView empleadoSeleccionado;
    private List<AdministradorView> listaAdministradores;

    private final String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
        cargarAdministradores();
    }

    public void cargarDatos() {
        this.empleados = empleadoViewMapper.fromDto(empleadoRepository.obtenerTodo());
        this.empleados.forEach(empleados -> logger.info(empleados.toString() + sl));
    }

   /* public void cargarAdministradores() {
        this.listaAdministradores = administradorControllerWeb.getAdministradores();
        .stream()
                .map(administrador -> {
                    AdministradorView administradorView = new AdministradorView();
                    administradorView.setCodigoAdministrador(administrador.getCodigoAdministrador());
                    administradorView.setName(administrador.getName());
                    administradorView.setLastName(administrador.getLastName());
                    return administradorView;
                })
                .toList();
    }*/

    public void cargarAdministradores() {
        this.listaAdministradores = administradorControllerWeb.getAdministradores()
                .stream()
                .map(administrador -> {
                    AdministradorView administradorView = new AdministradorView();
                    administradorView.setCodigoAdministrador(administrador.getCodigoAdministrador());
                    administradorView.setName(administrador.getName());
                    administradorView.setLastName(administrador.getLastName());
                    return administradorView;
                })
                .toList();
    }

    public void agregarEmpleado() {
        this.empleadoSeleccionado = new EmpleadoView();
        this.empleadoSeleccionado.setAdministrador(new AdministradorView());
    }

    public void guardarEmpleado() {
        if (this.empleadoSeleccionado == null) return;

        var dto = empleadoViewMapper.toDto(this.empleadoSeleccionado);
        logger.info("Empleado a guardar: " + dto + sl);

        if (dto.codigo() == null) {
            EmpleadoDto guardado = empleadoRepository.guardarEmpleado(dto);
            this.empleadoSeleccionado.setCodigo(guardado.codigo());
            this.empleados.add(this.empleadoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado agregado"));
        } else {
            empleadoRepository.guardarEmpleado(dto);
            this.cargarDatos();
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
        if (this.empleadoSeleccionado == null) return;

        var dto = empleadoViewMapper.toDto(this.empleadoSeleccionado);
        logger.info("Empleado a eliminar: " + dto + sl);

        empleadoRepository.eliminarEmpleado(dto.codigo());
        this.empleados.remove(this.empleadoSeleccionado);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado eliminado"));

        PrimeFaces.current().ajax().update(
                "formulario-empleados:mensaje_emergente",
                "formulario-empleados:tabla-empleados"
        );

        this.empleadoSeleccionado = null;
    }
}
