package atvbiblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telalogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telalogin frame = new telalogin();
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
	public telalogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Central do usuário");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(66, 10, 266, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("USUÁRIOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cadastrousuario cadastrousuario = new cadastrousuario();
				cadastrousuario.setLocationRelativeTo(cadastrousuario);
				cadastrousuario.setVisible(true);
			}
		});
		btnNewButton.setBounds(113, 83, 137, 48);
		contentPane.add(btnNewButton);
		
		JButton btnGerenciarAutores = new JButton("AUTORES");
		btnGerenciarAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cadastroautor cadastroautor = new cadastroautor();
				cadastroautor.setLocationRelativeTo(btnGerenciarAutores);
				cadastroautor.setVisible(true);
			}
		});
		btnGerenciarAutores.setBounds(113, 172, 137, 48);
		contentPane.add(btnGerenciarAutores);
		
		JButton btnClientes = new JButton("LIVROS");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cadastrolivros cadastrolivros = new cadastrolivros();
				cadastrolivros.setLocationRelativeTo(btnClientes);
				cadastrolivros.setVisible(true);
			}
		});
		btnClientes.setBounds(113, 261, 137, 48);
		contentPane.add(btnClientes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(140, 292, 1, 2);
		contentPane.add(separator);
		
		JButton btnEmprestimo = new JButton("EMPRESTIMO");
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cadastroemprestimo cadastroemprestimo = new cadastroemprestimo();
				cadastroemprestimo.setLocationRelativeTo(btnClientes);
				cadastroemprestimo.setVisible(true);
			}
		});
		btnEmprestimo.setBounds(113, 358, 137, 48);
		contentPane.add(btnEmprestimo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(506, 281, 0, 13);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 152, 367, 26);
		contentPane.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(0, 237, 367, 26);
		contentPane.add(separator_2_1);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(0, 331, 367, 26);
		contentPane.add(separator_2_2);
	}
}
