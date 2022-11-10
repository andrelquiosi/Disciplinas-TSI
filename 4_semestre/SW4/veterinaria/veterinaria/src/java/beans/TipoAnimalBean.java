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
import javax.transaction.UserTransaction;
import model.TipoAnimal;

@Named(value = "tipoAnimalBean")
@SessionScoped
public class TipoAnimalBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction trx;

    TipoAnimal tipo;

    private List<SelectItem> tiposAnimaisAsItems;
    private List<TipoAnimal> tipos;

    public TipoAnimalBean() {
        tipo = new TipoAnimal();
    }

    public List<SelectItem> getTiposAnimaisAsItems() {
        tiposAnimaisAsItems = new LinkedList<SelectItem>();
        for (TipoAnimal ta : getTipos()) {
            tiposAnimaisAsItems.add( new SelectItem( ta, ta.getDescricao() ) );
        }
        return tiposAnimaisAsItems;
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
                t.printStackTrace();
                tipos = new LinkedList<TipoAnimal>();
            }
        }
        return tipos;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public String salvar() {
        try {
            trx.begin();
            em.persist(tipo);
            trx.commit();
            tipo = new TipoAnimal();
            tipos = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                trx.rollback();
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
            tipos.remove( tp );
            trx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            try {
                trx.rollback();
            } catch (Exception ex2) {
            }
        }
    }
}
