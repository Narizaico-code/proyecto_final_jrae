package org.jrae.carwashito.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.exception.ClienteYaExisteException;
import org.jrae.carwashito.dominio.repository.ClienteRepository;
import org.jrae.carwashito.web.view.ClienteView;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class RegistrarseControllerWeb {

    @Autowired
    private ClienteRepository clienteRepository;

    private List<ClienteDto> clientes;
    private ClienteView clienteView;
    private static final Logger logger = LoggerFactory.getLogger(RegistrarseControllerWeb.class);

    private String mensajeExito;
    private String mensajeError;
    private String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        clienteView = new ClienteView();
        cargarDatos();
    }

    public void cargarDatos() {
        try {
            this.clientes = clienteRepository.obtenerTodo();
            logger.info("Clientes cargados: {}", clientes.size());
        } catch (Exception e) {
            logger.error("Error al cargar datos: {}", e.getMessage());
            mostrarError("Error al cargar los datos");
        }
    }

    public void prepararNuevoCliente() {
        this.clienteView = new ClienteView();
    }

    public void guardarUsuario() {
        logger.info("Intentando guardar usuario: {}", this.clienteView);

        try {
            if (!validarDatosCliente()) {
                return;
            }

            if (existeEmail(clienteView.getEmail())) {
                mostrarError("El correo " + clienteView.getEmail() + " ya está en uso");
                return;
            }

            if (existeNickname(clienteView.getNickname())) {
                mostrarError("El nickname " + clienteView.getNickname() + " ya está en uso");
                return;
            }

            ClienteDto clienteDto = convertirViewADto();

            ClienteDto clienteGuardado = clienteRepository.guardarClientes(clienteDto);

            if (clienteGuardado != null) {
                mostrarExito("Usuario registrado exitosamente");
                prepararNuevoCliente();
                cargarDatos();
            } else {
                mostrarError("Error al guardar el usuario");
            }

        } catch (ClienteYaExisteException e) {
            logger.error("Cliente ya existe: {}", e.getMessage());
            mostrarError("El cliente ya existe en el sistema");
        } catch (Exception e) {
            logger.error("Error al guardar usuario: {}", e.getMessage());
            mostrarError("Error interno del sistema al guardar el usuario");
        }
    }

    private ClienteDto convertirViewADto() {
        return new ClienteDto(
                0L,
                clienteView.getName(),
                clienteView.getLastName(),
                clienteView.getNickname(),
                clienteView.getPassword(),
                clienteView.getEmail(),
                clienteView.getPhoneNumber(),
                clienteView.getAddress()
        );
    }

    private boolean existeEmail(String email) {
        if (clientes == null) return false;
        return clientes.stream()
                .anyMatch(cliente -> cliente.email().equalsIgnoreCase(email.trim()));
    }

    private boolean existeNickname(String nickname) {
        if (clientes == null) return false;
        return clientes.stream()
                .anyMatch(cliente -> cliente.nickname().equalsIgnoreCase(nickname.trim()));
    }

    private boolean validarDatosCliente() {
        if (clienteView == null) {
            mostrarError("Por favor complete todos los campos");
            return false;
        }
        if (clienteView.getName() == null || clienteView.getName().trim().isEmpty()) {
            mostrarError("El nombre es obligatorio");
            return false;
        }
        if (clienteView.getLastName() == null || clienteView.getLastName().trim().isEmpty()) {
            mostrarError("El apellido es obligatorio");
            return false;
        }
        if (clienteView.getNickname() == null || clienteView.getNickname().trim().isEmpty()) {
            mostrarError("El apodo (nickname) es obligatorio");
            return false;
        }
        if (clienteView.getEmail() == null || clienteView.getEmail().trim().isEmpty()) {
            mostrarError("El correo electrónico es obligatorio");
            return false;
        }
        if (clienteView.getPassword() == null || clienteView.getPassword().trim().isEmpty()) {
            mostrarError("La contraseña es obligatoria");
            return false;
        }
        if (clienteView.getPhoneNumber() == null || clienteView.getPhoneNumber().trim().isEmpty()) {
            mostrarError("El teléfono es obligatorio");
            return false;
        }
        if (clienteView.getAddress() == null || clienteView.getAddress().trim().isEmpty()) {
            mostrarError("La dirección es obligatoria");
            return false;
        }

        if (!clienteView.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            mostrarError("El formato del correo electrónico no es válido");
            return false;
        }

        if (!clienteView.getPhoneNumber().matches("\\d{8}")) {
            mostrarError("El teléfono debe tener 8 dígitos");
            return false;
        }
        return true;
    }

    private void mostrarExito(String mensaje) {
        mensajeExito = mensaje;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", mensaje));
        PrimeFaces.current().executeScript("PF('modalExito').show()");
    }

    private void mostrarError(String mensaje) {
        mensajeError = mensaje;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensaje));
        PrimeFaces.current().executeScript("PF('modalError').show()");
    }
}