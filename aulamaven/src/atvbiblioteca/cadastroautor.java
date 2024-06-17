package atvbiblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class cadastroautor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnomecompletoautor;
	private JTextField textFieldgenerolit;
	private JTextField textFielddatadenascautor;
	private JTextField textFieldnacionalidadeautor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroautor frame = new cadastroautor();
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
	public cadastroautor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 566);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(0, 0, 853, 550);
		contentPane.add(contentPane_1);
		
		JLabel lblCadastroDeAutor = new JLabel("AUTORIA");
		lblCadastroDeAutor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblCadastroDeAutor.setBounds(345, 10, 334, 33);
		contentPane_1.add(lblCadastroDeAutor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 104, 158, 2);
		contentPane_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(425, 104, -177, 2);
		contentPane_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(425, 104, -209, 9);
		contentPane_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(271, 104, 165, 2);
		contentPane_1.add(separator_3);
		
		JLabel lblnomecompletoautor = new JLabel("Nome completo");
		lblnomecompletoautor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnomecompletoautor.setBounds(156, 93, 131, 13);
		contentPane_1.add(lblnomecompletoautor);
		
		textnomecompletoautor = new JTextField();
		textnomecompletoautor.setColumns(10);
		textnomecompletoautor.setBounds(51, 133, 319, 19);
		contentPane_1.add(textnomecompletoautor);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(0, 189, 189, 1);
		contentPane_1.add(separator_4);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(253, 188, 183, 2);
		contentPane_1.add(separator_3_1);
		
		JLabel lblgeneroautor = new JLabel("Gênero lit");
		lblgeneroautor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblgeneroautor.setBounds(180, 177, 131, 13);
		contentPane_1.add(lblgeneroautor);
		
		textFieldgenerolit = new JTextField();
		textFieldgenerolit.setColumns(10);
		textFieldgenerolit.setBounds(51, 211, 319, 19);
		contentPane_1.add(textFieldgenerolit);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 269, 165, 2);
		contentPane_1.add(separator_5);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setBounds(259, 269, 177, 2);
		contentPane_1.add(separator_3_2);
		
		JLabel lbldatadenascautor = new JLabel("Data de nasc");
		lbldatadenascautor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldatadenascautor.setBounds(166, 258, 131, 13);
		contentPane_1.add(lbldatadenascautor);
		
		textFielddatadenascautor = new JTextField();
		textFielddatadenascautor.setColumns(10);
		textFielddatadenascautor.setBounds(51, 297, 319, 19);
		contentPane_1.add(textFielddatadenascautor);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 355, 165, 2);
		contentPane_1.add(separator_6);
		
		JSeparator separator_3_3 = new JSeparator();
		separator_3_3.setBounds(271, 355, 165, 2);
		contentPane_1.add(separator_3_3);
		
		JLabel lblnacionalidadeautor = new JLabel("Nacionalidade");
		lblnacionalidadeautor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnacionalidadeautor.setBounds(166, 344, 131, 13);
		contentPane_1.add(lblnacionalidadeautor);
		
		textFieldnacionalidadeautor = new JTextField();
		textFieldnacionalidadeautor.setColumns(10);
		textFieldnacionalidadeautor.setBounds(51, 384, 319, 19);
		contentPane_1.add(textFieldnacionalidadeautor);
		
		JButton btnconfirmarautor = new JButton("CONFIRMAR");
		btnconfirmarautor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					Class.forName("org.sqlite.JDBC");
				
				Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
				PreparedStatement p = c.prepareStatement("insert into autor(NomeAutor, GeneroAutor, NascAutor, NacionalidadeAutor) values (?,?,?,?)");
				p.setString(1, textnomecompletoautor.getText()  );
				p.setString(2, textFieldgenerolit.getText()  );
				p.setString(3, textFielddatadenascautor.getText()  );
				p.setString(4, textFieldnacionalidadeautor.getText()  );
				p.execute();
				
				Statement s = c.createStatement();
			    ResultSet r = s.executeQuery("select NomeAutor, GeneroAutor, NascAutor, NacionalidadeAutor from autor");
			    
			    DefaultTableModel t = (DefaultTableModel) table.getModel();
			    t.setRowCount(0);
			    
			    while (r.next()) {
			    	
			    	t.addRow(new String[] {  r.getString("NomeAutor"), r.getString("GeneroAutor"), r.getString("NascAutor"), r.getString("NacionalidadeAutor")
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
		btnconfirmarautor.setForeground(Color.WHITE);
		btnconfirmarautor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnconfirmarautor.setBackground(Color.GREEN);
		btnconfirmarautor.setBounds(253, 470, 126, 34);
		contentPane_1.add(btnconfirmarautor);
		
		JButton btnvoltarautor = new JButton("VOLTAR");
		btnvoltarautor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				telalogin telalogin = new telalogin();
				telalogin.setLocationRelativeTo(btnvoltarautor);
				telalogin.setVisible(true);
			}
		});
		btnvoltarautor.setForeground(Color.WHITE);
		btnvoltarautor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvoltarautor.setBackground(Color.BLACK);
		btnvoltarautor.setBounds(51, 470, 126, 34);
		contentPane_1.add(btnvoltarautor);
		
		JButton btneditarautor = new JButton("EDITAR");
		btneditarautor.addActionListener(new ActionListener() {
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
								.prepareStatement("update autor set NomeAutor= ?, GeneroAutor =?, NascAutor= ?, NacionalidadeAutor= ? where NomeAutor=?");
						p.setString(1, textnomecompletoautor.getText()  );
						p.setString(2, textFieldgenerolit.getText()  );
						p.setString(3, textFielddatadenascautor.getText()  );
						p.setString(4, textFieldnacionalidadeautor.getText()  );
						p.setString(5,  table.getValueAt(table.getSelectedRow(), 0) .toString());
						p.execute();
						
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select NomeAutor, GeneroAutor, NascAutor, NacionalidadeAutor from autor");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("NomeAutor"), r.getString("GeneroAutor"), r.getString("NascAutor"), r.getString("NacionalidadeAutor")
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
		btneditarautor.setBounds(492, 470, 126, 34);
		contentPane_1.add(btneditarautor);
		btneditarautor.setForeground(Color.WHITE);
		btneditarautor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btneditarautor.setBackground(Color.ORANGE);
		
		JButton btnexcluir = new JButton("EXCLUIR");
		btnexcluir.addActionListener(new ActionListener() {
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
						PreparedStatement p = c.prepareStatement("delete from autor where NomeAutor =?");
				
						for(int linha:table.getSelectedRows()) {
						
						p.setString(1,  table.getValueAt( linha , 0).toString());
						p.execute();
						
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select NomeAutor, GeneroAutor, NascAutor, NacionalidadeAutor from autor");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("NomeAutor"), r.getString("GeneroAutor"), r.getString("NascAutor"), r.getString("NacionalidadeAutor")
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
		btnexcluir.setBounds(696, 470, 126, 34);
		contentPane_1.add(btnexcluir);
		btnexcluir.setForeground(Color.WHITE);
		btnexcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexcluir.setBackground(Color.RED);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(464, 88, 389, 350);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome completo", "Genero lit", "Data de nasc", "Nacionalidade"
			}
		));

		
		JButton btnexibirautor = new JButton("EXIBIR");
		btnexibirautor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				

				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
					Statement s = c.createStatement();
				    ResultSet r = s.executeQuery("select NomeAutor, GeneroAutor, NascAutor, NacionalidadeAutor from autor");
				    
				    DefaultTableModel t = (DefaultTableModel) table.getModel();
				    t.setRowCount(0);
				    
				    while (r.next()) {
				    	
				    	t.addRow(new String[] {  r.getString("NomeAutor"), r.getString("GeneroAutor"), r.getString("NascAutor"), r.getString("NacionalidadeAutor")
				    			});
				    }
				    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			
			
			
			}
		});
		btnexibirautor.setForeground(Color.WHITE);
		btnexibirautor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexibirautor.setBackground(Color.BLUE);
		btnexibirautor.setBounds(727, 53, 126, 34);
		contentPane_1.add(btnexibirautor);
	}

}
