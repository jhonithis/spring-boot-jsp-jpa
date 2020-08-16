package br.com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;

@Controller
public class IndexController {
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	@RequestMapping("/index")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("projeto/index");
		List<Projeto> listProjeto = projetoRepository.findAll();
		mav.addObject("listProjeto",listProjeto);
		return mav;
	}
	
}
