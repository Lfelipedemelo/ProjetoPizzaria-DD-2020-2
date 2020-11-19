package br.com.pizza.controller;

import java.util.List;

import br.com.pizza.model.bo.ClienteBO;
import br.com.pizza.model.dao.ClienteDAO;
import br.com.pizza.model.vo.ClienteSeletor;
import br.com.pizza.model.vo.ClienteVO;

public class ClienteController {
	
	ClienteBO clienteBO = new ClienteBO();
	
	public String cadastrarCliente(ClienteVO clienteVO) {
		return clienteBO.cadastrarCliente(clienteVO);
		
	}

	public ClienteVO pesquisarPorTelefone(String telefone) {
		ClienteBO bo = new ClienteBO();
		return bo.pesquisarPorTelefone(telefone);
		
		
	}

	public List<ClienteVO> listarClientes(ClienteSeletor seletor) {
		return clienteBO.listarClientes(seletor);
	}

	public boolean excluirCliente(ClienteVO clienteVO) {
			return clienteBO.excluirCliente(clienteVO);
		
	}


	
}
