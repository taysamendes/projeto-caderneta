package br.edu.ifpb.pweb2.caderneta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.caderneta.business.exception.EstudanteException;
import br.edu.ifpb.pweb2.caderneta.business.model.Estudante;
import br.edu.ifpb.pweb2.caderneta.business.service.EstudanteService;
import br.edu.ifpb.pweb2.caderneta.form.EstudanteForm;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	private EstudanteService estudanteService;


	/*
	 * @RequestMapping("/form") private ModelAndView form(ModelAndView
	 * modelAndView){ modelAndView.setViewName("aluno/form");
	 * modelAndView.addObject("estudanteForm", new EstudanteForm()); return
	 * modelAndView; }
	 */
	
	@RequestMapping("/formulario") 
	private ModelAndView form(ModelAndView modelAndView){
		modelAndView.setViewName("estudantes/formulario"); 
		return modelAndView; 
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView cadastrarEstudante(Estudante estudante, ModelAndView modelAndView, RedirectAttributes attr) {
		estudanteService.saveEstudante(estudante);
		modelAndView.setViewName("redirect:/estudantes");
		attr.addFlashAttribute("mensagem", "Estudante foi salvo com sucesso!");
		return modelAndView;
	}
	
	@RequestMapping(value="/editar/{id}")
	private ModelAndView editarEstudante(@PathVariable("id") Integer id, ModelAndView modelAndView) {
		Estudante estudante = estudanteService.findById(id);
		modelAndView.setViewName("estudantes/formulario");
		modelAndView.addObject("estudante", estudante);
		return modelAndView;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView list(ModelAndView modelAndView){
		modelAndView.setViewName("/estudantes/relatorio");
		List<Estudante> estudantes = estudanteService.findAll();
		modelAndView.addObject("estudantes", estudantes);
		return modelAndView;
		/*
		 * try { List<Estudante> estudantes = estudanteService.findAll();
		 * modelAndView.addObject("estudantes", estudantes); } catch (EstudanteException
		 * e) { modelAndView.addObject("mensagem", e.getMessage()); } return
		 * modelAndView;
		 */
	}
	
	
	@RequestMapping(value = "/{id}/delete")
	private ModelAndView delete(@PathVariable("id") Integer id, ModelAndView modelAndView, RedirectAttributes attr) {
		estudanteService.deleteById(id);
		modelAndView.setViewName("redirect:/estudantes");
		attr.addFlashAttribute("mensagem", "Estudante foi deletado com sucesso!");
		return modelAndView;
	}

}
