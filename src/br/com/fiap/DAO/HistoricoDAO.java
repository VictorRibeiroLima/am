package br.com.fiap.DAO;

import java.util.List;

import br.com.fiap.entity.Historico;
import br.com.fiap.entity.HistoricoPK;

public interface HistoricoDAO extends GenericDAO<Historico,HistoricoPK>{
	public List<Historico> buscarHistoricoLista();
	public List<Historico> buscarHistoricoLista(int usuarioId);
}
