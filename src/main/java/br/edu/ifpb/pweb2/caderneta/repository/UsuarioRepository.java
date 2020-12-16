package br.edu.ifpb.pweb2.caderneta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.pweb2.caderneta.business.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("from Usuario t where t.email = :login")
	Usuario findByLogin(@Param("login") String login);
	
}
