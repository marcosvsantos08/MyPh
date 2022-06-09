package sc.senai.sa.myphsa.model.remedio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sc.senai.sa.myphsa.model.usuario.entity.Usuario;


@Entity
public class Remedio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer remedioId;
	@Column(length = 100)
	private String nomeRemedio;
	@Column(length = 100)
	private String vencimento;
	@Column(length = 100)
	private Integer quantidade;
	@Column(length = 100)
	private String bula;
	
	public Integer getRemedioId() {
		return remedioId;
	}
	public void setRemedioId(Integer remedioId) {
		this.remedioId = remedioId;
	}
	public String getNomeRemedio() {
		return nomeRemedio;
	}
	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}
	public String getVencimento() {
		return vencimento;
	}
	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getBula() {
		return bula;
	}
	public void setBula(String bula) {
		this.bula = bula;
	}
	@ManyToOne
	@JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")
	private Usuario usuario;
	
}
