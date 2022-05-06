package sc.senai.sa.myphsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sc.senai.sa.myphsa.model.remedio.dto.RemedioDTO;
import sc.senai.sa.myphsa.model.remedio.service.RemedioService;



@Controller
@RequestMapping("/remedios")
public class MyPhController {
		
		@Autowired
		private RemedioService remedioService;
		
		@GetMapping
		public String buscarRemedios(Model model) {
			model.addAttribute("remedios",remedioService.buscarRemedio());
			return "remedios/remedio-list";
		}
		
		@GetMapping("/novo")
		public String novoRemedio(Model model) {
			model.addAttribute("remedio", new RemedioDTO());
			return "remedios/remedio-form";
		}
		
		@GetMapping("/{id}")
		public String buscarRemedioPorID(
			@PathVariable Integer id, Model model) {
			model.addAttribute("remedio", remedioService.buscarRemedioPorID(id));
			return "remedios/remedio-form";
		}
		
		@GetMapping("/excluir/{id}")
		public String excluir(
			@PathVariable Integer id) {
			remedioService.excluirRemedio(id);
			return "redirect:/remedios";
		}
		
		@PostMapping("/salvar")
		public String salvarRemedio(RemedioDTO remedio,Model model) {
			try {
				remedioService.salvarRemedio(remedio);
				return "redirect:/remedios";
			}catch (Exception e) {
				model.addAttribute("mensagem", e.getMessage());
				model.addAttribute("remedio", remedio);
				return "remedios/remedio-form";
			}
			
		}
}
