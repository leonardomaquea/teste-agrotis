package com.lmtest.dev;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class infosPropriedade {
	
	@Id
	private Long id;
	
	@Column(length = 100)
	private String nome;
	
	@Column(length = 100)
	private int cnpj;
	
	@Column(length = 100)
	private String observacao;
	
	@Column(length = 100)
	private Date dataInicio;
	
	@Column(length = 100)
	private Date dataFinal;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	
	
	
	
	
	
	
	
	
	
	
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

	public Cliente getCliente() {
		return cliente;
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

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
