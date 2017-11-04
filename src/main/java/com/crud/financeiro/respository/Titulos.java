package com.crud.financeiro.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.financeiro.model.Entidade;
import com.crud.financeiro.model.Titulo;

@Repository
public interface Titulos extends JpaRepository<Titulo, Long> {

	//List<Titulo> findByDescricaoContainingIgnoreCase(String descricao);

	@Query("select t from Titulo t where t.descricao like %?1% and (t.entidade = ?2 or ?2 is null)")
    List<Titulo> filtrados(String descricao, Entidade entidade);
	
}
