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
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;

public class myProfile extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int x=0;
	static int posX=0;
	static int posY=0;
	static String arg_uname;

	private JPanel contentPane;

	public static void main(String[] args) {
		
		arg_uname=args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myProfile frame = new myProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings("deprecation")
	public myProfile() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(myProfile.class.getResource("/Images/contact dealers 40.png")));
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
		
		

		
		JLabel lblName = new JLabel("Name :");
		lblName.setIcon(new ImageIcon("C:\\Users\\Siddharth\\eclipse-workspace\\try\\Images\\name.png"));
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblName.setBounds(154, 136, 121, 34);
		panel.add(lblName);
		
		JLabel txt_name = new JLabel("");
		txt_name.setForeground(Color.WHITE);
		txt_name.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_name.setBounds(285, 136, 581, 34);
		panel.add(txt_name);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setIcon(new ImageIcon("C:\\Users\\Siddharth\\eclipse-workspace\\try\\Images\\city.png"));
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblCity.setBounds(154, 181, 121, 34);
		panel.add(lblCity);
		
		JLabel txt_city = new JLabel("");
		txt_city.setForeground(Color.WHITE);
		txt_city.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_city.setBounds(285, 181, 248, 34);
		panel.add(txt_city);
		
		JLabel lblLocation = new JLabel("Locality :");
		lblLocation.setIcon(new ImageIcon(myProfile.class.getResource("/Images/location 40.png")));
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblLocation.setBounds(543, 181, 142, 34);
		panel.add(lblLocation);
		
		JLabel txt_locality = new JLabel("");
		txt_locality.setForeground(Color.WHITE);
		txt_locality.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_locality.setBounds(727, 181, 249, 34);
		panel.add(txt_locality);
		
		JLabel lblState = new JLabel("State :");
		lblState.setIcon(new ImageIcon("C:\\Users\\Siddharth\\eclipse-workspace\\try\\Images\\state.png"));
		lblState.setForeground(Color.WHITE);
		lblState.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblState.setBounds(154, 226, 121, 34);
		panel.add(lblState);
		
		JLabel txt_state = new JLabel("");
		txt_state.setForeground(Color.WHITE);
		txt_state.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_state.setBounds(285, 226, 248, 34);
		panel.add(txt_state);
		
		JLabel lblPinCode = new JLabel("Pin Code :");
		lblPinCode.setIcon(new ImageIcon("C:\\Users\\Siddharth\\eclipse-workspace\\try\\Images\\pincode.png"));
		lblPinCode.setForeground(Color.WHITE);
		lblPinCode.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPinCode.setBounds(543, 226, 123, 34);
		panel.add(lblPinCode);
		
		JLabel txt_pin = new JLabel("");
		txt_pin.setForeground(Color.WHITE);
		txt_pin.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_pin.setBounds(727, 226, 249, 34);
		panel.add(txt_pin);
		
		JLabel lblEmail = new JLabel("E-Mail :");
		lblEmail.setIcon(new ImageIcon(myProfile.class.getResource("/Images/email 30.png")));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblEmail.setBounds(154, 271, 103, 34);
		panel.add(lblEmail);
		
		JLabel txt_email = new JLabel("");
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_email.setBounds(285, 271, 603, 34);
		panel.add(txt_email);
		
		JLabel lblMobileNo = new JLabel("Mobile No :");
		lblMobileNo.setIcon(new ImageIcon(myProfile.class.getResource("/Images/mobile 30.png")));
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblMobileNo.setBounds(154, 316, 142, 34);
		panel.add(lblMobileNo);
		
		JLabel txt_mobile = new JLabel("");
		txt_mobile.setForeground(Color.WHITE);
		txt_mobile.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_mobile.setBounds(285, 316, 249, 34);
		panel.add(txt_mobile);

		
//**************************************************************CLOSE BUTTON*******************************************************************//
		JLabel lblClose = new JLabel("Close");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
				
			}
		});
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblClose.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblClose.setBounds(715, 316, 173, 34);
		panel.add(lblClose);
				
				JLabel label_2 = new JLabel("Username :");
				label_2.setForeground(Color.WHITE);
				label_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
				label_2.setBounds(154, 91, 121, 34);
				panel.add(label_2);
				
				JLabel lbl_uname = new JLabel(arg_uname);
				lbl_uname.setForeground(Color.WHITE);
				lbl_uname.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 17));
				lbl_uname.setBounds(285, 91, 326, 34);
				panel.add(lbl_uname);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(110, 89, 222));
				panel_2.setBounds(0, 486, 1052, 10);
				panel.add(panel_2);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBackground(new Color(110, 89, 222));
				panel_3.setBounds(0, 0, 10, 496);
				panel.add(panel_3);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBackground(new Color(110, 89, 222));
				panel_4.setBounds(1042, 0, 10, 496);
				panel.add(panel_4);
		
//********************************************************************************************************************************************************//		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     //dialog.dispose();
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});
//*******************************************************************************************************************************************************//		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				posX=e.getX();
				posY=e.getY();
			}
		});
//*******************************************************************************************************************************************************//		
		panel_1.setBackground(new Color(110, 89, 222));
		panel_1.setBounds(0, 0, 1052, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(428, 0, 211, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(myProfile.class.getResource("/Images/my profile 40.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(10, 11, 60, 34);
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
		
//**************************************REVCIEVING DATA FROM DATABASE*************************************************************//
		try {
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "modagrospark";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "lagad@11";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			String sql = "SELECT * from user_info where username =?";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setString(1, arg_uname);
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				txt_name.setText(rs.getString(4));
				txt_city.setText(rs.getString(5));
				txt_locality.setText(rs.getString(6));
				txt_state.setText(rs.getString(7));
				txt_pin.setText(rs.getString(8));
				txt_email.setText(rs.getString(9));
				txt_mobile.setText(rs.getString(10));
			
				
			}
			
	
			conn.close();
		}catch(Exception err) {
			  
			JOptionPane.showMessageDialog(null,
					"Something wents wrong, Try again later..!!");
			
		}
		
		
	}
}
