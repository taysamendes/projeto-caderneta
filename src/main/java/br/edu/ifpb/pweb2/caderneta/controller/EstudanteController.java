package br.edu.ifpb.pweb2.caderneta.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.caderneta.entity.Estudante;
import br.edu.ifpb.pweb2.caderneta.repository.EstudanteRepository;

@Controller
@RequestMapping("/alunos")
public class EstudanteController {


	@Autowired
	private EstudanteRepository estudanteRepository;
	

	@RequestMapping("/list")
	private ModelAndView list() {
		ModelAndView model = new ModelAndView("estudante/registrarEstudante");
		List<Estudante> estudantes = estudanteRepository.findAll();
		model.addObject("estudantes", estudantes);
		return model;
	}

	@RequestMapping("/registrar")
	private ModelAndView cadastrarEstudante() {
		ModelAndView model = new ModelAndView("estudante/registrarEstudante");
		List<Estudante> estudantes = estudanteRepository.findAll();
		model.addObject("estudantes", estudantes);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrarEstudante(Estudante estudante, String nome, Date dataNasc){
		estudante.setNome(nome);
		estudante.setDataNasc(dataNasc);
		estudanteRepository.saveAndFlush(estudante);
		return "redirect:/estudante";
	}
}
