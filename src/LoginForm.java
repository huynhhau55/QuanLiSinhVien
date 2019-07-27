import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.sun.javafx.tk.Toolkit;
import com.sun.prism.Image;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class LoginForm {

	public JFrame frmLogin;
	private JPasswordField passwordField_password;
	private ImageIcon img;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmLogin.setLocationRelativeTo(null);
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
		frmLogin.setBounds(100, 100, 679, 515);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(108, 56, 96, 20);
		frmLogin.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(108, 122, 69, 20);
		frmLogin.getContentPane().add(lblPassword);
		
		JTextPane textPane_userName = new JTextPane();
		textPane_userName.setBounds(219, 45, 248, 37);
		frmLogin.getContentPane().add(textPane_userName);
		
		passwordField_password = new JPasswordField();
		passwordField_password.setBounds(217, 115, 250, 34);
		frmLogin.getContentPane().add(passwordField_password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean flag1 = false;//Bo qua vong lap dau tien vi dong dau la tieu de
				boolean flag2 = false;//Cho biet den cuoi file ma van chua tim duoc user
				List<Account> Accounts = Account.readAccounts("matkhau.csv");
					for(Account a : Accounts) {
						if(flag1 == false) {
							flag1 = true;
							continue;
						}
					
						
					String uname=textPane_userName.getText();
					String pass=String.valueOf( passwordField_password.getPassword());
					
					if (uname.equals(a.user)&& pass.equals(a.pass)) {
						
						flag2 = true;
						GiaoVuForm giaoVu = new GiaoVuForm();
						frmLogin.setVisible(false);
						if(uname.equals("giaovu")) {
							
						giaoVu.frmGiaoVu.setVisible(true);
						giaoVu.frmGiaoVu.setLocationRelativeTo(null);
						giaoVu.frmGiaoVu.setExtendedState(giaoVu.frmGiaoVu.getExtendedState() | JFrame.MAXIMIZED_BOTH);
						break;
						
						}
						else {
							JOptionPane.showMessageDialog(frmLogin,"Thanh cong");
						}
					}
					
				}
					if (flag2 == false) {
						JOptionPane.showMessageDialog(frmLogin, "Please, check your account again !");
						
					}
					
				
				
			
		}
			});
		btnLogin.setBounds(129, 209, 115, 37);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(320, 209, 115, 37);
		frmLogin.getContentPane().add(btnExit);
		
		JLabel lblChangePassword = new JLabel("Change password");
		lblChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmLogin.setVisible(false);
				ChangePasswordForm changePasswordF = new ChangePasswordForm();
				changePasswordF.frmChangePassword.setLocationRelativeTo(null);
				changePasswordF.frmChangePassword.setVisible(true);
				
						
			}
		});
		lblChangePassword.setBounds(240, 165, 133, 20);
		frmLogin.getContentPane().add(lblChangePassword);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mr Hau\\File Do An\\Java\\ltudjava-18hcb-18424024-bt1\\src\\images\\bk4.jpg"));
		lblNewLabel.setBounds(0, 0, 661, 485);
		frmLogin.getContentPane().add(lblNewLabel);
	}
}

