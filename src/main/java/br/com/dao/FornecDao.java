package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.entidades.FornecEntidades;
import br.com.util.ConexaoBanco;

	public class FornecDao {
		
		public void Salvar(FornecEntidades fornecedores) throws ClassNotFoundException, SQLException {
			Connection con = new ConexaoBanco().Conectar();
				String sql = "insert into fornecedores (nome, telefone, email ) values (?, ?, ?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString (1, fornecedores.getNome());
				pst.setString(2, fornecedores.getTelefone());
				pst.setString(3, fornecedores.getEmail());
				pst.execute();

			}
			
			public void Deletar (FornecEntidades fornecedores) throws ClassNotFoundException, SQLException {
				Connection con = new ConexaoBanco().Conectar();
				String sql = "delete from fornecedores where codigo = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, fornecedores.getCodigo());
				pst.execute();
			}
			
			public void Atualizar (FornecEntidades fornecedores) throws ClassNotFoundException, SQLException {
				Connection con = new ConexaoBanco().Conectar();
				String sql = "update fornecedores set nome = ?, telefone = ?, email = ? where codigo = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, fornecedores.getNome());
				pst.setString(2, fornecedores.getTelefone());
				pst.setString(3, fornecedores.getEmail());
				pst.setInt(4, fornecedores.getCodigo());
				pst.execute();
			}
			
			public List <FornecEntidades> Listar () throws ClassNotFoundException, SQLException{
				Connection con = new ConexaoBanco().Conectar();
				List<FornecEntidades> lista = new ArrayList<FornecEntidades>();
				String sql = "select * from fornecedores";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.execute();
				ResultSet rst = pst.getResultSet();
				while (rst.next()) {
					FornecEntidades fornecedores = new FornecEntidades();
					fornecedores.setCodigo(rst.getInt("codigo"));
					fornecedores.setNome(rst.getString("nome"));
					fornecedores.setTelefone(rst.getString("telefone"));
					fornecedores.setEmail(rst.getString("email"));
					lista.add(fornecedores);
				}return lista;
			}
}
