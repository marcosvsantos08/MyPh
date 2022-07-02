package sc.senai.sa.myphsa;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import sc.senai.sa.myphsa.model.usuario.entity.Usuario;
import sc.senai.sa.myphsa.model.usuario.service.UsuarioService;
@SpringBootTest
class MyphSaApplicationTests {
	@Mock
	private UsuarioService usuarioService ;
	
	@Test
	    public void adicionaUsuario(){

		Usuario user= new Usuario("teste","123456","test@test.com");
		
		
		Mockito.when(usuarioService.salvarUsuario(user)).thenReturn(true);
		// Ação
		Usuario userTest = usuarioService.salvarUsuario("teste","123456","test@test.com");
			
		// Verificações
		assertNull(Usuario);
		Mokito.verify(usuarioReppository.Mokito.times(1)).contains(nome)

		}
	
	    }
	
}
