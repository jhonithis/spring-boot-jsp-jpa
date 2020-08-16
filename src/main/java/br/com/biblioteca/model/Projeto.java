package br.com.biblioteca.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Projeto implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8272014109225660877L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_previsao_fim")
	private Date dataPrevisaoFim;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_fim")
	private Date dataFim;
	
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoStatus status;
	
	private Double orcamento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoRisco risco;
	
	@OneToMany(mappedBy = "projeto", targetEntity = Membros.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Membros> listMembros = new ArrayList<Membros>();
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgerente")
	private Pessoa pessoa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataPrevisaoFim() {
		return dataPrevisaoFim;
	}
	public void setDataPrevisaoFim(Date dataPrevisaoFim) {
		this.dataPrevisaoFim = dataPrevisaoFim;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoStatus getStatus() {
		return status;
	}
	public void setStatus(TipoStatus status) {
		this.status = status;
	}
	
	public Double getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}
	
	public TipoRisco getRisco() {
		return risco;
	}
	public void setRisco(TipoRisco risco) {
		this.risco = risco;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Membros> getListMembros() {
		return listMembros;
	}
	public void setListMembros(List<Membros> listMembros) {
		this.listMembros = listMembros;
	}

}
