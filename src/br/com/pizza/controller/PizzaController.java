package br.com.pizza.controller;

import br.com.pizza.model.bo.PizzaBO;
import br.com.pizza.model.vo.PizzaVO;

public class PizzaController {

	public String inserirPedido(PizzaVO pVo) {
		PizzaBO bo = new PizzaBO();
		if(pVo.getSabor1().isEmpty() || pVo.getSabor2().isEmpty() || pVo.getSabor3().isEmpty() || pVo.getTamanho().isEmpty()
			|| pVo.getValor() == null || pVo.getTelefoneCliente().isEmpty()) {
			return "Não foi possivel inserir o pedido";
		}
		return bo.inserirPedido(pVo);
	}

}
