package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.BO.UsuarioBO;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Usuario;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;
import br.com.fiap.excecao.RegisterException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class UsuarioTeste {
	private static EntityManager em = EntityManagerFactorySingleton.getInstance("server").createEntityManager();;
	private static int id;
	/*@BeforeAll
	static void test() {
		Usuario usuario = new Usuario();
		usuario.setCpf(42742039805l);
		usuario.setLogin("zaiamlata3");
		usuario.setSenha("1234");
		Endereco endereco = new Endereco();
		endereco.setCep("05060050");
		endereco.setDescricao("Ap.16");
		endereco.setLogradouro("R.luís martin");
		usuario.setEndereco(endereco);
		usuario.setNascimento(new GregorianCalendar());
		usuario.setNome("Victor Ribeiro de Lima");
		usuario.setRg("507834549");
		usuario.setSaldo(0);
		usuario.setTelefone(38646969);
		System.out.println("usuario foi");
		try {
			UsuarioBO.addUsuario(usuario,em);
		} catch (RegisterException | CommitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			id = usuario.getCd();
			assertEquals(UsuarioBO.buscarUsuario(usuario.getCd(),em).getCd(), usuario.getCd());
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*@Test
	void busca() {
		try {
			Usuario us =UsuarioBO.buscarUsuario(id,em);
			assertEquals(id, us.getCd());
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test
	void saldoTeste() {
		int i=0;
		try {
			i = UsuarioBO.modificarSaldo(em, -4.20, 27);
		} catch (IdNotFoundException | CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,i);
	}
}
