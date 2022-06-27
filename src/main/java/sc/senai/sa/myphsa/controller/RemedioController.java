package sc.senai.sa.myphsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sc.senai.sa.myphsa.model.remedio.entity.Remedio;
import sc.senai.sa.myphsa.model.remedio.service.RemedioService;


@Controller
@RequestMapping("/remedios")
public class RemedioController {
		
		@Autowired
		private RemedioService remedioService;
		
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Remedio>> buscarRemedios() {
			return new ResponseEntity<>(remedioService.buscarRemedios(), HttpStatus.OK);
		}
		
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> salvarRemedio(@RequestBody Remedio remedio) {
			try {
				remedioService.salvarRemedio(remedio);
				return new ResponseEntity<>(HttpStatus.CREATED);
			} catch (IllegalArgumentException e) {
				return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		@PutMapping("/{id}")
		public ResponseEntity<Void> atualizaRemedio(@RequestBody Remedio remedio, @PathVariable Integer id){
			remedioService.salvarRemedio(remedio);
			return new ResponseEntity<>(HttpStatus.CREATED);
		    
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> excluirRemedio(@PathVariable Integer id) {
			remedioService.excluirRemedio(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
			
}
