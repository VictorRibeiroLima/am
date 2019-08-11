package br.com.fiap.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.DAO.IngressoDAO;
import br.com.fiap.entity.Ingresso;
import br.com.fiap.entity.IngressoPK;

public class IngressoDAOImpl extends GenericDAOImpl<Ingresso, IngressoPK> implements IngressoDAO {

	public IngressoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	public List<Ingresso> buscarListaIngresso(){
		TypedQuery<Ingresso> query = em.createNamedQuery("FROM Ingresso",Ingresso.class);
		return query.getResultList();
	}
}
