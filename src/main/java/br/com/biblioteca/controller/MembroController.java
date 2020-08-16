package br.com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.biblioteca.repository.MembrosRepository;

@Controller
public class MembroController {
	
	@Autowired
	MembrosRepository membrosRepository;
	
	
	/*
	 * Implementacao da inserção da Pessoa e Projeto na associativa muitos para muitos Membros
	 * Não deu tempo =(
	 */
	
	

}
