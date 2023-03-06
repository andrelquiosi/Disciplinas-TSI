package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import model.TipoAnimal;

@Named(value = "tipoAnimalBean")
@SessionScoped
public class TipoAnimalBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction userTransaction;

    TipoAnimal tipo;

    private List<SelectItem> tiposAnimaisAsItems;
    private List<TipoAnimal> tipos;

    public TipoAnimalBean() {
        tipo = new TipoAnimal();
    }

    public List<SelectItem> getTiposAnimaisAsItems() {
        tiposAnimaisAsItems = new LinkedList<>();
        for (TipoAnimal ta : getTipos()) {
            tiposAnimaisAsItems.add( new SelectItem( ta, ta.getDescricao() ) );
        }
        return tiposAnimaisAsItems;
    }

        
    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }
    public List<TipoAnimal> getTipos() {
        if (tipos == null) {
            try {
                Query consulta = em.createQuery(
                        "select t from TipoAnimal t "
                        + "order by t.descricao",
                        TipoAnimal.class);
                tipos = consulta.getResultList();
            } catch (Throwable t) {
                tipos = new LinkedList<>();
            }
        }
        return tipos;
    }

    public String salvar() {
        try {
            userTransaction.begin();
            em.persist(tipo);
            userTransaction.commit();
            tipo = new TipoAnimal();
            tipos = null;
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex2) {
            }
        }
        return null;
    }

    public void remover(TipoAnimal tp) {
        try {
            userTransaction.begin();
            tp = em.merge(tp);
            em.remove(tp);
            tipos.remove( tp );
            userTransaction.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException t) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex2) {
            }
        }
    }
}
