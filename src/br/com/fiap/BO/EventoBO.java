package br.com.fiap.BO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.impl.EventoDAOImpl;
import br.com.fiap.entity.Evento;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;

public class EventoBO {
	private static EventoDAOImpl dao;
	public static void registrarEvento(Evento evento,EntityManager em) throws CommitException {
		dao = new EventoDAOImpl(em);
		dao.create(evento);
		dao.commit();
	}
	public static Evento buscarEvento(int id,EntityManager em) throws IdNotFoundException {
		dao = new EventoDAOImpl(em);
		return dao.read(id);
	}
	public static List<Evento> listaEventosRegistrados(EntityManager em){
		dao = new EventoDAOImpl(em);
		return dao.buscarEventoLista();
	}
}
