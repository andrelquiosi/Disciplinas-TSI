/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dados.ItemCompra;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author aluno
 */
@Named(value = "listaBean")
@SessionScoped
public class ListaComprasBean implements Serializable {

    List<ItemCompra> itens;
    ItemCompra item;
    boolean editando = false;
    Date dataEntrega;
    String cepEntrega;

    /**
     * Creates a new instance of ListaComprasBean
     */
    public ListaComprasBean() {

        itens = new LinkedList<ItemCompra>();
        item = new ItemCompra();

    }

    public ItemCompra getItem() {
        return item;
    }

    public List<ItemCompra> getLista() {
        return itens;
    }

    public String confirmar() {

        if (!editando) {
            if (!itens.contains(item)) {
                itens.add(item);
            } else {
                FacesContext.getCurrentInstance().addMessage("frmLista:edDescr", new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "Produto já está na lista",
                        "Um produto só pode constar na lista uma vez só"));
                return null;
            }

        }
        item = new ItemCompra();
        editando = false;
        return null; // volta para a mesma visão (index.xhtml)
    }

    public String remover(ItemCompra itemSelecionado) {
        itens.remove(itemSelecionado);
        return null;

    }

    public String editar(ItemCompra itemEdicao) {
        item = itemEdicao;
        editando = true;
        return null;

    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }

    public String definirEntrega() {
        System.out.println("Entrega definida para "
                + cepEntrega + " em " + dataEntrega);
        return null;
    }
}
