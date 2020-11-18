package br.com.pizza.model.vo;

public class ClienteSeletor {
		
	private int idCliente;
	private String nome;
	private String telefone;
	private String endereco;
	
	
	private int limite;
	private int pagina;
	
	

	public ClienteSeletor(int idCliente, String nome, String telefone, String endereco, int limite, int pagina) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.limite = limite;
		this.pagina = pagina;
	}
	

	public ClienteSeletor() {
		super();
	}



	public void ProdutoSeletor() {
		this.limite = 5;
		this.pagina = 0;
	}
	
	public boolean temFiltro() {
		if (this.idCliente > 0) {
			return true;
		}
		if ((this.telefone != null) && (this.telefone.trim().length() > 0)) {
			return true;
		}
		if ((this.nome != null) && (this.nome.trim().length() > 0)) {
			return true;
		}
		return false;
	}
	
	public boolean temPaginacao() {
		if(this.limite > 0 && this.pagina > -1){
			return true;
		}
		return false;
	}


	public int getOffset() {
		return (this.limite * (this.pagina - 1));
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public int getLimite() {
		return limite;
	}


	public void setLimite(int limite) {
		this.limite = limite;
	}


	public int getPagina() {
		return pagina;
	}


	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	
	
}
