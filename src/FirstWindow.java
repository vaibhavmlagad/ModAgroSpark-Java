import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

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

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class FirstWindow {

	public static JFrame frmDashboard;
	private JLabel date_label;
	private JLabel time_label;
	
	static int milliseconds ;
	static int seconds ;
	static int minutes ;
	static int hours ;
	
	static String username;
	static String locality;
	static String city;
	static String state1;
	static String pincode;
	
	static String sensor_al_no;
	
	static boolean state = true;
	private JTextField txt_name;
	private JTextField txt_to;
	private JTextField txt_subject;

//************************************************************MAIN METHOD******************************************************//
	public static void main(String [] args) {
	//public static void main() {
		
		username=args[0];
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					FirstWindow window = new FirstWindow();
					window.frmDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//*************************************************************DATE METHOD*****************************************************************//
	
	public void clock()
	{
		Thread clock = new Thread() {
			public void run()
			{
				try {
					for(;;) {
					
					Calendar cal1 = new GregorianCalendar();
					
					cal1 = Calendar.getInstance();
					
					date_label.setText(" "+cal1.getTime().toString()+"|");
					
					sleep(1000);
					}
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
		clock.start();
		
	}
	
//***********************************************************TIMER METHOD********************************************************************//
	
	public void stopwatch() {
		
		state = true;
		
		Thread t = new Thread()
		{
			public void run() {
			
				for(;;) {
					if(state==true) {
						try {
							sleep(1);
							if(milliseconds>1000) {
								milliseconds=0;
								seconds++;
							}
							if(seconds>60) {
								milliseconds=0;
								seconds=0;
								minutes++;
							}
							if(minutes>1000) {
								milliseconds=0;
								seconds++;
								minutes=0;
								hours++;
							}
							
							
							time_label.setText(" "+hours+"hr: "+minutes+"min: "+seconds+"sec|");
							milliseconds++;
						}
						catch(Exception e) {
							
						}
					}
					else {
						break;
					}
				}
			}
			
		};
		t.start();
		
	}
	
//******************************************************CLOSE WINDOW BY FUNCTION*********************************************//
	 public static void closeLoadingWindow()
	  {
		 frmDashboard.dispose();
	  }
	

//**************************************************CONSTRUCTOR TO CALL INITIALIZE METHOD**************************************//
	public FirstWindow() {
		
		initialize();
		clock();
		stopwatch();
	}
	
//***********************************************************FUNCTIONS USED*****************************************************//
	
	void setcolor(Panel panel1) {
		panel1.setBackground(new Color(80, 65, 118));
	}
	
	void resetcolor(Panel panel1) {
		panel1.setBackground(new Color(54, 33, 89));
	}
	
	void showdash(Panel panel) {
		panel.setBounds(268, 166, 996, 516);
	}
	void hidedash(Panel panel) {
		panel.setBounds(0, 0, 0, 0);
	}
	
	
//***********************************************CREATION OF FRAME***********************************************************//
	@SuppressWarnings("deprecation")
	private void initialize() {
		
		
//**************************************RECEIVING DATA FROM DATABASE************************************************************//
		try {
//			TODO change the database parameter
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "modagrospark";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "lagad@11";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
		
			
			String sql = "SELECT locality, city, state, pincode from user_info where username =? ";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setString(1, username);
			 
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				locality = (rs.getString(1));
				city = (rs.getString(2));
				state1 = (rs.getString(3));
				pincode = (rs.getString(4));
				
			}
			
			
			Statement stmt2 = conn.createStatement();
			String sql2 = "SELECT COUNT(*) FROM sensor_alerts";
			ResultSet rs2 = stmt2.executeQuery(sql2);
			rs2.absolute(1);
			sensor_al_no = rs2.getString(1);
			
			conn.close();
		}catch(Exception err) {
			  
			locality = "Locality";
			city = "City";
			state1 = "State";
			pincode = "Pincode";
			
		}
		
		
		
		
		
		
		Color faint = new Color(80, 65, 118);     //faint violet colour
		//Color dark = new Color(54, 33, 89);     //faint violet colour
		
		
		frmDashboard = new JFrame();
		frmDashboard.getContentPane().setBackground(new Color(85, 65, 118));
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstWindow.class.getResource("/Images/ico main 50.png")));
		frmDashboard.setBounds(0, 0, 1280, 720);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.getContentPane().setLayout(null);
		
		Panel side_panel = new Panel();
		side_panel.setBackground(new Color(54, 33, 89));
		side_panel.setBounds(0, 0, 269, 692);
		frmDashboard.getContentPane().add(side_panel);
		side_panel.setLayout(null);
		
		JLabel lblModagrospark = new JLabel("ModAgroSpark");
		lblModagrospark.setForeground(new Color(255, 255, 255));
		lblModagrospark.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 50));
		lblModagrospark.setBounds(33, 56, 192, 58);
		side_panel.add(lblModagrospark);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/ico main 50.png")));
		label.setBounds(195, 32, 49, 44);
		side_panel.add(label);
		
		Panel side_panel_home = new Panel();
		side_panel_home.setBounds(0, 164, 269, 51);
		side_panel_home.setBackground(new Color(80,65,118));
		side_panel.add(side_panel_home);
		side_panel_home.setLayout(null);
		
		JLabel lblHome = new JLabel("    Home");
		lblHome.setBounds(37, 11, 129, 30);
		side_panel_home.add(lblHome);
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/home dark 30.png")));
		lblHome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblHome.setForeground(new Color(204, 204, 204));
		
		Panel side_panel_sales = new Panel();
		side_panel_sales.setLayout(null);
		side_panel_sales.setBounds(0, 221, 269, 51);
		side_panel.add(side_panel_sales);
		
		JLabel lblSalesPurchase = new JLabel("    Sales & Purchase");
		lblSalesPurchase.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/sales&purchse dark 30.png")));
		lblSalesPurchase.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalesPurchase.setForeground(new Color(204, 204, 204));
		lblSalesPurchase.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSalesPurchase.setBounds(37, 11, 207, 30);
		side_panel_sales.add(lblSalesPurchase);
		
		Panel side_panel_settings = new Panel();
		side_panel_settings.setLayout(null);
		side_panel_settings.setBounds(0, 278, 269, 51);
		side_panel.add(side_panel_settings);
		
		JLabel lblSettings = new JLabel("    Settings");
		lblSettings.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/setting dark 30.png")));
		lblSettings.setHorizontalAlignment(SwingConstants.LEFT);
		lblSettings.setForeground(new Color(204, 204, 204));
		lblSettings.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSettings.setBounds(37, 11, 130, 30);
		side_panel_settings.add(lblSettings);
		
		Panel side_panel_alert = new Panel();
		side_panel_alert.setLayout(null);
		side_panel_alert.setBounds(0, 335, 269, 51);
		side_panel.add(side_panel_alert);
		
		JLabel label_14 = new JLabel("23");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(new Color(0, 0, 102));
		label_14.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_14.setBackground(new Color(255, 255, 255));
		label_14.setBounds(235, 3, 30, 30);
		side_panel_alert.add(label_14);
		
		JLabel lblCheckAlerts = new JLabel("    Check Alerts");
		lblCheckAlerts.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/alert dark 30.png")));
		lblCheckAlerts.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckAlerts.setForeground(new Color(204, 204, 204));
		lblCheckAlerts.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCheckAlerts.setBounds(37, 11, 167, 30);
		side_panel_alert.add(lblCheckAlerts);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/green dot.png")));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_10.setBackground(new Color(0, 102, 0));
		label_10.setBounds(235, 3, 30, 30);
		side_panel_alert.add(label_10);
		
		Panel side_panel_profile = new Panel();
		side_panel_profile.setLayout(null);
		side_panel_profile.setBounds(0, 392, 269, 51);
		side_panel.add(side_panel_profile);
		
		JLabel lblProfile = new JLabel("    Profile");
		lblProfile.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/profile dark 30.png")));
		lblProfile.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfile.setForeground(new Color(204, 204, 204));
		lblProfile.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblProfile.setBounds(37, 11, 130, 30);
		side_panel_profile.add(lblProfile);
		
		Panel side_panel_contact = new Panel();
		side_panel_contact.setLayout(null);
		side_panel_contact.setBounds(0, 449, 269, 51);
		side_panel.add(side_panel_contact);
		
		JLabel lblContactUs = new JLabel("    Contact Us");
		lblContactUs.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/contact dark 30.png")));
		lblContactUs.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactUs.setForeground(new Color(204, 204, 204));
		lblContactUs.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblContactUs.setBounds(37, 11, 178, 30);
		side_panel_contact.add(lblContactUs);
		
		Panel bluestrip_panel = new Panel();
		bluestrip_panel.setBackground(new Color(110, 89, 222));
		bluestrip_panel.setBounds(267, 74, 997, 91);
		frmDashboard.getContentPane().add(bluestrip_panel);
		bluestrip_panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(649, 7, 19, 78);
		bluestrip_panel.add(separator);
		
		JLabel lblSalesPurchase_2 = new JLabel("Home  /  ...");
		lblSalesPurchase_2.setForeground(Color.WHITE);
		lblSalesPurchase_2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 23));
		lblSalesPurchase_2.setBounds(31, 22, 620, 47);
		bluestrip_panel.add(lblSalesPurchase_2);
		
		date_label = new JLabel("Date");
		date_label.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/calendar 20.png")));
		date_label.setHorizontalAlignment(SwingConstants.TRAILING);
		date_label.setForeground(Color.WHITE);
		date_label.setFont(new Font("Consolas", Font.PLAIN, 18));
		date_label.setBounds(661, 11, 326, 40);
		bluestrip_panel.add(date_label);
		
		time_label = new JLabel("Timer");
		time_label.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/timer 20.png")));
		time_label.setHorizontalAlignment(SwingConstants.TRAILING);
		time_label.setForeground(Color.WHITE);
		time_label.setFont(new Font("Consolas", Font.PLAIN, 18));
		time_label.setBounds(678, 44, 309, 36);
		bluestrip_panel.add(time_label);
		
		Panel usershow_panel = new Panel();
		usershow_panel.setBackground(new Color(54, 33, 89));
		usershow_panel.setBounds(781, 0, 483, 75);
		frmDashboard.getContentPane().add(usershow_panel);
		usershow_panel.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(23, 11, 40, 53);
		label_2.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/user 40.png")));
		usershow_panel.add(label_2);
		
		JLabel lblVaibhavLagad = new JLabel(username);
		lblVaibhavLagad.setForeground(Color.WHITE);
		lblVaibhavLagad.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 21));
		lblVaibhavLagad.setBounds(73, 11, 326, 36);
		usershow_panel.add(lblVaibhavLagad);
		
		JLabel lblGeneralUser = new JLabel("General User");
		lblGeneralUser.setForeground(Color.WHITE);
		lblGeneralUser.setFont(new Font("Consolas", Font.ITALIC, 13));
		lblGeneralUser.setBounds(73, 35, 316, 29);
		usershow_panel.add(lblGeneralUser);
		
		JLabel logout_button = new JLabel("");                                                                            //logout button
		logout_button.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/logout 40.png")));
		logout_button.setBounds(430, 11, 40, 36);
		usershow_panel.add(logout_button);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblLogout.setBounds(421, 48, 52, 16);
		usershow_panel.add(lblLogout);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(110, 89, 222));
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(417, 5, 12, 63);
		usershow_panel.add(separator_1);
		
//*********************************************************HOME DASHBOARD*******************************************************//
		
		Panel home_dashboard = new Panel();
		home_dashboard.setBackground(faint);
		home_dashboard.setBounds(268, 166, 996, 516);
		frmDashboard.getContentPane().add(home_dashboard);
		home_dashboard.setLayout(null);
		
		Panel forcasting_panel = new Panel();
		forcasting_panel.setLayout(null);
		forcasting_panel.setBackground(new Color(0,171,169));
		forcasting_panel.setBounds(601, 66, 306, 76);
		home_dashboard.add(forcasting_panel);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/forcast 40.png")));
		label_4.setBounds(10, 11, 40, 53);
		forcasting_panel.add(label_4);
		
		JLabel lblForecasting = new JLabel("Forecasting");
		lblForecasting.setForeground(Color.WHITE);
		lblForecasting.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblForecasting.setBounds(70, 11, 126, 53);
		forcasting_panel.add(lblForecasting);
		
		Panel field_panel = new Panel();
		field_panel.setBackground(new Color(204, 102, 255));
		field_panel.setBounds(126, 66, 306, 76);
		home_dashboard.add(field_panel);
		field_panel.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/monitor 40.png")));
		label_3.setBounds(10, 11, 40, 53);
		field_panel.add(label_3);
		
		JLabel lblFieldMonitor = new JLabel("Field Monitor");
		lblFieldMonitor.setForeground(new Color(255, 255, 255));
		lblFieldMonitor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblFieldMonitor.setBounds(70, 11, 126, 53);
		field_panel.add(lblFieldMonitor);
		
		Panel analysis_panel = new Panel();
		analysis_panel.setBackground(new Color(153, 153, 51));
		analysis_panel.setBounds(126, 214, 306, 76);
		home_dashboard.add(analysis_panel);
		analysis_panel.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/analy 40.png")));
		label_5.setBounds(10, 11, 40, 53);
		analysis_panel.add(label_5);
		
		JLabel lblAnalysis = new JLabel("Analysis");
		lblAnalysis.setForeground(Color.WHITE);
		lblAnalysis.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAnalysis.setBounds(70, 11, 126, 53);
		analysis_panel.add(lblAnalysis);
		
		Panel reports_panel = new Panel();
		reports_panel.setBackground(new Color(255, 102, 102));
		reports_panel.setBounds(601, 361, 306, 76);
		home_dashboard.add(reports_panel);
		reports_panel.setLayout(null);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/report 40.png")));
		label_8.setBounds(10, 11, 40, 53);
		reports_panel.add(label_8);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setForeground(Color.WHITE);
		lblReports.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblReports.setBounds(71, 11, 126, 53);
		reports_panel.add(lblReports);
		
		Panel news_panel = new Panel();
		news_panel.setLayout(null);
		news_panel.setBackground(new Color(204, 102, 51));
		news_panel.setBounds(125, 361, 306, 76);
		home_dashboard.add(news_panel);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/news 40.png")));
		label_7.setBounds(10, 11, 40, 53);
		news_panel.add(label_7);
		
		JLabel lblNews = new JLabel("News ");
		lblNews.setForeground(Color.WHITE);
		lblNews.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNews.setBounds(72, 11, 142, 53);
		news_panel.add(lblNews);
		
		Panel forum_panel = new Panel();
		forum_panel.setBackground(new Color(102, 153, 0));
		forum_panel.setBounds(602, 214, 306, 76);
		home_dashboard.add(forum_panel);
		forum_panel.setLayout(null);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/forum.png")));
		label_6.setBounds(10, 11, 40, 53);
		forum_panel.add(label_6);
		
		JLabel lblForum = new JLabel("Forum");
		lblForum.setForeground(Color.WHITE);
		lblForum.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblForum.setBounds(71, 11, 126, 53);
		forum_panel.add(lblForum);
 
//***************************************************SALES & PURCHASE DASHBOARD********************************************//
		Panel sales_dashboard = new Panel();
		sales_dashboard.setLayout(null);
		//sales_dashboard.setBounds(268, 166, 996, 516);
		sales_dashboard.setBackground(new Color(80, 65, 118));
		frmDashboard.getContentPane().add(sales_dashboard);
		
		
		
		Panel merchants_panel = new Panel();
		merchants_panel.setLayout(null);
		merchants_panel.setBackground(new Color(0, 171, 169));
		merchants_panel.setBounds(126, 214, 306, 76);
		sales_dashboard.add(merchants_panel);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/contact merchants 40.png")));
		label_9.setBounds(10, 11, 40, 53);
		merchants_panel.add(label_9);
		
		JLabel lblContactMerchants = new JLabel("Contact Dealer/Merchant");
		lblContactMerchants.setForeground(Color.WHITE);
		lblContactMerchants.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblContactMerchants.setBounds(70, 11, 236, 53);
		merchants_panel.add(lblContactMerchants);
		
		Panel purchase_panel = new Panel();
		purchase_panel.setLayout(null);
		purchase_panel.setBackground(new Color(204, 102, 51));
		purchase_panel.setBounds(601, 66, 306, 76);
		sales_dashboard.add(purchase_panel);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/purchase 40 .png")));
		label_17.setBounds(10, 11, 40, 53);
		purchase_panel.add(label_17);
		
		JLabel lblPurchase = new JLabel("Purchase");
		lblPurchase.setForeground(Color.WHITE);
		lblPurchase.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPurchase.setBounds(72, 11, 142, 53);
		purchase_panel.add(lblPurchase);
		
		Panel sales_panel = new Panel();
		sales_panel.setLayout(null);
		sales_panel.setBackground(new Color(102, 153, 0));
		sales_panel.setBounds(126, 66, 306, 76);
		sales_dashboard.add(sales_panel);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/sales 40.png")));
		label_19.setBounds(10, 11, 40, 53);
		sales_panel.add(label_19);
		
		JLabel lblSales = new JLabel("Sales");
		lblSales.setForeground(Color.WHITE);
		lblSales.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSales.setBounds(71, 11, 126, 53);
		sales_panel.add(lblSales);
		
//*******************************************************SETTING DASHBOARD*******************************************************//
		Panel setting_dashboard = new Panel();
		//setting_dashboard.setBounds(268, 166, 996, 516);
		frmDashboard.getContentPane().add(setting_dashboard);
		setting_dashboard.setLayout(null);
		setting_dashboard.setBackground(new Color(80, 65, 118));
		
		Panel fieldsetting_panel = new Panel();
		fieldsetting_panel.setLayout(null);
		fieldsetting_panel.setBackground(new Color(153, 153, 51));
		fieldsetting_panel.setBounds(126, 66, 306, 76);
		setting_dashboard.add(fieldsetting_panel);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/field seeting 40.png")));
		label_21.setBounds(10, 11, 40, 53);
		fieldsetting_panel.add(label_21);
		
		JLabel lblFieldSetting = new JLabel("Field setting");
		lblFieldSetting.setForeground(Color.WHITE);
		lblFieldSetting.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblFieldSetting.setBounds(70, 11, 126, 53);
		fieldsetting_panel.add(lblFieldSetting);
		
		Panel sensorsetting_panel = new Panel();
		sensorsetting_panel.setLayout(null);
		sensorsetting_panel.setBackground(new Color(255, 102, 102));
		sensorsetting_panel.setBounds(601, 66, 306, 76);
		setting_dashboard.add(sensorsetting_panel);
		
		JLabel label_23 = new JLabel("");
		label_23.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/sensor setting alert 40.png")));
		label_23.setBounds(10, 11, 40, 53);
		sensorsetting_panel.add(label_23);
		
		JLabel lblSensor = new JLabel("Sensor setting");
		lblSensor.setForeground(Color.WHITE);
		lblSensor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSensor.setBounds(71, 11, 126, 53);
		sensorsetting_panel.add(lblSensor);
		
//*****************************************************ALERT DASHBOARD********************************************************//
		Panel alert_dashboard = new Panel();
		//alert_dashboard.setBounds(268, 166, 996, 516);
		frmDashboard.getContentPane().add(alert_dashboard);
		alert_dashboard.setLayout(null);
		alert_dashboard.setBackground(new Color(80, 65, 118));
		
		
		Panel forumalert_panel = new Panel();
		forumalert_panel.setLayout(null);
		forumalert_panel.setBackground(new Color(0, 171, 169));
		forumalert_panel.setBounds(125, 214, 306, 76);
		alert_dashboard.add(forumalert_panel);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/news alert.png")));
		label_29.setBounds(10, 11, 40, 53);
		forumalert_panel.add(label_29);
		
		JLabel lblForumAlert = new JLabel("Forum/News alert");
		lblForumAlert.setForeground(Color.WHITE);
		lblForumAlert.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblForumAlert.setBounds(70, 11, 176, 53);
		forumalert_panel.add(lblForumAlert);
		
		JLabel forum_alert_no = new JLabel("12");
		forum_alert_no.setBounds(270, 0, 36, 22);
		forumalert_panel.add(forum_alert_no);
		forum_alert_no.setHorizontalAlignment(SwingConstants.CENTER);
		forum_alert_no.setForeground(Color.WHITE);
		forum_alert_no.setFont(new Font("Segoe UI", Font.BOLD, 16));
		forum_alert_no.setBackground(new Color(0, 102, 0));
		
		Panel sensoralert_panel = new Panel();
		sensoralert_panel.setLayout(null);
		sensoralert_panel.setBackground(new Color(255, 102, 102));
		sensoralert_panel.setBounds(125, 67, 306, 76);
		alert_dashboard.add(sensoralert_panel);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/sensor alert.png")));
		label_33.setBounds(10, 11, 40, 53);
		sensoralert_panel.add(label_33);
		
		JLabel lblSensorAlert = new JLabel("Sensor alert");
		lblSensorAlert.setForeground(Color.WHITE);
		lblSensorAlert.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSensorAlert.setBounds(71, 11, 126, 53);
		sensoralert_panel.add(lblSensorAlert);
		
		JLabel sensor_alert_no = new JLabel();
		sensor_alert_no.setText(sensor_al_no);
		sensor_alert_no.setBackground(new Color(0, 102, 0));
		sensor_alert_no.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sensor_alert_no.setForeground(new Color(255, 255, 255));
		sensor_alert_no.setHorizontalAlignment(SwingConstants.CENTER);
		sensor_alert_no.setBounds(270, 0, 36, 22);
		sensoralert_panel.add(sensor_alert_no);
		
		Panel salesalert_panel = new Panel();
		salesalert_panel.setLayout(null);
		salesalert_panel.setBackground(new Color(102, 153, 0));
		salesalert_panel.setBounds(601, 67, 306, 76);
		alert_dashboard.add(salesalert_panel);
		
		JLabel label_37 = new JLabel("");
		label_37.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/sales pur alert.png")));
		label_37.setBounds(10, 11, 40, 53);
		salesalert_panel.add(label_37);
		
		JLabel lblSalesPurchase_1 = new JLabel("Sales & Purchase alert");
		lblSalesPurchase_1.setForeground(Color.WHITE);
		lblSalesPurchase_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSalesPurchase_1.setBounds(71, 11, 214, 53);
		salesalert_panel.add(lblSalesPurchase_1);
		
		JLabel sales_alert_no = new JLabel("7");
		sales_alert_no.setHorizontalAlignment(SwingConstants.CENTER);
		sales_alert_no.setForeground(Color.WHITE);
		sales_alert_no.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sales_alert_no.setBackground(new Color(0, 102, 0));
		sales_alert_no.setBounds(270, 0, 36, 22);
		salesalert_panel.add(sales_alert_no);

//**************************************************************PROFILE DASHBOARD*************************************************//
		Panel profile_dashboard = new Panel();
		//profile_dashboard.setBounds(268, 166, 996, 516);
		frmDashboard.getContentPane().add(profile_dashboard);
		profile_dashboard.setLayout(null);
		profile_dashboard.setBackground(new Color(80, 65, 118));
		
		Panel myprofile_panel = new Panel();
		myprofile_panel.setLayout(null);
		myprofile_panel.setBackground(new Color(0, 171, 169));
		myprofile_panel.setBounds(126, 66, 306, 76);
		profile_dashboard.add(myprofile_panel);
		
		JLabel label_39 = new JLabel("");
		label_39.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/my profile 40.png")));
		label_39.setBounds(10, 11, 40, 53);
		myprofile_panel.add(label_39);
		
		JLabel lblMyProfile = new JLabel("My profile");
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblMyProfile.setBounds(70, 11, 126, 53);
		myprofile_panel.add(lblMyProfile);
		
		Panel backup_panel = new Panel();
		backup_panel.setLayout(null);
		backup_panel.setBackground(new Color(153, 153, 51));
		backup_panel.setBounds(601, 214, 306, 76);
		profile_dashboard.add(backup_panel);
		
		JLabel label_41 = new JLabel("");
		label_41.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/login Span.png")));
		label_41.setBounds(10, 11, 40, 53);
		backup_panel.add(label_41);
		
		JLabel lblBackup = new JLabel("User Access info");
		lblBackup.setForeground(Color.WHITE);
		lblBackup.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblBackup.setBounds(70, 11, 202, 53);
		backup_panel.add(lblBackup);
		
		Panel delete_panel = new Panel();
		delete_panel.setLayout(null);
		delete_panel.setBackground(new Color(204, 102, 51));
		delete_panel.setBounds(126, 214, 306, 76);
		profile_dashboard.add(delete_panel);
		
		JLabel label_45 = new JLabel("");
		label_45.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/delete me 40.png")));
		label_45.setBounds(10, 11, 40, 53);
		delete_panel.add(label_45);
		
		JLabel lblDeleteMe = new JLabel("Delete me");
		lblDeleteMe.setForeground(Color.WHITE);
		lblDeleteMe.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDeleteMe.setBounds(72, 11, 142, 53);
		delete_panel.add(lblDeleteMe);
		
		Panel update_panel = new Panel();
		update_panel.setLayout(null);
		update_panel.setBackground(new Color(102, 153, 0));
		update_panel.setBounds(601, 66, 306, 76);
		profile_dashboard.add(update_panel);
		
		JLabel label_47 = new JLabel("");
		label_47.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/update me 40.png")));
		label_47.setBounds(10, 11, 40, 53);
		update_panel.add(label_47);
		
		JLabel lblUpdateMe = new JLabel("Update me");
		lblUpdateMe.setForeground(Color.WHITE);
		lblUpdateMe.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUpdateMe.setBounds(71, 11, 126, 53);
		update_panel.add(lblUpdateMe);
		
//******************************************************************************CONTACT US DASHBOARD*****************************************************//
		Panel contact_dashboard = new Panel();
		//contact_dashboard.setBounds(268, 166, 996, 516);
		frmDashboard.getContentPane().add(contact_dashboard);
		contact_dashboard.setLayout(null);
		contact_dashboard.setBackground(new Color(80, 65, 118));
		
		JLabel label_11 = new JLabel("Your Name :");
		label_11.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/to 20.png")));
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_11.setBackground(Color.WHITE);
		label_11.setBounds(51, 32, 290, 30);
		contact_dashboard.add(label_11);
		
		txt_name = new JTextField();
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setForeground(Color.WHITE);
		txt_name.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_name.setColumns(10);
		txt_name.setBackground(new Color(80, 65, 118));
		txt_name.setBounds(50, 62, 394, 34);
		contact_dashboard.add(txt_name);
		
		JLabel label_12 = new JLabel("To :");
		label_12.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/to 20.png")));
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_12.setBackground(Color.WHITE);
		label_12.setBounds(550, 32, 156, 30);
		contact_dashboard.add(label_12);
		
		txt_to = new JTextField();
		txt_to.setText("modagrospark@gmail.com");
		txt_to.setHorizontalAlignment(SwingConstants.CENTER);
		txt_to.setForeground(Color.WHITE);
		txt_to.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_to.setEditable(false);
		txt_to.setColumns(10);
		txt_to.setBackground(new Color(80, 65, 118));
		txt_to.setBounds(549, 62, 394, 34);
		contact_dashboard.add(txt_to);
		
		JLabel label_13 = new JLabel("Query :");
		label_13.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/subj 20.png")));
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(50, 107, 276, 30);
		contact_dashboard.add(label_13);
		
		txt_subject = new JTextField();
		txt_subject.setHorizontalAlignment(SwingConstants.CENTER);
		txt_subject.setForeground(Color.WHITE);
		txt_subject.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_subject.setColumns(10);
		txt_subject.setBackground(new Color(80, 65, 118));
		txt_subject.setBounds(50, 135, 893, 34);
		contact_dashboard.add(txt_subject);
		
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 211, 893, 181);
		contact_dashboard.add(scrollPane);
		
		JTextArea txt_message = new JTextArea();
		txt_message.setForeground(new Color(255, 255, 255));
		txt_message.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_message.setLineWrap(true);
		scrollPane.setViewportView(txt_message);
		txt_message.setBackground(new Color(80, 65, 118));
		txt_message.setBorder(border);
		
		
		JLabel label_15 = new JLabel("Compose Message :");
		label_15.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/sms20.png")));
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_15.setBackground(Color.WHITE);
		label_15.setBounds(50, 180, 308, 34);
		contact_dashboard.add(label_15);
		
//**************************************************************SEND SMS BUTTON**********************************************************************//
		JLabel btn_send = new JLabel("Send");
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
							"Your Query has been send successfully..! Thank you");
					txt_name.setText(null);
				
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
		btn_send.setBounds(550, 433, 393, 34);
		contact_dashboard.add(btn_send);
		
		Panel locaton_panel = new Panel();
		locaton_panel.setBounds(270, 0, 513, 75);
		frmDashboard.getContentPane().add(locaton_panel);
		locaton_panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(23, 11, 50, 53);
		label_1.setIcon(new ImageIcon(FirstWindow.class.getResource("/Images/location 40.png")));
		locaton_panel.add(label_1);
		
		JLabel lblPuneMaharashtra = new JLabel();
		lblPuneMaharashtra.setText(locality+", "+city);
		lblPuneMaharashtra.setForeground(Color.WHITE);
		lblPuneMaharashtra.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 21));
		lblPuneMaharashtra.setBounds(69, 11, 416, 36);
		locaton_panel.add(lblPuneMaharashtra);
		
		JLabel lblPin = new JLabel("Maharashtra- 411001");
		lblPin.setText(state1+"- "+pincode);
		lblPin.setForeground(Color.WHITE);
		lblPin.setFont(new Font("Consolas", Font.ITALIC, 13));
		lblPin.setBounds(69, 35, 316, 29);
		locaton_panel.add(lblPin);
		
//***********************************************************************MOUSE EVENTS*********************************************************************//
		side_panel_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setcolor(side_panel_home);
				resetcolor(side_panel_sales);
				resetcolor(side_panel_settings);
				resetcolor(side_panel_profile);
				resetcolor(side_panel_alert);
				resetcolor(side_panel_contact);
				
				hidedash(sales_dashboard);
				hidedash(setting_dashboard);
				hidedash(alert_dashboard);
				hidedash(profile_dashboard);
				hidedash(contact_dashboard);
				showdash(home_dashboard);
				
				lblSalesPurchase_2.setText("Home  /  ...");
				
			}
		});
		side_panel_sales.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setcolor(side_panel_sales);
				resetcolor(side_panel_home);
				resetcolor(side_panel_settings);
				resetcolor(side_panel_profile);
				resetcolor(side_panel_alert);
				resetcolor(side_panel_contact);
				
				hidedash(home_dashboard);
				hidedash(setting_dashboard);
				hidedash(alert_dashboard);
				hidedash(profile_dashboard);
				hidedash(contact_dashboard);
				showdash(sales_dashboard);
				
				lblSalesPurchase_2.setText("Sales & Purchase  /  ...");
			}
		});
		side_panel_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setcolor(side_panel_settings);
				resetcolor(side_panel_home);
				resetcolor(side_panel_sales);
				resetcolor(side_panel_profile);
				resetcolor(side_panel_alert);
				resetcolor(side_panel_contact);
				
				hidedash(home_dashboard);
				hidedash(sales_dashboard);
				hidedash(alert_dashboard);
				hidedash(profile_dashboard);
				hidedash(contact_dashboard);
				showdash(setting_dashboard);
				
				lblSalesPurchase_2.setText("Settings  /  ...");
				
			}
		});
		side_panel_alert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setcolor(side_panel_alert);
				resetcolor(side_panel_home);
				resetcolor(side_panel_settings);
				resetcolor(side_panel_profile);
				resetcolor(side_panel_sales);
				resetcolor(side_panel_contact);
				
				hidedash(home_dashboard);
				hidedash(sales_dashboard);
				hidedash(setting_dashboard);
				hidedash(profile_dashboard);
				hidedash(contact_dashboard);
				showdash(alert_dashboard);
				
				lblSalesPurchase_2.setText("Check Alerts  /  ...");
			}
		});
		side_panel_profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setcolor(side_panel_profile);
				resetcolor(side_panel_home);
				resetcolor(side_panel_settings);
				resetcolor(side_panel_sales);
				resetcolor(side_panel_alert);
				resetcolor(side_panel_contact);		
				
				hidedash(home_dashboard);
				hidedash(sales_dashboard);
				hidedash(setting_dashboard);
				hidedash(alert_dashboard);
				hidedash(contact_dashboard);
				showdash(profile_dashboard);
				
				lblSalesPurchase_2.setText("Profile  /  ...");
			}
		});
		side_panel_contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setcolor(side_panel_contact);
				resetcolor(side_panel_home);
				resetcolor(side_panel_settings);
				resetcolor(side_panel_profile);
				resetcolor(side_panel_alert);
				resetcolor(side_panel_sales);	
				
				hidedash(home_dashboard);
				hidedash(sales_dashboard);
				hidedash(setting_dashboard);
				hidedash(alert_dashboard);
				hidedash(profile_dashboard);
				showdash(contact_dashboard);
				
				lblSalesPurchase_2.setText("Contact Us ");
			}
		});
		
		
//*****************************************************HOME PANEL MOUSE EVENTS***************************************************************************//
		
		field_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Home  /  Field Monitor");
				
				SensorGraph.main(null);
				
			}
		});
		
		
		forcasting_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Home  /  Forecasting");
				
				ForecastingWindow.main(null);
				
			}
		});
		
		
		analysis_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Home  /  Analysis");
				
				AnalysisWindow.main(null);
				
			}
		});
		
		
		forum_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Home  /  Forum");
				
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://modagrospark3.supportforum.co/"));
				}catch(IOException err) {
					
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		news_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Home  /  News");
				
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("http://epaper.agrowon.com/flashclient/client_panel.aspx#currPage=1/"));
				}catch(IOException err) {
					
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		reports_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Home  /  Reports");
				
				reportWindow.main(null);
				
			}
		});
		
//************************************************************SALES&PURCHASE PANEL MOUSE EVENTS**********************************************************//
		
		sales_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Sales & Purchase  /  Sales");
				SalesFrame.main(null);
			}
		});
		
		
		purchase_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Sales & Purchase  /  Purchase");
				PurchaseFrame.main(null);
				
			}
		});
		
		
		merchants_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Sales & Purchase  /  Contact Merchants");
				ContactDealerFrame.main(null);
				
			}
		});
		
//************************************************************SETTING PANEL MOUSE EVENTS**********************************************************//
		
		fieldsetting_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Settings  /  Field Setting");
				
				fieldsettingWindow.main(null);
				
			}
		});
		
		
		sensorsetting_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Settings  /  Sensor Setting");
				
				sensor_settingWindow.main(null);
				
			}
		});
		
//*************************************************************ALERT PANEL MOUSE EVENTS*******************************************************************//
		
		sensoralert_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Check Alerts  /  Sensor Alert");
				
				SensorAlerts.main(null);
			}
		});
		
		
		salesalert_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Check Alerts  /  Sales & Purchase Alert");
				
				saleAlerts.main(null);
			}
		});
		
		
		forumalert_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Check Alerts  /  Forum/News Alert");
				
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://modagrospark3.supportforum.co/news-827589/"));
				}catch(IOException err) {
					
				} catch (URISyntaxException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
//*************************************************************PROFILE PANEL MOUSE EVENTS***********************************************************//
		
		myprofile_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Profile  /  My Profile");
				myProfile.main(new String[] {username});
				
			}
		});
		
		
		update_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Profile  /  Update Me");
				updateProfile.main(new String[] {username});
				
			}
		});
		
		
		delete_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Profile  /  Delete Me");
				DeleteProfile.main(new String[] {username});
				
			}
		});
		
		
		backup_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				lblSalesPurchase_2.setText("Profile  /  User Access info");
				user_accessWindow.main(new String[] {username});
			}
		});
		
//***************************************************************CONTACT PANEL MOUSE EVENTS***********************************************************//
		
		
//***********************************************************LOGOUT BUTTON CODE***********************************************************************//
		
		logout_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				java.util.Date current_date = Calendar.getInstance().getTime();
				DateFormat dateFormat1 = new SimpleDateFormat("dd MMMMM, yyyy"); 
				DateFormat dateFormat2 = new SimpleDateFormat("hh:mm a");
				String date_now_str = dateFormat1.format(current_date);  // current date in string
				String now_time_str = dateFormat2.format(current_date);  //current time in string
				
				String labltime = time_label.getText();
				String timesta = labltime.substring(0, labltime.length() - 1);
				
				try{
					
					Connection conn5 = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn5 = DriverManager.getConnection(url+dbName,userName,password);
				
					PreparedStatement ps=conn5.prepareStatement("insert into user_access_info (username, date, access_period, logout_time) values(?,?,?,?)");
				
					ps.setString(1, username);
					ps.setString(2, date_now_str);
					ps.setString(3, timesta);
					ps.setString(4, now_time_str);
				
					ps.executeUpdate();
					
					conn5.close();
					
					login.main(null);
					
					 Component component = (Component) e.getSource();
				     JFrame win = (JFrame) SwingUtilities.getRoot(component);
				     win.dispose();
					
				}catch(Exception err) {
					JOptionPane.showMessageDialog(null,
							"Error Occured..! Can't LogOut Now..!");
				}
				
				
			}
		});
	}
}
