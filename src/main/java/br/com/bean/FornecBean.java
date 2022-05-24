package br.com.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.dao.FornecDao;
import br.com.entidades.FornecEntidades;
@ManagedBean
@ViewScoped
public class FornecBean {
	
	private FornecDao fornecdao = new FornecDao();
	private FornecEntidades fornecedores = new FornecEntidades();
	private List<FornecEntidades> lista = new ArrayList<FornecEntidades>();
	
	public List <FornecEntidades> getLista () throws ClassNotFoundException, SQLException {
		lista = fornecdao.Listar();
		return lista;
	}
	
	public FornecDao getFornecdao() {
		return fornecdao;
	}
	public void setFornecdao(FornecDao fornecdao) {
		this.fornecdao = fornecdao;
	}
	public FornecEntidades getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(FornecEntidades fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public void setLista(List<FornecEntidades> lista) {
		this.lista = lista;
	}
	
	public void Salvar() throws ClassNotFoundException, SQLException {
		try { if(this.fornecedores.getCodigo() == null) {
			new FornecDao().Salvar(this.fornecedores);
			this.fornecedores = new FornecEntidades();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		} else {
			new FornecDao().Atualizar(fornecedores);
			this.fornecedores = new FornecEntidades();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
		}} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor já existe!"));
	}		
}


	public void Lista() throws ClassNotFoundException, SQLException {
		lista = fornecdao.Listar();		
	}
	
	public void Carregar (FornecEntidades fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public void Deletar (FornecEntidades fornecedores) throws ClassNotFoundException, SQLException {
		new FornecDao().Deletar(fornecedores);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deletado com sucesso!"));
	}
	
}
