package br.com.fiap.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.DAO.EventoDAO;
import br.com.fiap.entity.Evento;

public class EventoDAOImpl extends GenericDAOImpl<Evento, Integer> implements EventoDAO {

	public EventoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	public List<Evento> buscarEventoLista(){
		TypedQuery<Evento> query = em.createNamedQuery("From Evento",Evento.class);
		return query.getResultList();
	}
}
