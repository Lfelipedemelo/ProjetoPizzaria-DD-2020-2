package br.com.pizza.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.pizza.controller.PizzaController;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultarPedido extends JPanel {
	private JTable tblPedidos;
	private JLabel lblPaginaAtual;
	
	private int paginaAtual = 1;
	private boolean limiteDePedidos = true;
	private JFormattedTextField txtNumeroCliente;
	private JFormattedTextField txtPesquisarPorId;
	
	private static final int TAMANHO_PAGINA = 10;
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
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
			txtNumeroCliente = new JFormattedTextField(mascaraTelefone);
			txtNumeroCliente.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					consultarPedidos();
				}
			});
			
			txtNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtNumeroCliente.setBounds(602, 32, 156, 28);
			panel.add(txtNumeroCliente);
			txtNumeroCliente.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
	        System.out.println("Causa da exceção: " + e1.getMessage());
		}
		
		JLabel lblPesquisarPorNumero = new JLabel("Numero do cliente:");
		lblPesquisarPorNumero.setBounds(404, 28, 191, 32);
		panel.add(lblPesquisarPorNumero);
		lblPesquisarPorNumero.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		
		
		JLabel lblPesquisarPorId = new JLabel("Numero do pedido:");
		lblPesquisarPorId.setBounds(10, 28, 196, 32);
		panel.add(lblPesquisarPorId);
		lblPesquisarPorId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
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
			txtPesquisarPorId.setBounds(216, 32, 156, 28);
			panel.add(txtPesquisarPorId);	
			txtPesquisarPorId.setFocusLostBehavior(JFormattedTextField.PERSIST);
			
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
	        System.out.println("Causa da exceção: " + e1.getMessage());
		}
		
		
		
		
		
		JButton btnProximaPagina = new JButton(">");
		btnProximaPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!limiteDePedidos) {
					paginaAtual += 1;
					consultarPedidos();
				}
			}
		});
		btnProximaPagina.setBounds(520, 652, 41, 17);
		add(btnProximaPagina);
		
		JButton btnPaginaAnterior = new JButton("<");
		btnPaginaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual -= 1;
				if(paginaAtual <= 0) {
					paginaAtual = 1;
					consultarPedidos();
				} else {
				consultarPedidos();
				}
			}
		});
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

		if (txtPesquisarPorId.getText().replace(" ", "") != null && !txtPesquisarPorId.getText().replace(" ", "").isEmpty()) {
			seletor.setIdPizza(Integer.parseInt(txtPesquisarPorId.getText().replace(" ", "")));
		}
		if (limparMascaraTelefone(txtNumeroCliente.getText()) != null && !limparMascaraTelefone(txtNumeroCliente.getText()).isEmpty()) {
			seletor.setTelefoneCliente(limparMascaraTelefone(txtNumeroCliente.getText()));
		}

		//AQUI é feita a consulta dos produtos e atualização na tabela
		List<PizzaVO> pedidos = controlador.listarPedidos(seletor);
		atualizarTabelaPedidos(pedidos);
	}

	private void atualizarTabelaPedidos(List<PizzaVO> pedidos) {
		
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
		if(pedidos.size() < TAMANHO_PAGINA) {
			limiteDePedidos = true;
		} else {
			limiteDePedidos = false;
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
	
	protected String limparMascaraTelefone(String telefone) {
		return telefone.replace(")", "").replace("(", "").replace("-", "").replace(" ", "");
	}
}
