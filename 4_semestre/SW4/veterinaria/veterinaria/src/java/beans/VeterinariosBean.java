package beans;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import model.Veterinario;

@Named(value = "veterinariosBean")
@ApplicationScoped
public class VeterinariosBean {

    private Veterinario veterinario;
    private List<Veterinario> veterinarios;

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
            try {
                utx.rollback();
            } catch (Throwable t2) {
            }
        }
        return null;
    }

    public List<Veterinario> getVeterinarios() {
        if (veterinarios == null) {
            try {
                Query consulta = em.createQuery(
                        "select t from Veterinario t "
                        + "order by t.nome",
                        Veterinario.class);
                veterinarios = consulta.getResultList();
            } catch (Throwable t) {
                t.printStackTrace();
                veterinarios = new LinkedList<Veterinario>();
            }
        }
        return veterinarios;
    }

    public void remover(Veterinario tp) {
        try {
            utx.begin();
            tp = em.merge(tp);
            em.remove(tp);
            veterinarios.remove(tp);
            utx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception ex2) {
            }
        }
    }
}
