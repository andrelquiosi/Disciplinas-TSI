/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericItemResource.java to edit this template
 */
package rest;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import remotos.ServicosCliente;

/**
 * REST Web Service
 *
 * @author andre
 */
@SessionScoped
@Named("clienteResource")
public class ClienteResource implements Serializable{

    @EJB(lookup = "java:global/EJBApp1/EJBApp1-ejb/ClienteEJB!remotos.ServicosCliente")
    ServicosCliente dao;

    private String id;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    /**
     * Get instance of the ClienteResource
     */
    public void setId(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of ClienteResource class.
        this.id = id;
    }

    /**
     * Retrieves representation of an instance of rest.ClienteResource
     *
     * @return an instance of modelo.Cliente
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getJson() {
        return dao.buscar(id);
    }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Cliente content) {
    }

    /**
     * DELETE method for resource ClienteResource
     */
    @DELETE
    public void delete() {
    }
}
