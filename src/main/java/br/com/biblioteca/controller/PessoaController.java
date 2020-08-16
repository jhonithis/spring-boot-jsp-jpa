package br.com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired PessoaRepository pessoaRepository;
	
	
	@RequestMapping(value="/pessoa", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("pessoa/index");
		List<Pessoa> listPessoa = pessoaRepository.findAll();
		mav.addObject("listPessoa",listPessoa);
		return mav;
	}
	
	@RequestMapping(value="/formPessoa", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("pessoa/form");
		Pessoa pessoa = new Pessoa();
		modelAndView.addObject("pessoa", pessoa);
		return modelAndView;
	}
	
	@RequestMapping(value = "/doFormPessoa", method = RequestMethod.POST)
	public RedirectView salvar(Pessoa pessoa) {
		try {
			pessoaRepository.save(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView("/", true);
	}
}
