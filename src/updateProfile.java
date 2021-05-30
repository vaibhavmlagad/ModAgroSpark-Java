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
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class updateProfile extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_city;
	private JTextField txt_state;
	private JTextField txt_email;
	private JTextField txt_mobile;
	private JTextField txt_locality;
	private JTextField txt_pin;

	static int x=0;
	static int posX=0;
	static int posY=0;
	static String arg_uname;
	
	
	public static void main(String[] args) {
		
		arg_uname=args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateProfile frame = new updateProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings("deprecation")
	public updateProfile() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(updateProfile.class.getResource("/Images/update me 40.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 50, 1052, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(54, 33, 89));
		panel.setBounds(0, 58, 1052, 522);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("Username :");
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblUserName.setBackground(Color.WHITE);
		lblUserName.setBounds(223, 42, 94, 24);
		panel.add(lblUserName);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(223, 88, 82, 14);
		panel.add(lblName);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblCity.setBackground(Color.WHITE);
		lblCity.setBounds(223, 158, 82, 14);
		panel.add(lblCity);
		
		JLabel lblLocation = new JLabel("Locatity :");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblLocation.setBackground(Color.WHITE);
		lblLocation.setBounds(577, 158, 94, 14);
		panel.add(lblLocation);
		
		JLabel lblState = new JLabel("State :");
		lblState.setForeground(Color.WHITE);
		lblState.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblState.setBackground(Color.WHITE);
		lblState.setBounds(223, 228, 50, 14);
		panel.add(lblState);
		
		JLabel lblPin = new JLabel("Pin Code :");
		lblPin.setForeground(Color.WHITE);
		lblPin.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblPin.setBackground(Color.WHITE);
		lblPin.setBounds(577, 228, 94, 14);
		panel.add(lblPin);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(223, 296, 64, 14);
		panel.add(lblEmail);
		
		JLabel lblMobileNo = new JLabel("Mobile No :");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblMobileNo.setBackground(Color.WHITE);
		lblMobileNo.setBounds(223, 366, 82, 14);
		panel.add(lblMobileNo);
		
		txt_name = new JTextField();
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setForeground(Color.WHITE);
		txt_name.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_name.setColumns(10);
		txt_name.setBackground(new Color(85, 65, 118));
		txt_name.setBounds(223, 113, 602, 34);
		panel.add(txt_name);
		
		txt_city = new JTextField();
		txt_city.setHorizontalAlignment(SwingConstants.CENTER);
		txt_city.setForeground(Color.WHITE);
		txt_city.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_city.setColumns(10);
		txt_city.setBackground(new Color(85, 65, 118));
		txt_city.setBounds(223, 183, 266, 34);
		panel.add(txt_city);
		
		txt_state = new JTextField();
		txt_state.setHorizontalAlignment(SwingConstants.CENTER);
		txt_state.setForeground(Color.WHITE);
		txt_state.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_state.setColumns(10);
		txt_state.setBackground(new Color(85, 65, 118));
		txt_state.setBounds(223, 253, 266, 34);
		panel.add(txt_state);
		
		txt_email = new JTextField();
		txt_email.setHorizontalAlignment(SwingConstants.CENTER);
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_email.setColumns(10);
		txt_email.setBackground(new Color(85, 65, 118));
		txt_email.setBounds(223, 321, 602, 34);
		panel.add(txt_email);
		
		txt_mobile = new JTextField();
		txt_mobile.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mobile.setForeground(Color.WHITE);
		txt_mobile.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_mobile.setColumns(10);
		txt_mobile.setBackground(new Color(85, 65, 118));
		txt_mobile.setBounds(223, 391, 266, 34);
		panel.add(txt_mobile);
		
		txt_locality = new JTextField();
		txt_locality.setHorizontalAlignment(SwingConstants.CENTER);
		txt_locality.setForeground(Color.WHITE);
		txt_locality.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_locality.setColumns(10);
		txt_locality.setBackground(new Color(85, 65, 118));
		txt_locality.setBounds(577, 183, 248, 34);
		panel.add(txt_locality);
		
		txt_pin = new JTextField();
		txt_pin.setHorizontalAlignment(SwingConstants.CENTER);
		txt_pin.setForeground(Color.WHITE);
		txt_pin.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_pin.setColumns(10);
		txt_pin.setBackground(new Color(85, 65, 118));
		txt_pin.setBounds(577, 253, 248, 34);
		panel.add(txt_pin);
		
//**************************************************UPDATE DATABASE BUTTON*******************************************************//
		
		JLabel update_button = new JLabel("Update Profile");
		update_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					
						Connection conn = null;
						String url = "jdbc:mysql://localhost:3306/";
						String dbName = "modagrospark";
						String driver = "com.mysql.cj.jdbc.Driver";
						String userName = "root";
						String password = "lagad@11";
						Class.forName(driver).newInstance();
						conn = DriverManager.getConnection(url+dbName,userName,password);
					
					
						PreparedStatement ps=conn.prepareStatement("UPDATE user_info set full_name =?, city =?, locality =?, state =?, pincode =?, email =?, mobile =? WHERE username =?");
						
						
					
						ps.setString(1, txt_name.getText());
						ps.setString(2, txt_city.getText());
						ps.setString(3, txt_locality.getText());
						ps.setString(4, txt_state.getText());
						ps.setString(5, txt_pin.getText());
						ps.setString(6, txt_email.getText());
						ps.setString(7, txt_mobile.getText());
						ps.setString(8, arg_uname);
					
						ps.executeUpdate();
						
						conn.close();
						
						
						JOptionPane.showMessageDialog(null,
								"Account updated successfully..!");
						
						txt_name.setText(null);
						txt_city.setText(null);
						txt_locality.setText(null);
						txt_state.setText(null);
						txt_pin.setText(null);
						txt_email.setText(null);
						txt_mobile.setText(null);
						
				
					}catch(Exception e1) {
						
						txt_email.setText(null);
						JOptionPane.showMessageDialog(null,
								"Something wents wrong..! Try again later");
						
					}
				
			}
		});
		
//***********************************************************************************************************************************//
		update_button.setBackground(new Color(85, 65, 118));
		update_button.setHorizontalAlignment(SwingConstants.CENTER);
		update_button.setForeground(Color.WHITE);
		update_button.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		update_button.setBorder(new LineBorder(new Color(255, 255, 255)));
		update_button.setBounds(223, 453, 349, 34);
		panel.add(update_button);
		
		JLabel cancel_button = new JLabel("Cancel");
		cancel_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
				
			}
		});
		cancel_button.setHorizontalAlignment(SwingConstants.CENTER);
		cancel_button.setForeground(Color.WHITE);
		cancel_button.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		cancel_button.setBorder(new LineBorder(new Color(255, 255, 255)));
		cancel_button.setBounds(601, 453, 224, 34);
		panel.add(cancel_button);

//*********************************************************************SHOW DATA FROM DATABASE******************************************************//
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
//*******************************************************************************************************************************//
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(110, 89, 222));
		panel_2.setBounds(0, 512, 1052, 10);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(110, 89, 222));
		panel_3.setBounds(0, 0, 10, 522);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(110, 89, 222));
		panel_4.setBounds(1042, 0, 10, 522);
		panel.add(panel_4);
		
		JLabel lbl_uname = new JLabel(arg_uname);
		lbl_uname.setForeground(Color.WHITE);
		lbl_uname.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 17));
		lbl_uname.setBackground(Color.WHITE);
		lbl_uname.setBounds(352, 42, 306, 24);
		panel.add(lbl_uname);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/*Component e1 = null;*/
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
		
		JLabel lblMyProfile = new JLabel("Update Profile");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(428, 0, 211, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(updateProfile.class.getResource("/Images/update me 40.png")));
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
