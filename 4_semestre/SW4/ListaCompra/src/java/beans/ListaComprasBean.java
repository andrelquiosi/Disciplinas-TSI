/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dados.ItemCompra;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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
        
        if(!editando)
            itens.add(item);
        
        item = new ItemCompra();
        editando = false;
        return null; // volta para a mesma visão (index.xhtml)
    }
    public String remover(ItemCompra itemSelecionado){
    itens.remove(itemSelecionado);
    return null;
    
    }
    public String editar(ItemCompra itemEdicao){
    item = itemEdicao;
    editando = true;
    return null;
    
    }
    

}
