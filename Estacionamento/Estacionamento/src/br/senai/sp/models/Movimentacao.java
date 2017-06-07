package br.senai.sp.models;

import java.util.Date;

public class Movimentacao {

	private int idMovimentacao;
	private String placa;
	private Date dataEntrada;
	private Date dataSaida;
	private String horaEntrada;
	private String horaSaida;

	public void setIdMovimentacao(int idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public int getIdMovimentacao() {
		return idMovimentacao;
	}

	private int tempo;
	private float valorPago;
}
