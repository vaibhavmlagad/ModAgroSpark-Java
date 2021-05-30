import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Toolkit;

public class signup extends JFrame {

	private static final long serialVersionUID = 1L;
	static int x=0;
	static int posX=0;
	static int posY=0;
	
	private JPanel contentPane;
	private JTextField txt_user;
	private JPasswordField txt_pass;
	private JTextField txt_city;
	private JTextField txt_email;
	private JPasswordField txt_confirm;

	
	public static void main(String[] args) {
	//public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public signup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(signup.class.getResource("/Images/ico main 50.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 835, 459);
		contentPane = new JPanel();
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
					
			}
		});
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     //dialog.dispose();
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 377, 459);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(signup.class.getResource("/Images/try.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 377, 459);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(85, 65, 118));
		panel_1.setBounds(376, 0, 460, 459);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
//**************************************************************CLOSE BUTTON**************************************************************************//
		JLabel label_1 = new JLabel("X");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				login.main(null);
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     dialog.dispose();
			}
		});
		
//********************************************************************************************************************************************//
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Black", Font.BOLD, 21));
		label_1.setBounds(410, 0, 49, 34);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("SignMeUp!");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Courier New", Font.BOLD, 30));
		label_2.setBounds(124, 42, 253, 56);
		panel_1.add(label_2);
		
		JLabel lblFullName = new JLabel("   Username");
		lblFullName.setIcon(new ImageIcon(signup.class.getResource("/Images/username 30.png")));
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblFullName.setBounds(49, 120, 129, 34);
		panel_1.add(lblFullName);
		
		txt_user = new JTextField();
		txt_user.setHorizontalAlignment(SwingConstants.CENTER);
		txt_user.setForeground(Color.WHITE);
		txt_user.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_user.setColumns(10);
		txt_user.setBackground(new Color(85, 65, 118));
		txt_user.setBounds(202, 122, 226, 34);
		panel_1.add(txt_user);
		
		JLabel label_4 = new JLabel("   Password");
		label_4.setIcon(new ImageIcon(signup.class.getResource("/Images/password 30.png")));
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_4.setBounds(49, 167, 129, 34);
		panel_1.add(label_4);
		
		txt_pass = new JPasswordField();
		txt_pass.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_pass.setHorizontalAlignment(SwingConstants.CENTER);
		txt_pass.setForeground(Color.WHITE);
		txt_pass.setBackground(new Color(85, 65, 118));
		txt_pass.setBounds(202, 167, 226, 34);
		panel_1.add(txt_pass);
		
		JLabel label_5 = new JLabel("   Email");
		label_5.setIcon(new ImageIcon(signup.class.getResource("/Images/email 30.png")));
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_5.setBounds(49, 307, 129, 34);
		panel_1.add(label_5);
		
		JLabel lblAddress = new JLabel("   City");
		lblAddress.setIcon(new ImageIcon(signup.class.getResource("/Images/address 30.png")));
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblAddress.setBounds(49, 257, 129, 34);
		panel_1.add(lblAddress);
		
		txt_city = new JTextField();
		txt_city.setHorizontalAlignment(SwingConstants.CENTER);
		txt_city.setForeground(Color.WHITE);
		txt_city.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_city.setColumns(10);
		txt_city.setBackground(new Color(85, 65, 118));
		txt_city.setBounds(202, 257, 226, 34);
		panel_1.add(txt_city);
		
		JLabel lblMobileNo = new JLabel("   Re-password");
		lblMobileNo.setIcon(new ImageIcon(signup.class.getResource("/Images/confirm 30.png")));
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblMobileNo.setBounds(49, 212, 154, 34);
		panel_1.add(lblMobileNo);
		
		txt_email = new JTextField();
		txt_email.setHorizontalAlignment(SwingConstants.CENTER);
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_email.setColumns(10);
		txt_email.setBackground(new Color(85, 65, 118));
		txt_email.setBounds(202, 307, 226, 34);
		panel_1.add(txt_email);
		
		txt_confirm = new JPasswordField();
		txt_confirm.setHorizontalAlignment(SwingConstants.CENTER);
		txt_confirm.setForeground(Color.WHITE);
		txt_confirm.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_confirm.setBackground(new Color(85, 65, 118));
		txt_confirm.setBounds(202, 212, 226, 34);
		panel_1.add(txt_confirm);
		
//******************************************************************REGISTER BUTTON**********************************************************//
		JLabel label_8 = new JLabel("Register");
		label_8.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
				
				if((txt_pass.getText().length() > 6 && txt_user.getText().length() > 2 && txt_email.getText().length() > 11)) {
					
					
					
					
					if (txt_pass.getText().equals(txt_confirm.getText())){
					
						
						Connection conn = null;
						String url = "jdbc:mysql://localhost:3306/";
						String dbName = "modagrospark";
						String driver = "com.mysql.cj.jdbc.Driver";
						String userName = "root";
						String password = "lagad@11";
						Class.forName(driver).newInstance();
						conn = DriverManager.getConnection(url+dbName,userName,password);
						//System.out.println("Connected to the database");
					
						PreparedStatement ps=conn.prepareStatement("insert into user_info (id, username, password, city, email) values(?,?,?,?,?)");
						Statement stmt = conn.createStatement();
						
						String sql = "SELECT MAX(id) from user_info";
						ResultSet rs = stmt.executeQuery(sql);
						int max_id = 0;
						while (rs.next()) {
							max_id = rs.getInt(1);
						}
						
						ps.setInt(1, (max_id + 1));
						ps.setString(2, txt_user.getText());
						ps.setString(3, txt_pass.getText());
						ps.setString(4, txt_city.getText());
						ps.setString(5, txt_email.getText());
					
						ps.executeUpdate();
						
						conn.close();
						
						JOptionPane.showMessageDialog(null,
								"Account created successfully..! Please Login");
						
						//*************OPEN DASHBOARD*************************************************//
						FirstWindow.main(new String[] {txt_user.getText()});
						
						Component component = (Component) e.getSource();
					     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
					     dialog.dispose();
						
					}else {
						txt_pass.setText(null);
						txt_confirm.setText(null);
						JOptionPane.showMessageDialog(null,
						"Password doesn't match..! Retype again");
					}
		
					
					
				}else {
					
					JOptionPane.showMessageDialog(null,
							"Enter all the parameters carefully..!\nPassword must contain at least 7 characters");
					
				}
				
				}catch(Exception e1) {
					

					JOptionPane.showMessageDialog(null,
							"Username or Email is already taken..!");
		
					
				}
				
			}
		});
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_8.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_8.setBounds(55, 376, 226, 34);
		panel_1.add(label_8);

//*******************************************************************CANCEL BUTTON************************************************************//
		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     dialog.dispose();
				
			}
		});
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblCancel.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblCancel.setBounds(299, 376, 129, 34);
		panel_1.add(lblCancel);
		
		
//**********************************************************************************************************************************************//
	}
}
