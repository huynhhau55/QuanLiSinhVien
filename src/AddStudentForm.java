import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddStudentForm {

	private JFrame frmAddSd;
	private JTable table;
	private JTextField txtMSSV;
	private JTextField txtGioiTinh;
	private JTextField txtHoTen;
	private JLabel lblCmnd;
	private JTextField txtCMND;
	private JLabel lblLop;
	private JTextField txtLop;
	private JButton btnThem;
	private JButton btnMacDinh;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentForm window = new AddStudentForm();
					window.frmAddSd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddStudentForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddSd = new JFrame();
		frmAddSd.setTitle("Add Student");
		frmAddSd.setBounds(100, 100, 640, 540);
		frmAddSd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddSd.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(51, 201, 519, 241);
		frmAddSd.getContentPane().add(table);
		
		txtMSSV = new JTextField();
		txtMSSV.setBounds(143, 20, 146, 29);
		frmAddSd.getContentPane().add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblMssv = new JLabel("MSSV");
		lblMssv.setBounds(51, 24, 69, 20);
		frmAddSd.getContentPane().add(lblMssv);
		
		JLabel lblGioiTinh = new JLabel("Gioi Tinh");
		lblGioiTinh.setBounds(51, 64, 69, 20);
		frmAddSd.getContentPane().add(lblGioiTinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(143, 60, 146, 29);
		frmAddSd.getContentPane().add(txtGioiTinh);
		
		JLabel lblHoTen = new JLabel("Ho Ten");
		lblHoTen.setBounds(332, 24, 69, 20);
		frmAddSd.getContentPane().add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(424, 20, 146, 29);
		frmAddSd.getContentPane().add(txtHoTen);
		
		lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(332, 68, 69, 20);
		frmAddSd.getContentPane().add(lblCmnd);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(424, 64, 146, 29);
		frmAddSd.getContentPane().add(txtCMND);
		
		lblLop = new JLabel("Lop");
		lblLop.setBounds(51, 104, 69, 20);
		frmAddSd.getContentPane().add(lblLop);
		
		txtLop = new JTextField();
		txtLop.setColumns(10);
		txtLop.setBounds(143, 100, 146, 29);
		frmAddSd.getContentPane().add(txtLop);
		
		btnThem = new JButton("Add");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					String filePath = txtLop.getText() + ".csv";
					List<Student> Students = Student.readStudents(filePath);
					Student sd = new Student(Students.size(), txtMSSV.getText(), txtHoTen.getText(), 
										txtGioiTinh.getText(),txtCMND.getText() , txtLop.getText());
					FileWriter fw = new FileWriter(filePath,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					pw.println(sd.sttStudent +";"+ sd.studentID + ";"+ sd.nameStudent + ";" + 
							   sd.genderStudent + ";" + sd.identityCard + ";" + sd.classRoom );
					pw.close();
					JOptionPane.showMessageDialog(frmAddSd,"Successful");
				}
				catch(Exception ioe) {
					
					JOptionPane.showMessageDialog(frmAddSd,"Fail");
				}
			}
		});
		btnThem.setBounds(143, 145, 115, 29);
		frmAddSd.getContentPane().add(btnThem);
		
		btnMacDinh = new JButton("Cancel");
		btnMacDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMacDinh.setBounds(355, 145, 115, 29);
		frmAddSd.getContentPane().add(btnMacDinh);
	}
}
