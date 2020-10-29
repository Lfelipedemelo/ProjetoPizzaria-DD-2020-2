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

public class TelaAdicionarCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtSobrenome;

	/**
	 * Create the panel.
	 */
	public TelaAdicionarCliente() {
		setBorder(UIManager.getBorder("Menu.border"));
		setLayout(null);
		
		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setBounds(248, 23, 619, 87);
		lblCadastroDeCliente.setFont(new Font("Tahoma", Font.PLAIN, 72));
		add(lblCadastroDeCliente);
		
		JPanel panel = new JPanel();
		panel.setBounds(7, 7, 985, 118);
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAdicionarCliente.class.getResource("/br/com/pizza/icons/mulher (1).png")));
		lblNewLabel.setBounds(141, -20, 124, 169);
		panel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(5, 200, 72, 27);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(5, 231, 501, 31);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(7, 339, 157, 31);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(7, 374, 157, 31);
		txtTelefone.setColumns(10);
		add(txtTelefone);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: ");
		lblEndereo.setBounds(7, 409, 157, 31);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(7, 444, 501, 31);
		txtEndereco.setColumns(10);
		add(txtEndereco);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(204, 577, 140, 45);
		add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(583, 582, 140, 45);
		add(btnLimpar);
		
		JLabel lblSobrenome = new JLabel("Sobrenome: ");
		lblSobrenome.setBounds(6, 272, 163, 27);
		lblSobrenome.setHorizontalAlignment(SwingConstants.LEFT);
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(6, 303, 501, 31);
		txtSobrenome.setColumns(10);
		add(txtSobrenome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(616, 139, 273, 399);
		lblNewLabel_1.setIcon(new ImageIcon(TelaAdicionarCliente.class.getResource("/br/com/pizza/icons/forno-de-pedra (2).png")));
		add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(574, 192, 349, 311);
		add(panel_1);
		

	}
}