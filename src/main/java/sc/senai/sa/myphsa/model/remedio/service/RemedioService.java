package sc.senai.sa.myphsa.model.remedio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sc.senai.sa.myphsa.model.remedio.dto.RemedioDTO;
import sc.senai.sa.myphsa.util.RemedioValidador;

@Service
public class RemedioService {
	
	@Autowired
	private RemedioValidador remedioValidador;
	
	private List<RemedioDTO> remedios = new ArrayList<>();
	
	private List<RemedioDTO> mockRemedios(){
		if (!remedios.isEmpty()) {
			return remedios;
		}
		remedios.add(new RemedioDTO(1,"Parecetamol",4,"10/06/2022" , "link"));
		remedios.add(new RemedioDTO(2,"Dorflex",10,"14/07/2022" , "link"));
		return remedios;
	}
	
	public List<RemedioDTO> buscarRemedio(){
		return mockRemedios();
	}
	public RemedioDTO buscarRemedioPorID(Integer id) {
		return mockRemedios().stream().filter(remedio -> remedio.getId().equals(id)).findAny().orElse(new RemedioDTO());
	}
	
	public void salvarRemedio(RemedioDTO remedio) {
		String mensagemValidacao=remedioValidador.validarRemedio(remedio);
		if (!mensagemValidacao.isEmpty()) {
			throw new IllegalArgumentException(mensagemValidacao);
		}
		if (remedio.getId()!= null) {
			excluirRemedio(remedio.getId());
		}
		remedio.setId(mockRemedios().size()+1);
		mockRemedios().add(remedio);
	}
	
	public void excluirRemedio(Integer id) {
		List<RemedioDTO> remediosAlterados= mockRemedios().stream().filter(remedio->!remedio.getId().equals(id)).collect(Collectors.toList());
		remedios.clear();
		remedios.addAll(remediosAlterados);
	}
}
