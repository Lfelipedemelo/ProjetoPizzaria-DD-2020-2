package br.com.pizza.view;

import javax.swing.JPanel;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
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
import javax.swing.ListSelectionModel;

public class TelaExcluirCliente extends JPanel {
	private JTextField txtIdExcluir;
	private JTextField txtNomePesquisado;
	private JTable tblClientes;

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
		lblImgTitulo.setIcon(new ImageIcon(TelaExcluirCliente.class.getResource("/br/com/pizza/icons/mulher (1).png")));
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
		btnExcluir.setBounds(368, 582, 140, 45);
		add(btnExcluir);
		
		JButton btnLimparExcluir = new JButton("Limpar");
		btnLimparExcluir.setBounds(583, 582, 140, 45);
		add(btnLimparExcluir);
		
		JLabel lblImgForno = new JLabel("");
		lblImgForno.setBounds(616, 139, 273, 399);
		lblImgForno.setIcon(new ImageIcon(TelaExcluirCliente.class.getResource("/br/com/pizza/icons/forno-de-pedra (2).png")));
		add(lblImgForno);
		
		JPanel panel_BordaForno = new JPanel();
		panel_BordaForno.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_BordaForno.setBounds(574, 192, 349, 311);
		add(panel_BordaForno);
		
		JLabel lblNomePesquisado = new JLabel("Insira um nome a ser pesquisado:");
		lblNomePesquisado.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomePesquisado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomePesquisado.setBounds(7, 153, 376, 27);
		add(lblNomePesquisado);
		
		txtNomePesquisado = new JTextField();
		txtNomePesquisado.setColumns(10);
		txtNomePesquisado.setBounds(7, 184, 501, 31);
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
		tblClientes.setBounds(7, 226, 501, 266);
		add(tblClientes);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(148, 582, 140, 45);
		add(btnPesquisar);
		

	}
}
