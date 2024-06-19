package org.academia_caju_fitness.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Aluno extends BasePessoa {
	
	@Column(length = 14, nullable = false)
	private String matricula;
	
	private int idade;
	
	private LocalDateTime dataCadastro;
	
	private String estado;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Medidas medidas;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Medidas getMedidas() {
		return medidas;
	}

	public void setMedidas(Medidas medidas) {
		this.medidas = medidas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
