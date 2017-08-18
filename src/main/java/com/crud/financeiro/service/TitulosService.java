package com.crud.financeiro.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.financeiro.model.Titulo;
import com.crud.financeiro.respository.Titulos;

@Service
public class TitulosService {

	@Autowired
	private Titulos titulos;

	public void salvar(Titulo titulo) {
		titulo.setDataDeEmissao(new Date());
		titulos.save(titulo);
	}

}
