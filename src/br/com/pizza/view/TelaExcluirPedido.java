package br.com.pizza.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class TelaExcluirPedido extends JPanel {
	private JTable tbExcluirPedidos;
	private JTextField txtPedidoSelecionado;
	private JTextField txtNPedido;
	private JTextField txtNCliente;

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
		
		tbExcluirPedidos = new JTable();
		tbExcluirPedidos.setModel(new DefaultTableModel(
				new Object[][] {
					{"n\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente"},
				},
				new String[] {
					"N\u00BA Pedido", "Tamanho", "Sabor_1", "Sabor_2", "Sabor_3", "N\u00BA Cliente"
				}
			));
		tbExcluirPedidos.setBounds(10, 162, 602, 487);
		add(tbExcluirPedidos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(622, 162, 368, 140);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNPedido = new JLabel("N\u00BA Pedido:");
		lblNPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNPedido.setBounds(10, 25, 108, 27);
		panel.add(lblNPedido);
		
		txtNPedido = new JTextField();
		txtNPedido.setBounds(128, 25, 230, 27);
		panel.add(txtNPedido);
		txtNPedido.setColumns(10);
		
		JLabel lblNCliente = new JLabel("N\u00BA Cliente:");
		lblNCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNCliente.setBounds(10, 67, 108, 27);
		panel.add(lblNCliente);
		
		txtNCliente = new JTextField();
		txtNCliente.setColumns(10);
		txtNCliente.setBounds(128, 63, 230, 27);
		panel.add(txtNCliente);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFiltrar.setBounds(128, 101, 89, 28);
		panel.add(btnFiltrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(269, 101, 89, 28);
		panel.add(btnLimpar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(622, 313, 368, 167);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPedidoSelecionado_1 = new JLabel("Pedido selecionado");
		lblPedidoSelecionado_1.setBounds(87, 11, 206, 25);
		panel_1.add(lblPedidoSelecionado_1);
		lblPedidoSelecionado_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtPedidoSelecionado = new JTextField();
		txtPedidoSelecionado.setBounds(87, 47, 187, 37);
		panel_1.add(txtPedidoSelecionado);
		txtPedidoSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPedidoSelecionado.setEditable(false);
		txtPedidoSelecionado.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir pedido");
		btnExcluir.setBounds(87, 95, 187, 61);
		panel_1.add(btnExcluir);
		btnExcluir.setIcon(new ImageIcon(TelaExcluirPedido.class.getResource("/br/com/pizza/icons/delete.png")));
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));

	}
}
