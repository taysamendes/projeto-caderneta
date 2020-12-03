package br.edu.ifpb.pweb2.caderneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.caderneta.entity.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}
