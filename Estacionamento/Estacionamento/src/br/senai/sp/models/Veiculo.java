package br.senai.sp.models;

import java.util.Date;

public class Veiculo {
	
	private int idveiculo;
	private String placa;
	private String cor;
	private String modelo;
	private Date ano;
	private int idCliente;
	private int idTipoVeiculo;

	public void setIdveiculo(int idveiculo) {
		this.idveiculo = idveiculo;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTipoVeiculo() {
		return idTipoVeiculo;
	}

	public void setIdTipoVeiculo(int idTipoVeiculo) {
		this.idTipoVeiculo = idTipoVeiculo;
	}

	public int getIdveiculo() {
		return idveiculo;
	}
	
}
