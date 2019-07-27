import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;

public class AddStudentForm {

	private JFrame frmAddSd;
	private JTable table;
	private JTextField txtMSSV;
	private JTextField txtLop;
	private JTextField txtHoTen;
	private JLabel lblCmnd;
	private JTextField txtCMND;
	private JLabel lblGioiTinh;
	private JButton btnThem;
	private JButton btnMacDinh;
	private JScrollBar scrollBar;
	private JScrollPane scrollPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentForm window = new AddStudentForm();
					window.frmAddSd.setLocationRelativeTo(null);
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
	private void loadSinhVien() {
		
		try {
			
			String filePath = txtLop.getText() + ".csv";
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
			List<String[]> elements = new ArrayList<String[]>();
			String line = null;
			while((line = br.readLine()) != null ) {
				
				String[] spiltted = line.split(";");
				elements.add(spiltted);
			
			}
			br.close();
			String[] columsName = new String[] {
					"STT","MSSV","Ho Ten","Gioi Tinh", "CMND", "Lop"							
			};
			Object[][] content = new Object[elements.size()][6];
			for(int i = 0; i < elements.size(); i++) {
				for(int j = 0; j < 6; j++) {
					
					content[i][j] = elements.get(i)[j];
				}
			}
			table.setModel(new DefaultTableModel(content,columsName));
		}catch (Exception e2) {
			
			e2.printStackTrace();
			
			}
		
		
	}
	private void initialize() {
		frmAddSd = new JFrame();
		frmAddSd.setTitle("Add Student");
		frmAddSd.setBounds(100, 100, 1107, 660);
		frmAddSd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddSd.getContentPane().setLayout(null);
		
		
		
		
		txtMSSV = new JTextField();
		txtMSSV.setBounds(143, 55, 146, 29);
		frmAddSd.getContentPane().add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblMssv = new JLabel("MSSV");
		lblMssv.setBounds(59, 59, 69, 20);
		frmAddSd.getContentPane().add(lblMssv);
		
		JLabel lblLop = new JLabel("Lop");
		lblLop.setBounds(51, 104, 69, 20);
		frmAddSd.getContentPane().add(lblLop);
		
		txtLop = new JTextField();
		txtLop.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				loadSinhVien();
			}
		});
		txtLop.setColumns(10);
		txtLop.setBounds(143, 100, 146, 29);
		frmAddSd.getContentPane().add(txtLop);
		
		JLabel lblHoTen = new JLabel("Ho Ten");
		lblHoTen.setBounds(332, 59, 69, 20);
		frmAddSd.getContentPane().add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(427, 55, 146, 29);
		frmAddSd.getContentPane().add(txtHoTen);
		
		lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(332, 104, 69, 20);
		frmAddSd.getContentPane().add(lblCmnd);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(427, 100, 146, 29);
		frmAddSd.getContentPane().add(txtCMND);
		
		lblGioiTinh = new JLabel("Gioi Tinh");
		lblGioiTinh.setBounds(671, 59, 69, 20);
		frmAddSd.getContentPane().add(lblGioiTinh);
		
		JComboBox<String> cbbGioiTinh = new JComboBox<String>();
		cbbGioiTinh.setBounds(799, 56, 146, 26);
		frmAddSd.getContentPane().add(cbbGioiTinh);
		cbbGioiTinh.addItem("Nam");
		cbbGioiTinh.addItem("Nu");
		
		btnThem = new JButton("Add");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String filePath = txtLop.getText() + ".csv";
					List<Student> Students = Student.readStudents(filePath);
					String stt = Integer.toString(Students.size());
					String gioiTinh = String.valueOf(cbbGioiTinh.getSelectedItem());
					Student sd = new Student(stt, txtMSSV.getText(), txtHoTen.getText(), 
										gioiTinh,txtCMND.getText() , txtLop.getText());
					FileWriter fw = new FileWriter(filePath,true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					pw.println(sd.sttStudent + ";" + sd.studentID + ";" + sd.nameStudent + ";" + 
							   sd.genderStudent + ";" + sd.identityCard + ";" + sd.classRoom );
					
					pw.close();
					loadSinhVien();
					txtCMND.setText("");
					txtHoTen.setText("");
					txtLop.setText("");
					txtMSSV.setText("");
					
					
				}
				catch(Exception ioe) {
					
					ioe.printStackTrace();
				}	
				
			}
		});
		btnThem.setBounds(350, 158, 156, 43);
		frmAddSd.getContentPane().add(btnThem);
		
		btnMacDinh = new JButton("Cancel");
		btnMacDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMacDinh.setBounds(642, 158, 146, 43);
		frmAddSd.getContentPane().add(btnMacDinh);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 217, 1055, 371);
		frmAddSd.getContentPane().add(scrollPane);
		
	
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	
		
	}
}
