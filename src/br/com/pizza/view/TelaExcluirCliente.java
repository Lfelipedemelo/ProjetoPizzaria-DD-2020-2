package br.com.pizza.view;

import javax.swing.JPanel;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.pizza.controller.ClienteController;
import br.com.pizza.model.vo.ClienteSeletor;
import br.com.pizza.model.vo.ClienteVO;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaExcluirCliente extends JPanel {
	private JTextField txtIdExcluir;
	private JTextField txtNomePesquisado;
	private JTable tblClientes;
	private JFormattedTextField formattedTextFieldTelefone;
	private int paginaAtual = 1;
	private List<ClienteVO> clientesConsultados;
	private static final int TAMANHO_PAGINA = 15;
	private JLabel lblPaginaAtual;
	private boolean limiteDeClientes = true;

	/**
	 * Create the panel.
	 */
	public TelaExcluirCliente() {
		setBorder(UIManager.getBorder("Menu.border"));
		setLayout(null);

		JPanel panel_CorTitulo = new JPanel();
		panel_CorTitulo.setBounds(7, 7, 985, 118);
		panel_CorTitulo.setBackground(Color.LIGHT_GRAY);
		add(panel_CorTitulo);
		panel_CorTitulo.setLayout(null);

		JLabel lblImgTitulo = new JLabel("Excluir Cliente");
		lblImgTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgTitulo.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblImgTitulo
				.setIcon(new ImageIcon(TelaExcluirCliente.class.getResource("/br/com/pizza/icons/cliente-titulo.png")));
		lblImgTitulo.setBounds(0, 0, 985, 118);
		panel_CorTitulo.add(lblImgTitulo);

		JLabel lblIdExcluir = new JLabel("Insira um Id a ser excluido:");
		lblIdExcluir.setBounds(7, 491, 311, 27);
		lblIdExcluir.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblIdExcluir.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblIdExcluir);

		txtIdExcluir = new JTextField();
		txtIdExcluir.setBounds(7, 522, 501, 31);
		add(txtIdExcluir);
		txtIdExcluir.setColumns(10);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController clienteController = new ClienteController();
				ClienteVO clienteVO = new ClienteVO();
				if (txtIdExcluir.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Insira um id para excluir!");
				} else {
					clienteVO.setIdCliente(Integer.parseInt(txtIdExcluir.getText()));
					if (clienteController.excluirCliente(clienteVO)) {
						JOptionPane.showMessageDialog(null, "Exclu�do com sucesso!");
						ClienteController controlador = new ClienteController();
						ClienteSeletor seletor = new ClienteSeletor();
						List<ClienteVO> Clientes = controlador.listarClientes(seletor);
						atualizarTabelaClientes(Clientes);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir um cliente!");
				}
				}}}
		);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluir.setBounds(368, 582, 140, 45);
		add(btnExcluir);

		JButton btnLimparExcluir = new JButton("Limpar");
		btnLimparExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomePesquisado.setText(null);
				txtIdExcluir.setText(null);
				limparTabela();
			}
		});
		btnLimparExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparExcluir.setBounds(583, 582, 140, 45);
		add(btnLimparExcluir);

		JLabel lblImgForno = new JLabel("");
		lblImgForno.setBounds(616, 139, 273, 399);
		lblImgForno.setIcon(new ImageIcon(TelaExcluirCliente.class.getResource("/br/com/pizza/icons/forno.png")));
		add(lblImgForno);

		JPanel panel_BordaForno = new JPanel();
		panel_BordaForno.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_BordaForno.setBounds(574, 192, 349, 311);
		add(panel_BordaForno);

		JLabel lblNomePesquisado = new JLabel("Insira um nome a ser pesquisado:");
		lblNomePesquisado.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomePesquisado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomePesquisado.setBounds(7, 153, 384, 27);
		add(lblNomePesquisado);

		txtNomePesquisado = new JTextField();
		txtNomePesquisado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				consultarClientes();
			}
		});
		txtNomePesquisado.setColumns(10);
		txtNomePesquisado.setBounds(7, 184, 501, 31);
		add(txtNomePesquisado);

		tblClientes = new JTable();
		tblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblClientes.setModel(new DefaultTableModel(new Object[][] { { "#ID", "Nome", "Telefone", "Endere\u00E7o" }, },
				new String[] { "#ID", "Nome", "Telefone", "Endere\u00E7o" }));
		tblClientes.getColumnModel().getColumn(0).setPreferredWidth(36);
		tblClientes.getColumnModel().getColumn(1).setPreferredWidth(98);
		tblClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblClientes.getColumnModel().getColumn(3).setPreferredWidth(277);
		tblClientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblClientes.setBounds(7, 226, 501, 266);
		add(tblClientes);


		lblPaginaAtual = new JLabel("1");
		lblPaginaAtual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaginaAtual.setBounds(430, 499, 46, 14);
		add(lblPaginaAtual);

		JButton btnVoltarPagina = new JButton("\u2190");
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAtual -= 1;
				if (paginaAtual <= 0) {
					paginaAtual = 1;
					consultarClientes();
				} else {
					consultarClientes();
				}
			}
		});
		btnVoltarPagina.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVoltarPagina.setBounds(359, 495, 53, 23);
		add(btnVoltarPagina);

		JButton btnAvancarPagina = new JButton("\u2192");
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!limiteDeClientes) {
					paginaAtual += 1;
					consultarClientes();
				}
			}
		});
		btnAvancarPagina.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAvancarPagina.setBounds(455, 495, 53, 23);
		add(btnAvancarPagina);

		consultarClientes();
	}

	protected void consultarClientes() {
		lblPaginaAtual.setText(paginaAtual + "");

		ClienteController controlador = new ClienteController();
		ClienteSeletor seletor = new ClienteSeletor();

		seletor.setPagina(paginaAtual);
		seletor.setLimite(TAMANHO_PAGINA);

		if (txtNomePesquisado.getText() != null && !txtNomePesquisado.getText().isEmpty()) {
			seletor.setNome(txtNomePesquisado.getText());
		}
		

		// AQUI é feita a consulta dos produtos e atualização na tabela
		List<ClienteVO> Clientes = controlador.listarClientes(seletor);
		atualizarTabelaClientes(Clientes);
	}

	protected void atualizarTabelaClientes(List<ClienteVO> clientes) {
		this.limparTabela();
		clientesConsultados = clientes;

		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();

		for (ClienteVO cliente : clientes) {
			String[] novaLinha = new String[] { cliente.getIdCliente() + "", cliente.getNome(),
					cliente.getTelefone() + "", cliente.getEndereco() + "", };
			modelo.addRow(novaLinha);
		}
		if (clientes.size() < TAMANHO_PAGINA) {
			limiteDeClientes = true;
		} else {
			limiteDeClientes = false;
		}

	}

	private void limparTabela() {
		tblClientes.setModel(new DefaultTableModel(new String[][] { { "#ID", "Nome", "Telefone", "Endere\u00E7o" }, },
				new String[] { "#ID", "Nome", "Telefone", "Endere\u00E7o" }));
	}
}
