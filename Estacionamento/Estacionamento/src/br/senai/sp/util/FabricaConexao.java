package br.senai.sp.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class FabricaConexao {

	Connection con = null;
	
	public Connection abrirConexao(){
		
		try{
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/estacionamento", "root", "bcd127");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public void fecharConexao(){
		
		if (con != null){
			try{
				con.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
}
