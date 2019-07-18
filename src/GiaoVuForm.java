import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class GiaoVuForm {

	public JFrame frmGiaoVu;
	private JTable table;
	private JTextField txtNhapVaoTen;
	private JLabel lblNhapTenLop;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoVuForm window = new GiaoVuForm();
					window.frmGiaoVu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaoVuForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGiaoVu = new JFrame();
		frmGiaoVu.setBounds(100, 100, 692, 515);
		frmGiaoVu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGiaoVu.getContentPane().setLayout(null);
		
		table = new JTable();
		
		table.setBounds(55, 80, 568, 348);
		frmGiaoVu.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Import");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String fileName = txtNhapVaoTen.getText() + ".csv";
					BufferedReader br  = new BufferedReader(new FileReader(new File(fileName)));
					List<String[]> elements = new ArrayList<String[]>();
					String line = null;
					while ((line = br.readLine()) != null) {
						
						String[] splitted = line.split(";");
						elements.add(splitted);
						
					}
					br.close();
					
					String[] columsName = new String[] {
							
							"STT", "MSSV", "Ho Ten", "Gioi Tinh", "CMND", "Lop"
							
						};
					
					Object[][] content = new Object[elements.size()][6];
					for (int i = 0; i < elements.size(); i++) {
						for (int j = 0; j < 6; j++) {
							
							content[i][j] = elements.get(i)[j];
							
						}
						
					}
					table.setModel(new DefaultTableModel(content,columsName));
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(213, 35, 115, 29);
		frmGiaoVu.getContentPane().add(btnNewButton);
		
		txtNhapVaoTen = new JTextField();
		txtNhapVaoTen.setBounds(359, 36, 146, 26);
		frmGiaoVu.getContentPane().add(txtNhapVaoTen);
		txtNhapVaoTen.setColumns(10);
		
		lblNhapTenLop = new JLabel("Nhap ten lop");
		lblNhapTenLop.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapTenLop.setBounds(359, 16, 146, 20);
		frmGiaoVu.getContentPane().add(lblNhapTenLop);
		
		
	}
}
