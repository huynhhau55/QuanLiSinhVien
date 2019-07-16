import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.sun.java.swing.plaf.windows.resources.windows;

import Mypack.Account;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class LoginForm {

	public JFrame frmLogin;
	private JPasswordField passwordField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 308);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(54, 62, 96, 20);
		frmLogin.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(54, 112, 69, 20);
		frmLogin.getContentPane().add(lblPassword);
		
		JTextPane textPane_userName = new JTextPane();
		textPane_userName.setBounds(184, 56, 185, 26);
		frmLogin.getContentPane().add(textPane_userName);
		
		passwordField_password = new JPasswordField();
		passwordField_password.setBounds(184, 109, 185, 26);
		frmLogin.getContentPane().add(passwordField_password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean flag1 = false;//Bo qua vong lap dau tien vi dong dau la tieu de
				boolean flag2 = false;//Cho biet den cuoi file ma van chua tim duoc user
				List<Account> Accounts = Account.readAccounts("C:\\Users\\Mr Hau\\File Do An\\Java\\ltudjava-18hcb-18424024-bt1\\matkhau.csv");
			
					for(Account a : Accounts) {
						if(flag1 == false) {
							flag1 = true;
							continue;
						}
						
					String uname=textPane_userName.getText();
					String pass=passwordField_password.getText();
					
					if (uname.equals(a.user)&& pass.equals(a.pass)) {
						flag2 = true;
						GiaoVuForm giaoVu = new GiaoVuForm();
						frmLogin.setVisible(false);
						giaoVu.frmGiaoVu.setVisible(true);
						giaoVu.frmGiaoVu.setExtendedState(giaoVu.frmGiaoVu.getExtendedState() | JFrame.MAXIMIZED_BOTH);
						break;
					}
					
				}
					if (flag2 == false) {
						JOptionPane.showMessageDialog(frmLogin, "Please, check your account again !");
						
					}
					
				
				
			
		}
			});
		btnLogin.setBounds(61, 199, 115, 29);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(254, 199, 115, 29);
		frmLogin.getContentPane().add(btnExit);
		
		JLabel lblChangePassword = new JLabel("Change password");
		lblChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmLogin.setVisible(false);
				ChangePasswordForm changePasswordF = new ChangePasswordForm();
				changePasswordF.frmChangePassword.setVisible(true);
				
						
			}
		});
		lblChangePassword.setBounds(194, 151, 133, 20);
		frmLogin.getContentPane().add(lblChangePassword);
	}
}

