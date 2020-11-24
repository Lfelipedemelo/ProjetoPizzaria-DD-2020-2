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
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

	private TelaEditarPedido editarPedido;
	private TelaAtualizarPedido atualizarPedido;

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
					frame.setSize(1024, 768);
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
		setPreferredSize(new Dimension(1024, 800));
		setMinimumSize(new Dimension(1024, 800));
		setMaximumSize(new Dimension(1024, 800));

		setTitle("Pizzaria Dale Pizza");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaPrincipal.class.getResource("/br/com/pizza/icons/pizzaLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 768);

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
				revalidate();
			}
		});
		mntmPedidosAdicionar.setIconTextGap(25);
		mntmPedidosAdicionar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosAdicionar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/add.png")));
		mnPedidos.add(mntmPedidosAdicionar);

		JMenuItem mntmPedidosConsultar = new JMenuItem("Consultar");

		mntmPedidosConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarPedido consultarPedido = new TelaConsultarPedido();
				setContentPane(consultarPedido);
				revalidate();
			}
		});
		mntmPedidosConsultar.setIconTextGap(25);
		mntmPedidosConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmPedidosConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/lupa.png")));
		mnPedidos.add(mntmPedidosConsultar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Editar");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				editarPedido = new TelaEditarPedido();
				editarPedido.getBtnEditar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaAtualizarPedido atualizar = new TelaAtualizarPedido();
						atualizar.setPedidoSelecionado(editarPedido.getPedidoSelecionado());
						setContentPane(atualizar);
						revalidate();
					}
				});
				setContentPane(editarPedido);
				revalidate();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/edit.png")));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnPedidos.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Excluir");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirPedido excluirPedido = new TelaExcluirPedido();
				setContentPane(excluirPedido);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/delete.png")));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnPedidos.add(mntmNewMenuItem_1);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		mnClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/cliente.png")));
		menuBar.add(mnClientes);

		JMenuItem mntmClientesAdicionar = new JMenuItem("Adicionar");
		mntmClientesAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarCliente addCliente = new TelaAdicionarCliente();
				setContentPane(addCliente);
				revalidate();
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
				revalidate();
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
				revalidate();
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
				revalidate();
			}
		});
		mntmClientesExcluir.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mntmClientesExcluir.setIconTextGap(25);
		mntmClientesExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmClientesExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/delete.png")));
		mnClientes.add(mntmClientesExcluir);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/pizza/icons/informacoes.png")));
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
						"SOFTWARE CRIADO POR:" + "\nBryan Richard Lohn e Luis Felipe de Melo", "Sobre",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnSobre.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuBar.add(mnSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { mnPedidos, mntmPedidosAdicionar,
				mntmPedidosConsultar, mnClientes, mntmClientesAdicionar, mntmClientesConsultar, mntmClientesEditar,
				mntmClientesExcluir, contentPane, menuBar }));
	}

}
