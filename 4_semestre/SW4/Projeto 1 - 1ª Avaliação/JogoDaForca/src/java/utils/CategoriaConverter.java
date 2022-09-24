/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package utils;

import beans.RegistroBean;
import dados.Categoria;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Named(value = "categoriaConverter")
@ApplicationScoped
public class CategoriaConverter implements Converter {

    @Inject
    RegistroBean registroBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return registroBean.getCategoria(value);

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Categoria categoria = (Categoria) value;
        return String.valueOf(categoria.getNome());
    }

}
