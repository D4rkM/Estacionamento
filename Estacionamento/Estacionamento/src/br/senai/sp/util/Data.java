package br.senai.sp.util;

public class Data {
	public String dataParaMySQL(String data){

		String dataMysql;
		
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);
		
		dataMysql = ano + "-" + mes + "-" + dia;
		
		return dataMysql;
	}
	
	public static String dataParaMovimentacao(String data){
		String dataMovimentacao;
		String dia = data.substring(8, 10);
		String mes = data.substring(5, 7);
		String ano = data.substring(0, 4);
		
		dataMovimentacao = dia + "-" + mes + "-" + ano;
		
		return dataMovimentacao;
	}
}
