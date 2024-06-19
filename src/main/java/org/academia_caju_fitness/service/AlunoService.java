package org.academia_caju_fitness.service;

import java.util.List;

import org.academia_caju_fitness.model.Aluno;

public interface AlunoService {

	List<Aluno> findAll();
	
	Aluno findById(Long id);
	
	Aluno create(Aluno aluno);
	
	void delete(Long id);
	
	Aluno update(Long id, Aluno aluno);
}
