package com.petcare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PetCare {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // FUNCIONA COM O MYSQL
	@GeneratedValue(generator = "increment") //Característica de atribuição de ID do Postgre
	@GenericGenerator(name="increment", strategy ="increment") //Característica de atribuição de ID do Postgre
	private Long id;
	private String solicitante;
	private String soliContato;
	private String tipo;
	private String descricao;
	private String localizacao;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getSoliContato() {
		return soliContato;
	}
	public void setSoliContato(String soliContato) {
		this.soliContato = soliContato;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;		
		PetCare other = (PetCare) obj;
		if (id == null) {	
		if (other.id != null)
			return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
