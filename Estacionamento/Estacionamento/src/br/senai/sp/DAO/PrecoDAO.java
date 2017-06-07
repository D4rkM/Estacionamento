package br.senai.sp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.senai.sp.models.Preco;
import br.senai.sp.util.FabricaConexao;

public class PrecoDAO {
	
	public ArrayList<Preco> mostarPrecos(){
		ArrayList<Preco> preco = new ArrayList<Preco>();
		
		String sql = "SELECT * FROM tbl_preco";
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		ResultSet rs;
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Preco precos = new Preco();
				precos.setIdPreco(rs.getInt("idPreco"));
				precos.setPrimeiraHora(rs.getFloat("primeiraHora"));
				precos.setDemaisHoras(rs.getFloat("demaisHoras"));
				precos.setDiaria(rs.getFloat("diaria"));
				precos.setMensalidade(rs.getFloat("mensalidade"));
				precos.setIdTipo(rs.getInt("idTipo"));
				precos.setTolerancia(rs.getInt("tolerancia"));
				preco.add(precos);				
			}
			
			fab.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preco;
	}
}
