package br.com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.biblioteca.model.Projeto;

public interface ProjetoRepository  extends JpaRepository<Projeto, Long>{
	public Projeto findById(Long id);
	
	@Query(" FROM Projeto projeto WHERE nome like %:pFilter%")
	public List<Projeto> listProjetoNome( @Param("pFilter") String filter);
}
