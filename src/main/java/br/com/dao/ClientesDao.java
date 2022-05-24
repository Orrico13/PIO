package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.entidades.ClientesEntidades;
import br.com.util.ConexaoBanco;

public class ClientesDao {
	
	public void Salvar (ClientesEntidades clientes) throws ClassNotFoundException, SQLException{
		Connection con = new ConexaoBanco().Conectar();
		String sql = "insert into clientes (nome, nascimento, sexo, telefone, email, cidade, estado) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, clientes.getNome());
		pst.setString(2, clientes.getNascimento());
		pst.setString(3, clientes.getSexo());
		pst.setString(4, clientes.getTelefone());
		pst.setString(5, clientes.getEmail());
		pst.setString(6, clientes.getCidade());
		pst.setString(7, clientes.getEstado());
		pst.execute();
	}
	
	public void Deletar (ClientesEntidades clientes) throws ClassNotFoundException, SQLException {
		Connection con = new ConexaoBanco().Conectar();
		String sql = "delete from clientes where codigo = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, clientes.getCodigo());
		pst.execute();
	}
	
	public void Atualizar (ClientesEntidades clientes) throws ClassNotFoundException, SQLException {
		Connection con = new ConexaoBanco().Conectar();
		String sql = "update clientes set nome = ?, nascimento = ?, sexo = ?, telefone = ?, email = ?, cidade = ?, estado = ? where codigo = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, clientes.getNome());
		pst.setString(2, clientes.getNascimento());
		pst.setString(3, clientes.getSexo());
		pst.setString(2, clientes.getTelefone());
		pst.setString(3, clientes.getEmail());
		pst.setString(4, clientes.getCidade());
		pst.setString(5, clientes.getEstado());
		pst.setInt(6, clientes.getCodigo());
		pst.execute();
	}
	
	public List <ClientesEntidades> Listar () throws ClassNotFoundException, SQLException{
		Connection con = new ConexaoBanco().Conectar();
		List<ClientesEntidades> lista = new ArrayList<ClientesEntidades>();
		String sql = "select * from clientes";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.execute();
		ResultSet rst = pst.getResultSet();
		while (rst.next()) {
			ClientesEntidades clientes = new ClientesEntidades();
			clientes.setCodigo(rst.getInt("codigo"));
			clientes.setNome(rst.getString("nome"));
			clientes.setNascimento(rst.getString("nascimento"));
			clientes.setSexo(rst.getString("sexo"));
			clientes.setTelefone(rst.getString("telefone"));
			clientes.setEmail(rst.getString("email"));
			clientes.setCidade(rst.getString("cidade"));
			clientes.setEstado(rst.getString("estado"));
			lista.add(clientes);
		}return lista;
	}
	
	
	
}
