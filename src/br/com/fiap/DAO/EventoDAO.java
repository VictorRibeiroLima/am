package br.com.fiap.DAO;

import java.util.List;

import br.com.fiap.entity.Evento;

public interface EventoDAO extends GenericDAO<Evento,Integer>{
	public List<Evento> buscarEventoLista();
}
