package br.com.pizza.model.vo;

public class PizzaVO {
	
	private int idPizza;
	private String sabor1;
	private String sabor2;
	private String sabor3;
	private String tamanho;
	private Double valor;
	private String observacoes;
	private String telefoneCliente;
	
	
	public PizzaVO(int idPizza, String sabor1, String sabor2, String sabor3, String tamanho, Double valor, String observacoes, String telefoneCliente) {
		super();
		this.idPizza = idPizza;
		this.sabor1 = sabor1;
		this.sabor2 = sabor2;
		this.sabor3 = sabor3;
		this.tamanho = tamanho;
		this.valor = valor;
		this.observacoes = observacoes;
		this.telefoneCliente = telefoneCliente;
	}


	public PizzaVO() {
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
	
	
}
