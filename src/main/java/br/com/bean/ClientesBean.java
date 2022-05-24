package br.com.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.dao.ClientesDao;
import br.com.entidades.ClientesEntidades;
@ManagedBean
@ViewScoped

public class ClientesBean {
	private ClientesDao clidao = new ClientesDao();
	private ClientesEntidades clientes = new ClientesEntidades();
	private List<ClientesEntidades> lista = new ArrayList<ClientesEntidades>();


	public List <ClientesEntidades> getLista () throws ClassNotFoundException, SQLException {
		lista = clidao.Listar();
		return lista;
	}

	public ClientesDao getClidao() {
		return clidao;
	}

	public void setClidao(ClientesDao clidao) {
		this.clidao = clidao;
	}

	public ClientesEntidades getClientes() {
		return clientes;
	}

	public void setClientes(ClientesEntidades clientes) {
		this.clientes = clientes;
	}

	public void setLista(List<ClientesEntidades> lista) {
		this.lista = lista;
	}
	
	public void Salvar() throws ClassNotFoundException, SQLException {
		try { if(this.clientes.getCodigo() == null) {
			new ClientesDao().Salvar(this.clientes);
			this.clientes = new ClientesEntidades();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		} else {
			new ClientesDao().Atualizar(clientes);
			this.clientes = new ClientesEntidades();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
		}} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente já existe!"));
	}		
}


	public void Lista() throws ClassNotFoundException, SQLException {
		lista = clidao.Listar();		
	}
	
	public void Carregar (ClientesEntidades clientes) {
		this.clientes = clientes;
	}
	
	public void Deletar (ClientesEntidades clientes) throws ClassNotFoundException, SQLException {
		new ClientesDao().Deletar(clientes);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deletado com sucesso!"));
	}
		
	
}
