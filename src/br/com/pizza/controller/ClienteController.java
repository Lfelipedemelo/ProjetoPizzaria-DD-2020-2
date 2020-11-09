package br.com.pizza.controller;

import br.com.pizza.model.bo.ClienteBO;
import br.com.pizza.model.vo.ClienteVO;

public class ClienteController {

	public void cadastrarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.cadastrarCliente(clienteVO);
	}

}
