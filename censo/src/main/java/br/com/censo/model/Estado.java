package br.com.censo.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estado  extends AbstractEntity {

	@Id
    @Column(name = "ESTADO_CODIGO")
    private String id;

    @Column(name = "ESTADO_SIGLA")
    private String sigla;

    @Column(name = "REGIAO_CODIGO")
    private String regiaoCodigo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getRegiaoCodigo() {
		return regiaoCodigo;
	}

	public void setRegiaoCodigo(String regiaoCodigo) {
		this.regiaoCodigo = regiaoCodigo;
	}

   
	
}
