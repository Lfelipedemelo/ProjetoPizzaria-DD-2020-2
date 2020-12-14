package br.com.pizza.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.pizza.Banco;
import br.com.pizza.model.vo.ClienteSeletor;
import br.com.pizza.model.vo.ClienteVO;
import br.com.pizza.model.vo.PizzaVO;

public class ClienteDAO implements BaseDAO<ClienteVO> {

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public ClienteVO inserir (ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		
		String sql = "INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO) "
				+ "VALUES (?,?,?)";
		
		PreparedStatement query = Banco.getPreparedStatement (conn, sql);
		
		try {
			query.setString(1, clienteVO.getNome());
			query.setString(2, clienteVO.getTelefone());
			query.setString(3, clienteVO.getEndereco());
			
			query.execute();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir cliente.\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
				
		return clienteVO;
	}
	
	
	public boolean excluir(int idCliente) {
	Connection conn = Banco.getConnection();
    String sql = " DELETE FROM CLIENTE WHERE IDCLIENTE=? ";

    PreparedStatement query = Banco.getPreparedStatement(conn, sql);
    boolean excluiu = false;
    		
    try {
        query.setInt(1, idCliente);

        int codigoRetorno = query.executeUpdate();
        excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
    } catch (SQLException e) {
        System.out.println("Erro ao excluir cliente (id: " + idCliente + ") .\nCausa: " + e.getMessage());
    }finally {
        Banco.closeStatement(query);
        Banco.closeConnection(conn);
    }

    return excluiu;
}
	
	public boolean alterar(ClienteVO clienteVO) {
		String sql = " UPDATE CLIENTE "
				+ " SET NOME=?, TELEFONE=?, ENDERECO=? " 
				+ " WHERE IDCLIENTE=? ";
		
		boolean alterou = false;
		
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
			
			query.setString(1, clienteVO.getNome());
			query.setString(2, clienteVO.getTelefone());
			query.setString(3, clienteVO.getEndereco());
			query.setInt(4, clienteVO.getIdCliente());
			
			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar cliente.\nCausa: " + e.getMessage());
		}
				
		return alterou;
	}
	
	public ClienteVO pesquisarPorId(int idCliente) {
		String sql = " SELECT * FROM CLIENTE WHERE IDCLIENTE=? ";
		ClienteVO clienteBuscado = null;
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setInt(1, idCliente);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				clienteBuscado = construirDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por Id (id: " + idCliente + ") .\nCausa: " + e.getMessage());
		}
		
		return clienteBuscado;
	}
	
	public ClienteVO construirDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		ClienteVO clienteBuscado = new ClienteVO();
		clienteBuscado.setIdCliente(conjuntoResultante.getInt("IdCliente"));
		clienteBuscado.setNome(conjuntoResultante.getString("Nome"));
		clienteBuscado.setTelefone(conjuntoResultante.getString("Telefone"));
		clienteBuscado.setEndereco(conjuntoResultante.getString("Endereco"));
		return clienteBuscado;
	}
	


	public List<ClienteVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE ";
		
		
		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<ClienteVO> clientesBuscados = new ArrayList<ClienteVO>();
		
		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while(conjuntoResultante.next()) {
				ClienteVO clienteBuscado = construirDoResultSet(conjuntoResultante);
				clientesBuscados.add(clienteBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os clientes .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		
		return clientesBuscados;
	}


	public ClienteVO pesquisarPorTelefone(String telefone) {
		String sql = " SELECT * FROM CLIENTE WHERE TELEFONE=? ";
		ClienteVO clienteBuscado = null;
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, telefone);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				clienteBuscado = construirDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por telefone (telefone: " + telefone + ") .\nCausa: " + e.getMessage());
		}
		
		return clienteBuscado;
	}


	public boolean clienteJaCadastrado(String telefone) {
		boolean existe = false;
		String sql = " SELECT * FROM CLIENTE WHERE TELEFONE=? ";
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, telefone);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por telefone (telefone: " + telefone + ") .\nCausa: " + e.getMessage());
		}
		return existe;
	}


	public List<ClienteVO> listarComSeletor(ClienteSeletor seletor) {
		String sql = " SELECT * FROM CLIENTE";

		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);
		}

		if (seletor.temPaginacao()) {
			sql += " LIMIT " + seletor.getLimite() + " OFFSET " + seletor.getOffset();
		}
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				ClienteVO c = construirDoResultSet(result);
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}


	private String criarFiltros(ClienteSeletor seletor, String sql) {
		// Tem pelo menos UM filtro
		sql += " WHERE ";
		boolean primeiro = true;

		if ((seletor.getNome() != null) && (seletor.getNome().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "NOME LIKE '%" + seletor.getNome() + "%'";
			primeiro = false;
		}

		if (seletor.getIdCliente() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "IDCLIENTE LIKE '" + seletor.getIdCliente() + "%'";
			primeiro = false;
		}
		
		if ((seletor.getTelefone() != null) && (seletor.getTelefone().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "TELEFONE LIKE '" + seletor.getTelefone() + "%'";
			primeiro = false;
		}
		
		return sql;
	}
}
