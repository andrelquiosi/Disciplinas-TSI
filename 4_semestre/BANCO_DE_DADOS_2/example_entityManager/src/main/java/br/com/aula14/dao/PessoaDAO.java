package br.com.aula14.dao;

import br.com.aula14.model.Pessoa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PessoaDAO {

    private final EntityManager em;

    public PessoaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pessoa p) {
        this.em.persist(p);
    }

    public void ler() {
        Query query = em.createQuery("SELECT p from Pessoa p ");
        List<Pessoa> lista = query.getResultList();

        lista.forEach(pessoa -> {
            System.out.println(pessoa.getNome());
        });
    }

}
