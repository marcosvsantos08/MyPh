package sc.senai.sa.myphsa.model.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sc.senai.sa.myphsa.model.usuario.entity.Usuario;
import sc.senai.sa.myphsa.model.usuario.repository.UsuarioRepository;
import sc.senai.sa.myphsa.util.UsuarioValidador;
import sc.senai.sa.myphsa.seguranca.JWTHelper;




@Service
public class UsuarioService {
	@Autowired
	private UsuarioValidador usuarioValidador;
	@Autowired
	private JWTHelper jwtHelper;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarUsuario() {
		return usuarioRepository.findAll();
		
	}
	public String efetuarLogin(Usuario usuario) {
		Usuario usuarioLogado = usuarioRepository.findByEmail(usuario.getEmail());
		
		if (usuarioLogado == null || 
			!new BCryptPasswordEncoder()
				.matches(usuario.getSenha(), usuarioLogado.getSenha())) {
			throw new IllegalArgumentException("Usuário Inválido");
		}
		
		return jwtHelper.gerarToken(usuarioLogado);
	}
	public void salvarUsuario(Usuario usuario) {
		String mensagemValidacao = usuarioValidador.validarUsuario(usuario);
		if (!mensagemValidacao.isEmpty()) {
			throw new IllegalArgumentException(mensagemValidacao);
			
		}	
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
	
	public void excluirUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
}