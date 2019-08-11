package br.com.fiap.BO;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.impl.HistoricoDAOImpl;
import br.com.fiap.entity.Historico;
import br.com.fiap.entity.HistoricoPK;
import br.com.fiap.entity.TipoTransacao;
import br.com.fiap.entity.Usuario;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;

public class HistoricoBO {
	private static HistoricoDAOImpl dao =null;
	public static void addHistorico(String desc,Usuario usuario,double valor,EntityManager em,boolean commit) throws IdNotFoundException, CommitException {
		Historico historico = new Historico();
		historico.setData(new GregorianCalendar());
		historico.setDescricao(desc);
		if(valor<0)
			historico.setTransacao(TipoTransacao.DEBITO);
		else
			historico.setTransacao(TipoTransacao.CREDITO);
		historico.setUsuario(usuario);
		historico.setValor(valor);
		dao = new HistoricoDAOImpl(em);
		dao.create(historico);
		if(commit) {
			dao.commit();
		}
	}
	public static Historico buscarHistorico(EntityManager em,HistoricoPK historicoId) throws IdNotFoundException {
		dao = new HistoricoDAOImpl(em);
		return dao.read(historicoId);
	}
	public List<Historico> listaHistoricosRegistrados(EntityManager em){
		dao = new HistoricoDAOImpl(em);
		return dao.buscarHistoricoLista();
	}
	public List<Historico> listaHistoricoUsuario(EntityManager em,int usuarioId){
		dao = new HistoricoDAOImpl(em);
		return dao.buscarHistoricoLista(usuarioId);
	}
}
