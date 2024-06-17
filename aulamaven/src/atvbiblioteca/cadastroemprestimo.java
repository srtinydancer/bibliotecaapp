package atvbiblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
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
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class cadastroemprestimo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldusuarioemprestimo;
	private JTextField textFieldlivroemprestimo;
	private JTextField textFielddatadoemprestimo;
	private JTextField textFieldprevisaodedevoluçao;
	private JTable table;
	private JTextField textFieldstatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroemprestimo frame = new cadastroemprestimo();
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
	public cadastroemprestimo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 667);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(0, 0, 891, 620);
		contentPane.add(contentPane_1);
		
		JLabel lblCadastroDeEmprestimo = new JLabel("EMPRÉSTIMOS");
		lblCadastroDeEmprestimo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblCadastroDeEmprestimo.setBounds(346, 10, 376, 33);
		contentPane_1.add(lblCadastroDeEmprestimo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 104, 181, 2);
		contentPane_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(425, 104, -177, 2);
		contentPane_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(425, 104, -209, 9);
		contentPane_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(247, 104, 189, 2);
		contentPane_1.add(separator_3);
		
		JLabel lblusurioemprestimo = new JLabel("Usuário");
		lblusurioemprestimo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblusurioemprestimo.setBounds(183, 93, 131, 13);
		contentPane_1.add(lblusurioemprestimo);
		
		textFieldusuarioemprestimo = new JTextField();
		textFieldusuarioemprestimo.setColumns(10);
		textFieldusuarioemprestimo.setBounds(51, 133, 319, 19);
		contentPane_1.add(textFieldusuarioemprestimo);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(0, 189, 189, 1);
		contentPane_1.add(separator_4);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(227, 188, 209, 2);
		contentPane_1.add(separator_3_1);
		
		JLabel lbllivroemprestimo = new JLabel("Livro");
		lbllivroemprestimo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllivroemprestimo.setBounds(190, 177, 131, 13);
		contentPane_1.add(lbllivroemprestimo);
		
		textFieldlivroemprestimo = new JTextField();
		textFieldlivroemprestimo.setColumns(10);
		textFieldlivroemprestimo.setBounds(51, 211, 319, 19);
		contentPane_1.add(textFieldlivroemprestimo);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 269, 131, 2);
		contentPane_1.add(separator_5);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setBounds(281, 269, 155, 2);
		contentPane_1.add(separator_3_2);
		
		JLabel lbldatadoemprestimo = new JLabel("Data do emprestimo");
		lbldatadoemprestimo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldatadoemprestimo.setBounds(134, 258, 155, 13);
		contentPane_1.add(lbldatadoemprestimo);
		
		textFielddatadoemprestimo = new JTextField();
		textFielddatadoemprestimo.setColumns(10);
		textFielddatadoemprestimo.setBounds(51, 297, 319, 19);
		contentPane_1.add(textFielddatadoemprestimo);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 355, 137, 2);
		contentPane_1.add(separator_6);
		
		JSeparator separator_3_3 = new JSeparator();
		separator_3_3.setBounds(299, 355, 137, 2);
		contentPane_1.add(separator_3_3);
		
		JLabel lblprevisaodedevoluçao = new JLabel("Previsão de devolução");
		lblprevisaodedevoluçao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblprevisaodedevoluçao.setBounds(134, 344, 170, 13);
		contentPane_1.add(lblprevisaodedevoluçao);
		
		textFieldprevisaodedevoluçao = new JTextField();
		textFieldprevisaodedevoluçao.setColumns(10);
		textFieldprevisaodedevoluçao.setBounds(51, 384, 319, 19);
		contentPane_1.add(textFieldprevisaodedevoluçao);
		
		JButton btnvoltaremprestimo = new JButton("VOLTAR");
		btnvoltaremprestimo.setBounds(51, 514, 126, 34);
		contentPane_1.add(btnvoltaremprestimo);
		btnvoltaremprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				telalogin telalogin = new telalogin();
				telalogin.setLocationRelativeTo(btnvoltaremprestimo);
				telalogin.setVisible(true);
			}
		});
		btnvoltaremprestimo.setForeground(Color.WHITE);
		btnvoltaremprestimo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnvoltaremprestimo.setBackground(Color.BLACK);
		
		JButton btnconfirmaremprestimo = new JButton("CONFIRMAR");
		btnconfirmaremprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					Class.forName("org.sqlite.JDBC");
				
				Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
				PreparedStatement p = c.prepareStatement("insert into emprestimo(UsuarioEmprestimo, LivroEmprestimo, DataEmprestimo, DevolucaoEmprestimo, StatusEmprestimo) values (?,?,?,?,?)");
				p.setString(1, textFieldusuarioemprestimo.getText()  );
				p.setString(2, textFieldlivroemprestimo.getText()  );
				p.setString(3, textFielddatadoemprestimo.getText()  );
				p.setString(4, textFieldprevisaodedevoluçao.getText()  );
				p.setString(5, textFieldstatus.getText()  );
				p.execute();
				Statement s = c.createStatement();
			    ResultSet r = s.executeQuery("select UsuarioEmprestimo, LivroEmprestimo, DataEmprestimo, Devolucaoemprestimo, StatusEmprestimo from emprestimo");
			    
			    DefaultTableModel t = (DefaultTableModel) table.getModel();
			    t.setRowCount(0);
			    
			    while (r.next()) {
			    	
			    	t.addRow(new String[] {  r.getString("UsuarioEmprestimo"), r.getString("LivroEmprestimo"), r.getString("DataEmprestimo"), r.getString("Devolucaoemprestimo"), r.getString("StatusEmprestimo")
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
		btnconfirmaremprestimo.setBounds(298, 514, 126, 34);
		contentPane_1.add(btnconfirmaremprestimo);
		btnconfirmaremprestimo.setForeground(Color.WHITE);
		btnconfirmaremprestimo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnconfirmaremprestimo.setBackground(Color.GREEN);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(0, 445, 181, 2);
		contentPane_1.add(separator_7);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setBounds(183, 434, 131, 13);
		contentPane_1.add(lblStatus);
		
		JSeparator separator_3_2_1 = new JSeparator();
		separator_3_2_1.setBounds(238, 445, 209, 2);
		contentPane_1.add(separator_3_2_1);
		
		JSeparator separator_3_2_1_1 = new JSeparator();
		separator_3_2_1_1.setBounds(0, 502, 891, 2);
		contentPane_1.add(separator_3_2_1_1);
		
		JButton btnalteraremprestimo = new JButton("ALTERAR");
		btnalteraremprestimo.addActionListener(new ActionListener() {
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
						PreparedStatement p = c.prepareStatement("update emprestimo set UsuarioEmprestimo= ?, LivroEmprestimo =?, DataEmprestimo= ?, DevolucaoEmprestimo= ?, StatusEmprestimo= ? where UsuarioEmprestimo=?");
						p.setString(1, textFieldusuarioemprestimo.getText()  );
						p.setString(2, textFieldlivroemprestimo.getText()  );
						p.setString(3, textFielddatadoemprestimo.getText()  );
						p.setString(4, textFieldprevisaodedevoluçao.getText()  );
						p.setString(5, textFieldstatus.getText()  );
						p.setString(6,  table.getValueAt(table.getSelectedRow(), 0) .toString());
						p.execute();
						
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select UsuarioEmprestimo, LivroEmprestimo, DataEmprestimo, DevolucaoEmprestimo, StatusEmprestimo  from emprestimo");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("UsuarioEmprestimo"), r.getString("LivroEmprestimo"), r.getString("DataEmprestimo"), r.getString("Devolucaoemprestimo"), r.getString("StatusEmprestimo")
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
		btnalteraremprestimo.setForeground(Color.WHITE);
		btnalteraremprestimo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnalteraremprestimo.setBackground(Color.ORANGE);
		btnalteraremprestimo.setBounds(508, 514, 126, 34);
		contentPane_1.add(btnalteraremprestimo);
		
		JButton btnexcluiremprestimo = new JButton("EXCLUIR");
		btnexcluiremprestimo.addActionListener(new ActionListener() {
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
						PreparedStatement p = c.prepareStatement("delete from emprestimo where UsuarioEmprestimo =?");
				
						for(int linha:table.getSelectedRows()) {						
						p.setString(1,  table.getValueAt( linha , 0).toString());
						p.execute();

						
						Statement s = c.createStatement();
					    ResultSet r = s.executeQuery("select UsuarioEmprestimo, LivroEmprestimo, DataEmprestimo, Devolucaoemprestimo, StatusEmprestimo from emprestimo");
					    
					    DefaultTableModel t = (DefaultTableModel) table.getModel();
					    t.setRowCount(0);
					    
					   
					    
					    while (r.next()) {
					    	
					    	t.addRow(new String[] {  r.getString("UsuarioEmprestimo"), r.getString("LivroEmprestimo"), r.getString("DataEmprestimo"), r.getString("Devolucaoemprestimo"), r.getString("StatusEmprestimo")
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
		btnexcluiremprestimo.setForeground(Color.WHITE);
		btnexcluiremprestimo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexcluiremprestimo.setBackground(Color.RED);
		btnexcluiremprestimo.setBounds(720, 514, 126, 34);
		contentPane_1.add(btnexcluiremprestimo);
		
		JButton btnexibiremprestimo = new JButton("EXIBIR");
		btnexibiremprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				

				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
					Statement s = c.createStatement();
				    ResultSet r = s.executeQuery("select UsuarioEmprestimo, LivroEmprestimo, DataEmprestimo, Devolucaoemprestimo, StatusEmprestimo from emprestimo");
				    
				    DefaultTableModel t = (DefaultTableModel) table.getModel();
				    t.setRowCount(0);
				    
				    while (r.next()) {
				    	
				    	t.addRow(new String[] {  r.getString("UsuarioEmprestimo"), r.getString("LivroEmprestimo"), r.getString("DataEmprestimo"), r.getString("Devolucaoemprestimo"), r.getString("StatusEmprestimo")
				    			});
				    }
				    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			
			
			
			}
		});
		btnexibiremprestimo.setForeground(Color.WHITE);
		btnexibiremprestimo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexibiremprestimo.setBackground(Color.BLUE);
		btnexibiremprestimo.setBounds(765, 52, 126, 33);
		contentPane_1.add(btnexibiremprestimo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(457, 88, 434, 404);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usu\u00E1rio", "Livro", "Data do emprestimo", "Previs\u00E3o de dev", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		textFieldstatus = new JTextField();
		textFieldstatus.setColumns(10);
		textFieldstatus.setBounds(51, 473, 319, 19);
		contentPane_1.add(textFieldstatus);
		
		JButton btnstatusemprestado = new JButton("EMPRESTADOS");
		btnstatusemprestado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			        try {
			            Class.forName("org.sqlite.JDBC");
			            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
			            JasperReport jasper;
			            try {
			                jasper = JasperCompileManager.compileReport("C:/Users/Vinícius Coimbra/eclipse-workspace/aulamaven/src/relatorios/statusemprestado.jrxml");
			                JasperPrint print = JasperFillManager.fillReport(jasper, null, c);
			                JasperViewer.viewReport(print, false);
			            } catch (JRException e1) {
			                // TODO Auto-generated catch block
			                e1.printStackTrace();
			            } catch (Exception e1) {
			                e1.printStackTrace();
			            } finally {
			                if (c != null) {
			                    try {
			                        c.close();
			                    } catch (Exception e2) {
			                        e2.printStackTrace();
			                    }
			                }
			            }
			        } catch (Exception e3) {
			            e3.printStackTrace();
			        }
			    }
			});
		btnstatusemprestado.setForeground(Color.WHITE);
		btnstatusemprestado.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnstatusemprestado.setBackground(new Color(0, 255, 204));
		btnstatusemprestado.setBounds(281, 586, 155, 34);
		contentPane_1.add(btnstatusemprestado);
		
		JButton btnStatusdevolvido = new JButton("DEVOLVIDOS");
		btnStatusdevolvido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
			            Class.forName("org.sqlite.JDBC");
			            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/netonerd/biblioteca");
			            JasperReport jasper;
			            try {
			                jasper = JasperCompileManager.compileReport("C:/Users/Vinícius Coimbra/eclipse-workspace/aulamaven/src/relatorios/statusdevolvido.jrxml");
			                JasperPrint print = JasperFillManager.fillReport(jasper, null, c);
			                JasperViewer.viewReport(print, false);
			            } catch (JRException e1) {
			                // TODO Auto-generated catch block
			                e1.printStackTrace();
			            } catch (Exception e1) {
			                e1.printStackTrace();
			            } finally {
			                if (c != null) {
			                    try {
			                        c.close();
			                    } catch (Exception e2) {
			                        e2.printStackTrace();
			                    }
			                }
			            }
			        } catch (Exception e3) {
			            e3.printStackTrace();
			        }
			    }
			
		});
		btnStatusdevolvido.setForeground(Color.WHITE);
		btnStatusdevolvido.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStatusdevolvido.setBackground(new Color(255, 51, 102));
		btnStatusdevolvido.setBounds(755, 586, 126, 34);
		contentPane_1.add(btnStatusdevolvido);
		
		JLabel lblReltorioDeLivros = new JLabel("Relátorio de livros emprestados:");
		lblReltorioDeLivros.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReltorioDeLivros.setBounds(24, 590, 265, 24);
		contentPane_1.add(lblReltorioDeLivros);
		
		JLabel lblReltorioDeLivros_2 = new JLabel("Relátorio de livros devolvidos:");
		lblReltorioDeLivros_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReltorioDeLivros_2.setBounds(493, 590, 265, 24);
		contentPane_1.add(lblReltorioDeLivros_2);
		
		
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(107);
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
	}
}
