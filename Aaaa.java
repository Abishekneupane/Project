package taxmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Aaaa {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTable table_1;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_2;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int id = 0;
					String email="";
					Aaaa window = new Aaaa(id,email);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aaaa(int id,String email) {
		System.out.println(id);
		System.out.println(email);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 997, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminPage = new JLabel("Admin page");
		lblAdminPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPage.setForeground(Color.RED);
		lblAdminPage.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblAdminPage.setBounds(266, 11, 367, 31);
		frame.getContentPane().add(lblAdminPage);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				frame.setAlwaysOnTop(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1.setBounds(22, 16, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(131, 81, 842, 405);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_1636625531284100");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(191, 68, 474, 280);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 11, 401, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(52, 80, 96, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(66, 149, 96, 30);
		panel_1.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(105, 107, 163, 20);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 190, 161, 20);
		panel_1.add(passwordField);
		JPanel panel_2 = new JPanel();
		layeredPane.add(panel_2, "name_1636844625688000");
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 111, 111));
		layeredPane.add(panel_3, "name_1639245553794100");
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
			    String password = new String(passwordField.getPassword());
			    if(email.equals("1")& password.equals("1")) {
			    	JOptionPane.showMessageDialog(null, "Successfully Login");
			    	layeredPane.removeAll();
					layeredPane.add(panel_3);
					layeredPane.repaint();					
					layeredPane.revalidate();	
			    }
			    else {
			    	JOptionPane.showMessageDialog(null,"incorect email and password");
			    }
			    
			    Connection con = null;
			    try {
			    	//making connection into database from file DatabaseConnection.
			      con = DbConnection.getConnection();
			    } catch (Exception ex) {
			      JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
			      return;
			    }
			    String retrieveRoleAndId = "SELECT * FROM users";
			    try {
			    	//preparedStatement to retrive and execute data from database and and check in database.
			      PreparedStatement retrieveStatement = con.prepareStatement(retrieveRoleAndId);
			      ResultSet result = retrieveStatement.executeQuery();
			      int i = 0;
            	   DefaultTableModel model = new DefaultTableModel();
            	   table_2.setModel(model);
            	   model.addColumn("id");
            	   model.addColumn("email");
            	   while (result.next()) {
            	      int id = result.getInt("id");
            	      String useremail = result.getString("email");
            	      model.addRow(new Object[]{id, useremail});
            	      i++;
            	   }
			     
			    } catch (Exception ex) {
			    	JOptionPane.showMessageDialog(null, "Please go back ");
			    }
//			  //retrive data from user table 
//			    
//			    String retrieveRoleAndId = "SELECT * FROM users WHERE email = ? AND password = ?";
//			    try {
//			    	//preparedStatement to retrive and execute data from database and and check in database.
//			      PreparedStatement retrieveStatement = con.prepareStatement(retrieveRoleAndId);
//			      retrieveStatement.setString(1, email);
//			      retrieveStatement.setString(2, password);
//			      ResultSet result = retrieveStatement.executeQuery();
//			      if (result.next()) {
//			    	  int id = result.getInt("id");
//			    	  //if username and password match with role then display new window similar to this.
//			    	  layeredPane.removeAll();
//						layeredPane.add(panel_3);
//						layeredPane.repaint();
//						layeredPane.revalidate();
//						result.close();
//			      } else {
//			    	  //otherwise,throw invalid
//			        JOptionPane.showMessageDialog(null, "Error: Invalid email or password");
//			    	  
//			      }
//			    } catch (Exception ex) {
//			    	JOptionPane.showMessageDialog(null, "Please register first ");
//			    }
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(165, 246, 113, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(Color.BLACK);
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(0, 116, 842, 135);
		panel.add(panel_1_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 822, 313);
		panel_2.add(scrollPane);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDetailsOfUsers = new JLabel("Details of Users on Income");
		lblDetailsOfUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailsOfUsers.setForeground(Color.RED);
		lblDetailsOfUsers.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDetailsOfUsers.setBounds(182, 11, 325, 31);
		panel_2.add(lblDetailsOfUsers);
		
		JPanel panel_4 = new JPanel();
		layeredPane.add(panel_4, "name_1641657447284700");
		panel_4.setLayout(null);
		
		JButton btnNewButton_1_3 = new JButton("Home");
		btnNewButton_1_3.setBounds(10, 16, 89, 23);
		panel_2.add(btnNewButton_1_3);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_3);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchincome = textField_2.getText();
				searchincome(searchincome);
				
			}

			private void searchincome(String searchincome) {
				// TODO Auto-generated method stub
				 DefaultTableModel model = new DefaultTableModel();
					// TODO Auto-generated method stub
					model = (DefaultTableModel) table.getModel();
					TableRowSorter<DefaultTableModel> trs =  new TableRowSorter<>(model);
					table.setRowSorter(trs);
					trs.setRowFilter(RowFilter.regexFilter(searchincome));
					
				
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(259, 53, 184, 20);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Search");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_3.setBounds(192, 52, 79, 18);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblDelete_1 = new JLabel("Delete");
		lblDelete_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblDelete_1.setBounds(613, 17, 65, 18);
		panel_2.add(lblDelete_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(688, 11, 109, 20);
		panel_2.add(textField_4);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				 try {
				    	//making connection into database from file DatabaseConnection.
				      con = DbConnection.getConnection();
				    } catch (Exception ex) {
				      JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
				      return;
				    }
				 String deleteField = textField_4.getText();
			     String deleteSQL = "DELETE FROM incomedata WHERE ID = ?";
			     try (PreparedStatement deleteStatement = con.prepareStatement(deleteSQL)) {
			            deleteStatement.setString(1, deleteField);
			            int affectedRows = deleteStatement.executeUpdate();
			            if (affectedRows == 0) {
			                JOptionPane.showMessageDialog(null, "Invalid ID.");
			            } else {
			            	JOptionPane.showMessageDialog(null, "Data deleted successfully.");
			            }
			        } catch (SQLException ex) {
			            JOptionPane.showMessageDialog(null, "Error while deleting course: " + ex.getMessage());
			        }
				
			}
		});
		btnNewButton_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_1_1_1_1.setBounds(743, 47, 89, 23);
		panel_2.add(btnNewButton_1_1_1_1_1);
		
		
		
		JButton btnNewButton_1_1 = new JButton("Income");
		btnNewButton_1_1.setBounds(31, 371, 89, 23);
		panel_3.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
			    try {
			    	//making connection into database from file DatabaseConnection.
			      con = DbConnection.getConnection();
			    } catch (Exception ex) {
			      JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
			      return;
			    }
			    String retrieveRoleAndId = "SELECT * FROM incomedata";
			    try {
			    	//preparedStatement to retrive and execute data from database and and check in database.
			      PreparedStatement retrieveStatement = con.prepareStatement(retrieveRoleAndId);
			      ResultSet result = retrieveStatement.executeQuery();
			      int i = 0;
            	   DefaultTableModel model = new DefaultTableModel();
            	   table.setModel(model);
            	   model.addColumn("id");
            	   model.addColumn("monthlyS");
            	   model.addColumn("months");
            	   model.addColumn("bounus");
            	   model.addColumn("insurance");
            	   model.addColumn("SSF");
            	   model.addColumn("EPF");
            	   model.addColumn("CIT");
            	   model.addColumn("Total");
            	   model.addColumn("user_id");
            	   while (result.next()) {
            	      int id = result.getInt("id");
            	      String monthlys = result.getString("monthlyS");
            	      String months = result.getString("months");
            	      String bonus = result.getString("bounus");
            	      String ins = result.getString("insurance");
            	      String ssf = result.getString("SSF");
            	      String epf = result.getString("EPF");
            	     String cit= result.getString("CIT");
            	     String Total = result.getString("Total");
            	     String user_id = result.getString("user_id");
            	      model.addRow(new Object[]{id, monthlys, months, bonus, ins, ssf, epf,cit,Total,user_id});
            	      i++;
            	   }
			     
			    } catch (Exception ex) {
			    	JOptionPane.showMessageDialog(null, "Please go back ");
			    }
			    layeredPane.removeAll();
				layeredPane.add(panel_2);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JButton btnNewButton_1_2 = new JButton("Vehicle");
		btnNewButton_1_2.setBounds(694, 371, 89, 23);
		panel_3.add(btnNewButton_1_2);
		
		
		
		JLabel lblDetailsOfUsers_2 = new JLabel("Details of Users on Vehicle");
		lblDetailsOfUsers_2.setBounds(269, 11, 271, 22);
		lblDetailsOfUsers_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailsOfUsers_2.setForeground(Color.RED);
		lblDetailsOfUsers_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		panel_4.add(lblDetailsOfUsers_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 115, 822, 279);
		panel_4.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1_3_1 = new JButton("Home");
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_3);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_3_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_3_1.setBounds(21, 64, 89, 23);
		panel_4.add(btnNewButton_1_3_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String search = textField_1.getText();
				search(search);
			}

			private void search(String search) {
				 DefaultTableModel model = new DefaultTableModel();
				// TODO Auto-generated method stub
				model = (DefaultTableModel) table_1.getModel();
				TableRowSorter<DefaultTableModel> trs =  new TableRowSorter<>(model);
				table_1.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
				
			}
		});
		textField_1.setBounds(259, 65, 184, 20);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel.setBounds(186, 64, 79, 18);
		panel_4.add(lblNewLabel);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblDelete.setBounds(593, 13, 65, 18);
		panel_4.add(lblDelete);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(668, 14, 109, 20);
		panel_4.add(textField_3);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection con = null;
				 try {
				    	//making connection into database from file DatabaseConnection.
				      con = DbConnection.getConnection();
				    } catch (Exception ex) {
				      JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
				      return;
				    }
				 String deleteField = textField_3.getText();
			     String deleteSQL = "DELETE FROM vehicletax WHERE ID = ?";
			     try (PreparedStatement deleteStatement = con.prepareStatement(deleteSQL)) {
			            deleteStatement.setString(1, deleteField);
			            int affectedRows = deleteStatement.executeUpdate();
			            if (affectedRows == 0) {
			                JOptionPane.showMessageDialog(null, "Invalid ID.");
			            } else {
			                JOptionPane.showMessageDialog(null, "Data deleted successfully.");
			            }
			        } catch (SQLException ex) {
			            JOptionPane.showMessageDialog(null, "Error while deleting course: " + ex.getMessage());
			        }
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_1_1_1.setBounds(743, 45, 89, 23);
		panel_4.add(btnNewButton_1_1_1_1);
		
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
			    try {
			    	//making connection into database from file DatabaseConnection.
			      con = DbConnection.getConnection();
			    } catch (Exception ex) {
			      JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
			      return;
			    }
			    String retrieveRoleAndId = "SELECT * FROM vehicletax";
			    try {
			    	//preparedStatement to retrive and execute data from database and and check in database.
			      PreparedStatement retrieveStatement = con.prepareStatement(retrieveRoleAndId);
			      ResultSet result = retrieveStatement.executeQuery();
			      int i = 0;
            	   DefaultTableModel model = new DefaultTableModel();
            	   table_1.setModel(model);
            	   model.addColumn("id");
            	   model.addColumn("vType");
            	   model.addColumn("vNumber");
            	   model.addColumn("vPower");
            	   model.addColumn("pay");
            	   model.addColumn("m_year");
            	   model.addColumn("T_CC");
            	   model.addColumn("user_id");
            	   while (result.next()) {
            	      int id = result.getInt("id");
            	      String monthlys = result.getString("vType");
            	      String months = result.getString("vNumber");
            	      String bonus = result.getString("vPower");
            	      String ins = result.getString("pay");
            	      String ssf = result.getString("m_year");
            	      String epf = result.getString("T_CC");
            	     String user_id = result.getString("user_id");
            	      model.addRow(new Object[]{id, monthlys, months, bonus, ins, ssf, epf,user_id});
            	      i++;
            	   }
			     
			    } catch (Exception ex) {
			    	JOptionPane.showMessageDialog(null, "Please go back ");
			    }
				layeredPane.removeAll();
				layeredPane.add(panel_4);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 65, 822, 283);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchuser = textField_5.getText();
				searchuser(searchuser);
				
			}

			private void searchuser(String searchuser) {
				// TODO Auto-generated method stub
				DefaultTableModel model = new DefaultTableModel();
				// TODO Auto-generated method stub
				model = (DefaultTableModel) table_2.getModel();
				TableRowSorter<DefaultTableModel> trs =  new TableRowSorter<>(model);
				table_2.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(searchuser));
				
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(345, 26, 151, 20);
		panel_3.add(textField_5);
		
		JLabel lblNewLabel_4 = new JLabel("Search");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_4.setBounds(244, 25, 79, 18);
		panel_3.add(lblNewLabel_4);
		frame.setVisible(true);
	}
}
