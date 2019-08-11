package br.com.fiap.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.DAO.HistoricoDAO;
import br.com.fiap.entity.Historico;
import br.com.fiap.entity.HistoricoPK;

public class HistoricoDAOImpl extends GenericDAOImpl<Historico, HistoricoPK> implements HistoricoDAO {

	public HistoricoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	public List<Historico> buscarHistoricoLista(){
		TypedQuery<Historico> query = em.createNamedQuery("From Historico",Historico.class);
		return query.getResultList();
	}
	public List<Historico> buscarHistoricoLista(int usuarioId){
		TypedQuery<Historico> query = em.createNamedQuery("From Historico h where h.usuario.cd =:d",Historico.class);
		query.setParameter("d", usuarioId);
		return query.getResultList();
	}
}
