package org.academia_caju_fitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medidas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(precision = 3)
	private double peso;
	
	@Column(precision = 3)
	private double altura;
	
	@Column(precision = 3)
	private double braco;
	
	@Column(precision = 3)
	private double cintura;
	
	@Column(precision = 3)
	private double quadril;
	
	@Column(precision = 3)
	private double coxa;

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBraco() {
		return braco;
	}

	public void setBraco(double braco) {
		this.braco = braco;
	}

	public double getCintura() {
		return cintura;
	}

	public void setCintura(double cintura) {
		this.cintura = cintura;
	}

	public double getQuadril() {
		return quadril;
	}

	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}

	public double getCoxa() {
		return coxa;
	}

	public void setCoxa(double coxa) {
		this.coxa = coxa;
	}
	
}
