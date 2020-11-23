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

public class TelaEditarCliente extends JPanel {
	private JTextField txtNomeAtualizado;
	private JTextField txtEnderecoAtualizado;
	private JTextField txtSobrenomeAtualizado;
	private JTextField txtTelefonePesquisado;
	protected JFormattedTextField formattedTextFieldTelefonePesquisado;
	protected JFormattedTextField formattedTextFieldTelefoneAtualizado;
	private JTextField txtNomeCliente;
	private JTextField txtEnderecoCliente;
	private int idClientePesquisado;

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
		
		JLabel lblImgTitulo = new JLabel("Editar Cliente");
		lblImgTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgTitulo.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblImgTitulo.setIcon(new ImageIcon(TelaEditarCliente.class.getResource("/br/com/pizza/icons/cliente-titulo.png")));
		lblImgTitulo.setBounds(0, 0, 985, 118);
		panel_CorTitulo.add(lblImgTitulo);
		
		JLabel lblNomeAtualizado = new JLabel("Inserir nome atualizado: ");
		lblNomeAtualizado.setBounds(7, 228, 273, 27);
		lblNomeAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomeAtualizado.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNomeAtualizado);
		
		txtNomeAtualizado = new JTextField();
		txtNomeAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNomeAtualizado.setBounds(7, 259, 501, 31);
		add(txtNomeAtualizado);
		txtNomeAtualizado.setColumns(10);
		
		JLabel lblTelefoneAtualizado = new JLabel("Inserir telefone atualizado: ");
		lblTelefoneAtualizado.setBounds(9, 367, 273, 31);
		lblTelefoneAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblTelefoneAtualizado);
		
		JLabel lblEnderecoAtualizado = new JLabel("Inserir Endere\u00E7o atualizado: ");
		lblEnderecoAtualizado.setBounds(9, 437, 311, 31);
		lblEnderecoAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblEnderecoAtualizado);
		
		txtEnderecoAtualizado = new JTextField();
		txtEnderecoAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEnderecoAtualizado.setBounds(9, 472, 501, 31);
		txtEnderecoAtualizado.setColumns(10);
		add(txtEnderecoAtualizado);
		
		JButton btnSalvarEditar = new JButton("Salvar");
		btnSalvarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 ClienteController clienteController = new ClienteController();
				 ClienteVO clienteAtualizadoVO = new ClienteVO();
				 clienteAtualizadoVO.setIdCliente(idClientePesquisado);
				 clienteAtualizadoVO.setNome(txtNomeAtualizado.getText() + "" + txtSobrenomeAtualizado.getText());
				 clienteAtualizadoVO.setEndereco(txtEnderecoAtualizado.getText());
				 clienteAtualizadoVO.setTelefone(limparMascaraTelefone(formattedTextFieldTelefoneAtualizado.getText()));
				 clienteController.atualizar(clienteAtualizadoVO);
				
			
			}
		});
		btnSalvarEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvarEditar.setBounds(204, 577, 140, 45);
		add(btnSalvarEditar);
		
		JButton btnLimparEditar = new JButton("Limpar");
		btnLimparEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTela();
			}
		});
		btnLimparEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparEditar.setBounds(583, 582, 140, 45);
		add(btnLimparEditar);
		
		JLabel lblSobrenomeAtualizado = new JLabel("Inserir sobrenome atualizado:");
		lblSobrenomeAtualizado.setBounds(8, 300, 323, 27);
		lblSobrenomeAtualizado.setHorizontalAlignment(SwingConstants.LEFT);
		lblSobrenomeAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblSobrenomeAtualizado);
		
		txtSobrenomeAtualizado = new JTextField();
		txtSobrenomeAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSobrenomeAtualizado.setBounds(8, 331, 501, 31);
		txtSobrenomeAtualizado.setColumns(10);
		add(txtSobrenomeAtualizado);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeCliente.setBounds(7, 208, 215, 21);
		add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnderecoCliente.setEditable(false);
		txtEnderecoCliente.setBounds(232, 208, 276, 21);
		add(txtEnderecoCliente);
		txtEnderecoCliente.setColumns(10);
		
		JLabel lblImgForno = new JLabel("");
		lblImgForno.setBounds(616, 139, 273, 399);
		lblImgForno.setIcon(new ImageIcon(TelaEditarCliente.class.getResource("/br/com/pizza/icons/forno.png")));
		add(lblImgForno);
		
		JPanel panel_BordaForno = new JPanel();
		panel_BordaForno.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_BordaForno.setBounds(574, 192, 349, 311);
		add(panel_BordaForno);
		
		JLabel lblTelefonePesquisado = new JLabel("Inserir telefone a ser pesquisado: ");
		lblTelefonePesquisado.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTelefonePesquisado.setBounds(5, 136, 339, 31);
		add(lblTelefonePesquisado);
		
		try {
			MaskFormatter mascaraTelefoneAtualizado = new MaskFormatter("(##)#####-####");
		
		formattedTextFieldTelefoneAtualizado = new JFormattedTextField(mascaraTelefoneAtualizado);
		formattedTextFieldTelefoneAtualizado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formattedTextFieldTelefoneAtualizado.setBounds(8, 402, 140, 31);
		add(formattedTextFieldTelefoneAtualizado);
		
	} catch (ParseException e) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
		System.out.println("Causa da exceção: " + e.getMessage());
		

	}
		
		
		try {
			MaskFormatter mascaraTelefonePesquisado = new MaskFormatter("(##)#####-####");
		
		formattedTextFieldTelefonePesquisado = new JFormattedTextField(mascaraTelefonePesquisado);
		formattedTextFieldTelefonePesquisado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formattedTextFieldTelefonePesquisado.setBounds(7, 170, 140, 31);
		add(formattedTextFieldTelefonePesquisado);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController clienteController = new ClienteController();
				ClienteVO clienteVO = new ClienteVO();
						
				clienteVO = clienteController.pesquisarPorTelefone(limparMascaraTelefone(formattedTextFieldTelefonePesquisado.getText()));
				idClientePesquisado = clienteVO.getIdCliente();
				txtNomeCliente.setText(clienteVO.getNome());
				txtEnderecoCliente.setText(clienteVO.getEndereco());
				
			}});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPesquisar.setBounds(157, 172, 140, 27);
		add(btnPesquisar);
		
	} catch (ParseException e) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro no campo Telefone, entre em contato com o administrador.");
		System.out.println("Causa da exceção: " + e.getMessage());
		

	}
		
}

	protected String limparMascaraTelefone(String telefone) {
		return telefone.replace(")", "").replace("(", "").replace("-", "").replace(" ", "");
	}

	private void limparTela() {
		formattedTextFieldTelefonePesquisado.setValue(null);
		txtEnderecoAtualizado.setText("");
		formattedTextFieldTelefoneAtualizado.setValue(null);
		txtNomeAtualizado.setText("");
		txtSobrenomeAtualizado.setText("");
	}	
}
