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

public class TelaConsultarPedido extends JPanel {
	private JTable tblPedidos;
	private JTextField txtPesquisarPorId;
	private JTextField txtPesquisarPorNumero;
	private JLabel lblPaginaAtual;
	private List<PizzaVO> pedidosConsultados;
	
	private int paginaAtual = 1;
	
	private static final int TAMANHO_PAGINA = 0;
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
		tblPedidos.setBounds(10, 273, 980, 368);
		add(tblPedidos);
		
		
		
		JLabel lblPesquisarPorId = new JLabel("Numero do pedido");
		lblPesquisarPorId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPesquisarPorId.setBounds(274, 162, 180, 32);
		add(lblPesquisarPorId);
		
		txtPesquisarPorId = new JTextField();
		txtPesquisarPorId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPesquisarPorId.setBounds(274, 196, 180, 25);
		add(txtPesquisarPorId);
		txtPesquisarPorId.setColumns(10);
		
		JLabel lblPesquisarPorNumero = new JLabel("Numero do cliente");
		lblPesquisarPorNumero.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPesquisarPorNumero.setBounds(560, 162, 180, 32);
		add(lblPesquisarPorNumero);
		
		txtPesquisarPorNumero = new JTextField();
		txtPesquisarPorNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				consultarPedidos();
			}
		});
		txtPesquisarPorNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPesquisarPorNumero.setColumns(10);
		txtPesquisarPorNumero.setBounds(560, 196, 180, 25);
		add(txtPesquisarPorNumero);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarPedidos();
			}
		});
		btnFiltrar.setIcon(new ImageIcon(TelaConsultarPedido.class.getResource("/br/com/pizza/icons/Lupa.png")));
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFiltrar.setBounds(422, 230, 180, 32);
		add(btnFiltrar);
		
		lblPaginaAtual = new JLabel("New label");
		lblPaginaAtual.setBounds(496, 652, 46, 14);
		add(lblPaginaAtual);
		
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
