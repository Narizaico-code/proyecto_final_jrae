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

import java.util.List;

@Component
@Data
@ViewScoped
public class LoginControllerWeb {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    AdministradorRepository administradorRepository;
    private List<ClienteDto> clientes;
    private List<AdministradorDto> administradores;
    private ClienteDto clienteSeleccionado;
    private AdministradorDto administradorSeleccionado;
    String mensajeExito, mensajeError;
    private static final Logger logger = LoggerFactory.getLogger(LoginControllerWeb.class);
    String sl = System.lineSeparator();

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.clienteRepository.obtenerTodo().forEach(clienteDto -> logger.info(clienteDto.toString() + sl));
        this.clienteRepository.obtenerTodo().forEach(administradorDto -> logger.info(administradorDto.toString() + sl));
    }

    public void iniciarSesion(){
        this.clientes = this.clienteRepository.obtenerTodo();
        this.administradores = this.administradorRepository.obtenerTodo();
        ClienteDto clienteEncontrado = null;
        if (clienteSeleccionado.email() == null || clienteSeleccionado.password() == null || this.clienteSeleccionado.nickname() == null || clienteSeleccionado.email().trim().isEmpty() || clienteSeleccionado.password().trim().isEmpty() || this.clienteSeleccionado.nickname().trim().isEmpty()){
            mostrarError("Porfavor complete todos los campos");
            return;}
        for (ClienteDto clienteDto : this.clientes){
            if (clienteDto.email().equals(this.clienteSeleccionado.email().trim()) || clienteDto.nickname().equals(this.clienteSeleccionado.nickname().trim())){
                if(clienteDto.password().equals(this.clienteSeleccionado.password())){
                    clienteEncontrado = clienteDto;
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                            .getExternalContext().getSession(true);
                    session.setAttribute("clienteLogueado", clienteEncontrado);
                    session.setAttribute("usuarioAutenticado", true);
                    logger.info("Login exitoso para: " + clienteEncontrado.email());
                    mostrarExito("¡Bienvenido " + clienteEncontrado.name() + "!");
                    PrimeFaces.current().executeScript(
                            "setTimeout(function(){ window.location.href = 'menuPrincipal.xhtml'; }, 2000);"
                    );
                    break;
                }
                else
                {
                 logger.warn("Contraseña incorrecta");
                 mostrarError("Correo o contraseña incorrectos");
                }
                clienteEncontrado = clienteDto;
                break;
            }
        }

        if (clienteEncontrado == null){
            logger.warn("Correo no encontrado: " + this.clienteSeleccionado.email());
            mostrarError("Correo o contraseña incorrectos");
        }
    }
    private void mostrarExito(String mensaje) {
        mensajeExito = mensaje;
        PrimeFaces.current().executeScript("PF('modalExito').show()");
    }

    private void mostrarError(String mensaje) {
        mensajeError = mensaje;
        PrimeFaces.current().executeScript("PF('modalError').show()");
    }
}