import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class QL_TKB {

	private JFrame frmQL_TKB;
	private JTextField txtMaMH;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField txtCMND;

	/**
	 * Launch the application.
	 */
	
	public JFrame getFrmQLTKB() {
		
		return this.frmQL_TKB;
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_TKB window = new QL_TKB();
					window.frmQL_TKB.setLocationRelativeTo(null);
					window.frmQL_TKB.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QL_TKB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQL_TKB = new JFrame();
		frmQL_TKB.setTitle("QL TKB");
		frmQL_TKB.setBounds(100, 100, 1107, 660);
		frmQL_TKB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQL_TKB.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD TH\u1EDCI KH\u00D3A BI\u1EC2U");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 0, 814, 49);
		frmQL_TKB.getContentPane().add(lblNewLabel);
		
		JButton btnThem = new JButton("Th\u00EAm ");
		btnThem.setBounds(131, 158, 156, 43);
		frmQL_TKB.getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setBounds(365, 158, 151, 43);
		frmQL_TKB.getContentPane().add(btnXoa);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.setBounds(584, 158, 156, 43);
		frmQL_TKB.getContentPane().add(btnCapNhat);
		
		JButton btnQuayLai = new JButton("Quay l\u1EA1i");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmQL_TKB.setVisible(false);
				ThoiKhoaBieuForm tkb = new ThoiKhoaBieuForm();
				tkb.getFramThoiKhoaBieu().setLocationRelativeTo(null);
				tkb.getFramThoiKhoaBieu().setVisible(true);
				
			}
		});
		btnQuayLai.setBounds(799, 158, 146, 43);
		frmQL_TKB.getContentPane().add(btnQuayLai);
		
		JComboBox cbbMonHoc = new JComboBox();
		cbbMonHoc.setBounds(244, 62, 146, 26);
		frmQL_TKB.getContentPane().add(cbbMonHoc);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00F4n h\u1ECDc");
		lblNewLabel_1.setBounds(131, 68, 69, 20);
		frmQL_TKB.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 m\u00F4n h\u1ECDc");
		lblNewLabel_2.setBounds(131, 104, 87, 20);
		frmQL_TKB.getContentPane().add(lblNewLabel_2);
		
		txtMaMH = new JTextField();
		txtMaMH.setBounds(244, 101, 146, 26);
		frmQL_TKB.getContentPane().add(txtMaMH);
		txtMaMH.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("MSSV");
		lblNewLabel_3.setBounds(447, 65, 69, 20);
		frmQL_TKB.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(533, 62, 146, 26);
		frmQL_TKB.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_4.setBounds(447, 104, 69, 20);
		frmQL_TKB.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(533, 101, 146, 26);
		frmQL_TKB.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_5.setBounds(712, 65, 69, 20);
		frmQL_TKB.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(799, 62, 146, 26);
		frmQL_TKB.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 217, 1055, 371);
		frmQL_TKB.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("CMND");
		lblNewLabel_6.setBounds(712, 104, 69, 20);
		frmQL_TKB.getContentPane().add(lblNewLabel_6);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(799, 101, 146, 26);
		frmQL_TKB.getContentPane().add(txtCMND);
		txtCMND.setColumns(10);
	}
}
