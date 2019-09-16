package br.com.api.services;

import java.util.List;

import org.springframework.data.domain.Example;

import br.com.api.models.Planeta;

public interface PlanetaService {

	List<Planeta> listarTodos();

	Planeta listarPorId(String id);
	
	Planeta listarPorNome(String nome);

	Planeta cadastrar(Planeta planeta);

	Planeta atualizar(Planeta planeta);

	void remover(String id);
}
