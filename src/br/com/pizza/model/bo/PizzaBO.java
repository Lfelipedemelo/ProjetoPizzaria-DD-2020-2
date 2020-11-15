package br.com.pizza.model.bo;

import java.util.List;

import br.com.pizza.model.dao.PizzaDAO;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

public class PizzaBO {
	
	PizzaDAO dao = new PizzaDAO();
	
	public String inserirPedido(PizzaVO pVo) {
		if(dao.inserir(pVo) == null) {
			return "Erro ao cadastrar pedido";
		} else {		
			return "Pedido cadastrado com sucesso";
		}
	}

	public List<PizzaVO> listarPedidos(PizzaSeletor seletor) {
		return dao.listarComSeletor(seletor);
	}

}
