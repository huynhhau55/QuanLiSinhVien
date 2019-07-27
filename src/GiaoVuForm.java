import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.collections.SetListenerHelper;
import com.sun.javafx.geom.Rectangle;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;



public class GiaoVuForm {

	public JFrame frmGiaoVu;
	private JTable table;
	public JTextField txtDuongDan;
	private JButton btnBack;
	private JLabel lblImportVaoDanh;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoVuForm window = new GiaoVuForm();
					window.frmGiaoVu.setLocationRelativeTo(null);
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
		frmGiaoVu.setTitle("Danh Sach Lop");
		frmGiaoVu.setBounds(100, 100, 1107, 660);
		frmGiaoVu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGiaoVu.getContentPane().setLayout(null);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile() ;
					String fileName = f.getAbsolutePath();
					txtDuongDan.setText(fileName);
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
					
				}
				
				
				
				
			}
		});
		btnImport.setBounds(149, 78, 127, 39);
		frmGiaoVu.getContentPane().add(btnImport);
		
		txtDuongDan = new JTextField();
		txtDuongDan.setBounds(318, 78, 447, 39);
		frmGiaoVu.getContentPane().add(txtDuongDan);
		txtDuongDan.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGiaoVu.setVisible(false);
				LoginForm login = new LoginForm();
				login.frmLogin.setLocationRelativeTo(null);
				login.frmLogin.setVisible(true);
				
			}
		});
		btnBack.setBounds(815, 78, 127, 39);
		frmGiaoVu.getContentPane().add(btnBack);
		
		lblImportVaoDanh = new JLabel("IMPORT VAO DANH SACH LOP");
		lblImportVaoDanh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblImportVaoDanh.setForeground(Color.RED);
		lblImportVaoDanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportVaoDanh.setBounds(320, 24, 447, 46);
		frmGiaoVu.getContentPane().add(lblImportVaoDanh);
		
		scrollPane = new JScrollPane();
		frmGiaoVu.getContentPane().add(scrollPane);
		scrollPane.setBounds(15, 133, 1055, 471);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
		
	}
}
