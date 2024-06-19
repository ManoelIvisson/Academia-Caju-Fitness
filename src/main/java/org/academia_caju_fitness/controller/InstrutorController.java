package org.academia_caju_fitness.controller;

import java.net.URI;
import java.util.List;

import org.academia_caju_fitness.model.Instrutor;
import org.academia_caju_fitness.service.InstrutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
	
	private final InstrutorService instrutorService;

	public InstrutorController(InstrutorService instrutorService) {
		this.instrutorService = instrutorService;
	}

	@GetMapping
	public ResponseEntity<List<Instrutor>> findAll() {
		return ResponseEntity.ok(instrutorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Instrutor> findById(@PathVariable("id") Long id) {
		var instrutor = instrutorService.findById(id);
		
		return ResponseEntity.ok(instrutor);
	}
	
	@PostMapping
	public ResponseEntity<Instrutor> create(@RequestBody Instrutor instrutorParaCriar) {
		var instrutorCriado = instrutorService.create(instrutorParaCriar);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(instrutorParaCriar.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(instrutorCriado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		instrutorService.delete(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Instrutor> update(@PathVariable("id") Long id, @RequestBody Instrutor instrutor) {
		instrutorService.update(id, instrutor);
		
		return ResponseEntity.ok(instrutor);
	}
	
}
