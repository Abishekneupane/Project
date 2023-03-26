package taxmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Dashboard {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
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
		
		JLabel lblNewLabel = new JLabel("Tax Calculator");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 177, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNepa = new JLabel("Nepalease Income Tax Calculation.  ");
		lblNepa.setForeground(new Color(255, 0, 0));
		lblNepa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNepa.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNepa.setBounds(314, 30, 367, 31);
		frame.getContentPane().add(lblNepa);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 82, 647, 462);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_610732957081300");
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Annual Income");
		lblNewLabel_1.setBounds(86, 11, 159, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(255, 12, 180, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Deduction");
		lblNewLabel_1_1.setBounds(195, 42, 141, 20);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("EPF Contribution");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(10, 88, 141, 20);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("CIT Contribution");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_1.setBounds(10, 164, 141, 20);
		panel.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Health Insurance Premium");
		lblNewLabel_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_2.setBounds(10, 249, 201, 20);
		panel.add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_1_1_2_3 = new JLabel("Other Expenses");
		lblNewLabel_1_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_3.setBounds(10, 323, 141, 20);
		panel.add(lblNewLabel_1_1_2_3);
		
		JLabel lblNewLabel_1_1_2_4 = new JLabel("Medical Expenses");
		lblNewLabel_1_1_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_4.setBounds(10, 400, 141, 20);
		panel.add(lblNewLabel_1_1_2_4);
		
		JLabel lblNewLabel_1_1_2_5 = new JLabel("SSF Contribution");
		lblNewLabel_1_1_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_5.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_5.setBounds(467, 88, 141, 20);
		panel.add(lblNewLabel_1_1_2_5);
		
		JLabel lblNewLabel_1_1_2_6 = new JLabel("Life Insurance Premium");
		lblNewLabel_1_1_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_6.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_6.setBounds(444, 168, 193, 20);
		panel.add(lblNewLabel_1_1_2_6);
		
		JLabel lblNewLabel_1_1_2_7 = new JLabel("House Insurance Premium");
		lblNewLabel_1_1_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_7.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_7.setBounds(428, 253, 209, 20);
		panel.add(lblNewLabel_1_1_2_7);
		
		JLabel lblNewLabel_1_1_2_8 = new JLabel("Donation");
		lblNewLabel_1_1_2_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_8.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1_2_8.setBounds(467, 327, 141, 20);
		panel.add(lblNewLabel_1_1_2_8);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 119, 156, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(55, 195, 156, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(55, 280, 156, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(55, 356, 156, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(55, 431, 156, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(481, 119, 156, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(481, 199, 156, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(481, 280, 156, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(481, 356, 156, 20);
		panel.add(textField_9);
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_611294820054000");
		
		JButton btnNewButton = new JButton("Calculate Tax ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setBounds(20, 565, 141, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClearInput = new JButton("Clear Input");
		btnClearInput.setForeground(new Color(255, 255, 255));
		btnClearInput.setBackground(new Color(255, 0, 0));
		btnClearInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClearInput.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnClearInput.setBounds(516, 565, 141, 23);
		frame.getContentPane().add(btnClearInput);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(667, 82, 347, 462);
		frame.getContentPane().add(panel_2);
		frame.setVisible(true);
		
	}
}
