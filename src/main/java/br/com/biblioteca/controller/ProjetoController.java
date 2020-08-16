package br.com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.biblioteca.model.Membros;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.MembrosRepository;
import br.com.biblioteca.repository.PessoaRepository;
import br.com.biblioteca.repository.ProjetoRepository;

@Controller
public class ProjetoController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	@Autowired
	MembrosRepository membrosRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("projeto/index");
		List<Projeto> listProjeto = projetoRepository.findAll();
		mav.addObject("listProjeto",listProjeto);
		return mav;
	}
	
	@RequestMapping(value="/formProjeto", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("projeto/form");
		List<Pessoa> listPessoa = pessoaRepository.findAllByFuncionario(true);
		mav.addObject("listPessoas", listPessoa);
		Projeto projeto = new Projeto();
		mav.addObject("projeto", projeto);
		return mav;
	}

	@RequestMapping(value = "/doFormProjeto", method = RequestMethod.POST)
	public RedirectView salvar(Projeto projeto, BindingResult result) {
		try {
			projetoRepository.save(projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView("/", true);
	}
	
	@RequestMapping(value="/editProjeto", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam Long idProjeto) {
		ModelAndView mav = new ModelAndView("projeto/form");
		try {
			Projeto projeto = new Projeto();
			if(idProjeto != null) {
				projeto = projetoRepository.findById(idProjeto);
			} 
			
			List<Pessoa> listPessoa = pessoaRepository.findAllByFuncionario(true);
			mav.addObject("listPessoas", listPessoa);
			mav.addObject("projeto", projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/deleteProjeto", method = RequestMethod.GET)
	public RedirectView delete(@RequestParam Long idProjeto) {
		Projeto projeto = projetoRepository.findById(idProjeto);
		try {
			if(projeto != null) {
				projetoRepository.delete(projeto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView("/", true);
	}
	
	@RequestMapping(value = "/doFind", method = RequestMethod.POST)
	public ModelAndView doFind(String filter) {
		ModelAndView modelView = new ModelAndView("projeto/index");
		List<Projeto> listProjeto= projetoRepository.listProjetoNome(filter);
		modelView.addObject("listProjeto",listProjeto);
		return modelView;
	}

}