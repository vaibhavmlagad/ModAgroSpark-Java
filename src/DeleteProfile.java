import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class DeleteProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user_txt;
	
	
	static int x=0;
	static int posX=0;
	static int posY=0;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	static String arg_uname;

	public static void main(String[] args) {
		
		arg_uname=args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteProfile frame = new DeleteProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}


	public DeleteProfile() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteProfile.class.getResource("/Images/delete me 40.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 50, 1052, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54, 33, 89));
		panel.setBounds(0, 58, 1052, 496);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setForeground(Color.WHITE);
		lblEnterUsername.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterUsername.setBackground(Color.WHITE);
		lblEnterUsername.setBounds(241, 110, 145, 14);
		panel.add(lblEnterUsername);
		
		user_txt = new JTextField(arg_uname);
		user_txt.setEditable(false);
		user_txt.setHorizontalAlignment(SwingConstants.CENTER);
		user_txt.setForeground(Color.WHITE);
		user_txt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		user_txt.setColumns(10);
		user_txt.setBackground(new Color(85, 65, 118));
		user_txt.setBounds(241, 135, 562, 34);
		panel.add(user_txt);
		
		JLabel lblEnterPassword = new JLabel("Password for "+arg_uname);
		lblEnterPassword.setForeground(Color.WHITE);
		lblEnterPassword.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterPassword.setBackground(Color.WHITE);
		lblEnterPassword.setBounds(241, 199, 247, 14);
		panel.add(lblEnterPassword);
		
		JLabel lblComfirmPaasword = new JLabel("Comfirm Paasword");
		lblComfirmPaasword.setForeground(Color.WHITE);
		lblComfirmPaasword.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblComfirmPaasword.setBackground(Color.WHITE);
		lblComfirmPaasword.setBounds(556, 199, 153, 14);
		panel.add(lblComfirmPaasword);
	
		
//*******************************************************DELETE PROFILE*************************************************************************//
		
		JLabel lblDeleteAccountPermentely = new JLabel("Delete Account Permentely");
		lblDeleteAccountPermentely.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					
					if (passwordField.getText().equals( passwordField_1.getText())) {
					
					Connection conn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url+dbName,userName,password);
					
					String myusn = user_txt.getText();
					String myname = passwordField.getText();
					
					String sql = "SELECT * from user_info where username =? and password =?";
					 PreparedStatement stmt = conn.prepareStatement(sql);
					 stmt.setString(1, myusn);
					 stmt.setString(2, myname);
					ResultSet rs = stmt.executeQuery();
					
						if(rs.next()) {
						
							String Query = "DELETE from user_info where username =? and password =?";
							PreparedStatement stmt1 = conn.prepareStatement(Query);
							stmt1.setString(1, myusn);
							stmt1.setString(2, myname);
							stmt1.executeUpdate();
							user_txt.setText(null);
							passwordField.setText(rs.getString(2));
							passwordField_1.setText(rs.getString(2));
							
							
							JOptionPane.showMessageDialog(null,
									"Account deleted successfully..!!");
							passwordField.setText(null);
							passwordField_1.setText(null);
						
							
							
							FirstWindow.closeLoadingWindow();
							
							login.main(null);  //go to login
							
							 Component component = (Component) e.getSource();
						     JFrame win = (JFrame) SwingUtilities.getRoot(component);
						     win.dispose();  //close this window
						}
						else {
							JOptionPane.showMessageDialog(null,
									"Password doesn't Matched...!!");
						}
						conn.close();
					
						}else {
					
						
						JOptionPane.showMessageDialog(null,
								"Password doesn't match..! Retry again");
						
					
					}
					}catch(Exception err) {
					
				}	
				
			}
		});
		
		lblDeleteAccountPermentely.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteAccountPermentely.setForeground(Color.WHITE);
		lblDeleteAccountPermentely.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblDeleteAccountPermentely.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblDeleteAccountPermentely.setBounds(241, 293, 351, 34);
		panel.add(lblDeleteAccountPermentely);
		
		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblCancel.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblCancel.setBounds(620, 293, 183, 34);
		panel.add(lblCancel);
		
		//*****************************************CANCLE**************************************************************//
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(new Color(85, 65, 118));
		passwordField.setBounds(241, 224, 226, 34);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setForeground(Color.WHITE);
		passwordField_1.setBackground(new Color(85, 65, 118));
		passwordField_1.setBounds(556, 224, 247, 34);
		panel.add(passwordField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(110, 89, 222));
		panel_2.setBounds(0, 0, 10, 496);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(110, 89, 222));
		panel_3.setBounds(1042, 0, 10, 496);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(110, 89, 222));
		panel_4.setBounds(0, 486, 1052, 10);
		panel.add(panel_4);
		
		JPanel panel_1 = new JPanel();
	
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/*Component e = null;*/
				posX=e.getX();
				posY=e.getY();
			}
		});
		
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     //dialog.dispose();
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});
		panel_1.setBackground(new Color(110, 89, 222));
		panel_1.setBounds(0, 0, 1052, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMyProfile = new JLabel("Delete Profile");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(428, 0, 211, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteProfile.class.getResource("/Images/delete me 40.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(10, 0, 60, 58);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("X");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Black", Font.BOLD, 21));
		label_1.setBounds(1017, 0, 35, 31);
		panel_1.add(label_1);
	}
}
