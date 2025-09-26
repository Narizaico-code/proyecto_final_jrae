package org.jrae.carwashito.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.carwashito.dominio.dto.ClienteDto;
import org.jrae.carwashito.dominio.repository.ClienteRepository;
import org.jrae.carwashito.web.mapper.ClienteViewMapper;
import org.jrae.carwashito.web.view.ClienteView;
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
public class ClienteControllerWeb implements Serializable {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteViewMapper clienteViewMapper;

    private static final Logger logger = LoggerFactory.getLogger(ClienteControllerWeb.class);

    private List<ClienteView> clientes;
    private ClienteView clienteSeleccionado;
    private final String sl = System.lineSeparator();

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.clientes = clienteViewMapper.fromDto(clienteRepository.obtenerTodo());
        this.clientes.forEach(cli -> logger.info(cli.toString() + sl));
    }

    public void agregarCliente() {
        this.clienteSeleccionado = new ClienteView();
    }

    public void guardarCliente() {
        if (this.clienteSeleccionado == null) return;

        var dto = clienteViewMapper.toDto(this.clienteSeleccionado);

        logger.info("Cliente a guardar: " + dto + sl);

        if (dto.codigoCliente() == null) {
            ClienteDto guardado = clienteRepository.guardarClientes(dto);
            this.clienteSeleccionado.setCodigoCliente(guardado.codigoCliente());
            this.clientes.add(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente agregado"));
        } else {
            clienteRepository.guardarClientes(dto);
            this.cargarDatos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente actualizado"));
        }

        PrimeFaces.current().executeScript("PF('ventanaModalCliente').hide()");
        PrimeFaces.current().ajax().update(
                "formulario-clientes:mensaje_emergente",
                "formulario-clientes:tabla-cliente"
        );

        this.clienteSeleccionado = null;
    }

    public void eliminarCliente() {
        if (this.clienteSeleccionado == null) return;

        var dto = clienteViewMapper.toDto(this.clienteSeleccionado);

        logger.info("Cliente a eliminar: " + dto + sl);

        clienteRepository.eliminarClientes(dto.codigoCliente());
        this.clientes.remove(this.clienteSeleccionado);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente eliminado"));

        PrimeFaces.current().ajax().update(
                "formulario-clientes:mensaje_emergente",
                "formulario-clientes:tabla-cliente"
        );

        this.clienteSeleccionado = null;
    }
}
