package br.com.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.models.Planeta;
import br.com.api.responses.Response;
import br.com.api.services.PlanetaService;

@RestController
@RequestMapping(path = "/jediapi/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	@GetMapping
	public ResponseEntity<Response<List<Planeta>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<Planeta>>(this.planetaService.listarTodos()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Planeta>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.listarPorId(id)));
	}
	
	@GetMapping(path = "/busca/{nome}")
	public ResponseEntity<Response<Planeta>> listarPorNome(@PathVariable(name = "nome") String nome) {
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.listarPorNome(nome)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody Planeta planeta, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.cadastrar(planeta)));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Planeta>> atualizar(@PathVariable(name = "id") String id,
			@Valid @RequestBody Planeta planeta, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		planeta.setId(id);
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.atualizar(planeta)));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		this.planetaService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(0));
	}

}
