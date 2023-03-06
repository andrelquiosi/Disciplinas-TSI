package br.com.aula16.loja.dao;

import javax.persistence.EntityManager;
import br.com.aula16.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto p) {
		this.em.persist(p);
	}
	
}
