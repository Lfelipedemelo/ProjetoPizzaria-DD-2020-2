package br.com.pizza.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class TelaEditarPedido extends JPanel {
	private JTable tblEditarPedido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		tblEditarPedido = new JTable();
		tblEditarPedido.setModel(new DefaultTableModel(
				new Object[][] {
					{"n\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente"},
				},
				new String[] {
					"N\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente"
				}
			));
		tblEditarPedido.setBounds(10, 162, 602, 487);
		add(tblEditarPedido);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(622, 162, 368, 140);
		add(panel);
		
		JLabel lblNPedido = new JLabel("N\u00BA Pedido:");
		lblNPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNPedido.setBounds(10, 25, 108, 27);
		panel.add(lblNPedido);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 25, 230, 27);
		panel.add(textField);
		
		JLabel lblNCliente = new JLabel("N\u00BA Cliente:");
		lblNCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNCliente.setBounds(10, 67, 108, 27);
		panel.add(lblNCliente);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 63, 230, 27);
		panel.add(textField_1);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFiltrar.setBounds(128, 101, 89, 28);
		panel.add(btnFiltrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(269, 101, 89, 28);
		panel.add(btnLimpar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(622, 313, 368, 167);
		add(panel_1);
		
		JLabel lblPedidoSelecionado_1 = new JLabel("Pedido selecionado");
		lblPedidoSelecionado_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPedidoSelecionado_1.setBounds(87, 11, 206, 25);
		panel_1.add(lblPedidoSelecionado_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(87, 47, 187, 37);
		panel_1.add(textField_2);
		
		JButton btnNewButton = new JButton("Editar Pedido");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(TelaEditarPedido.class.getResource("/br/com/pizza/icons/edit.png")));
		btnNewButton.setBounds(87, 95, 187, 61);
		panel_1.add(btnNewButton);

	}

}
