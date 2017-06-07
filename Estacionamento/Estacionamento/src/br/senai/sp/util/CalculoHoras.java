package br.senai.sp.util;

public class CalculoHoras {
	
	public float calculoDeHoras(Double horaEntrada, Double horaSaida){
		float tempoFinal;
		if (horaSaida > horaEntrada){
			tempoFinal = (float) (horaEntrada + (24 - horaSaida));
		} else{
			tempoFinal = (float) (horaSaida - horaEntrada);
		}
		return tempoFinal;
	}
}
