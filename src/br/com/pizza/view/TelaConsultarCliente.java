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
import br.com.pizza.model.dao.ClienteDAO;
import br.com.pizza.model.vo.ClienteVO;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaConsultarCliente extends JPanel {
	private JTextField txtIdPesquisado;
	private JTextField txtNomePesquisado;
	private JTable tblClientes;
	private JTextField txtTelefonePesquisado;
	private JFormattedTextField formattedTextFieldTelefone;

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
		lblImgTitulo.setIcon(new ImageIcon(TelaConsultarCliente.class.getResource("/br/com/pizza/icons/cliente-titulo.png")));
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
				limparTabela();
			}
		});
		
		btnLimparExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparExcluir.setBounds(574, 610, 140, 45);
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
		tblClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{"#ID", "Nome", "Telefone", "Endere\u00E7o"},
			},
			new String[] {
				"#ID", "Nome", "Telefone", "Endere\u00E7o"
			}
		));
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
				/*
				ClienteController cController = new ClienteController();
				ClienteVO cliente = new ClienteVO();
				
				String telefone = new String();
				
				telefone = formattedTextFieldTelefone.getText().replace(")", "").replace("(", "").replace("-", "").replace(" ", "");			
				cliente = cController.pesquisarPorTelefone(telefone);
				if(cliente != null) {
					JOptionPane.showMessageDialog(null, telefone);
					atualizarTabelaClientes(clientes);
					List<ClienteVO> clientes = controlador.listarProdutos(cliente);
					atualizarTabelaProdutos(clientes);
				}*/
				
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisar.setBounds(332, 610, 140, 45);
		add(btnPesquisar);
		
		JLabel lblPesquisarPorTelefone = new JLabel("Pesquisar por Telefone: ");
		lblPesquisarPorTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesquisarPorTelefone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPesquisarPorTelefone.setBounds(7, 248, 311, 27);
		add(lblPesquisarPorTelefone);
		
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
		
		formattedTextFieldTelefone = new JFormattedTextField(mascaraTelefone);
		formattedTextFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formattedTextFieldTelefone.setBounds(7, 276, 140, 31);
		add(formattedTextFieldTelefone);
	} catch (ParseException e) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
		System.out.println("Causa da exceção: " + e.getMessage());
	}}
		
		protected void consultarClientes() {

			ClienteDAO clienteDAO = new ClienteDAO();
			List<ClienteVO> clientes = new ArrayList<ClienteVO>();
			clientes = clienteDAO.pesquisarTodos();
			atualizarTabelaClientes(clientes);

		}

		protected void atualizarTabelaClientes(List<ClienteVO> clientes) {
			this.limparTabela();

			DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();

			for (ClienteVO cliente : clientes) {
				String[] novaLinha = new String[] { 
						cliente.getIdCliente() + "", 
						cliente.getNome(), 
						cliente.getTelefone() + "",
						cliente.getEndereco() + "", 
				};
				modelo.addRow(novaLinha);
			}

		}

		private void limparTabela() {
			tblClientes.setModel(new DefaultTableModel(
					new String[][] {
						{"#ID", "Nome", "Telefone", "Endere\u00E7o"},
					},
					new String[] {
						"#ID", "Nome", "Telefone", "Endere\u00E7o"
					}
				));
		}
		
}
