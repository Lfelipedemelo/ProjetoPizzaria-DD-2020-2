package br.com.pizza.model.vo;

public class PizzaSeletor {

	
	private int idPizza;
	private String sabor1;
	private String sabor2;
	private String sabor3;
	private String tamanho;
	private Double valor;
	private String observacoes;
	private String telefoneCliente;
	
	private int limite;
	private int pagina;
	
	
	
	public void ProdutoSeletor() {
		this.limite = 0;
		this.pagina = -1;
	}
	
	public boolean temFiltro() {
		if (this.idPizza > 0) {
			return true;
		}
		if ((this.telefoneCliente != null) && (this.telefoneCliente.trim().length() > 0)) {
			return true;
		}
		return false;
	}
	
	public boolean temPaginacao() {
		return ((this.limite > 0) && (this.pagina > -1));
	}


	public int getOffset() {
		return (this.limite * (this.pagina - 1));
	}


	public int getIdPizza() {
		return idPizza;
	}


	public void setIdPizza(int idPizza) {
		this.idPizza = idPizza;
	}


	public String getSabor1() {
		return sabor1;
	}


	public void setSabor1(String sabor1) {
		this.sabor1 = sabor1;
	}


	public String getSabor2() {
		return sabor2;
	}


	public void setSabor2(String sabor2) {
		this.sabor2 = sabor2;
	}


	public String getSabor3() {
		return sabor3;
	}


	public void setSabor3(String sabor3) {
		this.sabor3 = sabor3;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getObservacoes() {
		return observacoes;
	}


	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	public String getTelefoneCliente() {
		return telefoneCliente;
	}


	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
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
