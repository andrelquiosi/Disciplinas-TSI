/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dados.Setor;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author aluno
 */
@Named(value = "setorBean")
@ApplicationScoped
public class SetorBean {

    LinkedList<Setor> setores;

    LinkedList<SelectItem> itensSetor;

    public SetorBean() {

        setores = new LinkedList<>();
        setores.add(new Setor(1, "Hortifrute"));
        setores.add(new Setor(2, "Padaria"));
        setores.add(new Setor(3, "Açougue"));
        setores.add(new Setor(4, "Higiene"));
        setores.add(new Setor(5, "Limpeza"));
        setores.add(new Setor(6, "Bazar"));
        setores.add(new Setor(7, "Bebidas"));

        itensSetor = new LinkedList<>();
        itensSetor.add(new SelectItem (null, "-- Selecione --"));

        setores.forEach(s -> {
            itensSetor.add(new SelectItem(s, s.getDescricao()));
        });

    }

    public List<SelectItem> getItensSetor() {
        return itensSetor;

    }
    
    public Setor getSetor(int id){
        

        
        for(Setor s : setores){
            if(s.getId() == id){
                return s;
            }
        }
    return null;
    }
}
