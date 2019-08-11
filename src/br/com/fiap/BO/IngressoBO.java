package br.com.fiap.BO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.impl.IngressoDAOImpl;
import br.com.fiap.entity.Evento;
import br.com.fiap.entity.Ingresso;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;

public class IngressoBO {
	private static IngressoDAOImpl dao;
	public static void comprarIngressoPorSaldo(Ingresso ingresso,int eventoId,int usuarioId,EntityManager em,boolean commit) throws IdNotFoundException, CommitException{
		Evento evento = EventoBO.buscarEvento(eventoId, em);
		ingresso.setEvento(evento);
		ingresso.setUsuario(UsuarioBO.buscarUsuario(usuarioId, em));
		UsuarioBO.modificarSaldo(em, -1*evento.getPreco(), usuarioId,false);
		dao = new IngressoDAOImpl(em);
		if(commit) {
			dao.commit();
		}
	}
	public static void registrarIngresso(Ingresso ingresso,int eventoId,int usuarioId,EntityManager em,boolean commit) throws CommitException, IdNotFoundException{
		Evento evento = EventoBO.buscarEvento(eventoId, em);
		ingresso.setEvento(evento);
		ingresso.setUsuario(UsuarioBO.buscarUsuario(usuarioId, em));
		dao = new IngressoDAOImpl(em);
		if(commit) {
			dao.commit();
		}
	}
	public static List<Ingresso> listaIngressosRegistrados(EntityManager em){
		dao = new IngressoDAOImpl(em);
		return dao.buscarListaIngresso();
		
	}
}
