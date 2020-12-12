package br.edu.ifpb.pweb2.caderneta.business.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.caderneta.business.model.Estudante;
import br.edu.ifpb.pweb2.caderneta.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository estudanteRepository;

	@Autowired
	public EstudanteService(EstudanteRepository estudanteRepository) {
		super();
		this.estudanteRepository = estudanteRepository;
	}
	
	
	@Transactional
	public void saveEstudante(Estudante estudante) {
			estudanteRepository.saveAndFlush(estudante);
	}
	
	public Estudante findById(Integer id) {
		Optional<Estudante> opEstudante = estudanteRepository.findById(id);
		return opEstudante.isPresent() ? opEstudante.get() : null; 
	}
	
	@Transactional
	public void deleteById(Integer id) {
		estudanteRepository.deleteById(id);
	}
	
	public List<Estudante> findAll(){
		return estudanteRepository.findAll();
	}
	

		

}
