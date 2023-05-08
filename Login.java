package taxmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1036, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Calculator");
		lblNewLabel.setBounds(300, 11, 297, 35);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(264, 144, 474, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 11, 401, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(52, 80, 96, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(66, 138, 96, 30);
		panel.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(105, 107, 163, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 179, 161, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
			    String password = new String(passwordField.getPassword());
			    Connection con = null;
			    try {
			    	//making connection into database from file DatabaseConnection.
			      con = DbConnection.getConnection();
			    } catch (Exception ex) {
			      JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
			      return;
			    }
			  //retrive data from user table 
			    
			    String retrieveRoleAndId = "SELECT * FROM users WHERE email = ? AND password = ?";
			    try {
			    	//preparedStatement to retrive and execute data from database and and check in database.
			      PreparedStatement retrieveStatement = con.prepareStatement(retrieveRoleAndId);
			      retrieveStatement.setString(1, email);
			      retrieveStatement.setString(2, password);
			      ResultSet result = retrieveStatement.executeQuery();
			      if (result.next()) {
			    	  int id = result.getInt("id");
			    	  //if username and password match with role then display new window similar to this.
			    	  new Dashboard(id,email);
						frame.setVisible(false);
						result.close();
			      } else {
			    	  //otherwise,throw invalid
			        JOptionPane.showMessageDialog(null, "Error: Invalid email or password");
			    	  
			      }
			    } catch (Exception ex) {
			    	JOptionPane.showMessageDialog(null, "Please register first ");
			    }
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(165, 246, 113, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 0, 0));
		panel_1_1.setBounds(0, 200, 1022, 114);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Not have account? ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 451, 160, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Registration();
				frame.setVisible(false);
			}
		});
		btnSignup.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnSignup.setBounds(159, 455, 113, 23);
		frame.getContentPane().add(btnSignup);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 24, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}
}
