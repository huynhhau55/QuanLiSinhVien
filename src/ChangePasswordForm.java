import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ChangePasswordForm {

	private static Scanner x;
	
	public JFrame frmChangePassword;
	private JPasswordField passwOld;
	private JPasswordField passwNew;
	private JPasswordField passwConf;

	/**
	 * Launch the application.
	 */
	
	public static void editRecord(String filePath, List<Account> Accounts) {
		
		try {
			
			PrintWriter pw = new PrintWriter(filePath);
			int i =Accounts.size();
			for(Account a : Accounts ) {
				if(--i == 0 ){ 
					pw.print(a.user + ";" + a.pass );
				}
				else {
					pw.println(a.user + ";" + a.pass );
				}
				
			}
			pw.close();
		
		} catch (Exception e) {
			System.out.printf("Error");
		}	
	}
	
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
		lblNewLabel.setBounds(36, 65, 166, 20);
		frmChangePassword.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setBounds(36, 102, 166, 29);
		frmChangePassword.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm New Password");
		lblNewLabel_2.setBounds(36, 147, 177, 20);
		frmChangePassword.getContentPane().add(lblNewLabel_2);
		
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmChangePassword.setVisible(false);
				LoginForm login = new LoginForm();
				login.frmLogin.setLocationRelativeTo(null);
				login.frmLogin.setVisible(true);
			}
		});
		btnCancel.setBounds(231, 199, 135, 29);
		frmChangePassword.getContentPane().add(btnCancel);
		
		passwOld = new JPasswordField();
		passwOld.setBounds(210, 62, 156, 26);
		frmChangePassword.getContentPane().add(passwOld);
		
		passwNew = new JPasswordField();
		passwNew.setBounds(210, 104, 156, 26);
		frmChangePassword.getContentPane().add(passwNew);
		
		passwConf = new JPasswordField();
		passwConf.setBounds(209, 144, 157, 26);
		frmChangePassword.getContentPane().add(passwConf);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBounds(36, 20, 166, 29);
		frmChangePassword.getContentPane().add(lblNewLabel_3);
		
		JTextPane txtUsername = new JTextPane();
		txtUsername.setBounds(210, 20, 156, 26);
		frmChangePassword.getContentPane().add(txtUsername);
		
	
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(36, 199, 129, 29);
		frmChangePassword.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean flag1 = false;//Bo qua vong lap dau tien vi dong dau la tieu de
				boolean flag2 = false;//Cho biet den cuoi file ma van chua tim duoc user
				String filePath = "matkhau.csv" ;
				List<Account> Accounts = Account.readAccounts(filePath);
			
				String uname = txtUsername.getText();
				String passOld = String.valueOf(passwOld.getPassword()) ;
				String passNew = String.valueOf(passwNew.getPassword());
				String passConf = String.valueOf(passwConf.getPassword());
				
				for(Account a : Accounts) {
						
					if(flag1 == false) {
							flag1 = true;
							continue;
						}
						
					if ((uname.equals(a.user) && passOld.equals(a.pass)) && 
							(!(passNew.isEmpty()) && (!(passConf.isEmpty()) && 
							 (passNew.equals(passConf))))){
						a.pass = passNew;
						flag2 = true;
						break;
					}
					
				}
				if (flag2 == false) {
					
					JOptionPane.showMessageDialog(frmChangePassword, "Wrong !");
					return;
					
				}
				
				editRecord(filePath,Accounts);
					
			}
		});
		
		
		
	}
}
