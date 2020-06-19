package com.algaworks.comercial.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nomeProspecto", "descricao", "valor"})   //somento o ID pq ele é o identificador
public class Oportunidade {    //representar uma tabela no banco de dados

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  	//id automático no banco de dados
	private Long id;
	
	@NotEmpty
	@Size(max = 80)
	@Column(name = "nome_prospecto")
	private String nomeProspecto;
	
	@NotEmpty
	@Size(max = 200)
	private String descricao;
	
	@Min(0)
	private BigDecimal valor;
}
