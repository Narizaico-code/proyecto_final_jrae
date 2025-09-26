package org.jrae.carwashito.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.ServicioDto;
import org.jrae.carwashito.dominio.exception.ServicioNoExisteException;
import org.jrae.carwashito.dominio.exception.ServicioYaExisteException;
import org.jrae.carwashito.dominio.repository.ServicioRepository;
import org.jrae.carwashito.web.view.ServicioView;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class ServicioControllerWeb {

    @Autowired
    private ServicioRepository servicioRepository;

    private List<ServicioDto> servicios;
    private ServicioView servicioView;
    private ServicioDto servicioSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(ServicioControllerWeb.class);

    private String mensajeExito;
    private String mensajeError;

    @PostConstruct
    public void init() {
        servicioView = new ServicioView();
        cargarDatos();
    }

    public void cargarDatos() {
        try {
            this.servicios = servicioRepository.obtenerTodo();
            logger.info("Servicios cargados: {}", servicios.size());
        } catch (Exception e) {
            logger.error("Error al cargar datos: {}", e.getMessage());
            mostrarError("Error al cargar los servicios");
        }
    }

    public void agregarServicio() {
        this.servicioView = new ServicioView();
        this.servicioSeleccionado = null;
    }

    public void prepararEdicion(ServicioDto servicio) {
        this.servicioSeleccionado = servicio;
        this.servicioView = convertirDtoAView(servicio);
    }

    public void guardarServicio() {
        logger.info("Intentando guardar servicio: {}", this.servicioView);

        try {
            if (!validarDatosServicio()) {
                return;
            }

            ServicioDto servicioDto;

            if (servicioSeleccionado == null) {
                servicioDto = convertirViewADto();

                if (existeNombreServicio(servicioView.getName())) {
                    mostrarError("Ya existe un servicio con el nombre: " + servicioView.getName());
                    return;
                }
            } else {
                servicioDto = new ServicioDto(
                        servicioSeleccionado.codigo(),
                        servicioView.getName(),
                        servicioView.getDescription(),
                        servicioView.getPrice()
                );
            }

            ServicioDto servicioGuardado;

            if (servicioSeleccionado == null) {
                servicioGuardado = servicioRepository.guardarServicio(servicioDto);
            } else {
                servicioGuardado = servicioRepository.actualizarServicio(servicioSeleccionado.codigo(), servicioDto);
            }

            if (servicioGuardado != null) {
                String mensaje = servicioSeleccionado == null ?
                        "Servicio registrado exitosamente" : "Servicio actualizado exitosamente";
                mostrarExito(mensaje);
                cargarDatos();
            } else {
                mostrarError("Error al guardar el servicio");
            }

        } catch (ServicioYaExisteException e) {
            logger.error("Servicio ya existe: {}", e.getMessage());
            mostrarError("El servicio ya existe en el sistema");
        } catch (Exception e) {
            logger.error("Error al guardar servicio: {}", e.getMessage());
            mostrarError("Error interno del sistema al guardar el servicio");
        }
    }

    public void eliminarServicio() {
        if (servicioSeleccionado == null) {
            mostrarError("No se ha seleccionado ningún servicio para eliminar");
            return;
        }

        try {
            servicioRepository.eliminarServicio(servicioSeleccionado.codigo());
            mostrarExito("Servicio eliminado exitosamente");
            cargarDatos();
        } catch (ServicioNoExisteException e) {
            logger.error("Servicio no existe: {}", e.getMessage());
            mostrarError("El servicio no existe en el sistema");
        } catch (Exception e) {
            logger.error("Error al eliminar servicio: {}", e.getMessage());
            mostrarError("Error interno del sistema al eliminar el servicio");
        }
    }

    private ServicioDto convertirViewADto() {
        return new ServicioDto(
                null,
                servicioView.getName(),
                servicioView.getDescription(),
                servicioView.getPrice()
        );
    }

    private ServicioView convertirDtoAView(ServicioDto dto) {
        ServicioView view = new ServicioView();
        view.setName(dto.name());
        view.setDescription(dto.description());
        view.setPrice(dto.price());
        return view;
    }

    private boolean existeNombreServicio(String nombre) {
        if (servicios == null) return false;
        return servicios.stream()
                .anyMatch(servicio -> servicio.name().equalsIgnoreCase(nombre.trim()));
    }

    private boolean validarDatosServicio() {
        if (servicioView == null) {
            mostrarError("Por favor complete todos los campos");
            return false;
        }
        if (servicioView.getName() == null || servicioView.getName().trim().isEmpty()) {
            mostrarError("El nombre del servicio es obligatorio");
            return false;
        }
        if (servicioView.getName().length() < 3 || servicioView.getName().length() > 100) {
            mostrarError("El nombre debe tener entre 3 y 100 caracteres");
            return false;
        }
        if (servicioView.getDescription() == null || servicioView.getDescription().trim().isEmpty()) {
            mostrarError("La descripción es obligatoria");
            return false;
        }
        if (servicioView.getDescription().length() < 10 || servicioView.getDescription().length() > 500) {
            mostrarError("La descripción debe tener entre 10 y 500 caracteres");
            return false;
        }
        if (servicioView.getPrice() == null) {
            mostrarError("El precio es obligatorio");
            return false;
        }
        if (servicioView.getPrice() <= 0) {
            mostrarError("El precio debe ser mayor a 0");
            return false;
        }
        return true;
    }

    private void mostrarExito(String mensaje) {
        mensajeExito = mensaje;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", mensaje));
    }

    private void mostrarError(String mensaje) {
        mensajeError = mensaje;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensaje));
    }
}