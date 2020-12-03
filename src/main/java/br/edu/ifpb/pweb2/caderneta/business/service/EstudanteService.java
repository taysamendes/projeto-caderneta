package br.edu.ifpb.pweb2.caderneta.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.pweb2.caderneta.entity.Estudante;
import br.edu.ifpb.pweb2.caderneta.repository.EstudanteRepository;

public class EstudanteService {
	
	@Autowired
	private EstudanteRepository estudanteRepository;

	@Autowired
	public EstudanteService(EstudanteRepository estudanteRepository) {
		super();
		this.estudanteRepository = estudanteRepository;
	}
	
	public List<Estudante> findAll(){
		return estudanteRepository.findAll();
	}
	
	

}
