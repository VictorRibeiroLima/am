package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.fiap.DAO.impl.EmpresaDAOImpl;
import br.com.fiap.DAO.impl.EnderecoDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class EmpresaTeste {
	private static EntityManager em = EntityManagerFactorySingleton.getInstance("server").createEntityManager();;
	private static EmpresaDAOImpl dao=new EmpresaDAOImpl(em);
	private static EnderecoDAOImpl eDao = new EnderecoDAOImpl(em);
	@Test
	void test() {
		Empresa empresa = new Empresa();
		empresa.setCnpj(123123);
		try {
			empresa.setEndereco(eDao.read(1));
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empresa.setNome("Empresa");
		dao.create(empresa);
		try {
			dao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(dao.read(empresa.getCd()).getCd(), empresa.getCd());
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
