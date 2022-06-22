package sc.senai.sa.myphsa.model.remedio.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import sc.senai.sa.myphsa.model.remedio.dto.RemedioDTO;
import sc.senai.sa.myphsa.model.remedio.entity.Remedio;
import sc.senai.sa.myphsa.model.remedio.repository.RemedioRepository;
import sc.senai.sa.myphsa.util.RemedioValidador;

@Service
public class RemedioService {
	
	@Autowired
	private RemedioValidador remedioValidador;
	
	@Autowired
	private RemedioRepository remedioRepository;
	
	public List<Remedio> buscarRemedios() {
		return remedioRepository.findAll();
		
	}
	public void salvarRemedio(Remedio remedio) {
		String mensagemValidacao = remedioValidador.validarRemedio(remedio);
		if (!mensagemValidacao.isEmpty()) {
			throw new IllegalArgumentException(mensagemValidacao);
		}
				
		remedioRepository.save(remedio);
	}
	
	public void excluirRemedio(Integer id) {
		remedioRepository.deleteById(id);
	}
}
