import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;


public class login extends JFrame {
	
	static int posX=0;
	static int posY=0;
	
	static int posX1=0;
	static int posY1=0;
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField user_txt;
	private JPasswordField pass_txt;
	int xMouse;
	int yMouse;
	

//***********************************************************MAIN METHOD******************************************************//
	
	public static void main(String[] args) {
		try {
			login dialog = new login();
			dialog.setUndecorated(true);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//*************************************************************FUNCTIONS**********************************************************//
	
	
	
	
//************************************************************DIALOG CREATION****************************************************//
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Images/ico main 50.png"));
		
		random_generator.main(null);
		setUndecorated(true);
		setBounds(250, 150, 756, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		contentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
			}
		});
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			Component component = (Component) e.getSource();
			JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
				
			}
		});
		
		Panel panel = new Panel();
		
//*******************************************************************************************************************************//		
	
//*********************************************************************************************************************************//		
		panel.setBackground(new Color(85, 65, 118));
		panel.setBounds(366, 0, 392, 395);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblGetmein = new JLabel("GetMeIn");
		lblGetmein.setForeground(new Color(255, 255, 255));
		lblGetmein.setFont(new Font("Courier New", Font.BOLD, 30));
		lblGetmein.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetmein.setBounds(125, 29, 154, 56);
		panel.add(lblGetmein);
		
		user_txt = new JTextField();
		user_txt.setForeground(new Color(255, 255, 255));
		user_txt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		user_txt.setHorizontalAlignment(SwingConstants.CENTER);
		user_txt.setBackground(new Color(85,65,118));
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		user_txt.setBorder(border);
		user_txt.setBounds(113, 109, 226, 34);
		panel.add(user_txt);
		user_txt.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(login.class.getResource("/Images/user.png")));
		Border border1 = BorderFactory.createLineBorder(Color.white, 1);
		label_1.setBorder(border1);
		label_1.setBounds(65, 109, 38, 34);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(login.class.getResource("/Images/pass.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		Border border2 = BorderFactory.createLineBorder(Color.white, 1);
		label_2.setBorder(border2);
		label_2.setBounds(65, 154, 38, 34);
		panel.add(label_2);
		Border border3 = BorderFactory.createLineBorder(Color.white, 1);
		label_1.setBorder(border3);

//************************************************************LOGIN BUTTON*****************************************************//
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		Border border4 = BorderFactory.createLineBorder(Color.white, 1);
		lblLogin.setBorder(border4);
		lblLogin.setBounds(65, 199, 274, 34);
		panel.add(lblLogin);
		
//**********************************************************CLOSE BUTTON********************************************************//		
		JLabel lblClose = new JLabel("Close!");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     dialog.dispose();
			}
		});
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		Border border5 = BorderFactory.createLineBorder(Color.white, 1);
		lblClose.setBorder(border5);
		lblClose.setBounds(206, 289, 133, 34);
		panel.add(lblClose);
		
//*********************************************************FORGET BUTTON*********************************************************//
		JLabel lblForget = new JLabel("Forget?");
		lblForget.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				ForgotPass.main(null);
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     dialog.dispose();
				
			}
		});
		lblForget.setHorizontalAlignment(SwingConstants.CENTER);
		lblForget.setForeground(Color.WHITE);
		lblForget.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		Border border6 = BorderFactory.createLineBorder(Color.white, 1);
		lblForget.setBorder(border6);
		lblForget.setBounds(65, 289, 133, 34);
		panel.add(lblForget);

//**********************************************************REGISTER BUTTON******************************************************//
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblRegister.setBorder(border6);
		lblRegister.setBounds(65, 244, 274, 34);
		panel.add(lblRegister);
		
		pass_txt = new JPasswordField();
		pass_txt.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		pass_txt.setHorizontalAlignment(SwingConstants.CENTER);
		pass_txt.setBackground(new Color(85, 65, 118));
		pass_txt.setForeground(Color.WHITE);
		pass_txt.setBorder(border6);
		pass_txt.setBounds(113, 154, 226, 34);
		panel.add(pass_txt);

//**********************************************************CLOSE BUTTON X********************************************************//
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     dialog.dispose();
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Arial Black", Font.BOLD, 21));
		lblX.setBounds(343, 0, 49, 34);
		panel.add(lblX);
		
//*********************************************************************************************************************************//

		JLabel logoVariable = new JLabel("");
		logoVariable.setHorizontalAlignment(SwingConstants.CENTER);
		logoVariable.setIcon(new ImageIcon(login.class.getResource("/Images/try.png")));
		logoVariable.setBounds(0, 0, 368, 395);
		contentPanel.add(logoVariable);
		
//*************************************************MOUSE EVENTS******************************************************************//
//*************************************************REGISTER BUTTON************************************************************//
		
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				signup.main(null);
				
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     dialog.dispose();
				
			}
		});
		
//**************************************************LOGIN BUTTON***************************************************************//
		
		lblLogin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
//				TODO change the database parameter here
				try {
					Connection conn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url+dbName,userName,password);
					
					String myusn = user_txt.getText();
					String myname = pass_txt.getText();
					
					String sql = "SELECT * from user_info where username =? and password =?";
					 PreparedStatement stmt = conn.prepareStatement(sql);
					 stmt.setString(1, myusn);
					 stmt.setString(2, myname);
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						user_txt.setText(null);
						pass_txt.setText(null);
						FirstWindow.main(new String[] {myusn});
						 Component component = (Component) e.getSource();
					     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
					     dialog.dispose();
						
						
					}else {
						user_txt.setText(null);
						pass_txt.setText(null);
						JOptionPane.showMessageDialog(null,
								"Invalid Credentials...!");
					}
			
					conn.close();
					
				}catch(Exception err) {
					  
					JOptionPane.showMessageDialog(null,
							"Something wents wrong, Try again later..!!");
					
				}
			}
		});
		
	}
}
