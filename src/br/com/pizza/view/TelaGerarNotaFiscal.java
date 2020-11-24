package br.com.pizza.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.pizza.model.vo.ClienteVO;
import br.com.pizza.model.vo.PizzaVO;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class TelaGerarNotaFiscal extends JFrame {

	private JPanel contentPane;
	private static PizzaVO pedido;
	private static ClienteVO cliente;

	
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
					TelaGerarNotaFiscal frame = new TelaGerarNotaFiscal(pedido, cliente);
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
	public TelaGerarNotaFiscal(PizzaVO pedido, ClienteVO cliente) {
		this.pedido = pedido;
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSucesso = new JLabel("Pedido adicionado com sucesso");
		lblSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucesso.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSucesso.setBounds(10, 11, 414, 72);
		contentPane.add(lblSucesso);
		
		JButton lblGerarPdf = new JButton("Gerar PDF");
		lblGerarPdf.setIcon(new ImageIcon(TelaGerarNotaFiscal.class.getResource("/br/com/pizza/icons/pdf.png")));
		lblGerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarPdf();
				dispose();
			}
		});
		lblGerarPdf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGerarPdf.setBounds(10, 123, 153, 41);
		contentPane.add(lblGerarPdf);
		
		JButton lblCancelar = new JButton("Cancelar");
		lblCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		lblCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCancelar.setBounds(271, 123, 153, 41);
		contentPane.add(lblCancelar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 94, 414, 2);
		contentPane.add(separator);
	}

	protected void gerarPdf() {
		
		Document doc = new Document();
		String arquivoPdf = "NotaFiscal.pdf";
				
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
			doc.open();
			Image logo = Image.getInstance(TelaGerarNotaFiscal.class.getResource("/br/com/pizza/icons/pizzaLogo64px.png"));
			logo.setAlignment(1);
			doc.add(logo);
			Paragraph p = new Paragraph("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph("||||||||PIZZARIA DALE PIZZA||||||||");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			p.setAlignment(1);
			doc.add(p);
			
			p = new Paragraph("\n\n\nCLIENTE\n\n");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph("Nome: " + cliente.getNome());
			doc.add(p);
			p = new Paragraph("Entrega: " + cliente.getEndereco());
			doc.add(p);
			p = new Paragraph("Telefone: " + cliente.getTelefone());
			doc.add(p);
			p = new Paragraph("\nPEDIDO\n");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph("PIZZA " + pedido.getTamanho());
			doc.add(p);
			p = new Paragraph("Sabores: " + pedido.getSabor1() + "   " + pedido.getSabor2() + "   " + pedido.getSabor3());
			doc.add(p);
			p = new Paragraph("Observações: " + pedido.getObservacoes());
			doc.add(p);
			p = new Paragraph("Valor: R$" + pedido.getValor() + "0");
			doc.add(p);
			doc.close();
			Desktop.getDesktop().open(new File(arquivoPdf));			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
