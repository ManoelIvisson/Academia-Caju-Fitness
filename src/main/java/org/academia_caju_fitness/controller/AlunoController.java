package org.academia_caju_fitness.controller;

import java.net.URI;
import java.util.List;

import org.academia_caju_fitness.model.Aluno;
import org.academia_caju_fitness.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private final AlunoService alunoService;
	
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		return ResponseEntity.ok(alunoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable("id") Long id) {
		var aluno = alunoService.findById(id);
		
		return ResponseEntity.ok(aluno);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> create(@RequestBody Aluno alunoParaCriar) {
		var alunoCriado = alunoService.create(alunoParaCriar);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(alunoParaCriar.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(alunoCriado);
	}
}
