/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package converters;

import dao.AnimalDAO;
import entidade.Animal;
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
@Named(value = "animalConverter")
@ApplicationScoped
public class AnimalConverter implements Converter {

    @Inject
    AnimalDAO animalDao;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null) {
            return null;
        }
        Animal animal = (Animal) value;
        return String.valueOf(animal.getId());

    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            int id = Integer.parseInt(value);
            return animalDao.buscarAnimal(id);
        } catch (NumberFormatException ex) {
            return null;
        }

    }

}
