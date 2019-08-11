package br.com.fiap.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	public int modificarSaldo(double valor,int id) {
		em.getTransaction().begin();
		int resultado=em.createQuery("UPDATE Usuario u SET u.saldo = saldo + :c WHERE u.id =:d").setParameter("c", valor).setParameter("d", id).executeUpdate();
		return resultado;
	}
	public Usuario buscarPorLoginSenha(String login,String senha) {
		TypedQuery<Usuario> query= em.createQuery("FROM Usuario u where u.login =:l and u.senha =:s",Usuario.class);
		query.setParameter("l", login);
		query.setParameter("s", senha);
		if(query.getResultList().size()==0) {
			return null;
		}
		else
			return query.getSingleResult();
	}
	public List<Usuario> buscarUsuarioLista(){
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario", Usuario.class);
		return query.getResultList();
	}
}
