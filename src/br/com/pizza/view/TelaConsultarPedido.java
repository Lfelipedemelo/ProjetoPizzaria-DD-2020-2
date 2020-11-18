package br.com.pizza.view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.pizza.controller.PizzaController;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;

public class TelaConsultarPedido extends JPanel {
	private JTable tblPedidos;
	private JTextField txtPesquisarPorId;
	private JTextField txtPesquisarPorNumero;
	private JLabel lblPaginaAtual;
	private List<PizzaVO> pedidosConsultados;
	
	private int paginaAtual = 1;
	
	private static final int TAMANHO_PAGINA = 15;
	/**
	 * Create the panel.
	 */
	public TelaConsultarPedido() {
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 11, 980, 140);
		add(panel_2);
		
		JLabel lblConsultarPedido = new JLabel("Consultar Pedido");
		lblConsultarPedido.setIcon(new ImageIcon(TelaConsultarPedido.class.getResource("/br/com/pizza/icons/pizza.png")));
		lblConsultarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarPedido.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel_2.add(lblConsultarPedido);
		
		tblPedidos = new JTable();
		tblPedidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblPedidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPedidos.setModel(new DefaultTableModel(
			new Object[][] {
				{"n\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente", "Observa\u00E7\u00F5es"},
			},
			new String[] {
				"N\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente", "Observa\u00E7\u00F5es"
			}
		));
		tblPedidos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblPedidos.getColumnModel().getColumn(1).setPreferredWidth(53);
		tblPedidos.getColumnModel().getColumn(2).setPreferredWidth(73);
		tblPedidos.getColumnModel().getColumn(5).setPreferredWidth(55);
		tblPedidos.getColumnModel().getColumn(6).setPreferredWidth(203);
		tblPedidos.setBounds(10, 257, 980, 368);
		add(tblPedidos);
		
		lblPaginaAtual = new JLabel("New label");
		lblPaginaAtual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaginaAtual.setBounds(481, 652, 45, 14);
		add(lblPaginaAtual);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(108, 162, 809, 84);
		add(panel);
		panel.setLayout(null);
		
		txtPesquisarPorId = new JTextField();
		txtPesquisarPorId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				consultarPedidos();
			}
		});
		txtPesquisarPorId.setBounds(216, 32, 156, 28);
		panel.add(txtPesquisarPorId);
		txtPesquisarPorId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPesquisarPorId.setColumns(10);
		
		txtPesquisarPorNumero = new JTextField();
		txtPesquisarPorNumero.setBounds(605, 33, 180, 25);
		panel.add(txtPesquisarPorNumero);
		txtPesquisarPorNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				consultarPedidos();
			}
		});
		txtPesquisarPorNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPesquisarPorNumero.setColumns(10);
		
		JLabel lblPesquisarPorNumero = new JLabel("Numero do cliente:");
		lblPesquisarPorNumero.setBounds(404, 28, 191, 32);
		panel.add(lblPesquisarPorNumero);
		lblPesquisarPorNumero.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		
		
		JLabel lblPesquisarPorId = new JLabel("Numero do pedido:");
		lblPesquisarPorId.setBounds(10, 28, 196, 32);
		panel.add(lblPesquisarPorId);
		lblPesquisarPorId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnProximaPagina = new JButton(">");
		btnProximaPagina.setBounds(520, 652, 41, 17);
		add(btnProximaPagina);
		
		JButton btnPaginaAnterior = new JButton("<");
		btnPaginaAnterior.setBounds(408, 652, 41, 17);
		add(btnPaginaAnterior);
		
		//LISTAR TODOS OS PEDIDOS
		consultarPedidos();
		
	}
	
	protected void consultarPedidos() {
		lblPaginaAtual.setText(paginaAtual + "");

		PizzaController controlador = new PizzaController();
		PizzaSeletor seletor = new PizzaSeletor();

		seletor.setPagina(paginaAtual);
		seletor.setLimite(TAMANHO_PAGINA);

		if (txtPesquisarPorId.getText() != null && !txtPesquisarPorId.getText().isEmpty()) {
			seletor.setIdPizza(Integer.parseInt(txtPesquisarPorId.getText()));
		}
		if (txtPesquisarPorNumero.getText() != null && !txtPesquisarPorNumero.getText().isEmpty()) {
			seletor.setTelefoneCliente(txtPesquisarPorNumero.getText());
		}

		//AQUI é feita a consulta dos produtos e atualização na tabela
		List<PizzaVO> pedidos = controlador.listarPedidos(seletor);
		atualizarTabelaPedidos(pedidos);
	}

	private void atualizarTabelaPedidos(List<PizzaVO> pedidos) {
		// atualiza o atributo produtosConsultados
		pedidosConsultados = pedidos;

		this.limparTabela();

		DefaultTableModel modelo = (DefaultTableModel) tblPedidos.getModel();

		for (PizzaVO pedido : pedidos) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela

			String[] novaLinha = new String[] { 
					pedido.getIdPizza() + "", 
					pedido.getTamanho(), 
					pedido.getSabor1(),
					pedido.getSabor2(), 
					pedido.getSabor3(),
					pedido.getTelefoneCliente(),
					pedido.getObservacoes()
			};
			modelo.addRow(novaLinha);
		}

		
	}

	private void limparTabela() {
		tblPedidos.setModel(new DefaultTableModel(
				new String[][] {
					{"n\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente", "Observa\u00E7\u00F5es"},
				},
				new String[] {
					"N\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente", "Observa\u00E7\u00F5es"
				}
			));
	}
}
