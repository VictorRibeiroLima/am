package br.com.fiap.BO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;
import br.com.fiap.excecao.RegisterException;

public class EmpresaBO {
	static EmpresaDAOImpl dao =null;
	public static void addEmpresa(Empresa empresa,EntityManager em) throws RegisterException, CommitException {
		if(empresa.getCnpj()<14) {
			throw new RegisterException("CNPJ pequeno demais");
		}
		if(empresa.getNome().length()<2) {
			throw new RegisterException("Nome pequeno demais");
		}
		dao = new EmpresaDAOImpl(em);
		dao.create(empresa);
		dao.commit();
	}
	public static Empresa procurarEmpresa(int id,EntityManager em) throws IdNotFoundException {
		dao = new EmpresaDAOImpl(em);
		Empresa empresa = dao.read(id);
		return empresa;
	}
	public static List<Empresa> listaEmpresasRegistradas(EntityManager em){
		dao = new EmpresaDAOImpl(em);
		return dao.buscarListaEmpresa();
	}
}
