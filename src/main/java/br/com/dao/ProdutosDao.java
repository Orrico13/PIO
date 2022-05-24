package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.entidades.ProdEntidades;
import br.com.util.ConexaoBanco;


public class ProdutosDao {
	


	public void Salvar(ProdEntidades produtos) throws ClassNotFoundException, SQLException {
	Connection con = new ConexaoBanco().Conectar();
		String sql = "insert into produtos (descricao, unidade, valor) values (?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString (1, produtos.getDescricao());
		pst.setString(2, produtos.getUnidade());
		pst.setDouble(3, produtos.getValor());
		pst.execute();

	}
	
	public void Deletar (ProdEntidades produtos) throws ClassNotFoundException, SQLException {
		Connection con = new ConexaoBanco().Conectar();
		String sql = "delete from produtos where codigo = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, produtos.getCodigo());
		pst.execute();
	}
	
	public void Atualizar (ProdEntidades produtos) throws ClassNotFoundException, SQLException {
		Connection con = new ConexaoBanco().Conectar();
		String sql = "update produtos set descricao = ?, unidade = ?, valor = ? where codigo = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, produtos.getDescricao());
		pst.setString(2, produtos.getUnidade());
		pst.setDouble(3, produtos.getValor());
		pst.setInt(4, produtos.getCodigo());
		pst.execute();
	}
	
	public List <ProdEntidades> Listar () throws ClassNotFoundException, SQLException{
		Connection con = new ConexaoBanco().Conectar();
		List<ProdEntidades> lista = new ArrayList<ProdEntidades>();
		String sql = "select * from produtos";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.execute();
		ResultSet rst = pst.getResultSet();
		while (rst.next()) {
			ProdEntidades produtos = new ProdEntidades();
			produtos.setCodigo(rst.getInt("codigo"));
			produtos.setDescricao(rst.getString("descricao"));
			produtos.setUnidade(rst.getString("unidade"));
			produtos.setValor(rst.getDouble("valor"));
			lista.add(produtos);
		}return lista;
	}
	

	}
 

