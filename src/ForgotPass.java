import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.Toolkit;

public class ForgotPass extends JFrame {
	
	
	
	static int x=0;
	static int posX=0;
	static int posY=0;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_email;
	int xMouse;
	int yMouse;
	private JPasswordField txt_pass;
	private JTextField txt_otp;
	private JPasswordField txt_confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ForgotPass dialog = new ForgotPass();
			dialog.setUndecorated(true);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the Frame.
	 */
	public ForgotPass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(signup.class.getResource("/Images/ico main 50.png")));
		setBounds(250, 150, 967, 473);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(85, 65, 118));
		panel.setBounds(412, 0, 561, 474);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblGetmein = new JLabel("Reset Password");
		lblGetmein.setForeground(new Color(255, 255, 255));
		lblGetmein.setFont(new Font("Courier New", Font.BOLD, 30));
		lblGetmein.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetmein.setBounds(131, 22, 304, 56);
		panel.add(lblGetmein);
		
		txt_email = new JTextField();
		txt_email.setForeground(new Color(255, 255, 255));
		txt_email.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_email.setHorizontalAlignment(SwingConstants.CENTER);
		txt_email.setBackground(new Color(85,65,118));
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		txt_email.setBorder(border);
		txt_email.setBounds(87, 141, 262, 34);
		panel.add(txt_email);
		txt_email.setColumns(10);
		
		
//*******************************************************CHANGE PASSWORD BUTTON******************************************//
		JLabel changepassword_button = new JLabel("Change Password");
		changepassword_button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(txt_pass.getText().equals(txt_confirm.getText()) && txt_pass.getText().length() > 6) {
					
					try {
						Connection conn = null;
						String url = "jdbc:mysql://localhost:3306/";
						String dbName = "modagrospark";
						String driver = "com.mysql.cj.jdbc.Driver";
						String userName = "root";
						String password = "lagad@11";
						Class.forName(driver).newInstance();
						conn = DriverManager.getConnection(url+dbName,userName,password);
						
						String sql = "SELECT otp from user_info where email =?";
						 PreparedStatement stmt = conn.prepareStatement(sql);
						 stmt.setString(1, txt_email.getText());
						 
						ResultSet rs = stmt.executeQuery();
						String otpp = null; 
						while(rs.next()) {
							otpp = rs.getString(1);
						}
						
						
						if(txt_otp.getText().equals(otpp)) {
							PreparedStatement ps=conn.prepareStatement("UPDATE user_info set password =? WHERE email =?");
							
							ps.setString(1, txt_pass.getText());
							ps.setString(2, txt_email.getText());
							
							ps.executeUpdate();
							
							conn.close();
							
							
							JOptionPane.showMessageDialog(null,
									"Account updated successfully..!");
							
						}else {
							
							JOptionPane.showMessageDialog(null,
									"OTP doesn't matched..!");
							txt_pass.setText(null);
							txt_confirm.setText(null);
							txt_email.setText(null);
							txt_otp.setText(null);
							
						}
						
			
					}catch(Exception e1) {
						//System.out.println(e1);
						JOptionPane.showMessageDialog(null,
								"Something wents wrong..! Try again later");
						txt_pass.setText(null);
						txt_confirm.setText(null);
						txt_email.setText(null);
						txt_otp.setText(null);
						
					}
				}else {
					
					JOptionPane.showMessageDialog(null,
							"Password doesn't matched..!\nPassword must contain at least 7 characters");
					txt_pass.setText(null);
					txt_confirm.setText(null);
					txt_email.setText(null);
					txt_otp.setText(null);
				}
			
				
			}
		});
		changepassword_button.setHorizontalAlignment(SwingConstants.CENTER);
		changepassword_button.setForeground(Color.WHITE);
		changepassword_button.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		changepassword_button.setBorder(new LineBorder(new Color(255, 255, 255)));
		changepassword_button.setBounds(87, 393, 195, 34);
		panel.add(changepassword_button);
		
		JLabel lblEmail = new JLabel("Repeat Password :");
//		lblEmail.setIcon(new ImageIcon(signup.class.getResource("/Images/email 30.png")));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEmail.setBounds(87, 263, 164, 34);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("New Password :");
//		lblPassword.setIcon(new ImageIcon(signup.class.getResource("/Images/password 30.png")));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblPassword.setBounds(87, 206, 129, 34);
		panel.add(lblPassword);
		
		JLabel lblFullName = new JLabel("Registered E-Mail  :");
//		lblFullName.setIcon(new ImageIcon(signup.class.getResource("/Images/full name.png")));
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblFullName.setBounds(87, 102, 195, 34);
		panel.add(lblFullName);
		
		txt_pass = new JPasswordField();
		txt_pass.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_pass.addKeyListener(new KeyAdapter() {
		@Override
			public void keyPressed(KeyEvent arg0) {
					}
		});
		txt_pass.setHorizontalAlignment(SwingConstants.CENTER);
		txt_pass.setForeground(Color.WHITE);
		txt_pass.setBackground(new Color(85, 65, 118));
		txt_pass.setBounds(264, 208, 226, 34);
		panel.add(txt_pass);
	
		
//*******************************************************CANCEL BUTTON*************************************************//
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
		cancel_button.setBounds(295, 393, 195, 34);
		panel.add(cancel_button);
		
		JLabel lblEnterOtp = new JLabel("Enter OTP :");
		lblEnterOtp.setForeground(Color.WHITE);
		lblEnterOtp.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEnterOtp.setBounds(87, 320, 164, 34);
		panel.add(lblEnterOtp);
		
		txt_otp = new JTextField();
		txt_otp.setHorizontalAlignment(SwingConstants.CENTER);
		txt_otp.setForeground(Color.WHITE);
		txt_otp.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_otp.setColumns(10);
		txt_otp.setBackground(new Color(85, 65, 118));
		txt_otp.setBounds(264, 322, 226, 34);
		panel.add(txt_otp);
		
//**********************************************************SEND OTP BUTTON**********************************************************//
		JLabel sendOTP_button = new JLabel("Send OTP");
		sendOTP_button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				Random num1 = new Random();
				int otp = num1.nextInt(864198)+123456;
				String otp_string = Integer.toString(otp);
				try {
					
					Connection conn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url+dbName,userName,password);
				
				
					PreparedStatement ps=conn.prepareStatement("UPDATE user_info set otp =? WHERE email =?");
					
					
				
					ps.setString(1, otp_string);
					ps.setString(2, txt_email.getText());
					
				
					ps.executeUpdate();
					
					conn.close();
					
					
			
				}catch(Exception e1) {
			
					JOptionPane.showMessageDialog(null,
							"Something wents wrong..! Try again later");
					
				}
				
				final String username = "modagrospark@gmail.com"; // enter your mail id
				final String password = "rsvo03143556";// enter ur password

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("modagrospark@gmail.com")); // same email id
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(txt_email.getText()));// whome u have to send mails that person id
					message.setSubject("One Time Password");
					message.setText("Dear User,"
						+ "\n\nYour One Time Password(OTP) is......\n\n                    ' "+ otp_string +" '\n\nNever share your One Time Password(OTP) with anyone"
						+"\nThank You");

					Transport.send(message);

					JOptionPane.showMessageDialog(null,
							"OTP send to "+ txt_email.getText() +" successfully..!");

				} catch (MessagingException e) {
					
					JOptionPane.showMessageDialog(null,
							"Something went wrong..! Please check connections");
					
				}
				
			}
		});
//*********************************************************************************************************************************//
		sendOTP_button.setHorizontalAlignment(SwingConstants.CENTER);
		sendOTP_button.setForeground(Color.WHITE);
		sendOTP_button.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		sendOTP_button.setBorder(new LineBorder(new Color(255, 255, 255)));
		sendOTP_button.setBounds(373, 140, 117, 34);
		panel.add(sendOTP_button);
		
		txt_confirm = new JPasswordField();
		txt_confirm.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_confirm.setHorizontalAlignment(SwingConstants.CENTER);
		txt_confirm.setForeground(Color.WHITE);
		txt_confirm.setBackground(new Color(85, 65, 118));
		txt_confirm.setBounds(263, 265, 226, 34);
		panel.add(txt_confirm);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Black", Font.BOLD, 21));
		label.setBounds(516, 0, 35, 31);
		panel.add(label);
//************************************************************************************************************************************//		

		JLabel logoVariable = new JLabel("");
		logoVariable.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				 Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     //dialog.dispose();
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
				
			}
		});
		
		
		logoVariable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				posX=e.getX();
				posY=e.getY();
			}
		});
//***************************************************************************************************************************************//		
		logoVariable.setHorizontalAlignment(SwingConstants.CENTER);
		logoVariable.setIcon(new ImageIcon(ForgotPass.class.getResource("/Images/try.png")));
		logoVariable.setBounds(0, 0, 416, 474);
		contentPanel.add(logoVariable);
	}
}
