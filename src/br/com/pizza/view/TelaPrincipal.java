package br.com.pizza.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.border.CompoundBorder;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Window.Type;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		
		setTitle("Pizzaria Pizza e Pizza");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/com/pizza/icons/pizzaLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 800);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/pizzaLogo64px.png")));
		menuBar.add(lblNewLabel);
		
		JMenu mnPedidos = new JMenu("Pedidos");
		mnPedidos.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		mnPedidos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/fazerPedido.png")));
		menuBar.add(mnPedidos);
		
		JMenuItem mntmPedidosAdicionar = new JMenuItem("Adicionar");
		mntmPedidosAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarPedido addPedido = new TelaAdicionarPedido();
				setContentPane(addPedido);
			}
		});
		mntmPedidosAdicionar.setIconTextGap(25);
		mntmPedidosAdicionar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosAdicionar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/add.png")));
		mnPedidos.add(mntmPedidosAdicionar);
		
		JMenuItem mntmPedidosConsultar = new JMenuItem("Consultar");
		mntmPedidosConsultar.setIconTextGap(25);
		mntmPedidosConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/lupa.png")));
		mnPedidos.add(mntmPedidosConsultar);
		
		JMenuItem mntmPedidosExcluir = new JMenuItem("Excluir");
		mntmPedidosExcluir.setIconTextGap(25);
		mntmPedidosExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/delete.png")));
		mnPedidos.add(mntmPedidosExcluir);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		mnClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/Cliente.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmClientesAdicionar = new JMenuItem("Adicionar");
		mntmClientesAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarCliente addCliente = new TelaAdicionarCliente();
				setContentPane(addCliente);
			}
		});
		mntmClientesAdicionar.setHorizontalAlignment(SwingConstants.LEFT);
		mntmClientesAdicionar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mntmClientesAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mntmClientesAdicionar.setIconTextGap(25);
		mntmClientesAdicionar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesAdicionar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/add.png")));
		mnClientes.add(mntmClientesAdicionar);
		
		JMenuItem mntmClientesConsultar = new JMenuItem("Consultar");
		mntmClientesConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultarCliente consultarCliente = new TelaConsultarCliente();
				setContentPane(consultarCliente);
			}
		});
		mntmClientesConsultar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mntmClientesConsultar.setIconTextGap(25);
		mntmClientesConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/lupa.png")));
		mnClientes.add(mntmClientesConsultar);
		
		JMenuItem mntmClientesEditar = new JMenuItem("Editar");
		mntmClientesEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEditarCliente editarCliente = new TelaEditarCliente();
				setContentPane(editarCliente);
			}
		});
		mntmClientesEditar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mntmClientesEditar.setIconTextGap(25);
		mntmClientesEditar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesEditar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/edit.png")));
		mnClientes.add(mntmClientesEditar);
		
		JMenuItem mntmClientesExcluir = new JMenuItem("Excluir");
		mntmClientesExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirCliente excluirCliente = new TelaExcluirCliente();
				setContentPane(excluirCliente);
			}
		});
		mntmClientesExcluir.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mntmClientesExcluir.setIconTextGap(25);
		mntmClientesExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/delete.png")));
		mnClientes.add(mntmClientesExcluir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mnPedidos, mntmPedidosAdicionar, mntmPedidosConsultar, mntmPedidosExcluir, mnClientes, mntmClientesAdicionar, mntmClientesConsultar, mntmClientesEditar, mntmClientesExcluir, contentPane, menuBar}));
	}

}
