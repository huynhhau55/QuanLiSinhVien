import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class QL_BangDiem {

	private JFrame frmQLBD;
	private JTable table;
	private JTextField txtHoTen;
	private JTextField txtDiemGK;
	private JTextField txtDiemCK;
	private JTextField txtDiemKhac;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public JFrame getfrmQLBD() {
		
		return this.frmQLBD;
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_BangDiem window = new QL_BangDiem();
					window.frmQLBD.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QL_BangDiem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQLBD = new JFrame();
		frmQLBD.setTitle("QU\u1EA2N L\u00DD B\u1EA2NG \u0110I\u1EC2M");
		frmQLBD.setBounds(100, 100, 1107, 660);
		frmQLBD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQLBD.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD B\u1EA2NG \u0110I\u1EC2M");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(129, 0, 816, 43);
		frmQLBD.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 217, 1055, 371);
		frmQLBD.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00F4n h\u1ECDc");
		lblNewLabel_1.setBounds(129, 57, 69, 20);
		frmQLBD.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MSSV");
		lblNewLabel_2.setBounds(129, 104, 69, 20);
		frmQLBD.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(234, 54, 146, 26);
		frmQLBD.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_3.setBounds(426, 57, 69, 20);
		frmQLBD.getContentPane().add(lblNewLabel_3);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(510, 54, 146, 26);
		frmQLBD.getContentPane().add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110i\u1EC3m GK");
		lblNewLabel_4.setBounds(426, 104, 69, 20);
		frmQLBD.getContentPane().add(lblNewLabel_4);
		
		txtDiemGK = new JTextField();
		txtDiemGK.setBounds(510, 101, 146, 26);
		frmQLBD.getContentPane().add(txtDiemGK);
		txtDiemGK.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u0110i\u1EC3m CK");
		lblNewLabel_5.setBounds(692, 57, 69, 20);
		frmQLBD.getContentPane().add(lblNewLabel_5);
		
		txtDiemCK = new JTextField();
		txtDiemCK.setBounds(799, 54, 146, 26);
		frmQLBD.getContentPane().add(txtDiemCK);
		txtDiemCK.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u0110i\u1EC3m kh\u00E1c");
		lblNewLabel_6.setBounds(692, 104, 80, 20);
		frmQLBD.getContentPane().add(lblNewLabel_6);
		
		txtDiemKhac = new JTextField();
		txtDiemKhac.setBounds(799, 101, 146, 26);
		frmQLBD.getContentPane().add(txtDiemKhac);
		txtDiemKhac.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(234, 101, 146, 26);
		frmQLBD.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setBounds(131, 158, 156, 43);
		frmQLBD.getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setBounds(365, 158, 151, 43);
		frmQLBD.getContentPane().add(btnXoa);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.setBounds(584, 158, 156, 43);
		frmQLBD.getContentPane().add(btnCapNhat);
		
		JButton btnQuayLai = new JButton("QuayLai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmQLBD.setVisible(false);
				BangDiemForm bangDiem = new BangDiemForm();
				bangDiem.getFrmDiem().setLocationRelativeTo(null);
				bangDiem.getFrmDiem().setVisible(true);
				
				
			}
		});
		btnQuayLai.setBounds(799, 158, 146, 43);
		frmQLBD.getContentPane().add(btnQuayLai);
	}

}
