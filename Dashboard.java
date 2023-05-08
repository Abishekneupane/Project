package taxmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class Dashboard {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private int id;
	private String email;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int id = 0;
					String email="";
					Dashboard window = new Dashboard(id,email);
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
	public Dashboard(int id,String email) {
		this.id = id;
		this.email=email;
		System.out.println(id);
		System.out.println(email);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1028, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNepa = new JLabel("Salary Income Tax Calculation.");
		lblNepa.setForeground(new Color(255, 0, 0));
		lblNepa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNepa.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNepa.setBounds(293, 11, 367, 31);
		frame.getContentPane().add(lblNepa);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 82, 647, 462);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_610732957081300");
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nature of the employee");
		lblNewLabel_1.setBounds(10, 11, 209, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Total Salary");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1.setBounds(223, 366, 111, 20);
		panel.add(lblNewLabel_1_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBounds(223, 397, 156, 20);
		panel.add(textField_2);
		
		String [] items = {"Married","Unmarried"};
		JComboBox comboBox = new JComboBox(items);
		comboBox.setFont(new Font("Arial Black", Font.BOLD, 12));
		comboBox.setBounds(215, 11, 103, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fiscal Year");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(419, 11, 103, 20);
		panel.add(lblNewLabel_1_1);
		
		String [] itemss = {"79/80"};
		JComboBox comboBox_1 = new JComboBox(itemss);
		comboBox_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		comboBox_1.setBounds(534, 11, 103, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Monthly Salary");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_1.setBounds(10, 129, 103, 20);
		panel.add(lblNewLabel_1_1_2_1_1);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(10, 160, 156, 20);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("no of months");
		lblNewLabel_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_1_1.setBounds(10, 208, 103, 20);
		panel.add(lblNewLabel_1_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1 = new JLabel("Bonus");
		lblNewLabel_1_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_1_1_1.setBounds(10, 296, 51, 20);
		panel.add(lblNewLabel_1_1_2_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(10, 239, 156, 20);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		textField_3.setBounds(10, 327, 156, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Annual Deduction");
		lblNewLabel_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_2.setBounds(446, 86, 141, 20);
		panel.add(lblNewLabel_1_1_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		textField_4.setBounds(481, 160, 156, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_1_2_1_2_1 = new JLabel("Insurance");
		lblNewLabel_1_1_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_2_1.setBounds(440, 129, 96, 20);
		panel.add(lblNewLabel_1_1_2_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_2_1_1 = new JLabel("SSF");
		lblNewLabel_1_1_2_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_2_1_1.setBounds(440, 192, 39, 20);
		panel.add(lblNewLabel_1_1_2_1_2_1_1);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setColumns(10);
		textField_5.setBounds(469, 223, 156, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_1_2_1_2_1_1_1 = new JLabel("EPF");
		lblNewLabel_1_1_2_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_2_1_1_1.setBounds(440, 254, 60, 20);
		panel.add(lblNewLabel_1_1_2_1_2_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setColumns(10);
		textField_6.setBounds(469, 285, 156, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("");
		textField_7.setColumns(10);
		textField_7.setBounds(469, 353, 156, 20);
		panel.add(textField_7);
		
		JLabel lblNewLabel_1_1_2_1_2_1_1_1_1 = new JLabel("CIT");
		lblNewLabel_1_1_2_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1_2_1_1_1_1.setBounds(440, 326, 51, 20);
		panel.add(lblNewLabel_1_1_2_1_2_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_611294820054000");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Net Tax Liability");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2.setBounds(229, 11, 203, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total Income");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_3.setBounds(30, 67, 119, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Calculate Tax ");
		btnNewButton.addActionListener(new ActionListener() {
			//private int id;

			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()&& textField_2.getText().isEmpty()&&textField_3.getText().isEmpty()&&textField_4.getText().isEmpty()&&textField_5.getText().isEmpty()&&textField_6.getText().isEmpty()&&textField_7.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please insert the value");
					
				}
				double tax;
				 Connection con = null;
		    	 try {
				        con = DbConnection.getConnection();
				      } catch (Exception ex) {
				        JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
				        return;
				      }
		    	 String createTable = "CREATE TABLE IF NOT EXISTS Incomedata (id INT AUTO_INCREMENT PRIMARY KEY, monthlyS VARCHAR(255) NOT NULL, months VARCHAR(255) NOT NULL,bounus VARCHAR(255) NOT NULL, insurance VARCHAR(255) NOT NULL ,SSF VARCHAR(225) NOT NULL, EPF VARCHAR(255) NOT NULL , CIT VARCHAR(255) NOT NULL,Total VARCHAR(255),user_id INT NOT NULL,FOREIGN KEY(user_id) REFERENCES users(id))";
		    	 try {
				        PreparedStatement createStatement = con.prepareStatement(createTable);
				        createStatement.executeUpdate();
				        createStatement.close();
				      } catch (Exception ex) {
				        JOptionPane.showMessageDialog(null, "Error creating table: " + ex.getMessage());
				        return;
				      }
		    	 double mIncome = Double.parseDouble(textField.getText());
				 int months = Integer.parseInt(textField_1.getText());
				 double bonus = Double.parseDouble(textField_3.getText());
				 double insurance = Double.parseDouble(textField_4.getText());
				 double ssf = Double.parseDouble(textField_5.getText());
				 double epf = Double.parseDouble(textField_6.getText());
				 double cit = Double.parseDouble(textField_7.getText());
				 double total = (months*(mIncome+bonus))-(insurance+ssf+epf+cit);
				 textField_2.setText(""+total);

				 String insertIntoincomedata = "INSERT INTO Incomedata (user_id, monthlyS, months, bounus, insurance, SSF, EPF, CIT, Total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

				 try (PreparedStatement income = con.prepareStatement(insertIntoincomedata)) {
				     income.setInt(1, id);
				     income.setDouble(2, mIncome);
				     income.setInt(3, months);
				     income.setDouble(4, bonus);
				     income.setDouble(5, insurance);
				     income.setDouble(6, ssf);
				     income.setDouble(7, epf);
				     income.setDouble(8, cit);
				     income.setDouble(9, total);
				     
				     income.executeUpdate();
				       
				     //JOptionPane.showMessageDialog(null, "Data added successfully.");
				 } catch (SQLException ex) {
				     ex.printStackTrace();
				     JOptionPane.showMessageDialog(null, "Error while adding data.");
				 }
				 if(textField.equals("")&textField_1.equals("")&textField_3.equals("")&textField_4.equals("")&textField_5.equals("")&textField_6.equals("")&textField_7.equals("")) {
					 JOptionPane.showMessageDialog(null, "Please enter all the value");	 
				 }
				 if(total<250000) {
					 tax=total*0.01;
					 JOptionPane.showMessageDialog(null, "Your tax amount is rs. "+ tax);
					 
				 } else if(total <=500000 & total>250000){
					 tax = total*0.1;
					 JOptionPane.showMessageDialog(null,"Your tax amount is rs. "+ tax);
					
				 }else if(total<=1000000 & total>500000) {
					 tax = total*0.2;
					 JOptionPane.showMessageDialog(null,"Your tax amount is rs. "+ tax);
				 } else {
					  tax=total*0.3;
					 JOptionPane.showMessageDialog(null,"Your tax amount is rs."+ tax);
				 }
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setBounds(20, 565, 206, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClearInput = new JButton("Clear Input");
		btnClearInput.setForeground(new Color(255, 255, 255));
		btnClearInput.setBackground(new Color(255, 0, 0));
		btnClearInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
			}
		});
		btnClearInput.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnClearInput.setBounds(451, 565, 206, 23);
		frame.getContentPane().add(btnClearInput);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(667, 82, 347, 462);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 347, 462);
		panel_2.add(lblNewLabel);
		ImageIcon icon = new ImageIcon("Img/calctax.jpg");
		Image img1 = icon.getImage();
		Image modimg = img1.getScaledInstance(1080, 425, java.awt.Image.SCALE_DEFAULT);
		icon = new ImageIcon(modimg);
		lblNewLabel.setIcon(icon);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 35, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Vehicle tax.");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Vehicletax(id,email);
				frame.setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(585, 48, 141, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(830, 35, 174, 31);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textField_8 = new JTextField(this.email);
		textField_8.setEditable(false);
		textField_8.setBounds(0, 0, 174, 31);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		frame.setVisible(true);
		
	}
}
