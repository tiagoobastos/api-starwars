package br.com.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.api.models.Planeta;
import br.com.api.repositories.PlanetaRepository;
import br.com.api.services.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Override
	public List<Planeta> listarTodos() {
		return this.planetaRepository.findAll();
	}

	@Override
	public Planeta listarPorId(String id) {
		return this.planetaRepository.findOne(id);
	}

	@Override
	public Planeta listarPorNome(String nome) {
		Planeta planeta = new Planeta();
		planeta.setNome(nome);
		Example<Planeta> example = Example.of(planeta, ExampleMatcher.matchingAny());
		return this.planetaRepository.findOne(example);

	}

	@Override
	public Planeta cadastrar(Planeta planeta) {
		return this.planetaRepository.save(planeta);
	}

	@Override
	public Planeta atualizar(Planeta planeta) {
		return this.planetaRepository.save(planeta);
	}

	@Override
	public void remover(String id) {
		this.planetaRepository.delete(id);

	}

}
