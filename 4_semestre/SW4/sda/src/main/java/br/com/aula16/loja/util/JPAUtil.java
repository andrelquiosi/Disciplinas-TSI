package br.com.aula16.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("aula16");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
}
