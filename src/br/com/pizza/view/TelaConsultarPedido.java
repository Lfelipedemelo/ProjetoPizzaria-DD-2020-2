package br.com.pizza.view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaConsultarPedido extends JPanel {
	private JTable tblPedidos;
	private JTextField txtPesquisarPorNumero;
	private JTextField txtPesquisarPorCliente;

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
		tblPedidos.setModel(new DefaultTableModel(
			new Object[][] {
				{"n\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente"},
			},
			new String[] {
				"N\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente"
			}
		));
		tblPedidos.setBounds(10, 273, 980, 368);
		add(tblPedidos);
		
		JLabel lblPesquisarNumero = new JLabel("Numero do pedido");
		lblPesquisarNumero.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPesquisarNumero.setBounds(274, 162, 180, 32);
		add(lblPesquisarNumero);
		
		txtPesquisarPorNumero = new JTextField();
		txtPesquisarPorNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPesquisarPorNumero.setBounds(274, 196, 180, 25);
		add(txtPesquisarPorNumero);
		txtPesquisarPorNumero.setColumns(10);
		
		JLabel lblPesquisarPorCliente = new JLabel("Numero do cliente");
		lblPesquisarPorCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPesquisarPorCliente.setBounds(560, 162, 180, 32);
		add(lblPesquisarPorCliente);
		
		txtPesquisarPorCliente = new JTextField();
		txtPesquisarPorCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPesquisarPorCliente.setColumns(10);
		txtPesquisarPorCliente.setBounds(560, 196, 180, 25);
		add(txtPesquisarPorCliente);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setIcon(new ImageIcon(TelaConsultarPedido.class.getResource("/br/com/pizza/icons/Lupa.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(422, 230, 180, 32);
		add(btnNewButton);

	}
}
