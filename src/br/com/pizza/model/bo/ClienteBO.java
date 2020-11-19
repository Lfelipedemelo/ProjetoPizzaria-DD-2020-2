package br.com.pizza.model.bo;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.pizza.model.dao.ClienteDAO;
import br.com.pizza.model.vo.ClienteSeletor;
import br.com.pizza.model.vo.ClienteVO;


public class ClienteBO {

	ClienteDAO clienteDAO = new ClienteDAO();
	ClienteVO clienteVO = new ClienteVO();
	
	public String cadastrarCliente(ClienteVO clienteVO) {
		
		
		if (clienteVO.getNome() == null || clienteVO.getNome() == "" || clienteVO.getNome().isEmpty() || clienteVO.getNome().length() <3) {
			return "Digite um nome válido!";
		} else if (clienteVO.getEndereco() == null || clienteVO.getEndereco() == "" || clienteVO.getEndereco().isEmpty() || clienteVO.getEndereco().length() <3) {
			return "Digite um Endereço válido!";			
		} else if (clienteVO.getTelefone() == null || clienteVO.getTelefone() == "" || clienteVO.getTelefone().isEmpty() || clienteVO.getTelefone().length() <11) {
			return "Digite um Telefone válido!";
		} else if(clienteDAO.clienteJaCadastrado(clienteVO.getTelefone())) {
			return "Já possui um cliente com este telefone cadastrado";
		}else {
				clienteDAO.inserir(clienteVO);
				return "Cliente cadastrado com sucesso!";
			
			}}

	public ClienteVO pesquisarPorTelefone(String telefone) {
		if(telefone.length() == 11) {
			if(clienteDAO.pesquisarPorTelefone(telefone) == null) {
				JOptionPane.showMessageDialog(null, "Não existe nenhum cliente com este telefone cadastrado");		
				return null;
			} else {
				return clienteDAO.pesquisarPorTelefone(telefone);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor digite um telefone valido");
			return null;
		}
	}

	public List<ClienteVO> listarClientes(ClienteSeletor seletor) {
		return clienteDAO.listarComSeletor(seletor);
	}

	public boolean excluirCliente(ClienteVO clienteVO) {
			boolean excluiu = clienteDAO.excluir(clienteVO.getIdCliente());
			
			return excluiu;
	}
	

	
	
}