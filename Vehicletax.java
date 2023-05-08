package taxmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vehicletax {

	private JFrame frame;
	private JTextField txtBike;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private int id;
	private JTextField textField_6;
	private JTextField txtBikescooter;
	private JTextField textField;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private String email;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int id = 0;
					String email = "";
					Vehicletax window = new Vehicletax(id,email);
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
	public Vehicletax(int id,String email) {
		this.id = id;
		this.email = email;
		System.out.println(id);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1026, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle tax calculation(Bike/Scooter/car/jeep/van).");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(196, 25, 409, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard(id,email);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1.setBounds(39, 33, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(20, 74, 776, 508);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_990656506148500");
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Vehicle Type");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(32, 33, 119, 18);
		panel.add(lblNewLabel_1);
		
		txtBike = new JTextField();
		txtBike.setEditable(false);
		txtBike.setFont(new Font("Arial Black", Font.BOLD, 12));
		txtBike.setText("Bike/Scooter");
		txtBike.setBounds(55, 62, 152, 20);
		panel.add(txtBike);
		txtBike.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vehicle No.");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(32, 146, 119, 18);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(55, 175, 152, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Year of Manufacture.");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(435, 191, 161, 18);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(469, 232, 152, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Engine(CC)");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(32, 258, 161, 18);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 287, 152, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Pay upto(in yrs)");
		lblNewLabel_1_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(435, 65, 161, 18);
		panel.add(lblNewLabel_1_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(469, 94, 152, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Total paying CC ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(435, 287, 161, 18);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(483, 316, 152, 20);
		panel.add(textField_5);
		
		JButton btnNewButton = new JButton("Calculate Tax ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()&&textField_3.getText().isEmpty()&&textField_4.getText().isEmpty()&&textField_2.getText().isEmpty()&&textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please insert the value");
				}
				double tax;
				double amount;
				 Connection con = null;
		    	 try {
				        con = DbConnection.getConnection();
				      } catch (Exception ex) {
				        JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
				        return;
				      }
		    	 String createTable = "CREATE TABLE IF NOT EXISTS vehicleTax (id INT AUTO_INCREMENT PRIMARY KEY, vType VARCHAR(255) NOT NULL, vNumber INT NOT NULL,vPower INT NOT NULL, pay INT NOT NULL ,m_year VARCHAR(225) NOT NULL,T_CC VARCHAR(255) NOT NULL, user_id INT NOT NULL,FOREIGN KEY(user_id) REFERENCES users(id))";

		    	 try {
				        PreparedStatement createStatement = con.prepareStatement(createTable);
				        createStatement.executeUpdate();
				        createStatement.close();
				      } catch (Exception ex) {
				        JOptionPane.showMessageDialog(null, "Error creating table: " + ex.getMessage());
				        return;
				      }
		    	 String type = txtBike.getText();
		    	 int number = Integer.parseInt(textField_1.getText());
		    	 int power = Integer.parseInt(textField_3.getText());
		    	 int time = Integer.parseInt(textField_4.getText());
		    	 int manuF = Integer.parseInt(textField_2.getText());
		    	 double cc = (power*time);
		    	 textField_5.setText(""+cc);
		    	 textField_5.setText(""+cc);
		    	 String insertIntoincomedata = "INSERT INTO vehicleTax (user_id, vType, vNumber, vPower, pay, m_year, T_CC) VALUES (?, ?, ?, ?, ?, ?, ?);";

		    	 try (PreparedStatement income = con.prepareStatement(insertIntoincomedata)) {
				     income.setInt(1, id);
				     income.setString(2,type);
				     income.setInt(3, number);
				     income.setInt(4, power);
				     income.setInt(5, time);
				     income.setDouble(6, manuF);
				     income.setDouble(7,cc);
				     income.executeUpdate();
				       
				     //JOptionPane.showMessageDialog(null, "Data added successfully.");
				 } catch (SQLException ex) {
				     ex.printStackTrace();
				     JOptionPane.showMessageDialog(null, "Error while adding data.");
				 }
		    	 tax = (power*time);
		    	 if(tax<=125) {
		    		 amount = 3000;
		    		 textField_6.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+ amount); 
		    	 }
		    	 else if(tax>126 & tax<=150) {
		    		 amount=5000;
		    		 textField_6.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 else if(tax>151 & tax<=250) {
		    		 amount = 6500;
		    		 textField_6.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 
		    	 else if(tax>250 & tax<=400) {
		    		 amount = 11000;
		    		 textField_6.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 else if(tax>400 & tax<=600) {
		    		 amount = 20000;
		    		 textField_6.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 else if(tax>650){
		    		 amount = 30000;
		    		 textField_6.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(29, 463, 141, 23);
		panel.add(btnNewButton);
		
		JButton btnClearInput = new JButton("Clear Input");
		btnClearInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnClearInput.setForeground(Color.WHITE);
		btnClearInput.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnClearInput.setBackground(Color.RED);
		btnClearInput.setBounds(561, 464, 141, 23);
		panel.add(btnClearInput);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Amount");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_2.setBounds(230, 358, 161, 18);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(260, 387, 152, 20);
		panel.add(textField_6);
		
		JLabel lblbikescotoor = new JLabel("(Bike/Scooter).");
		lblbikescotoor.setHorizontalAlignment(SwingConstants.CENTER);
		lblbikescotoor.setForeground(Color.RED);
		lblbikescotoor.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblbikescotoor.setBounds(230, 0, 215, 23);
		panel.add(lblbikescotoor);
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_1070367414554999");
		panel_1.setLayout(null);
		
		JLabel lblcarjeppvan = new JLabel("(Car/Jepp/Van).");
		lblcarjeppvan.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarjeppvan.setForeground(Color.RED);
		lblcarjeppvan.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblcarjeppvan.setBounds(232, 11, 215, 23);
		panel_1.add(lblcarjeppvan);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vehicle Type");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(36, 53, 119, 18);
		panel_1.add(lblNewLabel_1_2);
		
		txtBikescooter = new JTextField();
		txtBikescooter.setText("Car/Jeep/Van");
		txtBikescooter.setFont(new Font("Arial Black", Font.BOLD, 12));
		txtBikescooter.setEditable(false);
		txtBikescooter.setColumns(10);
		txtBikescooter.setBounds(61, 80, 152, 20);
		panel_1.add(txtBikescooter);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Vehicle No.");
		lblNewLabel_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(36, 138, 119, 18);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(61, 168, 152, 20);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Engine(CC)");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_3.setBounds(36, 227, 161, 18);
		panel_1.add(lblNewLabel_1_1_1_1_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(61, 270, 152, 20);
		panel_1.add(textField_7);
		
		JButton btnNewButton_1_1_1 = new JButton("Bike/Scooter");
		btnNewButton_1_1_1.setBackground(new Color(255, 111, 111));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_1_1.setBounds(598, 23, 157, 23);
		panel_1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Pay upto(in yrs)");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_2_1.setBounds(496, 81, 161, 18);
		panel_1.add(lblNewLabel_1_1_1_2_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(529, 114, 152, 20);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Year of Manufacture.");
		lblNewLabel_1_1_1_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_3.setBounds(496, 171, 161, 18);
		panel_1.add(lblNewLabel_1_1_1_3);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(552, 200, 152, 20);
		panel_1.add(textField_9);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Total paying CC ");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(496, 270, 161, 18);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(552, 317, 152, 20);
		panel_1.add(textField_10);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Amount");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_2_1.setBounds(259, 349, 161, 18);
		panel_1.add(lblNewLabel_1_1_1_1_2_1);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(268, 391, 152, 20);
		panel_1.add(textField_11);
		
		JButton btnNewButton_2 = new JButton("Calculate Tax ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()&&textField_7.getText().isEmpty()&&textField_8.getText().isEmpty()&&textField_9.getText().isEmpty()&&textField_10.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please insert the value");
				}
				double tax;
				double amount;
				 Connection con = null;
		    	 try {
				        con = DbConnection.getConnection();
				      } catch (Exception ex) {
				        JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
				        return;
				      }
		    	 String createTable = "CREATE TABLE IF NOT EXISTS vehicleTax (id INT AUTO_INCREMENT PRIMARY KEY, vType VARCHAR(255) NOT NULL, vNumber INT NOT NULL,vPower INT NOT NULL, pay INT NOT NULL ,m_year VARCHAR(225) NOT NULL,T_CC VARCHAR(255) NOT NULL, user_id INT NOT NULL,FOREIGN KEY(user_id) REFERENCES users(id))";

		    	 try {
				        PreparedStatement createStatement = con.prepareStatement(createTable);
				        createStatement.executeUpdate();
				        createStatement.close();
				      } catch (Exception ex) {
				        JOptionPane.showMessageDialog(null, "Error creating table: " + ex.getMessage());
				        return;
				      }
		    	 String type = txtBikescooter.getText();
		    	 int number = Integer.parseInt(textField.getText());
		    	 int power = Integer.parseInt(textField_7.getText());
		    	 int time = Integer.parseInt(textField_8.getText());
		    	 int manuF = Integer.parseInt(textField_9.getText());
		    	 double cc = (power*time);
		    	 textField_10.setText(""+cc);
		    	 textField_10.setText(""+cc);
		    	 String insertIntoincomedata = "INSERT INTO vehicleTax (user_id, vType, vNumber, vPower, pay, m_year, T_CC) VALUES (?, ?, ?, ?, ?, ?, ?);";

		    	 try (PreparedStatement income = con.prepareStatement(insertIntoincomedata)) {
				     income.setInt(1, id);
				     income.setString(2,type);
				     income.setInt(3, number);
				     income.setInt(4, power);
				     income.setInt(5, time);
				     income.setDouble(6, manuF);
				     income.setDouble(7,cc);
				     income.executeUpdate();
				       
				     //JOptionPane.showMessageDialog(null, "Data added successfully.");
				 } catch (SQLException ex) {
				     ex.printStackTrace();
				     JOptionPane.showMessageDialog(null, "Error while adding data.");
				 }
		    	 tax = (power*time);
		    	 if(tax<=1000) {
		    		 amount = 22000;
		    		 textField_11.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+ amount); 
		    	 }
		    	 else if(tax>1000 & tax<1500) {
		    		 amount=25000;
		    		 textField_11.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 else if(tax>1500 & tax<2000) {
		    		 amount = 27000;
		    		 textField_11.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 
		    	 else if(tax>2500 & tax<3000) {
		    		 amount = 50000;
		    		 textField_11.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 else if(tax>3000 & tax<3500) {
		    		 amount = 60500;
		    		 textField_11.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
		    	 else if(tax>3500){
		    		 amount = 65000;
		    		 textField_11.setText(""+amount);
		    		 JOptionPane.showMessageDialog(null, "Your vehicle tax price is rs:"+amount);
		    	 }
				
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(36, 459, 141, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnClearInput_1 = new JButton("Clear Input");
		btnClearInput_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
			}
		});
		btnClearInput_1.setForeground(Color.WHITE);
		btnClearInput_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnClearInput_1.setBackground(Color.RED);
		btnClearInput_1.setBounds(563, 460, 141, 23);
		panel_1.add(btnClearInput_1);
		
		JButton btnNewButton_1_1 = new JButton("Car/Van/Jeep");
		btnNewButton_1_1.setBackground(new Color(255, 111, 111));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_1);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1.setBounds(592, 11, 157, 23);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(828, 75, 174, 31);
		frame.getContentPane().add(panel_3);
		
		textField_12 = new JTextField(this.email);
		textField_12.setBounds(813, 30, 174, 31);
		frame.getContentPane().add(textField_12);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		frame.setVisible(true);
	}
}
