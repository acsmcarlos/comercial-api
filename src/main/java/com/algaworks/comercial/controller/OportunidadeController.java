package com.algaworks.comercial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	//inclusao de oportunidades na nossa API
	
}
