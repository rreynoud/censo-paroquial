package br.com.censo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "FAMILIA")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Familia extends AbstractEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "sobrenome")
	private String sobreNome;

	@Column(name = "setor")
	private String setor;

	@Column(name = "quadra_numero")
	private String quadraNumero;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "numero")
	private String numero;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="familia")
	private List<Pessoa> integrantes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getQuadraNumero() {
		return quadraNumero;
	}

	public void setQuadraNumero(String quadraNumero) {
		this.quadraNumero = quadraNumero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Pessoa> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Pessoa> integrantes) {
		this.integrantes = integrantes;
	}

	
	

}
