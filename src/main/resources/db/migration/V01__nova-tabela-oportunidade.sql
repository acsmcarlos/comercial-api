create table oportunidade (
	id serial PRIMARY KEY,
	nome_prospecto varchar(80) not null,
	descricao varchar(200) not null,
	valor decimal(10,2)
);