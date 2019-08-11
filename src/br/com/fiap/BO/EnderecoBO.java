package br.com.fiap.BO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.EnderecoDAO;
import br.com.fiap.DAO.impl.EnderecoDAOImpl;
import br.com.fiap.entity.Endereco;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;
import br.com.fiap.excecao.RegisterException;

public class EnderecoBO {
	private static EnderecoDAO dao = null;
	public static void addEndereco(Endereco endereco,EntityManager em) throws RegisterException, CommitException {
		if(endereco.getCep().length()<8) {
			throw new RegisterException("CEP é pequeno demais");
		}
		if(endereco.getLogradouro().length()<4) {
			throw new RegisterException("Logradouro é pequeno demais");
		}
		dao = new EnderecoDAOImpl(em);
		dao.create(endereco);
		dao.commit();
	}
	public static Endereco buscarEndereco(Endereco endereco,EntityManager em) {
		dao = new EnderecoDAOImpl(em);
		Endereco e = dao.procurarEndereco(endereco);
		return e;
	}
	public static Endereco buscarEndereco(int id,EntityManager em) throws IdNotFoundException {
		dao = new EnderecoDAOImpl(em);
		Endereco e = dao.read(id);
		return e;
	}
	public static List<Endereco> listaEnderecosRegistrados(EntityManager em){
		dao = new EnderecoDAOImpl(em);
		return dao.buscarEnderecoLista();
	}
}
