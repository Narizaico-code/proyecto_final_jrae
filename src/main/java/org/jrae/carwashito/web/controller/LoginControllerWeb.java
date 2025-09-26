package org.jrae.carwashito.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.AdministradorDto;
import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.repository.AdministradorRepository;
import org.jrae.carwashito.dominio.repository.ClienteRepository;
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
public class LoginControllerWeb implements Serializable {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    // Campos del formulario
    private String correoONickname;
    private String password;

    // Mensajes para los modales
    private String mensajeExito;
    private String mensajeError;

    private static final Logger logger = LoggerFactory.getLogger(LoginControllerWeb.class);
    private String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        // Cargar datos iniciales si es necesario
        List<ClienteDto> clientes = this.clienteRepository.obtenerTodo();
        List<AdministradorDto> administradores = this.administradorRepository.obtenerTodo();

        clientes.forEach(clienteDto -> logger.info("Cliente: " + clienteDto.toString() + sl));
        administradores.forEach(administradorDto -> logger.info("Admin: " + administradorDto.toString() + sl));
    }

    public void iniciarSesion() {
        if (correoONickname == null || password == null ||
                correoONickname.trim().isEmpty() || password.trim().isEmpty()) {
            mostrarError("Por favor complete todos los campos");
            return;
        }

        // Primero validamos si es cliente
        List<ClienteDto> clientes = this.clienteRepository.obtenerTodo();
        for (ClienteDto clienteDto : clientes) {
            if (clienteDto.email().equals(correoONickname.trim()) ||
                    clienteDto.nickname().equals(correoONickname.trim())) {

                if (clienteDto.password().equals(password)) {
                    iniciarSesionCliente(clienteDto);
                    return;
                } else {
                    logger.warn("Contraseña incorrecta para cliente: " + correoONickname);
                    mostrarError("Correo/nickname o contraseña incorrectos");
                    return;
                }
            }
        }

        // Si no fue cliente, intentamos con administrador
        List<AdministradorDto> administradores = this.administradorRepository.obtenerTodo();
        for (AdministradorDto adminDto : administradores) {
            if (adminDto.email().equals(correoONickname.trim())) {
                if (adminDto.password().equals(password)) {
                    iniciarSesionAdministrador(adminDto);
                    return;
                } else {
                    logger.warn("Contraseña incorrecta para administrador: " + correoONickname);
                    mostrarError("Correo o contraseña incorrectos");
                    return;
                }
            }
        }

        logger.warn("Usuario no encontrado: " + correoONickname);
        mostrarError("Correo/nickname o contraseña incorrectos");
    }

    private void iniciarSesionCliente(ClienteDto clienteEncontrado) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.setAttribute("clienteLogueado", clienteEncontrado);
        session.setAttribute("usuarioAutenticado", true);
        session.setAttribute("tipoUsuario", "cliente");

        logger.info("Login exitoso (Cliente) para: " + clienteEncontrado.email());
        mostrarExito("¡Bienvenido " + clienteEncontrado.name() + "!");

        PrimeFaces.current().executeScript(
                "setTimeout(function(){ window.location.href = 'menu.xhtml'; }, 2000);"
        );
    }

    private void iniciarSesionAdministrador(AdministradorDto adminEncontrado) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.setAttribute("adminLogueado", adminEncontrado);
        session.setAttribute("usuarioAutenticado", true);
        session.setAttribute("tipoUsuario", "administrador");

        logger.info("Login exitoso (Admin) para: " + adminEncontrado.email());
        mostrarExito("¡Bienvenido Administrador " + adminEncontrado.name() + "!");

        PrimeFaces.current().executeScript(
                "setTimeout(function(){ window.location.href = 'menu.xhtml'; }, 2000);"
        );
    }

    private void mostrarExito(String mensaje) {
        this.mensajeExito = mensaje;
        PrimeFaces.current().executeScript("PF('modalExito').show()");
    }

    private void mostrarError(String mensaje) {
        this.mensajeError = mensaje;
        PrimeFaces.current().executeScript("PF('modalError').show()");
    }

    public void limpiarFormulario() {
        this.correoONickname = "";
        this.password = "";
        this.mensajeError = null;
        this.mensajeExito = null;
    }
}