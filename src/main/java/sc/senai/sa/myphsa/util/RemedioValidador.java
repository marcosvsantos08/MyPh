package sc.senai.sa.myphsa.util;

import org.springframework.stereotype.Component;

import sc.senai.sa.myphsa.model.remedio.entity.Remedio;

@Component
public class RemedioValidador {
	
	public String validarRemedio(Remedio remedio) {
		if(remedio==null) {
			return "O remedio não foi preenchido corretamente.";
		}
		if(remedio.getNomeRemedio()==null|| remedio.getNomeRemedio().isEmpty()) {
			return "O nome do remedio é obrigatorio.";			
		}
		if(remedio.getVencimento()==null|| remedio.getVencimento().isEmpty()) {
			return "A data de validade do remedio é obrigatorio.";			
		}
		return "";
	}
}
