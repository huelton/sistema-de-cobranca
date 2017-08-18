package com.crud.financeiro.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.financeiro.model.Titulo;

@Repository
public interface Titulos extends JpaRepository<Titulo, Long>{

}
