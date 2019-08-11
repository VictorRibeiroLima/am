package br.com.fiap.DAO;

import java.util.List;

import br.com.fiap.entity.Endereco;

public interface EnderecoDAO extends GenericDAO<Endereco,Integer> {
	public Endereco procurarEndereco(Endereco e);
	public List<Endereco> buscarEnderecoLista();
}
