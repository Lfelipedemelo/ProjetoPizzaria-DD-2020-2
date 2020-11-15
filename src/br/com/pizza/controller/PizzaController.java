package br.com.pizza.controller;

import java.util.List;

import br.com.pizza.model.bo.PizzaBO;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

public class PizzaController {
	
	private PizzaBO bo = new PizzaBO();

	public String inserirPedido(PizzaVO pVo) {
		if(pVo.getSabor1().isEmpty() || pVo.getSabor2().isEmpty() || pVo.getSabor3().isEmpty() || pVo.getTamanho().isEmpty()
			|| pVo.getValor() == null || pVo.getTelefoneCliente().isEmpty()) {
			return "N�o foi possivel inserir o pedido";
		}
		if(pVo.getSabor2().equals("SELECIONE UM SABOR")) {
			pVo.setSabor2("");
		}
		if(pVo.getSabor3().equals("SELECIONE UM SABOR")) {
			pVo.setSabor3("");
		}
		return bo.inserirPedido(pVo);
	}

	public List<PizzaVO> listarPedidos(PizzaSeletor seletor) {
		
		return bo.listarPedidos(seletor);
	}

}
