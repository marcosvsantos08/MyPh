package sc.senai.sa.myphsa.model.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sc.senai.sa.myphsa.model.usuario.entity.Usuario;
import sc.senai.sa.myphsa.model.usuario.repository.UsuarioRepository;



@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarUsuario() {
		return usuarioRepository.findAll();
		
	}
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void excluirUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
}