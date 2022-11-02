package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.TipoAnimal;

/**
 *
 * @author andre
 */
@Named(value = "tipoAnimalBean")
@SessionScoped
public class TipoAnimalBean implements Serializable {

    @PersistenceContext
    EntityManager em;
    
    
    TipoAnimal tipo;
    public TipoAnimalBean() {
    }
    
    public String salvar(){
        em.persist(tipo);
        
        return null;
    }
    
}
