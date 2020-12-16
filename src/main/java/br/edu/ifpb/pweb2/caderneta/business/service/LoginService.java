package br.edu.ifpb.pweb2.caderneta.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.caderneta.business.model.Usuario;
import br.edu.ifpb.pweb2.caderneta.repository.UsuarioRepository;
import br.edu.ifpb.pweb2.caderneta.util.PasswordUtil;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario isValido(Usuario usuario) {
		Usuario usuarioBD = usuarioRepository.findByLogin(usuario.getEmail());
		boolean valido = false;
		if (usuarioBD != null) {
			if (PasswordUtil.checkPass(usuario.getSenha(), usuarioBD.getSenha())) {
				valido = true;
			}
		} 
		return valido ? usuarioBD : null;
	}
	
	
}
