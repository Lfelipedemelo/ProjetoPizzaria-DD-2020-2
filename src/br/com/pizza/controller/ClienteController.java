package br.com.pizza.controller;

import br.com.pizza.model.bo.ClienteBO;
import br.com.pizza.model.dao.ClienteDAO;
import br.com.pizza.model.vo.ClienteVO;

public class ClienteController {

	public String cadastrarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.cadastrarCliente(clienteVO);
		
	}

	
}
