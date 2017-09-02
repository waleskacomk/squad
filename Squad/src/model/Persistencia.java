package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Persistencia {
	public static void inserir(Object objeto,String tabela){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(tabela);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(objeto);
		manager.getTransaction().commit();
		manager.close();
	}
}