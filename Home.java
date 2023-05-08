package taxmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import java.awt.Color;

public class Home{

	private JFrame frame;
	protected String email;
	protected int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1032, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Calculator");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 232, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Registration();
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setBounds(416, 411, 133, 36);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(837, 97, 1, 2);
		frame.getContentPane().add(separator);
		
		JButton btnWhyUs = new JButton("Admin");
		btnWhyUs.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				new Aaaa(id,email);
				frame.setVisible(false);
				
			}
			
		});
		btnWhyUs.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnWhyUs.setBounds(614, 11, 109, 27);
		frame.getContentPane().add(btnWhyUs);
		
		JButton btnOurServices = new JButton("Services");
		btnOurServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "Nothing here");
				
			}
		});
		btnOurServices.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnOurServices.setBounds(744, 11, 121, 27);
		frame.getContentPane().add(btnOurServices);
		
		JButton btnContactUs = new JButton("Contact Us");
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Nothing here");
			}
		});
		btnContactUs.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnContactUs.setBounds(876, 11, 121, 27);
		frame.getContentPane().add(btnContactUs);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 97, 998, 303);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = 	new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 0, 998, 303);
		ImageIcon icon = new ImageIcon("Img/taximg.jpg");
		Image img1 = icon.getImage();
		Image modimg = img1.getScaledInstance(1080, 425, java.awt.Image.SCALE_DEFAULT);
		icon = new ImageIcon(modimg);
		lblNewLabel_1.setIcon(icon);
		panel.add(lblNewLabel_1);
		frame.setVisible(true);
	}
}
