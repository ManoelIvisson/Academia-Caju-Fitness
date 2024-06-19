package org.academia_caju_fitness.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

	@Override
	public void delete(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		
		if (aluno.isPresent()) {
			alunoRepository.deleteById(id);
		}
	}

	@Override
	public Aluno update(Long id, Aluno aluno) {
		Aluno alunoBd = alunoRepository.findById(id).orElseThrow(NoSuchElementException::new);
		
		alunoBd.setNome(aluno.getNome());
		alunoBd.setEmail(aluno.getEmail());
		alunoBd.setIdade(aluno.getIdade());
		alunoBd.setMatricula(aluno.getMatricula());
		alunoBd.setEstado(aluno.getEstado());
		alunoBd.setTurno(aluno.getTurno());
		alunoBd.setMedidas(aluno.getMedidas());
		
		return alunoRepository.save(alunoBd);
	}

}
