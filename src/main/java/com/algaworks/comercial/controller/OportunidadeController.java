package com.algaworks.comercial.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.algaworks.comercial.model.Oportunidade;
import com.algaworks.comercial.repository.OportunidadeRepository;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {
	
	@Autowired
	private OportunidadeRepository oportunidades;
	
	@GetMapping
	public List<Oportunidade> listar() {   	//retornar uma lista de oportunidades do banco de dados
		return oportunidades.findAll(); 	//Select na tabela do banco de dados.
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Oportunidade> buscar(@PathVariable Long id) {
		Optional<Oportunidade> oportunidade = oportunidades.findById(id);
		
		if(oportunidade.isEmpty()) { 					//se estiver vazio. 
			return ResponseEntity.notFound().build();	// vamos retornar um response entity (notfund = status 404)
		}
		
		return ResponseEntity.ok(oportunidade.get());
	}
	
	@PostMapping                 			// requestbody pega o json e transforma em um objeto java
	@ResponseStatus(HttpStatus.CREATED)		// Retornar status 201 created.
	public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade) { 		//inclusao de oportunidades na nossa API
		Optional<Oportunidade> oportunidadeExistente = oportunidades
				.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), 
						oportunidade.getNomeProspecto());   //evitar que uma oportunidade se repita
		
		if(oportunidadeExistente.isPresent()) {		//se já existe uma oportunidade com os mesmos dados.
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,	//lançar uma exceção - retornar um BAD REQUEST
					"Já existe uma oportunidade para esse prospecto com a mesma descrição.");
		}
			
		return oportunidades.save(oportunidade);	// se não existe uma oportunidade, então salve.
	}
}
