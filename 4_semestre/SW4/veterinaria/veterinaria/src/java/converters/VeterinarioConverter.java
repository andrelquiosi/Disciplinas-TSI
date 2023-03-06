package converters;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Veterinario;

@Named("vetConverter")
@ApplicationScoped
public class VeterinarioConverter implements Converter<Veterinario> {

    @PersistenceContext
    EntityManager em;

    @Override
    public Veterinario getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Long id = Long.parseLong(value);
            return em.find(Veterinario.class, id);
        } catch (NumberFormatException t) {
            t.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Veterinario value) {
        if (value == null) {
            return "NULL";
        }
        return String.valueOf(value.getId());

    }

}
