package br.com.pizza.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.pizza.Banco;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

public class PizzaDAO implements BaseDAO<PizzaVO> {

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public PizzaVO inserir(PizzaVO pizzaVO) {
		Connection conn = Banco.getConnection();

		String sql = "INSERT INTO PIZZA (SABOR1, SABOR2, SABOR3, TAMANHO, VALOR, OBSERVACOES, TELEFONECLIENTE) "
				+ "VALUES (?,?,?,?,?,?,?)";

		PreparedStatement query = Banco.getPreparedStatement(conn, sql);

		try {
			query.setString(1, pizzaVO.getSabor1());
			query.setString(2, pizzaVO.getSabor2());
			query.setString(3, pizzaVO.getSabor3());
			query.setString(4, pizzaVO.getTamanho());
			query.setDouble(5, pizzaVO.getValor());
			query.setString(6, pizzaVO.getObservacoes());
			query.setString(7, pizzaVO.getTelefoneCliente());
			query.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir uma pizza.\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}

		return pizzaVO;
	}

	public boolean excluir(int idPizza) {
		Connection conn = Banco.getConnection();
		String sql = " DELETE FROM PIZZA WHERE IDPIZZA=? ";

		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;

		try {
			query.setInt(1, idPizza);

			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente (id: " + idPizza + ") .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}

		return excluiu;
	}

	public boolean alterar(PizzaVO pizzaVO) {
		String sql = " UPDATE PIZZA " + " SET SABOR1=?, SABOR2=?, SABOR3=?, TAMANHO=?, VALOR=?, OBSERVACOES=? " + " WHERE IDPIZZA=? ";

		boolean alterou = false;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {

			query.setString(1, pizzaVO.getSabor1());
			query.setString(2, pizzaVO.getSabor2());
			query.setString(3, pizzaVO.getSabor3());
			query.setString(4, pizzaVO.getTamanho());
			query.setDouble(5, pizzaVO.getValor());
			query.setString(6, pizzaVO.getObservacoes());
			query.setInt(7, pizzaVO.getIdPizza());

			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar cliente.\nCausa: " + e.getMessage());
		}

		return alterou;
	}

	public PizzaVO pesquisarPorId(int idPizza) {
		String sql = " SELECT * FROM PIZZA WHERE IDPIZZA=? ";
		PizzaVO pizzaBuscada = null;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setInt(1, idPizza);
			ResultSet conjuntoResultante = consulta.executeQuery();

			if (conjuntoResultante.next()) {
				pizzaBuscada = construirDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por Id (id: " + idPizza + ") .\nCausa: " + e.getMessage());
		}

		return pizzaBuscada;
	}

	public PizzaVO construirDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		PizzaVO pizzaBuscada = new PizzaVO();
		pizzaBuscada.setIdPizza(conjuntoResultante.getInt("idPizza"));
		pizzaBuscada.setSabor1(conjuntoResultante.getString("sabor1"));
		pizzaBuscada.setSabor2(conjuntoResultante.getString("sabor2"));
		pizzaBuscada.setSabor3(conjuntoResultante.getString("sabor3"));
		pizzaBuscada.setTamanho(conjuntoResultante.getString("tamanho"));
		pizzaBuscada.setValor(conjuntoResultante.getDouble("valor"));
		pizzaBuscada.setTelefoneCliente(conjuntoResultante.getString("TelefoneCliente"));
		pizzaBuscada.setObservacoes(conjuntoResultante.getString("OBSERVACOES"));
		return pizzaBuscada;
	}

	public List<PizzaVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PIZZA ";

		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<PizzaVO> pizzasBuscadas = new ArrayList<PizzaVO>();

		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while (conjuntoResultante.next()) {
				PizzaVO pizzaBuscada = construirDoResultSet(conjuntoResultante);
				pizzasBuscadas.add(pizzaBuscada);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os clientes .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}

		return pizzasBuscadas;
	}

	public List<PizzaVO> listarComSeletor(PizzaSeletor seletor) {
		String sql = " SELECT * FROM PIZZA";

		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);
		}

		if (seletor.temPaginacao()) {
			sql += " LIMIT " + seletor.getLimite() + " OFFSET " + seletor.getOffset();
		}

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<PizzaVO> pedidos = new ArrayList<PizzaVO>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				PizzaVO p = construirDoResultSet(result);
				pedidos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	private String criarFiltros(PizzaSeletor seletor, String sql) {
		// Tem pelo menos UM filtro
		sql += " WHERE ";
		boolean primeiro = true;

		if (seletor.getIdPizza() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "IDPIZZA LIKE '" + seletor.getIdPizza() + "%'";
			primeiro = false;
		}

		if ((seletor.getTelefoneCliente() != null) && (seletor.getTelefoneCliente().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "TELEFONECLIENTE LIKE '" + seletor.getTelefoneCliente() + "%'";
			primeiro = false;
		}

		return sql;
	}

}
