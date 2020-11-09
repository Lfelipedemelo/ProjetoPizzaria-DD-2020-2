package br.com.pizza.view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaConsultarPedido extends JPanel {

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

	}
}
