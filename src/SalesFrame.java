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
import javax.swing.DefaultComboBoxModel;
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
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Toolkit;


public class SalesFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int x=0;
	static int posX=0;
	static int posY=0;
	
	private JPanel contentPane;
	private JTextField txt_quantity;
	private JTextField txt_merchant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesFrame frame = new SalesFrame();
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
	public SalesFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SalesFrame.class.getResource("/Images/sales 40.png")));
		
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
		
		JLabel lblTypeOfProduct = new JLabel("Type of Product :");
		lblTypeOfProduct.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\product type-40.png"));
		lblTypeOfProduct.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblTypeOfProduct.setForeground(Color.WHITE);
		lblTypeOfProduct.setBounds(203, 11, 187, 36);
		panel.add(lblTypeOfProduct);
		
		JComboBox<?> txt_producttype = new JComboBox<Object>();
		txt_producttype.setForeground(new Color(255, 255, 255));
		txt_producttype.setBackground(new Color(54, 33, 89));
		txt_producttype.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_producttype.setModel(new DefaultComboBoxModel(new String[] {"Grains", "Pulses", "Fruits", "Fruit vegetables", "Leafy vegetables", "Flowers"}));
		txt_producttype.setToolTipText("");
		txt_producttype.setBorder(border4);
		txt_producttype.setBounds(203, 46, 307, 36);
		panel.add(txt_producttype);
		
		JLabel lblSelectProduct = new JLabel("Select Product :");
		lblSelectProduct.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\used-product-40.png"));
		lblSelectProduct.setForeground(Color.WHITE);
		lblSelectProduct.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblSelectProduct.setBounds(534, 11, 187, 36);
		panel.add(lblSelectProduct);
		
		JComboBox<?> txt_product = new JComboBox<Object>();
		txt_product.setModel(new DefaultComboBoxModel(new String[] {"Jowar", "Bajra", "Wheat", "Barley", "Corn", "Rice", "Oats", "Millete", "Dry Beans", "Lentils", "Faba Beans", "Dry Peas", "Chickpeas", "Cowpeas", "Bambara Beans", "Pigeon Peas", "Lupins", "Vetches", "Red Grams", "White Grams", "Onions", "Batata", "Apple", "Banana", "Berry", "Cherry", "Coconut", "Chiku", "Guava", "Jackfruit", "Jambul", "Lemon", "Mango", "Orange", "Papaya", "Pear", "Pine-apple", "Custerd-apple", "Tamarind", "Avocado", "Bell pepper", "Pumpkin", "cucumber", "Sweet Corn", "Tinda", "Tomato", "Brinjal", "Ladyfinger", "Rocket", "Carrot", "Chard", "Kale", "Mustard seeds", "Cabbage", "Metha", "Flower", "Marigold", "Lily", "Jasmin", "Aster", "Jarbera", "Daisy", "Orchid", "Hibiscus", "Rose", "Lotus"}));
		txt_product.setForeground(new Color(255, 255, 255));
		txt_product.setBackground(new Color(54, 33, 89));
		txt_product.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		
		txt_product.setToolTipText("");
		txt_product.setBorder(border4);
		txt_product.setBounds(534, 46, 317, 36);
		panel.add(txt_product);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\quantity-40.png"));
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblQuantity.setBounds(203, 95, 187, 36);
		panel.add(lblQuantity);
		
		txt_quantity = new JTextField();
		txt_quantity.setHorizontalAlignment(SwingConstants.CENTER);
		txt_quantity.setForeground(new Color(255, 255, 255));
		txt_quantity.setBackground(new Color(54, 33, 89));
		txt_quantity.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_quantity.setBounds(203, 131, 648, 36);
		txt_quantity.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		panel.add(txt_quantity);
		txt_quantity.setColumns(10);
		
		JLabel lblProductDescription = new JLabel("Product Description :");
		lblProductDescription.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\description (2).png"));
		lblProductDescription.setForeground(Color.WHITE);
		lblProductDescription.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblProductDescription.setBounds(203, 262, 178, 36);
		panel.add(lblProductDescription);
		
		JLabel lblSelectMerchant = new JLabel("Enter Merchant : (E-mail)");
		lblSelectMerchant.setIcon(new ImageIcon("C:\\Users\\Rutik\\eclipse-workspace\\ModAgro\\Images\\merchant.png"));
		lblSelectMerchant.setForeground(Color.WHITE);
		lblSelectMerchant.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblSelectMerchant.setBounds(203, 180, 187, 36);
		panel.add(lblSelectMerchant);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 270, 471, 127);
		panel.add(scrollPane);
		
		
		txt_merchant = new JTextField();
		txt_merchant.setHorizontalAlignment(SwingConstants.CENTER);
		txt_merchant.setForeground(Color.WHITE);
		txt_merchant.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_merchant.setColumns(10);
		txt_merchant.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txt_merchant.setBackground(new Color(54, 33, 89));
		txt_merchant.setBounds(203, 215, 648, 36);
		panel.add(txt_merchant);
		
		
		JTextArea txt_descriptionbox = new JTextArea();
		txt_descriptionbox.setTabSize(0);
		scrollPane.setViewportView(txt_descriptionbox);
		txt_descriptionbox.setLineWrap(true);
		txt_descriptionbox.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_descriptionbox.setBackground(new Color(54,33,89));
		txt_descriptionbox.setForeground(new Color(255, 255, 255));
		txt_descriptionbox.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		
		JLabel lblSell = new JLabel("Send Sell Quatation");
		lblSell.addMouseListener(new MouseAdapter() {
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
				
				//*******************************SENDING MAIL********************************************************//	
				
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("modagrospark@gmail.com")); // same email id
				message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(txt_merchant.getText()));// whome u have to send mails that person id
				message.setSubject("Product Sales Quotation");
				message.setText("Dear Sir/Madam,\n"
				+ "Below Stated is a Product Quotation: \n"
				+"-------------------------- Quatation ----------------------------"
				+ "\nProduct type = "+txt_producttype.getSelectedItem()
				+ "\nProduct = "+txt_product.getSelectedItem() + "\nQuantity = "+ txt_quantity.getText()+"\nDescription :\n      "+txt_descriptionbox.getText());
				
				Transport.send(message);
				
				JOptionPane.showMessageDialog(null,
				"Sales order sent succesfully..!");
				
				//***********************************ADDING OREDR TO DATABASE***********************************************//
				
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
				DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy"); 
				DateFormat dateFormat2 = new SimpleDateFormat("hh:mm a");
				String date_now = dateFormat1.format(current_date);  // current date in string
				String now_time = dateFormat2.format(current_date);  //current time in string
				
				ps.setString(1, date_now);
				ps.setString(2, now_time);
				ps.setString(3, "Sales Order");
				ps.setString(4, (String) txt_producttype.getSelectedItem());
				ps.setString(5, (String) txt_product.getSelectedItem());
				ps.setString(6, txt_quantity.getText());
				ps.setString(7, txt_merchant.getText());
				ps.setString(8, txt_descriptionbox.getText());
				
				ps.executeUpdate();
				
				conn.close();
				
				txt_quantity.setText(null);
				txt_descriptionbox.setText(null);
				txt_merchant.setText(null);
				
				} catch (MessagingException e1) {
					JOptionPane.showMessageDialog(null,
							"Something went wrong..! Check your connections");
				} catch (SQLException e1) {
					
					
				} catch (InstantiationException e1) {
					
					
				} catch (IllegalAccessException e1) {
					
					
				} catch (ClassNotFoundException e1) {
					
				} 
				
			}
		});
		lblSell.setHorizontalAlignment(SwingConstants.CENTER);
		lblSell.setForeground(Color.WHITE);
		lblSell.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblSell.setBounds(203, 423, 402, 34);
		
		lblSell.setBorder(border4);
		panel.add(lblSell);
		
		JLabel lblCloses = new JLabel("Close");
		lblCloses.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
			}
		});
		lblCloses.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloses.setForeground(Color.WHITE);
		lblCloses.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblCloses.setBounds(615, 423, 236, 34);
		lblCloses.setBorder(border4);
		panel.add(lblCloses);
		
	
		
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
//****************************************************************************************************************************//		
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
		
//************************************************************************************************************************************//		
		panel_1.setBackground(new Color(110, 89, 222));
		panel_1.setBounds(0, 0, 1052, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMyProfile = new JLabel("Sell Products");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(428, 0, 211, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SalesFrame.class.getResource("/Images/sales 40.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(10, 0, 72, 48);
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
