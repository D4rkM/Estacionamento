package br.senai.sp.models;

import java.util.Date;

public class Caixa {
	
	private int idCaixa;
	private Date dtAbertura;
	private Date dtFechamento;
	private float valorAbertura;
	private float valorFechamento;

	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	
	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public float getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(float valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public float getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(float valorFechamento) {
		this.valorFechamento = valorFechamento;
	}

	public int getIdCaixa() {
		return idCaixa;
	}

}
