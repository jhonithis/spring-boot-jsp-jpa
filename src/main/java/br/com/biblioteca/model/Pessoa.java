package br.com.biblioteca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Inheritance( strategy = InheritanceType.JOINED )
public class Pessoa implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -331301504565905710L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@NotNull
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private String cpf;
	
	private Boolean funcionario;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	Projeto projeto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Boolean getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}

}
