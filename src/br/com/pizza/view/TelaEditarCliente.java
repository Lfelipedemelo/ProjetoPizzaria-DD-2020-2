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

public class TelaEditarCliente extends JPanel {
	private JTextField txtNomeAtualizado;
	private JTextField txtTelefoneAtualizado;
	private JTextField txtEnderecoAtualizado;
	private JTextField txtSobrenomeAtualizado;

	/**
	 * Create the panel.
	 */
	public TelaEditarCliente() {
		setBorder(UIManager.getBorder("Menu.border"));
		setLayout(null);
		
		JPanel panel_CorTitulo = new JPanel();
		panel_CorTitulo.setBounds(7, 7, 985, 118);
		panel_CorTitulo.setBackground(Color.LIGHT_GRAY);
		add(panel_CorTitulo);
		panel_CorTitulo.setLayout(null);
		
		JLabel lblImgTitulo = new JLabel("");
		lblImgTitulo.setIcon(new ImageIcon(TelaEditarCliente.class.getResource("/br/com/pizza/icons/mulher (1).png")));
		lblImgTitulo.setBounds(215, -23, 124, 169);
		panel_CorTitulo.add(lblImgTitulo);
		
		JLabel lblEditarCliente = new JLabel("Editar Cliente");
		lblEditarCliente.setBounds(269, 11, 557, 87);
		panel_CorTitulo.add(lblEditarCliente);
		lblEditarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarCliente.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		JLabel lblNomeAtualizado = new JLabel("Inserir nome atualizado: ");
		lblNomeAtualizado.setBounds(5, 200, 273, 27);
		lblNomeAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomeAtualizado.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNomeAtualizado);
		
		txtNomeAtualizado = new JTextField();
		txtNomeAtualizado.setBounds(5, 231, 501, 31);
		add(txtNomeAtualizado);
		txtNomeAtualizado.setColumns(10);
		
		JLabel lblTelefoneAtualizado = new JLabel("Inserir telefone atualizado: ");
		lblTelefoneAtualizado.setBounds(7, 339, 273, 31);
		lblTelefoneAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblTelefoneAtualizado);
		
		txtTelefoneAtualizado = new JTextField();
		txtTelefoneAtualizado.setBounds(7, 374, 157, 31);
		txtTelefoneAtualizado.setColumns(10);
		add(txtTelefoneAtualizado);
		
		JLabel lblEnderecoAtualizado = new JLabel("Inserir Endere\u00E7o atualizado: ");
		lblEnderecoAtualizado.setBounds(7, 409, 311, 31);
		lblEnderecoAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblEnderecoAtualizado);
		
		txtEnderecoAtualizado = new JTextField();
		txtEnderecoAtualizado.setBounds(7, 444, 501, 31);
		txtEnderecoAtualizado.setColumns(10);
		add(txtEnderecoAtualizado);
		
		JButton btnSalvarEditar = new JButton("Salvar");
		btnSalvarEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvarEditar.setBounds(204, 577, 140, 45);
		add(btnSalvarEditar);
		
		JButton btnLimparEditar = new JButton("Limpar");
		btnLimparEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparEditar.setBounds(583, 582, 140, 45);
		add(btnLimparEditar);
		
		JLabel lblSobrenomeAtualizado = new JLabel("Inserir sobrenome atualizado:");
		lblSobrenomeAtualizado.setBounds(6, 272, 323, 27);
		lblSobrenomeAtualizado.setHorizontalAlignment(SwingConstants.LEFT);
		lblSobrenomeAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblSobrenomeAtualizado);
		
		txtSobrenomeAtualizado = new JTextField();
		txtSobrenomeAtualizado.setBounds(6, 303, 501, 31);
		txtSobrenomeAtualizado.setColumns(10);
		add(txtSobrenomeAtualizado);
		
		JLabel lblImgForno = new JLabel("");
		lblImgForno.setBounds(616, 139, 273, 399);
		lblImgForno.setIcon(new ImageIcon(TelaEditarCliente.class.getResource("/br/com/pizza/icons/forno.png")));
		add(lblImgForno);
		
		JPanel panel_BordaForno = new JPanel();
		panel_BordaForno.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_BordaForno.setBounds(574, 192, 349, 311);
		add(panel_BordaForno);
		

	}
}
