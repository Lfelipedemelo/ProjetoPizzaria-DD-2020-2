package br.com.pizza.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.pizza.controller.PizzaController;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

public class TelaEditarPedido extends JPanel {
	private static final int TAMANHO_PAGINA = 25;
	private int paginaAtual = 1;
	private boolean limiteDePedidos = true;
	private int pedidoSelecionadoTabela;
	private PizzaVO pedidoSelecionado;
	private JTable tblPedidos;
	private JFormattedTextField txtPesquisarPorId;
	private JTextField txtPedidoSelecionado;
	private JFormattedTextField txtNumeroCliente;
	private PizzaController controlador;
	private PizzaSeletor seletor;
	private JLabel lblPaginaAtual;
	private JButton btnEditar;

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public PizzaVO getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	/**
	 * Create the panel.
	 */
	public TelaEditarPedido() {
		setLayout(null);
	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 11, 980, 140);
		add(panel_2);

		JLabel lblEditarPedido = new JLabel("Editar Pedido");
		lblEditarPedido.setIcon(new ImageIcon(TelaEditarPedido.class.getResource("/br/com/pizza/icons/pizza.png")));
		lblEditarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarPedido.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel_2.add(lblEditarPedido);

		tblPedidos = new JTable();
		tblPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pedidoSelecionadoTabela = tblPedidos.getSelectedRow() - 1;
				if (pedidoSelecionadoTabela >= 0) {
					pedidoSelecionado = consultarPedidos().get(pedidoSelecionadoTabela);
					txtPedidoSelecionado.setText(String.valueOf(pedidoSelecionado.getIdPizza()));
					btnEditar.setEnabled(true);
				}
			}
		});
		tblPedidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPedidos.setModel(new DefaultTableModel(
				new Object[][] { { "n\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente" }, },
				new String[] { "N\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente" }));
		tblPedidos.setBounds(10, 162, 602, 416);
		add(tblPedidos);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtrar", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(622, 162, 368, 115);
		add(panel);

		JLabel lblNPedido = new JLabel("N\u00BA Pedido:");
		lblNPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNPedido.setBounds(10, 25, 108, 27);
		panel.add(lblNPedido);

		try {
			MaskFormatter mascaraId = new MaskFormatter("#########");
			txtPesquisarPorId = new JFormattedTextField(mascaraId);
			txtPesquisarPorId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					consultarPedidos();
				}
			});
			txtPesquisarPorId.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtPesquisarPorId.setBounds(128, 25, 230, 27);
			panel.add(txtPesquisarPorId);
			txtPesquisarPorId.setFocusLostBehavior(JFormattedTextField.PERSIST);

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
			System.out.println("Causa da exceção: " + e1.getMessage());
		}

		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
			txtNumeroCliente = new JFormattedTextField(mascaraTelefone);
			txtNumeroCliente.setBounds(128, 63, 145, 27);
			panel.add(txtNumeroCliente);
			txtNumeroCliente.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					consultarPedidos();
				}
			});

			txtNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel.add(txtNumeroCliente);
			txtNumeroCliente.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
			System.out.println("Causa da exceção: " + e1.getMessage());
		}

		JLabel lblNCliente = new JLabel("N\u00BA Cliente:");
		lblNCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNCliente.setBounds(10, 67, 108, 27);
		panel.add(lblNCliente);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(283, 63, 75, 28);
		panel.add(btnLimpar);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(622, 288, 368, 167);
		add(panel_1);

		JLabel lblPedidoSelecionado_1 = new JLabel("Pedido selecionado");
		lblPedidoSelecionado_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPedidoSelecionado_1.setBounds(87, 11, 206, 25);
		panel_1.add(lblPedidoSelecionado_1);

		txtPedidoSelecionado = new JTextField();
		txtPedidoSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPedidoSelecionado.setEditable(false);
		txtPedidoSelecionado.setColumns(10);
		txtPedidoSelecionado.setBounds(87, 47, 187, 37);
		panel_1.add(txtPedidoSelecionado);

		btnEditar = new JButton("Editar Pedido");
		

		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditar.setIcon(new ImageIcon(TelaEditarPedido.class.getResource("/br/com/pizza/icons/edit.png")));
		btnEditar.setBounds(87, 95, 187, 61);
		panel_1.add(btnEditar);

		lblPaginaAtual = new JLabel("New label");
		lblPaginaAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaginaAtual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaginaAtual.setBounds(10, 604, 602, 22);
		add(lblPaginaAtual);

		JButton btnProximaPagina = new JButton(">");
		btnProximaPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!limiteDePedidos) {
					paginaAtual += 1;
					consultarPedidos();
				}
			}
		});
		btnProximaPagina.setBounds(336, 604, 51, 22);
		add(btnProximaPagina);

		JButton btnPaginaAnterior = new JButton("<");
		btnPaginaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual -= 1;
				if (paginaAtual <= 0) {
					paginaAtual = 1;
					consultarPedidos();
				} else {
					consultarPedidos();
				}
			}
		});
		btnPaginaAnterior.setBounds(235, 604, 51, 22);
		add(btnPaginaAnterior);

		consultarPedidos();
	}


	protected void limparTela() {
		txtNumeroCliente.setText("");
		txtPesquisarPorId.setText("");
		txtPedidoSelecionado.setText("");
		btnEditar.setEnabled(false);
		consultarPedidos();
	}

	protected List<PizzaVO> consultarPedidos() {
		lblPaginaAtual.setText(paginaAtual + "");

		controlador = new PizzaController();
		seletor = new PizzaSeletor();

		seletor.setPagina(paginaAtual);
		seletor.setLimite(TAMANHO_PAGINA);

		if (txtPesquisarPorId.getText().replace(" ", "") != null
				&& !txtPesquisarPorId.getText().replace(" ", "").isEmpty()) {
			seletor.setIdPizza(Integer.parseInt(txtPesquisarPorId.getText().replace(" ", "")));
		}
		if (limparMascaraTelefone(txtNumeroCliente.getText()) != null
				&& !limparMascaraTelefone(txtNumeroCliente.getText()).isEmpty()) {
			seletor.setTelefoneCliente(limparMascaraTelefone(txtNumeroCliente.getText()));
		}

		// AQUI é feita a consulta dos produtos e atualização na tabela
		List<PizzaVO> pedidos = controlador.listarPedidos(seletor);
		atualizarTabelaPedidos(pedidos);
		return pedidos;
	}

	private void atualizarTabelaPedidos(List<PizzaVO> pedidos) {

		this.limparTabela();

		DefaultTableModel modelo = (DefaultTableModel) tblPedidos.getModel();

		for (PizzaVO pedido : pedidos) {
			String[] novaLinha = new String[] { pedido.getIdPizza() + "", pedido.getTamanho(), pedido.getSabor1(),
					pedido.getSabor2(), pedido.getSabor3(), adicionarMascara(pedido.getTelefoneCliente()), pedido.getObservacoes() };
			modelo.addRow(novaLinha);
		}
		if (pedidos.size() < TAMANHO_PAGINA) {
			limiteDePedidos = true;
		} else {
			limiteDePedidos = false;
		}

	}

	private void limparTabela() {
		tblPedidos.setModel(new DefaultTableModel(
				new String[][] { { "n\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente" }, },
				new String[] { "N\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente" }));
	}

	protected String limparMascaraTelefone(String telefone) {
		return telefone.replace(")", "").replace("(", "").replace("-", "").replace(" ", "");
	}
	
	private String adicionarMascara(String str) {
		String novaString = new String();
		for(int i = 0; i < str.length(); i++) {
			if(i == 0) {
				novaString += "(";
			} else if(i == 2) {
				novaString += ")";
			} else if(i == 7) {
				novaString += "-";
			}
			novaString += str.charAt(i);
		}
		return novaString;
	}
}
