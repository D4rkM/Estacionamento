package br.senai.sp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.senai.sp.models.Caixa;
import br.senai.sp.util.FabricaConexao;

public class CaixaDAO {

	public ArrayList<Caixa> abrirCaixa(){
		ArrayList<Caixa> caixa = new ArrayList<Caixa>();
		
		String sql = "SELECT * FROM tbl_caixa";
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		ResultSet rs;
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Caixa valores = new Caixa();
				valores.setDtAbertura(rs.getDate("dtAbertura"));
				valores.setValorAbertura(rs.getFloat("valorAbertura"));
				valores.setDtFechamento(rs.getDate("dtFechamento"));
				valores.setValorFechamento(rs.getFloat("valorFechamento"));
				caixa.add(valores);				
			}
			
			fab.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return caixa;
	}
	
}
