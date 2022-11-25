/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import modelo.Cliente;
import remotos.ServicosCliente;

/**
 *
 * @author andre
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    Cliente cliente;

    @EJB(lookup = "java:global/EJBApp1/EJBApp1-ejb/ClienteEJB!remotos.ServicosCliente")
    ServicosCliente dao;

    public ClienteBean() {
        cliente = new Cliente();

    }

    public Cliente getCLiente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        cliente = c;
    }

    public String confirmar() {
        dao.inserir(cliente);
        return null;
    }

    public List<Cliente> getListaClientes() {
        return dao.filtrar(null);

    }

}
