package br.com.fiap.DAO;

import java.util.List;

import br.com.fiap.entity.Ingresso;
import br.com.fiap.entity.IngressoPK;

public interface IngressoDAO extends GenericDAO<Ingresso,IngressoPK>{
	public List<Ingresso> buscarListaIngresso();
}
