package br.com.pizza.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import br.com.pizza.controller.ClienteController;
import br.com.pizza.controller.PizzaController;
import br.com.pizza.model.vo.ClienteVO;
import br.com.pizza.model.vo.PizzaVO;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class TelaAdicionarPedido extends JPanel {
	private JTextField txtNomeCliente;
	private JTextField txtEnderecoCliente;
	private JLabel lblSegundoSabor;
	private JLabel lblTerceiroSabor;
	private JComboBox cbSegundoSabor;
	private JComboBox cbPrimeiroSabor;
	private JComboBox cbTerceiroSabor;
	private JLabel lblPrimeiroSabor;
	private JLabel lblValorNumerico;
	private ButtonGroup btgpNSabores;
	private JRadioButton rdbtNsaboresUnico;
	private JRadioButton rdbtnTamanhoBroto;
	private JRadioButton rdbtNsaboresDois;
	private JRadioButton rdbtNsaboresTres;
	private Component formattedTextFieldTelefone;
	private JFormattedTextField txtTelefone;
	private JTextArea txtObservacoes;
	
	private final String SELECIONE_SABOR = "Selecione um sabor";
	private final double VALOR_BROTO = 32.90;
	private final double VALOR_MEDIA = 46.90;
	private final double VALOR_GRANDE = 52.90;
	private final double VALOR_GIGANTE = 56.90;
	private JRadioButton rdbtnTamanhoMedia;
	private JRadioButton rdbtnTamanhoGrande;
	private JRadioButton rdbtnTamanhoGigante;
	

	public TelaAdicionarPedido() {
		setMaximumSize(new Dimension(1000, 700));
		setMinimumSize(new Dimension(1000, 700));
		setPreferredSize(new Dimension(1000, 700));
		setLayout(null);
		
		JPanel panelTamanho = new JPanel();
		panelTamanho.setBounds(31, 174, 334, 78);
		panelTamanho.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelTamanho);
		panelTamanho.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Tamanho:");
		panelTamanho.add(lblNewLabel_1, "cell 0 0");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		rdbtnTamanhoBroto = new JRadioButton("Broto");
		rdbtnTamanhoBroto.setActionCommand("BROTO");
		rdbtnTamanhoBroto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = String.valueOf(VALOR_BROTO + "0");
				lblValorNumerico.setText(valor);
				isPizzaBroto(true);		
			}
		});
		rdbtnTamanhoBroto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoBroto, "flowx,cell 0 1");
		
		
		rdbtnTamanhoMedia = new JRadioButton("M\u00E9dia");
		rdbtnTamanhoMedia.setActionCommand("MEDIA");
		rdbtnTamanhoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = String.valueOf(VALOR_MEDIA + "0");
				lblValorNumerico.setText(valor);
				isPizzaBroto(false);
			}
		});
		rdbtnTamanhoMedia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoMedia, "cell 0 1");
		
		rdbtnTamanhoGrande = new JRadioButton("Grande");
		rdbtnTamanhoGrande.setActionCommand("GRANDE");
		rdbtnTamanhoGrande.setSelected(true);
		rdbtnTamanhoGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = String.valueOf(VALOR_GRANDE + "0");
				lblValorNumerico.setText(valor);
				isPizzaBroto(false);
			}
		});
		rdbtnTamanhoGrande.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoGrande, "cell 0 1");
		
		rdbtnTamanhoGigante = new JRadioButton("Gigante");
		rdbtnTamanhoGigante.setActionCommand("GIGANTE");
		rdbtnTamanhoGigante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = String.valueOf(VALOR_GIGANTE + "0");
				lblValorNumerico.setText(valor);
				isPizzaBroto(false);
			}
		});
		rdbtnTamanhoGigante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoGigante, "cell 0 1");
		
		final ButtonGroup btgpTamanho = new ButtonGroup();
		btgpTamanho.add(rdbtnTamanhoBroto);
		btgpTamanho.add(rdbtnTamanhoMedia);
		btgpTamanho.add(rdbtnTamanhoGrande);
		btgpTamanho.add(rdbtnTamanhoGigante);
		
		JPanel PanelNSabores = new JPanel();
		PanelNSabores.setBounds(561, 174, 393, 78);
		PanelNSabores.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(PanelNSabores);
		PanelNSabores.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblNewLabel_2 = new JLabel("N\u00BA Sabores:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PanelNSabores.add(lblNewLabel_2, "cell 0 0");
		
		rdbtNsaboresUnico = new JRadioButton("Sabor \u00FAnico");
		rdbtNsaboresUnico.setActionCommand("UM SABOR");
		rdbtNsaboresUnico.setSelected(true);
		rdbtNsaboresUnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSegundoSabor.setEnabled(false);
				cbSegundoSabor.setEnabled(false);
				cbSegundoSabor.setSelectedIndex(0);
				lblTerceiroSabor.setEnabled(false);
				cbTerceiroSabor.setEnabled(false);
				cbTerceiroSabor.setSelectedIndex(0);
			}
			
		});
		rdbtNsaboresUnico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PanelNSabores.add(rdbtNsaboresUnico, "flowx,cell 0 1");
		
		rdbtNsaboresDois = new JRadioButton("Dois sabores");
		rdbtNsaboresDois.setActionCommand("DOIS SABORES");
		rdbtNsaboresDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				lblSegundoSabor.setEnabled(true);
				cbSegundoSabor.setEnabled(true);
				lblTerceiroSabor.setEnabled(false);
				cbTerceiroSabor.setSelectedIndex(0);
				cbTerceiroSabor.setEnabled(false);
				
			}
		});
		rdbtNsaboresDois.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PanelNSabores.add(rdbtNsaboresDois, "cell 0 1");
		
		rdbtNsaboresTres = new JRadioButton("Tr\u00EAs sabores");
		rdbtNsaboresTres.setActionCommand("TRES SABORES");
		rdbtNsaboresTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSegundoSabor.setEnabled(true);
				cbSegundoSabor.setEnabled(true);
				lblTerceiroSabor.setEnabled(true);
				cbTerceiroSabor.setEnabled(true);
			}
		});
		rdbtNsaboresTres.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PanelNSabores.add(rdbtNsaboresTres, "cell 0 1");
		
		btgpNSabores = new ButtonGroup();
		btgpNSabores.add(rdbtNsaboresUnico);
		btgpNSabores.add(rdbtNsaboresDois);
		btgpNSabores.add(rdbtNsaboresTres);
		
		lblPrimeiroSabor = new JLabel("Primeiro sabor:");
		lblPrimeiroSabor.setBounds(31, 290, 149, 27);
		lblPrimeiroSabor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblPrimeiroSabor);
		
		lblSegundoSabor = new JLabel("Segundo sabor:");
		lblSegundoSabor.setEnabled(false);
		lblSegundoSabor.setBounds(342, 290, 153, 27);
		lblSegundoSabor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblSegundoSabor);
		
		lblTerceiroSabor = new JLabel("Terceiro sabor:");
		lblTerceiroSabor.setEnabled(false);
		lblTerceiroSabor.setBounds(653, 290, 149, 27);
		lblTerceiroSabor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblTerceiroSabor);
		
		cbPrimeiroSabor = new JComboBox();
		cbPrimeiroSabor.setModel(new DefaultComboBoxModel(new String[] {"Selecione um sabor", "Alho e \u00F3leo", "Bacon", "Bolonhesa", "Br\u00F3colis", "Calabresa", "Frango", "Lombinho", "Marguerita", "Mussarela", "Portuguesa", "Quatro queijos"}));
		cbPrimeiroSabor.setBounds(31, 322, 301, 26);
		cbPrimeiroSabor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(cbPrimeiroSabor);
		
		cbSegundoSabor = new JComboBox();
		cbSegundoSabor.setModel(new DefaultComboBoxModel(new String[] {"Selecione um sabor", "Alho e \u00F3leo", "Bacon", "Bolonhesa", "Br\u00F3colis", "Calabresa", "Frango", "Lombinho", "Marguerita", "Mussarela", "Portuguesa", "Quatro queijos"}));
		cbSegundoSabor.setEnabled(false);
		cbSegundoSabor.setBounds(342, 322, 301, 26);
		cbSegundoSabor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(cbSegundoSabor);
		
		cbTerceiroSabor = new JComboBox();
		cbTerceiroSabor.setModel(new DefaultComboBoxModel(new String[] {"Selecione um sabor", "Alho e \u00F3leo", "Bacon", "Bolonhesa", "Br\u00F3colis", "Calabresa", "Frango", "Lombinho", "Marguerita", "Mussarela", "Portuguesa", "Quatro queijos"}));
		cbTerceiroSabor.setEnabled(false);
		cbTerceiroSabor.setBounds(653, 322, 301, 26);
		cbTerceiroSabor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(cbTerceiroSabor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 980, 140);
		panel_2.setBackground(Color.LIGHT_GRAY);
		add(panel_2);
		
		JLabel lblAdicionarPeedido = new JLabel("Adicionar Pedido");
		panel_2.add(lblAdicionarPeedido);
		lblAdicionarPeedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarPeedido.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblAdicionarPeedido.setIcon(new ImageIcon(TelaAdicionarPedido.class.getResource("/br/com/pizza/icons/pizza.png")));
		
		JLabel lblValorTotal = new JLabel("Valor Total: R$");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblValorTotal.setBounds(31, 622, 149, 32);
		add(lblValorTotal);
		
		JLabel lblTelCliente = new JLabel("Telefone Do Cliente:");
		lblTelCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTelCliente.setBounds(31, 369, 207, 27);
		add(lblTelCliente);
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
			txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtTelefone.setBounds(248, 369, 143, 28);
			add(txtTelefone);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
	        System.out.println("Causa da exceção: " + e1.getMessage());
		}
		
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeCliente.setBounds(31, 411, 360, 32);
		add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnderecoCliente.setEditable(false);
		txtEnderecoCliente.setBounds(401, 411, 560, 32);
		add(txtEnderecoCliente);
		txtEnderecoCliente.setColumns(10);
		
		lblValorNumerico = new JLabel("");
		lblValorNumerico.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblValorNumerico.setBounds(183, 628, 90, 21);
		add(lblValorNumerico);
		
		JButton btnFazerPedido = new JButton("Confirmar Pedido");
		btnFazerPedido.setIcon(new ImageIcon(TelaAdicionarPedido.class.getResource("/br/com/pizza/icons/add.png")));
		btnFazerPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFazerPedido.setForeground(Color.BLACK);
		btnFazerPedido.setBounds(440, 616, 237, 43);
		add(btnFazerPedido);
		
		btnFazerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PizzaController pController = new PizzaController();
				PizzaVO pVo = new PizzaVO();
				pVo.setTamanho(btgpTamanho.getSelection().getActionCommand());
				pVo.setTelefoneCliente(txtTelefone.getText().replace(")", "").replace("(", "").replace("-", "").replace(" ", ""));
				pVo.setObservacoes(txtObservacoes.getText());
			//FAZER	pVo.setValor(VALOR_);
				if(cbPrimeiroSabor.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um sabor");
				} else if (cbSegundoSabor.getSelectedIndex() == 0 && rdbtNsaboresUnico.isSelected() == false){
					JOptionPane.showMessageDialog(null, "Selecione um sabor");
				} else if(cbTerceiroSabor.getSelectedIndex() == 0 && !rdbtNsaboresTres.isSelected() == false){
					JOptionPane.showMessageDialog(null, "Selecione um sabor");
				} else {
					pVo.setSabor1(cbPrimeiroSabor.getSelectedItem().toString().toUpperCase());
					pVo.setSabor2(cbSegundoSabor.getSelectedItem().toString().toUpperCase());
					pVo.setSabor3(cbTerceiroSabor.getSelectedItem().toString().toUpperCase());
					JOptionPane.showMessageDialog(null, pVo.getTamanho() + "\n" + pVo.getSabor1());
				}
			}
		});
		
		
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setIcon(new ImageIcon(TelaAdicionarPedido.class.getResource("/br/com/pizza/icons/borracha.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(687, 616, 237, 43);
		add(btnCancelar);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblObservacoes.setBounds(31, 454, 138, 28);
		add(lblObservacoes);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController cController = new ClienteController();
				ClienteVO cliente = new ClienteVO();
				String telefone = new String();
				
				telefone = txtTelefone.getText().replace(")", "").replace("(", "").replace("-", "").replace(" ", "");			
				cliente = cController.pesquisarPorTelefone(telefone);
				if(cliente != null) {
					txtNomeCliente.setText(cliente.getNome());
					txtEnderecoCliente.setText(cliente.getEndereco());
				}
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.setBounds(401, 368, 90, 34);
		add(btnPesquisar);
		
		txtObservacoes = new JTextArea();
		txtObservacoes.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtObservacoes.setLineWrap(true);
		
		txtObservacoes.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtObservacoes.setBounds(28, 493, 926, 118);
		add(txtObservacoes);
		txtObservacoes.setWrapStyleWord(true);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 274, 980, 5);
		add(separator);
		txtObservacoes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtObservacoes.getText().length() == 250 || txtObservacoes.getText().length() > 250 )
	            {
	                e.consume();
	            }
			}
		});
		
		
	}

	public void isPizzaBroto(boolean b) {
		if(b) {
			rdbtNsaboresUnico.setSelected(true);
			rdbtNsaboresDois.setEnabled(false);
			rdbtNsaboresTres.setEnabled(false);
			lblSegundoSabor.setEnabled(false);
			lblTerceiroSabor.setEnabled(false);
			cbSegundoSabor.setEnabled(false);
			cbSegundoSabor.setSelectedIndex(0);
			cbTerceiroSabor.setEnabled(false);
			cbTerceiroSabor.setSelectedIndex(0);
		} else {
			rdbtNsaboresDois.setEnabled(true);
			rdbtNsaboresTres.setEnabled(true);
		}
		
	}
	
	private void limparTela() {
		txtTelefone.setValue(null);
		txtNomeCliente.setText(null);
		txtEnderecoCliente.setText(null);
		txtObservacoes.setText(null);
	}
}
