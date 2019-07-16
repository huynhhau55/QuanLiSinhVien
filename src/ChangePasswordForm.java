import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordForm {

	public JFrame frmChangePassword;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordForm window = new ChangePasswordForm();
					window.frmChangePassword.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangePasswordForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChangePassword = new JFrame();
		frmChangePassword.setTitle("Change Password");
		frmChangePassword.setBounds(100, 100, 450, 300);
		frmChangePassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChangePassword.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Password");
		lblNewLabel.setBounds(37, 36, 106, 20);
		frmChangePassword.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setBounds(37, 72, 106, 20);
		frmChangePassword.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm New Password");
		lblNewLabel_2.setBounds(37, 120, 172, 20);
		frmChangePassword.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.setBounds(43, 188, 166, 29);
		frmChangePassword.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmChangePassword.setVisible(false);
				LoginForm login = new LoginForm();
				login.frmLogin.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(237, 188, 129, 29);
		frmChangePassword.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 33, 156, 26);
		frmChangePassword.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(210, 75, 156, 26);
		frmChangePassword.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(210, 117, 156, 26);
		frmChangePassword.getContentPane().add(passwordField_2);
	}
}
