package org.jrae.carwashito.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.ClienteDto;
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
public class RegistrarseControllerWeb {

    @Autowired
    ClienteRepository clienteRepository;

    private List<ClienteDto> clientes;
    private ClienteDto clienteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(RegistrarseControllerWeb.class);
    String mensajeExito, mensajeError;
    String sl = System.lineSeparator();

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.clienteRepository.obtenerTodo().forEach(clienteDto -> logger.info(clienteDto.toString() + sl));
    }

    public void agregarEmpleado(){
        this.clienteSeleccionado = new ClienteDto(this.clienteSeleccionado.codigoCliente(), this.clienteSeleccionado.name(), this.clienteSeleccionado.lastName(), this.clienteSeleccionado.nickname(), this.clienteSeleccionado.password(), this.clienteSeleccionado.email(), this.clienteSeleccionado.phoneNumber(), this.clienteSeleccionado.address());
    }

    public void guardarUsuario(){
        logger.info("Usuario a guardar: " + this.clienteSeleccionado + sl);
        this.clientes = this.clienteRepository.obtenerTodo();
        ClienteDto clienteEncontrado = null;
        if (this.clienteSeleccionado == null){
            mostrarError("Porfavor complete todos los campos");
            return;}
        for (ClienteDto clienteDto : this.clientes){
            if (clienteDto.email().equals(this.clienteSeleccionado.email().trim()) || clienteDto.nickname().equals(this.clienteSeleccionado.nickname().trim())) {
                clienteEncontrado = clienteDto;
                logger.info("El correo y el nickname esta en uso");
                mostrarError("El correo " + clienteEncontrado.email() + " y/o el nickname " + clienteEncontrado.nickname() + " ya esta en uso");
            }else{
                this.clienteRepository.guardarClientes(this.clienteSeleccionado);
                this.clientes.add(this.clienteSeleccionado);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario(cliente) agregado"));
                logger.warn("Contraseña incorrecta");
                mostrarError("Correo o contraseña incorrectos");
                }
                clienteEncontrado = clienteDto;
                break;
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
