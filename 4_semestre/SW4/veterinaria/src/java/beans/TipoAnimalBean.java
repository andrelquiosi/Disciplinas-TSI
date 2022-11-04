package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
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

    @Resource
    UserTransaction trx;

    TipoAnimal tipo;

    public TipoAnimalBean() {
        tipo = new TipoAnimal();
    }

    public String salvar() {
        try {
            trx.begin();
            em.persist(tipo);
            trx.commit();
            tipo = new TipoAnimal();

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
            } catch (Exception ex2) {
            }
        }
        return null;

    }

    public void remover(TipoAnimal tp) {
        try {
            trx.begin();
            tp = em.merge(tp);
            em.remove(tp);
            trx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            try {
                trx.rollback();
            } catch (Exception ex2) {
            }
        }
    }

    public List<TipoAnimal> getTipos() {
        try {
            Query consulta = em.createQuery(
                    "select t from TipoAnimal t "
                    + "order by t.descricao", TipoAnimal.class);
            return consulta.getResultList();
        } catch (Throwable t) {
            t.printStackTrace();
            return new LinkedList<TipoAnimal>();
        }
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

}
