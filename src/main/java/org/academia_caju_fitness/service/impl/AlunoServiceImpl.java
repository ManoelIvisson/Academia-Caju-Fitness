package org.academia_caju_fitness.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.academia_caju_fitness.model.Aluno;
import org.academia_caju_fitness.repository.AlunoRepository;
import org.academia_caju_fitness.service.AlunoService;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

	private final AlunoRepository alunoRepository;
	
	public AlunoServiceImpl(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}
	
	@Override
	public Aluno findById(Long id) {
		return alunoRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public Aluno create(Aluno aluno) {
		aluno.setDataCadastro(LocalDateTime.now());
		
		return alunoRepository.save(aluno);
	}

}
