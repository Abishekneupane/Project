package taxmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registration {

	private static final int Name = 0;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}
	//validate email
		public static boolean validateEmail(String email) {
		    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
		                        "[a-zA-Z0-9_+&-]+)*@" + 
		                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
		                        "A-Z]{2,7}$"; 
		                        
		    Pattern pattern = Pattern.compile(emailRegex);
		    Matcher matcher = pattern.matcher(email);
		    return matcher.matches();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1011, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(0, 255, 0));
		layeredPane.setBounds(10, 139, 977, 448);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		layeredPane.add(panel, "name_993575618492100");
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Signup Page");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(228, 22, 376, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2.setBounds(265, 132, 99, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(265, 187, 131, 28);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Conform Password");
		lblNewLabel_2_1_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2_1_1.setBounds(265, 238, 191, 28);
		panel.add(lblNewLabel_2_1_1);
		
		
		JButton btnLogin = new JButton("Create Account");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
			    if (!validateEmail(email)) {
			      JOptionPane.showMessageDialog(null, "Please enter a valid email address");
			      return;
			    }

			    String password=new String(passwordField.getPassword());
			    String confirmPassword=new String(passwordField.getPassword());
			    if(password.equals(confirmPassword)) {
			    	JOptionPane.showMessageDialog(null,"successfull ");
			    	Connection con = null;
			    	 try {
					        con = DbConnection.getConnection();
					      } catch (Exception ex) {
					        JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
					        return;
					      }

					      String createTable = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, email VARCHAR(255) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL)";
					      try {
					        PreparedStatement createStatement = con.prepareStatement(createTable);
					        createStatement.executeUpdate();
					        createStatement.close();
					      } catch (Exception ex) {
					        JOptionPane.showMessageDialog(null, "Error creating table: " + ex.getMessage());
					        return;
					      }

					      String email1 = textField.getText();
					      String password1 = new String(passwordField.getPassword());  
					      String insertData = "INSERT INTO users (email, password) VALUES (?, ?)";
					      try {
					    	    PreparedStatement insertStatement = con.prepareStatement(insertData);
					    	    insertStatement.setString(1, email1);
					    	    insertStatement.setString(2, password1);
					    	   	   
					    	    insertStatement.executeUpdate();
					    	    insertStatement.close();
					    	} catch (SQLIntegrityConstraintViolationException e1) {
					    	    JOptionPane.showMessageDialog(null, "Error: User already exists");
					    	    return;
					    	} catch (Exception ex) {
					    	    JOptionPane.showMessageDialog(null, "Error inserting data: " + ex.getMessage());
					    	    return;
					    	}

					      // open the login screen
					      JOptionPane.showMessageDialog(null, "Registration successful!");
					      new Login();
					      frame.setVisible(false);
					    } else {
					    	JOptionPane.showMessageDialog(null, "Error: Password donot match");
					    	System.out.println("Password doesnot match");
					    }
					  }
					});
		btnLogin.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogin.setBounds(416, 305, 203, 36);
		panel.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(507, 137, 191, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(507, 192, 191, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(507, 243, 191, 20);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Already have account?");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(45, 396, 239, 28);
		panel.add(lblNewLabel_3);
		
		JButton btnSignin = new JButton("Signin");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.setVisible(false);
			}
		});
		btnSignin.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnSignin.setBounds(281, 396, 99, 28);
		panel.add(btnSignin);
		ImageIcon icon = new ImageIcon("Img/user.png");
		Image img1 = icon.getImage();
		Image modimg = img1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modimg);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 0));
		panel_2.setBounds(722, 132, 245, 129);
		panel.add(panel_2);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(Color.RED);
		panel_2_3.setBounds(10, 137, 245, 129);
		panel.add(panel_2_3);
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_441721126839700");
		
		JLabel lblNewLabel = new JLabel("Tax Calculator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 232, 47);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
