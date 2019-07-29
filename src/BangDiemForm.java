import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

public class BangDiemForm {

	private JFrame frmDiem;
	private JTable table;
	private JTextField txtImport;

	/**
	 * Launch the application.
	 */
	public JFrame getFrmDiem() {
		
		return this.frmDiem;
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangDiemForm window = new BangDiemForm();
					window.frmDiem.setLocationRelativeTo(null);;
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
		frmDiem.setBounds(100, 100, 1107, 660);
		frmDiem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDiem.getContentPane().setLayout(null);
		
		
		
		
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					JFileChooser choser = new JFileChooser();
					choser.showOpenDialog(null);
					File f =choser.getSelectedFile();
					String filePath = f.getAbsolutePath();
					txtImport.setText(filePath);
					BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
					List<String[]> elements = new ArrayList<String[]>();
					String line = null;
					while((line = br.readLine()) != null ) {
						
						String[] spiltted = line.split(";");
						elements.add(spiltted);
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
					
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnImport.setBounds(149, 78, 127, 39);
		frmDiem.getContentPane().add(btnImport);
		
		txtImport = new JTextField();
		txtImport.setBounds(318, 78, 447, 39);
		frmDiem.getContentPane().add(txtImport);
		txtImport.setColumns(10);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmDiem.setVisible(false);
				MainWindow mainWindow = new MainWindow();
				mainWindow.getFrmMainWindow().setLocationRelativeTo(null);
				mainWindow.getFrmMainWindow().setVisible(true);
				
			}
		});
		btnCancel.setBounds(815, 78, 127, 39);
		frmDiem.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("IMPORT V\u00C0O B\u1EA2NG \u0110I\u1EC2M C\u1EE6A M\u00D4N H\u1ECCC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(293, 24, 502, 46);
		frmDiem.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 133, 1055, 471);
		frmDiem.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}
