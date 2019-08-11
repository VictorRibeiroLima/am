package br.com.fiap.DAO;

import java.util.List;

import br.com.fiap.entity.Usuario;

public interface UsuarioDAO extends GenericDAO <Usuario,Integer>{
	public int modificarSaldo(double valor,int id);
	public Usuario buscarPorLoginSenha(String login,String senha);
	public List<Usuario> buscarUsuarioLista();
}
