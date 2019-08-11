package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static EntityManagerFactory fabrica=null;
	private EntityManagerFactorySingleton() {
		
	}
	public static EntityManagerFactory getInstance(String server) {
		if(fabrica==null)
			fabrica= Persistence.createEntityManagerFactory(server);
		return fabrica;
	}
}
