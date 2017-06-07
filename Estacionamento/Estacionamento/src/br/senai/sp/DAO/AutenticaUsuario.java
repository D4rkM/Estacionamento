package br.senai.sp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.senai.sp.models.Usuario;
import br.senai.sp.util.FabricaConexao;

public class AutenticaUsuario {
	
	public Usuario validacao(String usuario, String senha){
		Usuario user = new Usuario();
		
		String sql = "SELECT usuario, senha, privilegio, ativo FROM tbl_usuario WHERE usuario = ? AND senha = ?;";
		
		Connection con;
		FabricaConexao fabCon = new FabricaConexao();
		con = fabCon.abrirConexao();
		
		
		try{
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, usuario);
			stm.setString(2, senha);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()){
				user.setUsuario(rs.getString("usuario"));
				user.setSenha(rs.getString("senha"));
				user.setPrivilegio(rs.getString("privilegio"));
				user.setAtivo(rs.getBoolean("ativo"));
			}
			fabCon.fecharConexao();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return user;
	}
}
