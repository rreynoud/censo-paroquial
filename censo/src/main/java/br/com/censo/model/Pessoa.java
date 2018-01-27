package br.com.censo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PESSOA")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
//	@Column(name="family_id", insertable=false, updatable=false)
//	private Integer FamilyId;	

	@Column(name = "nome")
	private String nome;

	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@Column(name = "religiao")
	private String religiao;
	
	@Column(name = "sacramentos")
	private String sacramentos;

	@Column(name = "casamento")
	private String casamento;

	@Column(name = "profissao")
	private String profissao;

	
	@Column(name = "dizimista")
	private String dizimista;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@ManyToOne
	@JoinColumn(name = "familia_id", nullable=false)
	private Familia familia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public String getSacramentos() {
		return sacramentos;
	}

	public void setSacramentos(String sacramentos) {
		this.sacramentos = sacramentos;
	}

	public String getCasamento() {
		return casamento;
	}

	public void setCasamento(String casamento) {
		this.casamento = casamento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getDizimista() {
		return dizimista;
	}

	public void setDizimista(String dizimista) {
		this.dizimista = dizimista;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	
	

}
