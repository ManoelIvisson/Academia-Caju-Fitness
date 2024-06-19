package org.academia_caju_fitness.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.academia_caju_fitness.model.Instrutor;
import org.academia_caju_fitness.repository.InstrutorRepository;
import org.academia_caju_fitness.service.InstrutorService;
import org.springframework.stereotype.Service;

@Service
public class InstrutorServiceImpl implements InstrutorService {

	private final InstrutorRepository instrutorRepository;
	
	public InstrutorServiceImpl(InstrutorRepository instrutorRepository) {
		this.instrutorRepository = instrutorRepository;
	}

	@Override
	public List<Instrutor> findAll() {
		return instrutorRepository.findAll();
	}

	@Override
	public Instrutor findById(Long id) {
		return instrutorRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Instrutor create(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	@Override
	public void delete(Long id) {
		Instrutor instrutor = instrutorRepository.findById(id).orElseThrow(NoSuchElementException::new);
		
		instrutorRepository.delete(instrutor);
	}

	@Override
	public Instrutor update(Long id, Instrutor instrutor) {
		Instrutor instrutorBd = instrutorRepository.findById(id).orElseThrow(NoSuchElementException::new);
		
		instrutorBd.setNome(instrutor.getNome());
		instrutorBd.setEmail(instrutor.getEmail());
		instrutorBd.setSenha(instrutor.getSenha());
		instrutorBd.setTurno(instrutor.getTurno());
		
		return instrutorRepository.save(instrutorBd);
	}

}
