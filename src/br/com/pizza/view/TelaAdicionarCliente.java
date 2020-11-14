package br.com.pizza.view;

import javax.swing.JPanel;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.text.MaskFormatter;

import br.com.pizza.controller.ClienteController;
import br.com.pizza.model.vo.ClienteVO;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class TelaAdicionarCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtSobrenome;
	private JFormattedTextField formattedTextFieldTelefone;

	/**
	 * Create the panel.
	 */
	public TelaAdicionarCliente() {
		setBorder(UIManager.getBorder("Menu.border"));
		setLayout(null);
		
		JPanel panel_Titulo = new JPanel();
		panel_Titulo.setBounds(7, 7, 985, 118);
		panel_Titulo.setBackground(Color.LIGHT_GRAY);
		add(panel_Titulo);
		panel_Titulo.setLayout(null);
		
		JLabel lblImgTitulo = new JLabel("Cadastro de Cliente");
		lblImgTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgTitulo.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblImgTitulo.setIcon(new ImageIcon(TelaAdicionarCliente.class.getResource("/br/com/pizza/icons/cliente-titulo.png")));
		lblImgTitulo.setBounds(0, 0, 985, 118);
		panel_Titulo.add(lblImgTitulo);
		
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
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: ");
		lblEndereo.setBounds(7, 409, 157, 31);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(7, 444, 501, 31);
		txtEndereco.setColumns(10);
		add(txtEndereco);
		
		JButton btnSalvarAdicionar = new JButton("Salvar");
		btnSalvarAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController clienteController = new ClienteController();
				ClienteVO clienteVO = new ClienteVO();
				String telefone = new String();
				clienteVO.setNome(txtNome.getText() + " " + txtSobrenome.getText());
				clienteVO.setTelefone(formattedTextFieldTelefone.getText().replace("(","").replace(")", "").replace("-", ""));
				clienteVO.setEndereco(txtEndereco.getText());	
				
				JOptionPane.showMessageDialog(null, clienteController.cadastrarCliente(clienteVO));
			}
		});
		btnSalvarAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvarAdicionar.setBounds(204, 577, 140, 45);
		add(btnSalvarAdicionar);
		
		JButton btnLimparAdicionar = new JButton("Limpar");
		btnLimparAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
				txtSobrenome.setText(null);
				formattedTextFieldTelefone.setValue(null);
				txtEndereco.setText(null);
			}
		});
		btnLimparAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparAdicionar.setBounds(583, 582, 140, 45);
		add(btnLimparAdicionar);
		
		JLabel lblSobrenome = new JLabel("Sobrenome: ");
		lblSobrenome.setBounds(6, 272, 163, 27);
		lblSobrenome.setHorizontalAlignment(SwingConstants.LEFT);
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(6, 303, 501, 31);
		txtSobrenome.setColumns(10);
		add(txtSobrenome);
		
		JLabel lblImgForno = new JLabel("");
		lblImgForno.setBounds(616, 139, 273, 399);
		lblImgForno.setIcon(new ImageIcon(TelaAdicionarCliente.class.getResource("/br/com/pizza/icons/forno.png")));
		add(lblImgForno);
		
		JPanel panel_BordaForno = new JPanel();
		panel_BordaForno.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_BordaForno.setBounds(574, 192, 349, 311);
		add(panel_BordaForno);
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
		
		formattedTextFieldTelefone = new JFormattedTextField(mascaraTelefone);
		formattedTextFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formattedTextFieldTelefone.setBounds(7, 376, 140, 31);
		add(formattedTextFieldTelefone);
	} catch (ParseException e) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro no campo Telefone, entre em contato com o administrador.");
		System.out.println("Causa da exceção: " + e.getMessage());
		
}}}
