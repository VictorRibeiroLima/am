package br.com.fiap.DAO.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.GenericDAO;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K> {
	protected EntityManager em;
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl (EntityManager em){
		super();
		this.em=em;
		this.clazz=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	@Override
	public void create(T table) {
		em.persist(table);
	}


	public T read(K key) throws IdNotFoundException {
		T entity= em.find(clazz,key );
		if(entity==null)
			throw new IdNotFoundException();
		return entity;
	}

	public void update(T table) {
		em.merge(table);
	}

	public void delete(K key) {
		T table = em.find(clazz, key);
		em.remove(table);
	}

	public void commit() throws CommitException {
		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	} 
}
