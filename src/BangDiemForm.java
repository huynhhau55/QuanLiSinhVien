import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BangDiemForm {

	private JFrame frmDiem;
	private JTable table;
	private JTextField txtImport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangDiemForm window = new BangDiemForm();
					window.frmDiem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BangDiemForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiem = new JFrame();
		frmDiem.setTitle("Diem");
		frmDiem.setBounds(100, 100, 783, 569);
		frmDiem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDiem.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(15, 96, 731, 401);
		frmDiem.getContentPane().add(table);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String filePath = txtImport.getText() ;
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnImport.setBounds(159, 51, 115, 29);
		frmDiem.getContentPane().add(btnImport);
		
		txtImport = new JTextField();
		txtImport.setBounds(309, 52, 146, 26);
		frmDiem.getContentPane().add(txtImport);
		txtImport.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(485, 51, 115, 29);
		frmDiem.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Nhap vao lop");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(312, 16, 143, 20);
		frmDiem.getContentPane().add(lblNewLabel);
	}
}
