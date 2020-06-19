package com.algaworks.comercial.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nomeProspecto", "descricao", "valor"})   //somento o ID pq ele é o identificador
public class Oportunidade {    //representar uma tabela no banco de dados

	private Long id;
	private String nomeProspecto;
	private String descricao;
	private BigDecimal valor;
}
