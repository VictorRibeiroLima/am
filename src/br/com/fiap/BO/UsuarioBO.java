package br.com.fiap.BO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.DAO.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;
import br.com.fiap.excecao.RegisterException;

public class UsuarioBO {
	private static UsuarioDAO dao=null;
	public static void addUsuario(Usuario usuario,EntityManager em) throws RegisterException, CommitException{
		if(usuario.getNome().length()<4 || usuario.getNome().isEmpty()) {
			throw new RegisterException("Nome pequeno demais");
		}
		if(usuario.getRg().length()<9) {
			throw new RegisterException("RG pequeno demais");
		}
		dao = new UsuarioDAOImpl(em);
		dao.create(usuario);
		dao.commit();
	}
	public static Usuario buscarUsuario(int id,EntityManager em) throws IdNotFoundException {
		dao = new UsuarioDAOImpl(em);
		Usuario us = dao.read(id);
		return us;
	}
	public static Usuario logar(String login,String senha,EntityManager em) {
		dao = new UsuarioDAOImpl(em);
		Usuario us = dao.buscarPorLoginSenha(login, senha);
		return us;
	}
	public static int modificarSaldo(EntityManager em,double valor,int usuarioId,boolean commit) throws IdNotFoundException, CommitException {
		dao = new UsuarioDAOImpl(em);
		int i=dao.modificarSaldo(valor, usuarioId);
		HistoricoBO.addHistorico("teste", buscarUsuario(usuarioId,em),valor, em,false);
		if(commit) {
			dao.commit();
		}
		return i;
	}
	public static List<Usuario> listaUsuariosRegistrados(EntityManager em){
		dao = new UsuarioDAOImpl(em);
		return dao.buscarUsuarioLista();
	}
}
