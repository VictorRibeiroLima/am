package br.com.fiap.DAO;

import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.IdNotFoundException;

public interface GenericDAO <T,K> {
	void create(T etity);
	T read(K id) throws IdNotFoundException;
	void update(T entity);
	void delete(K id) throws IdNotFoundException;
	void commit() throws CommitException;
}
