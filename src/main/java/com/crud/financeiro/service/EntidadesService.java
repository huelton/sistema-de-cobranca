package com.crud.financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.financeiro.model.Entidade;
import com.crud.financeiro.respository.Entidades;

@Service
public class EntidadesService {

	@Autowired
	private Entidades entidades;

	public void salvar(Entidade entidade) {

		entidades.save(entidade);
	}
	
	public void remover(Long codigo) {

		entidades.delete(codigo);;
	}

}
