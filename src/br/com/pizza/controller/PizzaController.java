package br.com.pizza.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.pizza.model.bo.PizzaBO;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

public class PizzaController {

	private PizzaBO bo = new PizzaBO();

	public String inserirPedido(PizzaVO pVo) {
		if (isNullOrEmpty(pVo.getSabor1()) || isNullOrEmpty(pVo.getSabor2()) || isNullOrEmpty(pVo.getSabor3())
				|| isNullOrEmpty(pVo.getTamanho()) || pVo.getValor() == null || pVo.getTelefoneCliente().isEmpty()) {
			return "Não foi possivel inserir o pedido";
		}
		if (pVo.getSabor2().equals("SELECIONE UM SABOR")) {
			pVo.setSabor2("");
		}
		if (pVo.getSabor3().equals("SELECIONE UM SABOR")) {
			pVo.setSabor3("");
		}
		return bo.inserirPedido(pVo);
	}

	public List<PizzaVO> listarPedidos(PizzaSeletor seletor) {
		return bo.listarPedidos(seletor);
	}

	private boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	public boolean excluirPedido(int idPizza) {
		return bo.excluirPedido(idPizza);
	}

	public boolean atualizarPedido(PizzaVO pVo) {
		if (isNullOrEmpty(pVo.getSabor1()) || isNullOrEmpty(pVo.getSabor2()) || isNullOrEmpty(pVo.getSabor3())
			|| isNullOrEmpty(pVo.getTamanho()) || pVo.getValor() == null || pVo.getTelefoneCliente().isEmpty()) {
			return false;
		} else {
			if (pVo.getSabor2().equals("SELECIONE UM SABOR")) {
				pVo.setSabor2("");
			}
			if (pVo.getSabor3().equals("SELECIONE UM SABOR")) {
				pVo.setSabor3("");
			}
			return bo.atualizarPedido(pVo);
		}
	}
}
