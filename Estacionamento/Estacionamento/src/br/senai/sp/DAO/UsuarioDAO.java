package br.senai.sp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.senai.sp.models.Cliente;
import br.senai.sp.models.Usuario;
import br.senai.sp.util.FabricaConexao;

public class UsuarioDAO {

	public ArrayList<Usuario> mostrarUsuario(){
		ArrayList<Usuario> user = new ArrayList<Usuario>();
		
		String sql = "SELECT usuario FROM tbl_usuario";
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		ResultSet rs;
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Usuario u = new Usuario();
				u.setNome(rs.getString("usuario"));
				user.add(u);				
			}
			
			fab.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public Usuario mostrarDadosUsuario(String nome){
		Usuario user = new Usuario();
		
		String sql = "SELECT * FROM tbl_usuario WHERE usuario = ?";
		
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		ResultSet rs;
		
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, nome);
			rs = stm.executeQuery();
			
			while (rs.next()){
				
				user.setIdUsuario(rs.getInt("idUsuario"));
				user.setTelefone(rs.getString("telefone"));
				user.setUsuario(rs.getString("usuario"));
				user.setNome(rs.getString("nome"));
				user.setSenha(rs.getString("senha"));
				user.setPrivilegio(rs.getString("Privilegio"));
				user.setAtivo(rs.getBoolean("ativo"));
			}
			fab.fecharConexao();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}
	
	public boolean salvarUsuario(Usuario us){
		boolean gravado = false;
		
		String sql = "INSERT INTO tbl_usuario(nome, telefone, usuario, senha,"
				+ " privilegio, ativo)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		
		try{
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, us.getNome());
			stm.setString(2, us.getTelefone());
			stm.setString(3, us.getUsuario());
			stm.setString(4, us.getSenha());
			stm.setString(5, us.getPrivilegio());
			stm.setBoolean(6, us.isAtivo());
			
			stm.execute();
			fab.fecharConexao();
			gravado = true;
			
		}catch (SQLException e){
			gravado = false;
			e.printStackTrace();
		}
		
		return gravado;
	}
	
	public boolean alterarUsuario(Usuario us){
		boolean alterado = false;
		
		String sql = "UPDATE tbl_usuario SET nome = ?, telefone = ?, usuario = ?, senha = ?, "
				+ "privilegio = ?, ativo = ?";
		
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, us.getNome());
			stm.setString(2, us.getTelefone());
			stm.setString(3, us.getUsuario());
			stm.setString(4, us.getSenha());
			stm.setString(5, us.getPrivilegio());
			stm.setBoolean(6, us.isAtivo());
			stm.setInt(9, us.getIdUsuario());
			
			stm.execute();
			alterado = true;
			fab.fecharConexao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			alterado = false;
		}
		                                  
		
		return alterado;
	}

	public boolean excluirUsuario(int id){
		boolean excluido = false;
		
		String sql = "DELETE FROM tbl_Usuario WHERE idUsuario = ?";
		
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setInt(1, id);
		
			stm.execute();
			excluido = true;
			fab.fecharConexao();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			excluido = false;
		}
		
		return excluido;
	}
	
}
