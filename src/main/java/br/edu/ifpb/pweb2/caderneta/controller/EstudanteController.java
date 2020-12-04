package br.edu.ifpb.pweb2.caderneta.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.caderneta.business.exception.EstudanteException;
import br.edu.ifpb.pweb2.caderneta.business.service.EstudanteService;
import br.edu.ifpb.pweb2.caderneta.entity.Estudante;
import br.edu.ifpb.pweb2.caderneta.repository.EstudanteRepository;

@Controller
@RequestMapping("/alunos")
public class EstudanteController {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Autowired
	private EstudanteService estudanteService;


	@RequestMapping("/form")
	private String form() {
		return "aluno/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	private String cadastrar(Estudante estudante) {
		estudanteRepository.saveAndFlush(estudante);
		return "redirect:estudantes";
	}

	@RequestMapping()
	private ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("estudantes/list");
		try {
			List<Estudante> estudantes = estudanteService.findAll();
			modelAndView.addObject("estudantes", estudantes);
		} catch (EstudanteException e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}
		return modelAndView;
	}

	
	
	@RequestMapping("/{id}/estudantes")
	private ModelAndView delete(@PathVariable("id") Integer id,  ModelAndView modelAndView,
			RedirectAttributes attr) {
		estudanteRepository.delete(id);
		modelAndView.setViewName("redirect:/estudantes/list");
		attr.addFlashAttribute("mensagem", "Estudante excluídas!");
		return modelAndView;
	}
	
	
	//private update
}
