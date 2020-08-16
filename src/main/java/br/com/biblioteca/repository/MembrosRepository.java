package br.com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.model.Membros;

public interface MembrosRepository extends JpaRepository<Membros, Long>{

}
