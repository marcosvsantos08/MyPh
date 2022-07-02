package sc.senai.sa.myphsa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sc.senai.sa.myphsa.model.usuario.entity.Usuario;
import sc.senai.sa.myphsa.model.usuario.service.UsuarioService;



@RestController
@RequestMapping(path = "/usuario")

public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarUsuario() {
		return new ResponseEntity<>(usuarioService.buscarUsuario(), HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<String> efetuarLogin(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.efetuarLogin(usuario), HttpStatus.OK);
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioService.salvarUsuario(usuario);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizaUsuario(@RequestBody Usuario usuario, @PathVariable Integer id){
		usuarioService.salvarUsuario(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	    
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
		usuarioService.excluirUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
