package br.com.fiap.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Empresa;

public class EmpresaDAOImpl extends GenericDAOImpl<Empresa, Integer>{

	public EmpresaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	public List<Empresa> buscarListaEmpresa(){
		TypedQuery<Empresa> query = em.createNamedQuery("From Empresa",Empresa.class);
		return query.getResultList();
	}
}
