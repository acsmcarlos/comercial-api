package com.algaworks.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.comercial.model.Oportunidade;

//Buscar e fazer inserções no banco de dados. Classe que faz as pesquisas e todas as operaçoões que precisamos.
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {

}
