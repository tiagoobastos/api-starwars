package br.com.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.api.models.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
}
