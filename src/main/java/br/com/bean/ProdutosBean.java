package br.com.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.dao.ProdutosDao;
import br.com.entidades.ProdEntidades;
@ManagedBean
@ViewScoped
public class ProdutosBean {

	private ProdutosDao proddao = new ProdutosDao();
	private ProdEntidades produtos = new ProdEntidades();
	private List<ProdEntidades> lista = new ArrayList<ProdEntidades>();

		

	public List<ProdEntidades> getLista() throws ClassNotFoundException, SQLException {
		this.lista = proddao.Listar();
		return lista;
	}

	public void setLista(List<ProdEntidades> lista) {
		this.lista = lista;
	}


	public ProdutosDao getProddao() {
		return proddao;
	}

	public void setProddao(ProdutosDao proddao) {
		this.proddao = proddao;
	}

	public ProdEntidades getProdutos() {
		return produtos;
	}

	public void setProdutos(ProdEntidades produtos) {
		this.produtos = produtos;
	}

	public void Salvar() throws ClassNotFoundException, SQLException {
		try {	if(this.produtos.getCodigo() == null) {
		new ProdutosDao().Salvar(this.produtos);
		this.produtos = new ProdEntidades();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		} else {
		new ProdutosDao().Atualizar(produtos);
		this.produtos = new ProdEntidades();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
		} } catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto já existe!"));
		}
		
	}
	
	public void Lista() throws ClassNotFoundException, SQLException {
		lista = proddao.Listar();
	}
	
	public void Carregar (ProdEntidades produtos) {
		this.produtos = produtos;
	}
	
	public void Deletar(ProdEntidades produtos) throws ClassNotFoundException, SQLException {
		new ProdutosDao().Deletar(produtos);	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage ("Deletado com sucesso"));
	}
	
	
}
