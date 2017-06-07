package br.senai.sp.models;

public class Preco {

	private int idPreco;
	private float primeiraHora;
	private float demaisHoras;
	private float diaria;
	private float mensalidade;
	private int idTipo;
	private int tolerancia;

	public void setIdPreco(int idPreco) {
		this.idPreco = idPreco;
	}

	public float getPrimeiraHora() {
		return primeiraHora;
	}

	public void setPrimeiraHora(float primeiraHora) {
		this.primeiraHora = primeiraHora;
	}

	public float getDemaisHoras() {
		return demaisHoras;
	}

	public void setDemaisHoras(float demaisHoras) {
		this.demaisHoras = demaisHoras;
	}

	public float getDiaria() {
		return diaria;
	}

	public void setDiaria(float diaria) {
		this.diaria = diaria;
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getTolerancia() {
		return tolerancia;
	}

	public void setTolerancia(int tolerancia) {
		this.tolerancia = tolerancia;
	}

	public int getIdPreco() {
		return idPreco;
	}

}
