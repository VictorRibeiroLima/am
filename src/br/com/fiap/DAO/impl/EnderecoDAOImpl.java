package br.com.fiap.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.DAO.EnderecoDAO;
import br.com.fiap.entity.Endereco;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco, Integer> implements EnderecoDAO{

	public EnderecoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	public Endereco procurarEndereco(Endereco e) {
		TypedQuery<Endereco> query = em.createQuery("FROM Endereco e WHERE e.cep =:c AND e.logradouro =:l and e.descricao =:d",Endereco.class);
		query.setParameter("c", e.getCep());
		query.setParameter("l", e.getLogradouro());
		query.setParameter("d",e.getDescricao());
		if(query.getResultList().size()==0) {
			return null;
		}
		else
			return query.getSingleResult();
	}
	public List<Endereco> buscarEnderecoLista() {
		TypedQuery<Endereco> query = em.createQuery("FROM Endereco ",Endereco.class);
		return query.getResultList();
	}
}
