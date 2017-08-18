package com.crud.financeiro.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "titulo")
public class Titulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_de_emissao")
	private Date dataDeEmissao;
	
	private String descricao;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_de_validade")
	private Date dataDeValidade;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_do_pagamento")
	private Date dataDoPagamento;

	private BigDecimal valor;

	@Column(name = "valor_pago")
	private BigDecimal valorPago;

	@Column(name = "valor_original")
	private BigDecimal valorOriginal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entidadeId")
	private Entidade entidade;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_pagamento_id")
	private TipoDePagamento tipoDePagamento;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public Date getDataDeEmissao() {
		return dataDeEmissao;
	}

	public void setDataDeEmissao(Date dataDeEmissao) {
		this.dataDeEmissao = dataDeEmissao;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(Date dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	public Date getDataDoPagamento() {
		return dataDoPagamento;
	}

	public void setDataDoPagamento(Date dataDoPagamento) {
		this.dataDoPagamento = dataDoPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public TipoDePagamento getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(TipoDePagamento tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Titulo{codigo=" + codigo + ", dataDeEmissao=" + dataDeEmissao + ", descricao=" + descricao
				+ ", dataDeValidade=" + dataDeValidade + ", dataDoPagamento=" + dataDoPagamento + ", valor=" + valor
				+ ", valorPago=" + valorPago + ", valorOriginal=" + valorOriginal + ", entidade=" + entidade
				+ ", tipoDePagamento=" + tipoDePagamento + ", tipo=" + tipo + ", situacao=" + situacao + "}";
	}
	
	

}
