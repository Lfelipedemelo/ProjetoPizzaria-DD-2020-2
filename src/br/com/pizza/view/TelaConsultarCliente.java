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
import javax.swing.text.MaskFormatter;

import br.com.pizza.controller.ClienteController;
import br.com.pizza.controller.PizzaController;
import br.com.pizza.model.dao.ClienteDAO;
import br.com.pizza.model.vo.ClienteSeletor;
import br.com.pizza.model.vo.ClienteVO;
import br.com.pizza.model.vo.PizzaSeletor;
import br.com.pizza.model.vo.PizzaVO;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaConsultarCliente extends JPanel {
	private JTextField txtIdPesquisado;
	private JTextField txtNomePesquisado;
	private JTable tblClientes;
	private JTextField txtTelefonePesquisado;
	private JFormattedTextField formattedTextFieldTelefone;
	private int paginaAtual = 1;
	private List<ClienteVO> clientesConsultados;
	private static final int TAMANHO_PAGINA = 15;
	private JLabel lblPaginaAtual;
	private boolean limiteDeClientes = true;

	/**
	 * Create the panel.
	 */
	public TelaConsultarCliente() {
		setBorder(UIManager.getBorder("Menu.border"));
		setLayout(null);

		JPanel panel_CorTitulo = new JPanel();
		panel_CorTitulo.setBounds(7, 7, 985, 118);
		panel_CorTitulo.setBackground(Color.LIGHT_GRAY);
		add(panel_CorTitulo);
		panel_CorTitulo.setLayout(null);

		JLabel lblImgTitulo = new JLabel("Consultar Cliente");
		lblImgTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgTitulo.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblImgTitulo.setIcon(
				new ImageIcon(TelaConsultarCliente.class.getResource("/br/com/pizza/icons/cliente-titulo.png")));
		lblImgTitulo.setBounds(0, 0, 985, 118);
		panel_CorTitulo.add(lblImgTitulo);

		JLabel lblIdPesquisado = new JLabel("Pesquisar por ID: ");
		lblIdPesquisado.setBounds(7, 188, 311, 27);
		lblIdPesquisado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblIdPesquisado.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblIdPesquisado);

		txtIdPesquisado = new JTextField();
		txtIdPesquisado.setBounds(7, 221, 501, 22);
		add(txtIdPesquisado);
		txtIdPesquisado.setColumns(10);

		JButton btnLimparExcluir = new JButton("Limpar");
		btnLimparExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomePesquisado.setText(null);
				formattedTextFieldTelefone.setValue(null);
				txtIdPesquisado.setText(null);
			}
		});

		btnLimparExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparExcluir.setBounds(816, 608, 140, 45);
		add(btnLimparExcluir);

		JLabel lblImgForno = new JLabel("");
		lblImgForno.setBounds(616, 139, 273, 399);
		lblImgForno.setIcon(new ImageIcon(TelaConsultarCliente.class.getResource("/br/com/pizza/icons/forno.png")));
		add(lblImgForno);

		JPanel panel_BordaForno = new JPanel();
		panel_BordaForno.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_BordaForno.setBounds(574, 192, 349, 311);
		add(panel_BordaForno);

		JLabel lblNomePesquisado = new JLabel("Pesquisar por Nome: ");
		lblNomePesquisado.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomePesquisado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomePesquisado.setBounds(7, 132, 384, 27);
		add(lblNomePesquisado);

		txtNomePesquisado = new JTextField();
		txtNomePesquisado.setColumns(10);
		txtNomePesquisado.setBounds(7, 161, 501, 22);
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
		tblClientes.setBounds(7, 314, 501, 266);
		add(tblClientes);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarClientes();
			}
		});

		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisar.setBounds(574, 608, 140, 45);
		add(btnPesquisar);

		JLabel lblPesquisarPorTelefone = new JLabel("Pesquisar por Telefone: ");
		lblPesquisarPorTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesquisarPorTelefone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPesquisarPorTelefone.setBounds(7, 248, 311, 27);
		add(lblPesquisarPorTelefone);

		lblPaginaAtual = new JLabel("1");
		lblPaginaAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaginaAtual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaginaAtual.setBounds(4, 594, 501, 14);
		add(lblPaginaAtual);

		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");

			formattedTextFieldTelefone = new JFormattedTextField(mascaraTelefone);
			formattedTextFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			formattedTextFieldTelefone.setBounds(7, 276, 140, 31);
			formattedTextFieldTelefone.setFocusLostBehavior(JFormattedTextField.PERSIST);
			add(formattedTextFieldTelefone);

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
			System.out.println("Causa da exceção: " + e.getMessage());
		}

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
		btnVoltarPagina.setBounds(180, 590, 53, 23);
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
		btnAvancarPagina.setBounds(276, 590, 53, 23);
		add(btnAvancarPagina);

		// INICIO DA TABELA PREENCHIDA
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
		if (txtIdPesquisado.getText() != null && !txtIdPesquisado.getText().isEmpty()) {
			seletor.setIdCliente(Integer.parseInt(txtIdPesquisado.getText()));
		}
		if (formattedTextFieldTelefone.getText() != null && !formattedTextFieldTelefone.getText().isEmpty()) {
			seletor.setTelefone(formattedTextFieldTelefone.getText().replace(")", "").replace("(", "").replace("-", "")
					.replace(" ", ""));
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
