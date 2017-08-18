package com.crud.financeiro.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.financeiro.model.TipoDePagamento;

@Repository
public interface TiposDePagamentos extends JpaRepository<TipoDePagamento, Long>  {

	
}
