import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class ContactDealerFrame extends JFrame {

	static int x=0;
	static int posX=0;
	static int posY=0;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_to;
	private JTextField txt_subject;
	private JTextField txt_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactDealerFrame frame = new ContactDealerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactDealerFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ContactDealerFrame.class.getResource("/Images/contact.png")));
		
		Border border4 = BorderFactory.createLineBorder(Color.white, 1);
		
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
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setIcon(new ImageIcon(ContactDealerFrame.class.getResource("/Images/to 20.png")));
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblTo.setBackground(Color.WHITE);
		lblTo.setBounds(537, 28, 156, 30);
		panel.add(lblTo);
		
		JLabel lblSubject = new JLabel("Subject :");
		lblSubject.setIcon(new ImageIcon(ContactDealerFrame.class.getResource("/Images/subj 20.png")));
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblSubject.setBackground(Color.WHITE);
		lblSubject.setBounds(37, 103, 276, 30);
		panel.add(lblSubject);
		
		JLabel lblComposeMessage = new JLabel("Compose Message :");
		lblComposeMessage.setIcon(new ImageIcon(ContactDealerFrame.class.getResource("/Images/sms20.png")));
		lblComposeMessage.setForeground(Color.WHITE);
		lblComposeMessage.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblComposeMessage.setBackground(Color.WHITE);
		lblComposeMessage.setBounds(37, 176, 308, 34);
		panel.add(lblComposeMessage);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(27, 385, 46, 14);
		panel.add(label_4);
		
		txt_to = new JTextField();
		txt_to.setHorizontalAlignment(SwingConstants.CENTER);
		txt_to.setForeground(Color.WHITE);
		txt_to.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_to.setColumns(10);
		txt_to.setBackground(new Color(54, 33, 89));
		txt_to.setBorder(border4);
		txt_to.setBounds(536, 58, 478, 34);
		panel.add(txt_to);
		
		txt_subject = new JTextField();
		txt_subject.setHorizontalAlignment(SwingConstants.CENTER);
		txt_subject.setForeground(Color.WHITE);
		txt_subject.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_subject.setColumns(10);
		txt_subject.setBackground(new Color(54, 33, 89));
		txt_subject.setBorder(border4);
		txt_subject.setBounds(37, 131, 977, 34);
		panel.add(txt_subject);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 210, 977, 177);
		panel.add(scrollPane);
		
		JTextArea txt_message = new JTextArea();
		txt_message.setTabSize(0);
		scrollPane.setViewportView(txt_message);
		txt_message.setWrapStyleWord(true);
		txt_message.setLineWrap(true);
		txt_message.setForeground(Color.WHITE);
		txt_message.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_message.setBackground(new Color(54, 33, 89));
		txt_message.setBorder(border4);
		
		txt_name = new JTextField();
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setForeground(Color.WHITE);
		txt_name.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_name.setColumns(10);
		txt_name.setBackground(new Color(54, 33, 89));
		txt_name.setBorder(border4);
		txt_name.setBounds(37, 58, 456, 34);
		panel.add(txt_name);
		
		
//**********************************************************SEND BUTTON*************************************************************//
		JLabel btn_send = new JLabel("Send");
		btn_send.setIcon(null);
		btn_send.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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
				InternetAddress.parse(txt_to.getText()));// whome u have to send mails that person id
				message.setSubject(txt_subject.getText());
				message.setText("I am Mr./Miss. "+txt_name.getText()+",\n"+txt_message.getText());
				
				Transport.send(message);
				
					JOptionPane.showMessageDialog(null,
							"Your message has been send successfully..!");
					txt_name.setText(null);
					txt_to.setText(null);
					txt_subject.setText(null);
					txt_message.setText(null);

				} catch (MessagingException e1) {
					JOptionPane.showMessageDialog(null,
							"Something went wrong..! Check your connections");
					txt_name.setText(null);
					txt_to.setText(null);
					txt_subject.setText(null);
					txt_message.setText(null);
				}
				
			}
				
		});
		btn_send.setHorizontalAlignment(SwingConstants.CENTER);
		btn_send.setForeground(Color.WHITE);
		btn_send.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_send.setBorder(new LineBorder(new Color(255, 255, 255)));
		btn_send.setBounds(37, 426, 327, 34);
		panel.add(btn_send);

		
//*****************************************************CANCIL BUTTON****************************************************//
		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
				
			}
		});
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblCancel.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblCancel.setBounds(393, 426, 125, 34);
		panel.add(lblCancel);
		
		JLabel lblName = new JLabel("Your Name :");
		lblName.setIcon(new ImageIcon(ContactDealerFrame.class.getResource("/Images/to 20.png")));
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(38, 28, 432, 30);
		panel.add(lblName);
		
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
		
		JLabel lblMyProfile = new JLabel("Contact Dealer/Merchant");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(428, 0, 295, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ContactDealerFrame.class.getResource("/Images/email 30.png")));
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
		
		////////////////////////////////////////////////////EMAIL/////////////////////////////////
		
	
	}
}

