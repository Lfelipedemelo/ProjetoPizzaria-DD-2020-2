package br.com.pizza.model.bo;

import br.com.pizza.model.dao.PizzaDAO;
import br.com.pizza.model.vo.PizzaVO;

public class PizzaBO {

	public String inserirPedido(PizzaVO pVo) {
		PizzaDAO dao = new PizzaDAO();
		if(dao.inserir(pVo) == null) {
			return "Erro ao cadastrar pedido";
		} else {		
			return "Pedido cadastrado com sucesso";
		}
	}

}
