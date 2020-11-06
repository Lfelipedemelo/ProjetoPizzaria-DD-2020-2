package br.com.pizza.model.bo;

import br.com.pizza.model.dao.ClienteDAO;
import br.com.pizza.model.vo.ClienteVO;

public class ClienteBO {

	ClienteDAO clienteDAO = new ClienteDAO();
	ClienteVO clienteVO = new ClienteVO();
	
	public String cadastrarCliente(ClienteVO clienteVO) {
		clienteDAO.inserir(clienteVO);
		
		if (clienteVO.getNome() == null || clienteVO.getNome() == "" || clienteVO.getNome().isEmpty() || clienteVO.getNome().length() <3) {
			return "Digite um nome válido!";
		} else if (clienteVO.getEndereco() == null || clienteVO.getEndereco() == "" || clienteVO.getEndereco().isEmpty() || clienteVO.getEndereco().length() <3) {
			return "Digite um Endereço válido!";			
		} else if (clienteVO.getTelefone() == null || clienteVO.getTelefone() == "" || clienteVO.getTelefone().isEmpty() || clienteVO.getTelefone().length() <11) {
			return "Digite um Telefone válido!";
		} else {
				this.cadastrarCliente(clienteVO);
				return "Aluno cadastrado com sucesso!";
			
			}}
		

}