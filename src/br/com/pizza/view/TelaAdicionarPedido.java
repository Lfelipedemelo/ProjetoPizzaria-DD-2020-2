package br.com.pizza.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class TelaAdicionarPedido extends JPanel {
	private JTextField txtTelCliente;
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

	/**
	 * Create the panel.
	 */
	public TelaAdicionarPedido() {
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
		rdbtnTamanhoBroto.setSelected(true);
		rdbtnTamanhoBroto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblValorNumerico.setText("10,50");
			}
		});
		rdbtnTamanhoBroto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoBroto, "flowx,cell 0 1");
		
		JRadioButton rdbtnTamanhoMedia = new JRadioButton("M\u00E9dia");
		rdbtnTamanhoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblValorNumerico.setText("19,90");
			}
		});
		rdbtnTamanhoMedia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoMedia, "cell 0 1");
		
		JRadioButton rdbtnTamanhoGrande = new JRadioButton("Grande");
		rdbtnTamanhoGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblValorNumerico.setText("26,90");
			}
		});
		rdbtnTamanhoGrande.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoGrande, "cell 0 1");
		
		JRadioButton rdbtnTamanhoGigante = new JRadioButton("Gigante");
		rdbtnTamanhoGigante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblValorNumerico.setText("34,90");
			}
		});
		rdbtnTamanhoGigante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTamanho.add(rdbtnTamanhoGigante, "cell 0 1");
		
		ButtonGroup btgpTamanho = new ButtonGroup();
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
		rdbtNsaboresUnico.setSelected(true);
		rdbtNsaboresUnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSegundoSabor.setEnabled(false);
				cbSegundoSabor.setEnabled(false);
				lblTerceiroSabor.setEnabled(false);
				cbTerceiroSabor.setEnabled(false);
			}
			
		});
		rdbtNsaboresUnico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PanelNSabores.add(rdbtNsaboresUnico, "flowx,cell 0 1");
		
		rdbtNsaboresDois = new JRadioButton("Dois sabores");
		rdbtNsaboresDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				lblSegundoSabor.setEnabled(true);
				cbSegundoSabor.setEnabled(true);
				lblTerceiroSabor.setEnabled(false);
				cbTerceiroSabor.setEnabled(false);
			}
		});
		rdbtNsaboresDois.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PanelNSabores.add(rdbtNsaboresDois, "cell 0 1");
		
		rdbtNsaboresTres = new JRadioButton("Tr\u00EAs sabores");
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
		cbPrimeiroSabor.setBounds(31, 322, 301, 26);
		cbPrimeiroSabor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(cbPrimeiroSabor);
		
		cbSegundoSabor = new JComboBox();
		cbSegundoSabor.setEnabled(false);
		cbSegundoSabor.setBounds(342, 322, 301, 26);
		cbSegundoSabor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(cbSegundoSabor);
		
		cbTerceiroSabor = new JComboBox();
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
		
		txtTelCliente = new JTextField();
		txtTelCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTelCliente.setBounds(235, 368, 156, 32);
		add(txtTelCliente);
		txtTelCliente.setColumns(10);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeCliente.setBounds(31, 411, 360, 32);
		add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setEditable(false);
		txtEnderecoCliente.setBounds(401, 411, 560, 32);
		add(txtEnderecoCliente);
		txtEnderecoCliente.setColumns(10);
		
		lblValorNumerico = new JLabel("10,50");
		lblValorNumerico.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblValorNumerico.setBounds(183, 628, 90, 21);
		add(lblValorNumerico);
		
		JButton btnFazerPedido = new JButton("Confirmar Pedido");
		btnFazerPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFazerPedido.setForeground(Color.BLACK);
		btnFazerPedido.setBounds(440, 616, 237, 54);
		add(btnFazerPedido);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(687, 616, 237, 54);
		add(btnCancelar);
		
		JTextPane txtObservacoes = new JTextPane();
		txtObservacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtObservacoes.setBounds(31, 493, 929, 111);
		add(txtObservacoes);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblObservacoes.setBounds(31, 454, 138, 28);
		add(lblObservacoes);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.setBounds(401, 368, 90, 34);
		add(btnPesquisar);
		
	}
}
