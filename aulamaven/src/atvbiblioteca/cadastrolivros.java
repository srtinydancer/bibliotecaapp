package atvbiblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class cadastrolivros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldtitulolivro;
	private JTextField textFieldautorlivro;
	private JTextField textFieldgenerolivro;
	private JTextField textFieldeditoralivro;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrolivros frame = new cadastrolivros();
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
	public cadastrolivros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(0, 0, 848, 548);
		contentPane.add(contentPane_1);
		
		JLabel lblCadastroDeLivro = new JLabel("LIVROS");
		lblCadastroDeLivro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblCadastroDeLivro.setBounds(369, 10, 334, 33);
		contentPane_1.add(lblCadastroDeLivro);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 104, 189, 2);
		contentPane_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(425, 104, -177, 2);
		contentPane_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(425, 104, -209, 9);
		contentPane_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(236, 104, 200, 2);
		contentPane_1.add(separator_3);
		
		JLabel lbltitulolivro = new JLabel("Título");
		lbltitulolivro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltitulolivro.setBounds(190, 93, 131, 13);
		contentPane_1.add(lbltitulolivro);
		
		textFieldtitulolivro = new JTextField();
		textFieldtitulolivro.setColumns(10);
		textFieldtitulolivro.setBounds(51, 133, 319, 19);
		contentPane_1.add(textFieldtitulolivro);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(0, 189, 189, 1);
		contentPane_1.add(separator_4);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(227, 188, 209, 2);
		contentPane_1.add(separator_3_1);
		
		JLabel lblautorlivro = new JLabel("Autor");
		lblautorlivro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblautorlivro.setBounds(190, 177, 131, 13);
		contentPane_1.add(lblautorlivro);
		
		textFieldautorlivro = new JTextField();
		textFieldautorlivro.setColumns(10);
		textFieldautorlivro.setBounds(51, 211, 319, 19);
		contentPane_1.add(textFieldautorlivro);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 269, 187, 2);
		contentPane_1.add(separator_5);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setBounds(236, 269, 200, 2);
		contentPane_1.add(separator_3_2);
		
		JLabel lblgenerolivro = new JLabel("Gênero");
		lblgenerolivro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblgenerolivro.setBounds(183, 259, 131, 13);
		contentPane_1.add(lblgenerolivro);
		
		textFieldgenerolivro = new JTextField();
		textFieldgenerolivro.setColumns(10);
		textFieldgenerolivro.setBounds(51, 297, 319, 19);
		contentPane_1.add(textFieldgenerolivro);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 355, 189, 2);
		contentPane_1.add(separator_6);
		
		JSeparator separator_3_3 = new JSeparator();
		separator_3_3.setBounds(247, 355, 189, 2);
		contentPane_1.add(separator_3_3);
		
		JLabel lbleditoralivro = new JLabel("Editora");
		lbleditoralivro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbleditoralivro.setBounds(190, 344, 131, 13);
		contentPane_1.add(lbleditoralivro);
		
		textFieldeditoralivro = new JTextField();
		textFieldeditoralivro.setColumns(10);
		textFieldeditoralivro.setBounds(51, 384, 319, 19);
		contentPane_1.add(textFieldeditoralivro);
		
		JButton btnconfirmarlivro = new JButton("CONFIRMAR");
		btnconfirmarlivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					Class.forName("org.sqlite.JDBC");
				
				Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
				PreparedStatement p = c.prepareStatement("insert into livros(TituloLivro, AutorLivro, GeneroLivro, EditoraLivro) values (?,?,?,?)");
				p.setString(1, textFieldtitulolivro.getText()  );
				p.setString(2, textFieldautorlivro.getText()  );
				p.setString(3, textFieldgenerolivro.getText()  );
				p.setString(4, textFieldeditoralivro.getText()  );
				p.execute();
				Statement s = c.createStatement();
			    ResultSet r = s.executeQuery("select TituloLivro, Autorlivro, GeneroLivro, EditoraLivro from livros");
			    
			    DefaultTableModel t = (DefaultTableModel) table.getModel();
			    t.setRowCount(0);
			    
			    while (r.next()) {
			    	
			    	t.addRow(new String[] {  r.getString("TituloLivro"), r.getString("Autorlivro"), r.getString("GeneroLivro"), r.getString("EditoraLivro")
			    			});
			    }
			    
				table.setEnabled(true);
				
				JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnconfirmarlivro.setForeground(Color.WHITE);
		btnconfirmarlivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnconfirmarlivro.setBackground(Color.GREEN);
		btnconfirmarlivro.setBounds(258, 474, 126, 34);
		contentPane_1.add(btnconfirmarlivro);
		
		JButton btnvoltarlivro = new JButton("VOLTAR");
		btnvoltarlivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				telalogin telalogin = new telalogin();
				telalogin.setLocationRelativeTo(btnvoltarlivro);
				telalogin.setVisible(true);
			}
		});
		btnvoltarlivro.setForeground(Color.WHITE);
		btnvoltarlivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvoltarlivro.setBackground(Color.BLACK);
		btnvoltarlivro.setBounds(51, 474, 126, 34);
		contentPane_1.add(btnvoltarlivro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(458, 88, 390, 357);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Autor", "Genero", "Editora"
			}
		));
		

		
		JButton btneditarlivros = new JButton("EDITAR");
		btneditarlivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try { 
					int dialogo = JOptionPane.showConfirmDialog(null, "Confirma alteração?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
					if (dialogo != 0 ) { return;
					
					}
					if (table.getSelectedRows(). length != 1) {
						JOptionPane.showMessageDialog(null, "Selecione uma linha");
						return;
					} else {
						Class.forName("org.sqlite.JDBC");
						Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
						PreparedStatement p = c
								.prepareStatement("update livros set TituloLivro= ?, AutorLivro =?, GeneroLivro= ?, EditoraLivro= ? where TituloLivro=?");
						p.setString(1, textFieldtitulolivro.getText()  );
						p.setString(2, textFieldautorlivro.getText()  );
						p.setString(3, textFieldgenerolivro.getText()  );
						p.setString(4, textFieldeditoralivro.getText()  );
						p.setString(5,  table.getValueAt(table.getSelectedRow(), 0) .toString());
						p.execute();
						
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select TituloLivro, AutorLivro, GeneroLivro, EditoraLivro from livros");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("TituloLivro"), r.getString("AutorLivro"), r.getString("GeneroLivro"), r.getString("EditoraLivro")
					    			});
					    }
					    
						table.setEnabled(true);
					}
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				} catch (Exception el) {
					el.printStackTrace();
				}
				
				
			
			
			}
		});
		btneditarlivros.setBounds(473, 474, 126, 34);
		contentPane_1.add(btneditarlivros);
		btneditarlivros.setForeground(Color.WHITE);
		btneditarlivros.setFont(new Font("Tahoma", Font.BOLD, 13));
		btneditarlivros.setBackground(Color.ORANGE);
		
		JButton btnexcluirlivros = new JButton("EXCLUIR");
		btnexcluirlivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int dialogo = JOptionPane.showConfirmDialog(null, "Confirma exclusão?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
				if (dialogo != 0 ) { return;
				
				}
				if (table.getSelectedRows(). length != 1) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
					return;
				} 
				
				try {
						Class.forName("org.sqlite.JDBC");
						Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
						PreparedStatement p = c.prepareStatement("delete from livros where TituloLivro =?");
				
						for(int linha:table.getSelectedRows()) {
						
						p.setString(1,  table.getValueAt( linha , 0).toString());
						p.execute();
						
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select TituloLivro, Autorlivro, GeneroLivro, EditoraLivro from livros");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("TituloLivro"), r.getString("Autorlivro"), r.getString("GeneroLivro"), r.getString("EditoraLivro")
					    			});
					    }
					    
						table.setEnabled(true);
						}
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
				} catch (Exception el) {
					el.printStackTrace();
				}
				
			
			
			}
		});
		btnexcluirlivros.setBounds(665, 474, 126, 34);
		contentPane_1.add(btnexcluirlivros);
		btnexcluirlivros.setForeground(Color.WHITE);
		btnexcluirlivros.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexcluirlivros.setBackground(Color.RED);
		
		JButton btnexibirlivro = new JButton("EXIBIR");
		btnexibirlivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
					Statement s = c.createStatement();
				    ResultSet r = s.executeQuery("select TituloLivro, Autorlivro, GeneroLivro, EditoraLivro from livros");
				    
				    DefaultTableModel t = (DefaultTableModel) table.getModel();
				    t.setRowCount(0);
				    
				    while (r.next()) {
				    	
				    	t.addRow(new String[] {  r.getString("TituloLivro"), r.getString("Autorlivro"), r.getString("GeneroLivro"), r.getString("EditoraLivro")
				    			});
				    }
				    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			
			
			}
		});
		btnexibirlivro.setForeground(Color.WHITE);
		btnexibirlivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexibirlivro.setBackground(Color.BLUE);
		btnexibirlivro.setBounds(722, 54, 126, 34);
		contentPane_1.add(btnexibirlivro);
	}
	
	
}
