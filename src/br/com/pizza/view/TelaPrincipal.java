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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPedidos = new JMenu("Pedidos");
		mnPedidos.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		mnPedidos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/fazerPedido.png")));
		menuBar.add(mnPedidos);
		
		JMenuItem mntmPedidosAdicionar = new JMenuItem("Adicionar");
		mntmPedidosAdicionar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosAdicionar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/add.png")));
		mnPedidos.add(mntmPedidosAdicionar);
		
		JMenuItem mntmPedidosConsultar = new JMenuItem("Consultar");
		mntmPedidosConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/loupe.png")));
		mnPedidos.add(mntmPedidosConsultar);
		
		JMenuItem mntmPedidosExcluir = new JMenuItem("Excluir");
		mntmPedidosExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/delete.png")));
		mnPedidos.add(mntmPedidosExcluir);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		mnClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/Cliente.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmClientesAdicionar = new JMenuItem("Adicionar");
		mntmClientesAdicionar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesAdicionar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/add.png")));
		mnClientes.add(mntmClientesAdicionar);
		
		JMenuItem mntmClientesConsultar = new JMenuItem("Consultar");
		mntmClientesConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/loupe.png")));
		mnClientes.add(mntmClientesConsultar);
		
		JMenuItem mntmClientesEditar = new JMenuItem("Editar");
		mntmClientesEditar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesEditar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/edit.png")));
		mnClientes.add(mntmClientesEditar);
		
		JMenuItem mntmClientesExcluir = new JMenuItem("Excluir");
		mntmClientesExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/delete.png")));
		mnClientes.add(mntmClientesExcluir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
