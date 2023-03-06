package br.com.aula14.testes;

import br.com.aula14.dao.PessoaDAO;
import javax.persistence.EntityManager;
import br.com.aula14.model.Pessoa;
import br.com.aula14.util.JPAUtil;

public class CadastroPessoa {

    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Nome 3");
        p.setIdade(16);

        EntityManager em = JPAUtil.getEntityManager();
        PessoaDAO pessoaDao = new PessoaDAO(em);
        
        pessoaDao.ler();

        em.getTransaction().begin();
        pessoaDao.cadastrar(p);
        em.getTransaction().commit();
        em.close();

    }
}
