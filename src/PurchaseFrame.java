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
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;

public class PurchaseFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_quantity;
	private JTextField txt_merchant;
	
	static int x=0;
	static int posX=0;
	static int posY=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseFrame frame = new PurchaseFrame();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PurchaseFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PurchaseFrame.class.getResource("/Images/purchase 40 .png")));
		
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
		
		JLabel lblTypeOfProduct = new JLabel("  Type of Product :");
		lblTypeOfProduct.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\product type-40.png"));
		lblTypeOfProduct.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblTypeOfProduct.setForeground(Color.WHITE);
		lblTypeOfProduct.setBounds(216, 21, 187, 36);
		panel.add(lblTypeOfProduct);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fertilizers", "Pesticides", "Saplings", "Seeds"}));
		comboBox.setBackground(new Color(54, 33, 89));
		comboBox.setBorder(border4);
		comboBox.setBounds(226, 52, 281, 36);
		panel.add(comboBox);
		
		JLabel lblSelectProduct = new JLabel("  Select Product :");
		lblSelectProduct.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\product-40.png"));
		lblSelectProduct.setForeground(Color.WHITE);
		lblSelectProduct.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblSelectProduct.setBounds(549, 21, 187, 36);
		panel.add(lblSelectProduct);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Micronutrients", "Nitrogen fertilizers ", "Phosphate fertilizers", "Potassium fertilizers ", "Compound fertilizers", "Organic fertilizers", "Insecticides - insects", "Herbicides - plants", "Rodenticides - rodents (rats and mice)", "Bactericides - bacteria", "Fungicides - fungi", "Larvicides - larvae"}));
		comboBox_1.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		comboBox_1.setBackground(new Color(54, 33, 89));
		comboBox_1.setBorder(border4);
		comboBox_1.setBounds(559, 51, 281, 36);
		panel.add(comboBox_1);
		
		JLabel lblQuantity = new JLabel("  Quantity :");
		lblQuantity.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\quantity-40.png"));
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblQuantity.setBounds(216, 99, 187, 36);
		panel.add(lblQuantity);
		
		JLabel lblSelectMerchant = new JLabel("Enter Merchant : (E-mail)");
		lblSelectMerchant.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\merchant.png"));
		lblSelectMerchant.setForeground(Color.WHITE);
		lblSelectMerchant.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblSelectMerchant.setBounds(226, 176, 371, 36);
		panel.add(lblSelectMerchant);
		
		JLabel lblOrderDescription = new JLabel("Order Description :");
		lblOrderDescription.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\order description-40.png"));
		lblOrderDescription.setForeground(Color.WHITE);
		lblOrderDescription.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblOrderDescription.setBounds(223, 253, 169, 36);
		panel.add(lblOrderDescription);
		
		txt_quantity = new JTextField();
		txt_quantity.setHorizontalAlignment(SwingConstants.CENTER);
		txt_quantity.setForeground(Color.WHITE);
		txt_quantity.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_quantity.setColumns(10);
		txt_quantity.setBackground(new Color(54, 33, 89));
		txt_quantity.setBounds(226, 131, 614, 34);
		panel.add(txt_quantity);
		
		txt_merchant = new JTextField();
		txt_merchant.setHorizontalAlignment(SwingConstants.CENTER);
		txt_merchant.setForeground(Color.WHITE);
		txt_merchant.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_merchant.setColumns(10);
		txt_merchant.setBackground(new Color(54, 33, 89));
		txt_merchant.setBorder(border4);
		txt_merchant.setBounds(226, 208, 614, 34);
		panel.add(txt_merchant);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(374, 264, 466, 124);
		panel.add(scrollPane);
		
		JTextArea txt_description = new JTextArea();
		txt_description.setTabSize(0);
		scrollPane.setViewportView(txt_description);
		txt_description.setLineWrap(true);
		txt_description.setWrapStyleWord(true);
		txt_description.setForeground(new Color(255, 255, 255));
		txt_description.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_description.setBackground(new Color(54, 33, 89));
		txt_description.setBorder(border4);
		
		
//**************************************************************PURCHASE BUTTON***************************************************************//
		JLabel btn_purchase = new JLabel("Purchase");
		btn_purchase.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
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
				
				//********************************************SENDING MAIL********************************************************//
					
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("modagrospark@gmail.com")); // same email id
				message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(txt_merchant.getText()));// whome u have to send mails that person id
				message.setSubject("Product Purchase Order");
				message.setText("Dear Sir/Madam,\n"
				+ "Below Stated is a Product Quotation: \n"
				+"-------------------------- Quatation ----------------------------"
				+ "\nProduct type = "+comboBox.getSelectedItem()
				+ "\nProduct = "+comboBox_1.getSelectedItem() + "\nQuantity = "+ txt_quantity.getText()+"\nDescription :\n      "+txt_description.getText());
				
				Transport.send(message);
				
				JOptionPane.showMessageDialog(null,
				"Purchase order sent succesfully..!");
				
				//******************************************ADDING ORDER TO DATABASE************************************************//
				
				Connection conn = null;
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "modagrospark";
				String driver = "com.mysql.cj.jdbc.Driver";
				String userName = "root";
				String password2 = "lagad@11";
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,password2);
				//System.out.println("Connected to the database");
			
				PreparedStatement ps=conn.prepareStatement("insert into sales_purchase_orders (date, time, order_type, product_type, product_name, quantity, merchant, description) "
						+ "values(?,?,?,?,?,?,?,?)");
				
				java.util.Date current_date = Calendar.getInstance().getTime();
				DateFormat dateFormat2 = new SimpleDateFormat("hh:mm a");
				String now_time = dateFormat2.format(current_date);  //current time in string
				
				java.util.Date date=new java.util.Date();
				
				java.sql.Date sqlDate=new java.sql.Date(date.getTime());
				
				ps.setDate(1, sqlDate);
				ps.setString(2, now_time);
				ps.setString(3, "Purchase Order");
				ps.setString(4, (String) comboBox.getSelectedItem());
				ps.setString(5, (String) comboBox_1.getSelectedItem());
				ps.setString(6, txt_quantity.getText());
				ps.setString(7, txt_merchant.getText());
				ps.setString(8, txt_description.getText());
				
				ps.executeUpdate();
				
				conn.close();
				
				txt_quantity.setText(null);
				txt_description.setText(null);
				txt_merchant.setText(null);
				
				} catch (MessagingException e1) {
					JOptionPane.showMessageDialog(null,
							"Something went wrong..! Check your connections");
				}catch (SQLException e1) {
					
					System.out.println(e1);
				} catch (InstantiationException e1) {
					
					System.out.println(e1);
				} catch (IllegalAccessException e1) {
					
					System.out.println(e1);
				} catch (ClassNotFoundException e1) {
					System.out.println(e1);
				} 
				
			}
		});
		btn_purchase.setHorizontalAlignment(SwingConstants.CENTER);
		btn_purchase.setForeground(Color.WHITE);
		btn_purchase.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_purchase.setBounds(226, 419, 388, 42);
		btn_purchase.setBorder(border4);
		panel.add(btn_purchase);
		
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
		lblClose.setBounds(624, 419, 216, 42);
		lblClose.setBorder(border4);
		panel.add(lblClose);
		
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
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				posX=e.getX();
				posY=e.getY();
				
			}
		});
		panel_1.setBackground(new Color(110, 89, 222));
		panel_1.setBounds(0, 0, 1052, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMyProfile = new JLabel("Purchase Products");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(427, 0, 212, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PurchaseFrame.class.getResource("/Images/purchase 40 .png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(10, 11, 72, 37);
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
