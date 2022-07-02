package sc.senai.sa.myphsa.util;

import org.springframework.stereotype.Component;

import sc.senai.sa.myphsa.model.usuario.entity.Usuario;
@Component
public class UsuarioValidador {
	
		
	public String validarUsuario(Usuario usuario) {
		if(usuario==null) {
			return "O usuario não foi preenchido corretamente.";
		}
		if(usuario.getNome()==null|| usuario.getNome().isEmpty()) {
			return "O nome do usuario é obrigatorio.";			
		}
		if(usuario.getEmail()==null|| usuario.getEmail().isEmpty()) {
			return "O seu e-mail é obrigatorio.";			
		}
			
		return "";
	}
	
}
