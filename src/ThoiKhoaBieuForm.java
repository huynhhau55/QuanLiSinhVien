import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ThoiKhoaBieuForm {

	private JFrame frmThoiKhoaBieu;
	private JTable table;
	private JTextField txtImport;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThoiKhoaBieuForm window = new ThoiKhoaBieuForm();
					window.frmThoiKhoaBieu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThoiKhoaBieuForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThoiKhoaBieu = new JFrame();
		frmThoiKhoaBieu.setTitle("Thoi Khoa Bieu");
		frmThoiKhoaBieu.setBounds(100, 100, 805, 584);
		frmThoiKhoaBieu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThoiKhoaBieu.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(31, 111, 727, 377);
		frmThoiKhoaBieu.getContentPane().add(table);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filePath =txtImport.getText() + "TKB.csv";
				try {
					
					BufferedReader br =new BufferedReader(new FileReader(new File(filePath)));
					List<String[]> elements = new ArrayList<String[]>();
					String line = null;
					while ((line = br.readLine()) != null) {
						
						String[] spiltted = line.split(";");
						elements.add(spiltted);
						
					}
					br.close();
					String[] columsName = new String[] {
							"STT","Ma Mon Hoc","Ten Mon Hoc","Phong Hoc"
					};
					Object[][] content = new Object[elements.size()][4];
					for(int i = 0; i < elements.size() ; i++) {
						for (int j = 0; j < 4 ; j++) {
							
							content[i][j] = elements.get(i)[j];
						}
						
					}
					table.setModel(new DefaultTableModel(content,columsName));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frmThoiKhoaBieu, "Fail");
				}
				
			}
		});
		btnImport.setBounds(160, 53, 115, 29);
		frmThoiKhoaBieu.getContentPane().add(btnImport);
		
		txtImport = new JTextField();
		txtImport.setBounds(316, 54, 146, 26);
		frmThoiKhoaBieu.getContentPane().add(txtImport);
		txtImport.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhao vao ten lop");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(316, 28, 146, 20);
		frmThoiKhoaBieu.getContentPane().add(lblNewLabel);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(498, 53, 115, 29);
		frmThoiKhoaBieu.getContentPane().add(btnBack);
	}
}
