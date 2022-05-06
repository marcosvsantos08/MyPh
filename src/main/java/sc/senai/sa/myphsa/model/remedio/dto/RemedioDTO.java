package sc.senai.sa.myphsa.model.remedio.dto;



public class RemedioDTO {
	private Integer id;
	private String nomeRemedio;
	private Integer quantidade;
	private String vencimento;
	private String bulaOnline;
	
	public RemedioDTO() {
		
	}
	public RemedioDTO(Integer id,String nomeRemedio, Integer quantidade, String vencimento, String bulaOnline) {
	this.id=id;
	this.nomeRemedio=nomeRemedio;
	this.quantidade=quantidade;
	this.vencimento=vencimento;
	this.bulaOnline=bulaOnline;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public String getBulaOnline() {
		return bulaOnline;
	}

	public void setBulaOnline(String bulaOnline) {
		this.bulaOnline = bulaOnline;
	}


}
