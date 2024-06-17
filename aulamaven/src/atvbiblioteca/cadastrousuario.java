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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class cadastrousuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldnomecompletousuario;
	private JTextField textFieldcpf;
	private JTextField textFielddatadenascusuario;
	private JTextField textFieldnacionalidadeusuario;
	private JTable table;
	;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrousuario frame = new cadastrousuario();
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
	public cadastrousuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeUsurio = new JLabel("USUÁRIO");
		lblCadastroDeUsurio.setBounds(362, 10, 334, 33);
		lblCadastroDeUsurio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		contentPane.add(lblCadastroDeUsurio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 104, 158, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(425, 104, -177, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(425, 104, -209, 9);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(271, 104, 165, 2);
		contentPane.add(separator_3);
		
		JLabel lblnomecompletousuario = new JLabel("Nome completo");
		lblnomecompletousuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnomecompletousuario.setBounds(156, 93, 131, 13);
		contentPane.add(lblnomecompletousuario);
		
		textFieldnomecompletousuario = new JTextField();
		textFieldnomecompletousuario.setBounds(51, 133, 319, 19);
		contentPane.add(textFieldnomecompletousuario);
		textFieldnomecompletousuario.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 188, 198, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(220, 188, 216, 2);
		contentPane.add(separator_3_1);
		
		JLabel lblcpf = new JLabel("CPF");
		lblcpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcpf.setBounds(198, 177, 131, 13);
		contentPane.add(lblcpf);
		
		textFieldcpf = new JTextField();
		textFieldcpf.setColumns(10);
		textFieldcpf.setBounds(51, 211, 319, 19);
		contentPane.add(textFieldcpf);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 269, 165, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setBounds(259, 269, 177, 2);
		contentPane.add(separator_3_2);
		
		JLabel lbldatadenascusuario = new JLabel("Data de nasc");
		lbldatadenascusuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldatadenascusuario.setBounds(166, 258, 131, 13);
		contentPane.add(lbldatadenascusuario);
		
		textFielddatadenascusuario = new JTextField();
		textFielddatadenascusuario.setColumns(10);
		textFielddatadenascusuario.setBounds(51, 297, 319, 19);
		contentPane.add(textFielddatadenascusuario);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 355, 165, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_3_3 = new JSeparator();
		separator_3_3.setBounds(271, 355, 165, 2);
		contentPane.add(separator_3_3);
		
		JLabel lblnacionalidadeusuario = new JLabel("Nacionalidade");
		lblnacionalidadeusuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnacionalidadeusuario.setBounds(166, 344, 131, 13);
		contentPane.add(lblnacionalidadeusuario);
		
		textFieldnacionalidadeusuario = new JTextField();
		textFieldnacionalidadeusuario.setColumns(10);
		textFieldnacionalidadeusuario.setBounds(51, 384, 319, 19);
		contentPane.add(textFieldnacionalidadeusuario);
		
		JButton btnsalvarusuario = new JButton("SALVAR");
		btnsalvarusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("org.sqlite.JDBC");
				
				Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
				PreparedStatement p = c.prepareStatement("insert into usuario(NomeUsuario, CPFUsuario, DatadeNascUsuario, NacionalidadeUsuario) values (?,?,?,?)");
				p.setString(1, textFieldnomecompletousuario.getText()  );
				p.setString(2, textFieldcpf.getText()  );
				p.setString(3, textFielddatadenascusuario.getText()  );
				p.setString(4, textFieldnacionalidadeusuario.getText()  );
				p.execute();
				
				Statement s = c.createStatement();
			    ResultSet r = s.executeQuery("select NomeUsuario, CPFUsuario, DatadeNascUsuario, NacionalidadeUsuario from usuario");
			    
			    DefaultTableModel t = (DefaultTableModel) table.getModel();
			    t.setRowCount(0);
			    
			    while (r.next()) {
			    	
			    	t.addRow(new String[] {  r.getString("NomeUsuario"), r.getString("CPFUsuario"), r.getString("DatadeNascUsuario"), r.getString("NacionalidadeUsuario")
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
		btnsalvarusuario.setBackground(Color.GREEN);
		btnsalvarusuario.setForeground(Color.WHITE);
		btnsalvarusuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsalvarusuario.setBounds(259, 474, 126, 34);
		contentPane.add(btnsalvarusuario);
		
		JButton btnvoltarusuario = new JButton("VOLTAR");
		btnvoltarusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				telalogin telalogin = new telalogin();
				telalogin.setLocationRelativeTo(btnvoltarusuario);
				telalogin.setVisible(true);
			}
		});
		btnvoltarusuario.setBackground(Color.BLACK);
		btnvoltarusuario.setForeground(Color.WHITE);
		btnvoltarusuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvoltarusuario.setBounds(51, 474, 126, 34);
		contentPane.add(btnvoltarusuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(469, 88, 376, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome completo", "CPF", "Data de nasc", "Nacionalidade"
			}
		));
		

		
		
		JButton btneditarusuario = new JButton("EDITAR");
		btneditarusuario.addActionListener(new ActionListener() {
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
								.prepareStatement("update usuario set NomeUsuario= ?, CPFUsuario =?, DatadeNascUsuario= ?, NacionalidadeUsuario= ? where NomeUsuario=?");
						p.setString(1, textFieldnomecompletousuario.getText()  );
						p.setString(2, textFieldcpf.getText()  );
						p.setString(3, textFielddatadenascusuario.getText()  );
						p.setString(4, textFieldnacionalidadeusuario.getText()  );
						p.setString(5,  table.getValueAt(table.getSelectedRow(), 0) .toString());
						p.execute();
						
						p.executeUpdate();
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select NomeUsuario, CPFUsuario, DatadeNascUsuario, NacionalidadeUsuario from usuario");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("NomeUsuario"), r.getString("CPFUsuario"), r.getString("DatadeNascUsuario"), r.getString("NacionalidadeUsuario")
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
		btneditarusuario.setForeground(Color.WHITE);
		btneditarusuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btneditarusuario.setBackground(Color.ORANGE);
		btneditarusuario.setBounds(469, 474, 126, 34);
		contentPane.add(btneditarusuario);
		
		JButton btnexcluirusuario = new JButton("EXCLUIR");
		btnexcluirusuario.addActionListener(new ActionListener() {
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
						PreparedStatement p = c.prepareStatement("delete from usuario where NomeUsuario =?");
				
						for(int linha:table.getSelectedRows()) {
						
						p.setString(1,  table.getValueAt( linha , 0).toString());
						p.execute();
						
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select NomeUsuario, CPFUsuario, DatadeNascUsuario, NacionalidadeUsuario from usuario");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("NomeUsuario"), r.getString("CPFUsuario"), r.getString("DatadeNascUsuario"), r.getString("NacionalidadeUsuario")
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
		btnexcluirusuario.setForeground(Color.WHITE);
		btnexcluirusuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexcluirusuario.setBackground(Color.RED);
		btnexcluirusuario.setBounds(662, 474, 126, 34);
		contentPane.add(btnexcluirusuario);
		
		JButton btnexibirusuario = new JButton("EXIBIR");
		btnexibirusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
					Statement s = c.createStatement();
				    ResultSet r = s.executeQuery("select NomeUsuario, CPFUsuario, DatadeNascUsuario, NacionalidadeUsuario from usuario");
				    
				    DefaultTableModel t = (DefaultTableModel) table.getModel();
				    t.setRowCount(0);
				    
				    while (r.next()) {
				    	
				    	t.addRow(new String[] {  r.getString("NomeUsuario"), r.getString("CPFUsuario"), r.getString("DatadeNascUsuario"), r.getString("NacionalidadeUsuario")
				    			});
				    }
				    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			
			}
		});
		btnexibirusuario.setForeground(Color.WHITE);
		btnexibirusuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexibirusuario.setBackground(Color.BLUE);
		btnexibirusuario.setBounds(719, 55, 126, 34);
		contentPane.add(btnexibirusuario);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
	}
	
	
}
