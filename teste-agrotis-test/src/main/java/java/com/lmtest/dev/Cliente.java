package com.lmtest.dev;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(length = 100)
	public String nome;
	
	@Column(length = 100)
	public Date dataInicio;
	
	@Column(length = 100)
	public Date dataFinal;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<infosPropriedade> propriedades = new ArrayList<>();

	
	
	
	
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<infosPropriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<infosPropriedade> propriedades) {
		this.propriedades = propriedades;
	}


	
	
	
	
	
	
	
}
