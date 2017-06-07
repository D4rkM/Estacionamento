package br.senai.sp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.senai.sp.models.Movimentacao;
import br.senai.sp.util.FabricaConexao;

public class MovimentacaoDAO {
	public ArrayList<Movimentacao> mostrarMovimentacao(){
		ArrayList<Movimentacao> movimentacao = new ArrayList<Movimentacao>();
		
		String sql = "SELECT * FROM tbl_movimentacao";
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		ResultSet rs;
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Movimentacao mov = new Movimentacao();
				mov.setDataEntrada(rs.getDate("dataEntrada"));
				mov.setDataSaida(rs.getDate("dataSaida"));
				mov.setHoraEntrada(rs.getString("horaEntrada"));
				mov.setHoraSaida(rs.getString("horaSaida"));
				mov.setIdMovimentacao(rs.getInt("idMovimentacao"));
				mov.setPlaca(rs.getString("placa"));
				mov.setTempo(rs.getInt("tempo"));
				mov.setValorPago(rs.getFloat("valorPago"));
				
				movimentacao.add(mov);				
			}
			
			fab.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movimentacao;
	}
	
	public Movimentacao dadosMovimentacao(String placa){
		Movimentacao mov = new Movimentacao();
		
		String sql = "SELECT * FROM tbl_movimentacao WHERE placa = ?";
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		
		try{
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, placa);
			stm.executeQuery();
			fab.fecharConexao();
		}catch (Exception error){
			error.printStackTrace();
		}	
		
		return mov;
	}
}
