package org.academia_caju_fitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Instrutor extends BasePessoa {
	
	@Column(length = 50, nullable = false)
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
