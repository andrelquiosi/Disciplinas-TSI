/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Cliente;
import remotos.ServicosCliente;

/**
 * REST Web Service
 *
 * @author andre
 */
@Path("cliente")
public class ClientesResource {

    @Context
    private UriInfo context;

    @EJB(lookup = "java:global/EJBApp1/EJBApp1-ejb/ClienteEJB!remotos.ServicosCliente")
    ServicosCliente dao;

    @Inject
    ClienteResource infoCliente;

    /**
     * Creates a new instance of ClientesResource
     */
    public ClientesResource() {
    }

    /**
     * Retrieves representation of an instance of rest.ClientesResource
     *
     * @return an instance of java.List<modelo.Cliente>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public java.util.List<modelo.Cliente> listarClientes() {
        //TODO return proper representation object
        return dao.filtrar(null);
    }

    /**
     * POST method for creating an instance of ClienteResource
     *
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(Cliente cliente) {
        dao.inserir(cliente);
        return Response.created(context.getAbsolutePath()).build();
    }

    @Path("{id}")
    public ClienteResource getClienteResource(@PathParam("id") String id) {
        infoCliente.setId(id);
        return infoCliente;
    }
}
