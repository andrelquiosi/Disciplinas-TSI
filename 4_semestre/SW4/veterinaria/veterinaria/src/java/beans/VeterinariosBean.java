
package beans;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import model.Veterinario;


@Named(value = "veterinariosBean")
@ApplicationScoped
public class VeterinariosBean {

    private Veterinario veterinario;
    
    @PersistenceContext
    EntityManager em;
    
    @Resource
    UserTransaction utx;
    
    public VeterinariosBean() {
        veterinario = new Veterinario();
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
    public String salvar() {
        try {
            utx.begin();
            em.persist(veterinario);
            utx.commit();
            veterinario = new Veterinario();
        } catch (Throwable t) {
            t.printStackTrace();
            try { utx.rollback(); } catch(Throwable t2) { }
        }
        return null;
    }

}
