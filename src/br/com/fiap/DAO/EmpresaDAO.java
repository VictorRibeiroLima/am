package br.com.fiap.DAO;

import java.util.List;

import br.com.fiap.entity.Empresa;

public interface EmpresaDAO extends GenericDAO<Empresa,Integer>{
	public List<Empresa> buscarListaEmpresa();
}
