package br.senai.sp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.senai.sp.models.Cliente;
import br.senai.sp.util.FabricaConexao;

public class ClienteDAO {

	public ArrayList<Cliente> mostrarClientes(){
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		
		String sql = "SELECT nome FROM tbl_cliente";
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		ResultSet rs;
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			rs = stm.executeQuery();			
			
			while(rs.next()){
				Cliente c = new Cliente();
				c.setNome(rs.getString("nome"));
				cli.add(c);				
			}
			
			fab.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cli;
	}
	
	public Cliente mostrarDadosCliente(String nome){
		Cliente client = new Cliente();
		
		String sql = "SELECT * FROM tbl_cliente WHERE nome = ?";
		
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		ResultSet rs;
		
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, nome);
			rs = stm.executeQuery();
			
			while (rs.next()){
				
				client.setIdCliente(rs.getInt("idCliente"));
				client.setTelefone(rs.getString("telefone"));
				client.setLogradouro(rs.getString("logradouro"));
				client.setNumero(rs.getInt("numero"));
				client.setBairro(rs.getString("bairro"));
				client.setCidade(rs.getString("cidade"));
				client.setEstado(rs.getString("estado"));
				client.setCep(rs.getString("cep"));
			}
			fab.fecharConexao();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return client;
	}
	
	public boolean salvarCliente(Cliente cli){
		boolean gravado = false;
		
		String sql = "INSERT INTO tbl_cliente(nome, telefone, logradouro, numero,"
				+ " bairro, cidade, estado, cep)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		
		try{
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, cli.getNome());
			stm.setString(2, cli.getTelefone());
			stm.setString(3, cli.getLogradouro());
			stm.setInt(4, cli.getNumero());
			stm.setString(5, cli.getBairro());
			stm.setString(6, cli.getCidade());
			stm.setString(7, cli.getEstado());
			stm.setString(8, cli.getCep());
			
			stm.execute();
			fab.fecharConexao();
			gravado = true;
			
		}catch (SQLException e){
			gravado = false;
			e.printStackTrace();
		}
		
		return gravado;
	}
	
	public boolean alterarCliente(Cliente cli){
		boolean alterado = false;
		
		String sql = "UPDATE tbl_cliente SET nome = ?, telefone = ?, logradouro = ?, numero = ?, "
				+ "bairro = ?, cidade = ?, estado = ?, cep = ? WHERE idCliente = ?";
		
		FabricaConexao fab = new FabricaConexao();
		Connection con = fab.abrirConexao();
		
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setString(1, cli.getNome());
			stm.setString(2, cli.getTelefone());
			stm.setString(3, cli.getLogradouro());
			stm.setInt(4, cli.getNumero());
			stm.setString(5, cli.getBairro());
			stm.setString(6, cli.getCidade());
			stm.setString(7, cli.getEstado());
			stm.setString(8, cli.getCep());
			stm.setInt(9, cli.getIdCliente());
			
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

	public boolean excluirCliente(int id){
		boolean excluido = false;
		
		String sql = "DELETE FROM tbl_cliente WHERE idCliente = ?";
		
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
