package converters;


import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.TipoAnimal;

@Named(value="tpAnimalCnvtr")
@ApplicationScoped
public class TipoAnimalConverter implements Converter<TipoAnimal> {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public TipoAnimal getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Long id = Long.valueOf(value);
            return em.find(TipoAnimal.class, id);
        } catch(NumberFormatException t) {
            t.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, TipoAnimal value) {
        if (value == null) {
            return "NULL";
        }
        return String.valueOf( value.getId());
    }
    
}
