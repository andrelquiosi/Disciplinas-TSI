package beans;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
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
    UserTransaction userTransaction;

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
            userTransaction.begin();
            em.persist(veterinario);
            userTransaction.commit();
            veterinario = new Veterinario();
            veterinarios = null;
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException t) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException t2) {
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
                veterinarios = new LinkedList<>();
            }
        }
        return veterinarios;
    }

    public void remover(Veterinario tp) {
        try {
            userTransaction.begin();
            tp = em.merge(tp);
            em.remove(tp);
            veterinarios.remove(tp);
            userTransaction.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException t) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex2) {
            }
        }
    }
}
