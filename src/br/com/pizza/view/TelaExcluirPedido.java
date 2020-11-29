package br.com.pizza.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.pizza.controller.PizzaController;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaExcluirPedido extends JPanel {
	private JTable tblPedidos;
	private JTextField txtPedidoSelecionado;
	private JFormattedTextField txtPesquisarPorId;
	private static final int TAMANHO_PAGINA = 25;

	private int paginaAtual = 1;
	private boolean limiteDePedidos = true;
	private int pedidoSelecionadoTabela;
	private PizzaVO pedidoSelecionado;
	private JLabel lblPaginaAtual;
	private JFormattedTextField txtNumeroCliente;
	private PizzaController controlador;
	private PizzaSeletor seletor;
	private JButton btnExcluir;

	/**
	 * Create the panel.
	 */
	public TelaExcluirPedido() {
		setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 11, 980, 140);
		add(panel_2);

		JLabel lblConsultarPedido = new JLabel("Excluir Pedido");
		lblConsultarPedido.setIcon(new ImageIcon(TelaExcluirPedido.class.getResource("/br/com/pizza/icons/pizza.png")));
		lblConsultarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarPedido.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel_2.add(lblConsultarPedido);

		tblPedidos = new JTable();
		tblPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pedidoSelecionadoTabela = tblPedidos.getSelectedRow() - 1;
				if (pedidoSelecionadoTabela >= 0) {
					pedidoSelecionado = consultarPedidos().get(pedidoSelecionadoTabela);
					txtPedidoSelecionado.setText(String.valueOf(pedidoSelecionado.getIdPizza()));
					btnExcluir.setEnabled(true);
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtrar", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(622, 162, 368, 111);
		add(panel);
		panel.setLayout(null);

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
			System.out.println("Causa da exce√ß√£o: " + e1.getMessage());
		}

		JLabel lblNCliente = new JLabel("N\u00BA Cliente:");
		lblNCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNCliente.setBounds(10, 67, 108, 27);
		panel.add(lblNCliente);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(283, 63, 75, 28);
		panel.add(btnLimpar);

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
			System.out.println("Causa da exce√ß√£o: " + e1.getMessage());
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(622, 284, 368, 167);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPedidoSelecionado_1 = new JLabel("Pedido selecionado");
		lblPedidoSelecionado_1.setBounds(87, 11, 206, 25);
		panel_1.add(lblPedidoSelecionado_1);
		lblPedidoSelecionado_1.setFont(new Font("Tahoma", Font.PLAIN, 22));

		txtPedidoSelecionado = new JTextField();
		txtPedidoSelecionado.setHorizontalAlignment(SwingConstants.CENTER);
		txtPedidoSelecionado.setBounds(87, 47, 187, 37);
		panel_1.add(txtPedidoSelecionado);
		txtPedidoSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPedidoSelecionado.setEditable(false);
		txtPedidoSelecionado.setColumns(10);

		btnExcluir = new JButton("Excluir pedido");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "VocÍ tem certeza que deseja Excluir o pedido "
						+ pedidoSelecionado.getIdPizza() + "\nEsta operaÁ„o È irreversivel!") == 0) {
					if (controlador.excluirPedido(pedidoSelecionado.getIdPizza())) {
						JOptionPane.showMessageDialog(null, "Pedido excluido com sucesso!");
						consultarPedidos();
					}
				}
			}
		});
		btnExcluir.setBounds(87, 95, 187, 61);
		panel_1.add(btnExcluir);
		btnExcluir.setIcon(new ImageIcon(TelaExcluirPedido.class.getResource("/br/com/pizza/icons/delete.png")));
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblPaginaAtual = new JLabel("1");
		lblPaginaAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaginaAtual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaginaAtual.setBounds(10, 603, 602, 22);
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
		btnProximaPagina.setBounds(329, 603, 51, 22);
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
		btnPaginaAnterior.setBounds(232, 603, 51, 22);
		add(btnPaginaAnterior);

		consultarPedidos();

	}

	protected void limparTela() {
		txtNumeroCliente.setText("");
		txtPesquisarPorId.setText("");
		txtPedidoSelecionado.setText("");
		btnExcluir.setEnabled(false);
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

		// AQUI √© feita a consulta dos produtos e atualiza√ß√£o na tabela
		List<PizzaVO> pedidos = controlador.listarPedidos(seletor);
		atualizarTabelaPedidos(pedidos);
		return pedidos;
	}

	private void atualizarTabelaPedidos(List<PizzaVO> pedidos) {

		this.limparTabela();

		DefaultTableModel modelo = (DefaultTableModel) tblPedidos.getModel();

		for (PizzaVO pedido : pedidos) {
			String[] novaLinha = new String[] { pedido.getIdPizza() + "", pedido.getTamanho(), pedido.getSabor1(),
					pedido.getSabor2(), pedido.getSabor3(), pedido.getTelefoneCliente(), pedido.getObservacoes() };
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
}
