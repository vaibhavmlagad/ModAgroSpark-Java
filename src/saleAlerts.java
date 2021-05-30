import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Panel;
import java.awt.Toolkit;

public class saleAlerts extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	static int x=0;
	static int posX=0;
	static int posY=0;
	
	Connection conn5 = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saleAlerts frame = new saleAlerts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings("deprecation")
	public saleAlerts() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(saleAlerts.class.getResource("/Images/alert 50.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1052, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Component component = (Component) e.getSource();
			     JFrame dialog = (JFrame) SwingUtilities.getRoot(component);
			     //dialog.dispose();
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});
		panel.setLayout(null);
		panel.setBackground(new Color(110, 89, 222));
		panel.setBounds(0, 0, 1052, 59);
		contentPane.add(panel);
		
		JLabel lblSensorAlerts = new JLabel("Sales & Purchase Alerts");
		lblSensorAlerts.setHorizontalAlignment(SwingConstants.CENTER);
		lblSensorAlerts.setForeground(Color.WHITE);
		lblSensorAlerts.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblSensorAlerts.setBounds(346, 0, 326, 58);
		panel.add(lblSensorAlerts);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(saleAlerts.class.getResource("/Images/alert 50.png")));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(10, 6, 60, 47);
		panel.add(label_1);
		
//**************************************************************CLOSE BUTTON**************************************************************************//
		JLabel label_2 = new JLabel("X");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
				
			}
		});
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial Black", Font.BOLD, 21));
		label_2.setBounds(1017, 0, 35, 31);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.GREEN);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(54, 33, 89));
		panel_1.setBounds(0, 58, 1052, 496);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(110, 89, 222));
		panel_2.setBounds(0, 486, 1052, 10);
		panel_1.add(panel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(80, 65, 118));
		panel_3.setBounds(26, 60, 996, 51);
		panel_1.add(panel_3);
		
		JLabel txt_date1 = new JLabel();
		txt_date1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date1.setForeground(Color.WHITE);
		txt_date1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date1.setBounds(20, 11, 126, 29);
		panel_3.add(txt_date1);
		
		JLabel txt_time1 = new JLabel();
		txt_time1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time1.setForeground(new Color(255, 255, 255));
		txt_time1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time1.setBounds(180, 11, 103, 29);
		panel_3.add(txt_time1);
		
		JLabel txt_type1 = new JLabel();
		txt_type1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type1.setForeground(Color.GREEN);
		txt_type1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type1.setBounds(363, 11, 200, 29);
		panel_3.add(txt_type1);
		
		JLabel txt_sta1 = new JLabel();
		txt_sta1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_sta1.setForeground(Color.RED);
		txt_sta1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_sta1.setBounds(619, 11, 187, 29);
		panel_3.add(txt_sta1);
		
		JLabel delete_btn1 = new JLabel();
		delete_btn1.setText("X");
		delete_btn1.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn1.setForeground(Color.WHITE);
		delete_btn1.setFont(new Font("Arial Black", Font.BOLD, 18));
		delete_btn1.setBorder(null);
		//delete_btn1.setBounds(910, 11, 76, 29);
		delete_btn1.setBounds(0,0,0,0);
		panel_3.add(delete_btn1);
		
		//**************************************************************************************************************//
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(110, 89, 222));
		panel_8.setBounds(0, 0, 10, 496);
		panel_1.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(110, 89, 222));
		panel_9.setBounds(1042, 0, 10, 496);
		panel_1.add(panel_9);
		
		JLabel lblDate = new JLabel();
		lblDate.setText("Status");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblDate.setBounds(714, 22, 72, 26);
		panel_1.add(lblDate);
		
		JLabel lblParameter = new JLabel();
		lblParameter.setText("Date");
		lblParameter.setHorizontalAlignment(SwingConstants.LEFT);
		lblParameter.setForeground(Color.WHITE);
		lblParameter.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblParameter.setBounds(76, 22, 85, 26);
		panel_1.add(lblParameter);
		
		JLabel lblValue = new JLabel();
		lblValue.setText("Time");
		lblValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblValue.setForeground(Color.WHITE);
		lblValue.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblValue.setBounds(240, 22, 72, 26);
		panel_1.add(lblValue);
		
		JLabel lblStatus = new JLabel();
		lblStatus.setText("Type");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblStatus.setBounds(463, 22, 72, 26);
		panel_1.add(lblStatus);
		
		JLabel lblDelete = new JLabel();
		lblDelete.setText("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.LEFT);
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblDelete.setBounds(950, 22, 72, 26);
		panel_1.add(lblDelete);
		
		Panel panel_4 = new Panel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(80, 65, 118));
		panel_4.setBounds(26, 133, 996, 51);
		panel_1.add(panel_4);
		
		JLabel txt_date2 = new JLabel();
		txt_date2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date2.setForeground(Color.WHITE);
		txt_date2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date2.setBounds(20, 11, 126, 29);
		panel_4.add(txt_date2);
		
		JLabel txt_time2 = new JLabel();
		txt_time2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time2.setForeground(new Color(255, 255, 255));
		txt_time2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time2.setBounds(180, 11, 103, 29);
		panel_4.add(txt_time2);
		
		JLabel txt_type2 = new JLabel();
		txt_type2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type2.setForeground(Color.GREEN);
		txt_type2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type2.setBounds(359, 11, 204, 29);
		panel_4.add(txt_type2);
		
		JLabel txt_sta2 = new JLabel();
		txt_sta2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_sta2.setForeground(Color.RED);
		txt_sta2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_sta2.setBounds(620, 11, 186, 29);
		panel_4.add(txt_sta2);
		
		JLabel delete_btn2 = new JLabel("X");
		delete_btn2.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn2.setForeground(Color.WHITE);
		delete_btn2.setFont(new Font("Arial Black", Font.BOLD, 18));
		delete_btn2.setBorder(null);
		//delete_btn2.setBounds(910, 11, 76, 29);
		delete_btn2.setBounds(0,0,0,0);
		panel_4.add(delete_btn2);
		
		Panel panel_5 = new Panel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(80, 65, 118));
		panel_5.setBounds(26, 208, 996, 51);
		panel_1.add(panel_5);
		
		JLabel txt_date3 = new JLabel();
		txt_date3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date3.setForeground(Color.WHITE);
		txt_date3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date3.setBounds(20, 11, 126, 29);
		panel_5.add(txt_date3);
		
		JLabel txt_time3 = new JLabel();
		txt_time3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time3.setForeground(new Color(255, 255, 255));
		txt_time3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time3.setBounds(180, 11, 103, 29);
		panel_5.add(txt_time3);
		
		JLabel txt_type3 = new JLabel();
		txt_type3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type3.setForeground(Color.GREEN);
		txt_type3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type3.setBounds(360, 11, 203, 29);
		panel_5.add(txt_type3);
		
		JLabel txt_sta3 = new JLabel();
		txt_sta3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_sta3.setForeground(Color.RED);
		txt_sta3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_sta3.setBounds(621, 11, 185, 29);
		panel_5.add(txt_sta3);
		
		JLabel delete_btn3 = new JLabel("X");
		delete_btn3.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn3.setForeground(Color.WHITE);
		delete_btn3.setFont(new Font("Arial Black", Font.BOLD, 18));
		delete_btn3.setBorder(null);
		//delete_btn3.setBounds(910, 11, 76, 29);
		delete_btn3.setBounds(0,0,0,0);
		panel_5.add(delete_btn3);
		
		Panel panel_6 = new Panel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(80, 65, 118));
		panel_6.setBounds(26, 282, 996, 51);
		panel_1.add(panel_6);
		
		JLabel txt_date4 = new JLabel();
		txt_date4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date4.setForeground(Color.WHITE);
		txt_date4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date4.setBounds(20, 11, 126, 29);
		panel_6.add(txt_date4);
		
		JLabel txt_time4 = new JLabel();
		txt_time4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time4.setForeground(new Color(255, 255, 255));
		txt_time4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time4.setBounds(180, 11, 103, 29);
		panel_6.add(txt_time4);
		
		JLabel txt_type4 = new JLabel();
		txt_type4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type4.setForeground(Color.GREEN);
		txt_type4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type4.setBounds(358, 11, 205, 29);
		panel_6.add(txt_type4);
		
		JLabel txt_sta4 = new JLabel();
		txt_sta4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_sta4.setForeground(Color.RED);
		txt_sta4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_sta4.setBounds(623, 11, 183, 29);
		panel_6.add(txt_sta4);
		
		JLabel delete_btn4 = new JLabel("X");
		delete_btn4.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn4.setForeground(Color.WHITE);
		delete_btn4.setFont(new Font("Arial Black", Font.BOLD, 18));
		delete_btn4.setBorder(null);
		//delete_btn4.setBounds(910, 11, 76, 29);
		delete_btn4.setBounds(0,0,0,0);
		panel_6.add(delete_btn4);
		
		Panel panel_7 = new Panel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(80, 65, 118));
		panel_7.setBounds(26, 355, 996, 51);
		panel_1.add(panel_7);
		
		JLabel txt_date5 = new JLabel();
		txt_date5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date5.setForeground(Color.WHITE);
		txt_date5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date5.setBounds(20, 11, 126, 29);
		panel_7.add(txt_date5);
		
		JLabel txt_time5 = new JLabel();
		txt_time5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time5.setForeground(new Color(255, 255, 255));
		txt_time5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time5.setBounds(180, 11, 103, 29);
		panel_7.add(txt_time5);
		
		JLabel txt_type5 = new JLabel();
		txt_type5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type5.setForeground(Color.GREEN);
		txt_type5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type5.setBounds(357, 11, 206, 29);
		panel_7.add(txt_type5);
		
		JLabel txt_sta5 = new JLabel();
		txt_sta5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_sta5.setForeground(Color.RED);
		txt_sta5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_sta5.setBounds(625, 11, 181, 29);
		panel_7.add(txt_sta5);
		
		JLabel delete_btn5 = new JLabel("X");
		delete_btn5.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn5.setForeground(Color.WHITE);
		delete_btn5.setFont(new Font("Arial Black", Font.BOLD, 18));
		delete_btn5.setBorder(null);
		//delete_btn5.setBounds(910, 11, 76, 29);
		delete_btn5.setBounds(0,0,0,0);
		panel_7.add(delete_btn5);
		
		JLabel label_29 = new JLabel("Close");
		label_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
			}
		});
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_29.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_29.setBounds(802, 430, 220, 34);
		panel_1.add(label_29);
		
		
//*************************************************RECIEVING DATA FROM TABLE**********************************************************//
		
		try {
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "modagrospark";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "lagad@11";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT date, time, order_type FROM sales_purchase_orders "
					+ "WHERE date < (DATE(NOW()) - INTERVAL 3 DAY) ORDER BY id DESC LIMIT 5";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sf.format(new Date());
			Date curr_date = sf.parse(date);
			
			//*******************************************************************************************************//
			rs.absolute(1);
			txt_date1.setText(rs.getString(1));
			txt_time1.setText(rs.getString(2));
			txt_type1.setText(rs.getString(3));
			Date db_date1 = sf.parse(rs.getString(1));
			
			int diffInDays1 = (int) ((curr_date.getTime() - db_date1.getTime()) / (1000 * 60 * 60 * 24));
			
			if(diffInDays1>3 && diffInDays1<=5) {
				txt_sta1.setText("Under Scrutiny");
			}else if(diffInDays1==6) {
				txt_sta1.setText("Confirmed");
			}else if(diffInDays1>6 && diffInDays1<=8) {
				txt_sta1.setText("Dispatched");
			}else if(diffInDays1>8) {
				txt_sta1.setText("Rejected");
				delete_btn1.setBounds(910, 11, 76, 29);
			}
			
			//**********************************************************************************************************//
			rs.absolute(2);
			txt_date2.setText(rs.getString(1));
			txt_time2.setText(rs.getString(2));
			txt_type2.setText(rs.getString(3));
			Date db_date2 = sf.parse(rs.getString(1));
			
			int diffInDays2 = (int) ((curr_date.getTime() - db_date2.getTime()) / (1000 * 60 * 60 * 24));
			
			if(diffInDays2>3 && diffInDays2<=5) {
				txt_sta2.setText("Under Scrutiny");
			}else if(diffInDays2==6) {
				txt_sta2.setText("Confirmed");
			}else if(diffInDays2>6 && diffInDays2<=8) {
				txt_sta2.setText("Dispatched");
			}else if(diffInDays2>8) {
				txt_sta2.setText("Rejected");
				delete_btn2.setBounds(910, 11, 76, 29);
			}
			
			//**********************************************************************************************************//
			rs.absolute(3);
			txt_date3.setText(rs.getString(1));
			txt_time3.setText(rs.getString(2));
			txt_type3.setText(rs.getString(3));
			Date db_date3 = sf.parse(rs.getString(1));
			
			int diffInDays3 = (int) ((curr_date.getTime() - db_date3.getTime()) / (1000 * 60 * 60 * 24));
			
			if(diffInDays3>3 && diffInDays3<=5) {
				txt_sta3.setText("Under Scrutiny");
			}else if(diffInDays3==6) {
				txt_sta3.setText("Confirmed");
			}else if(diffInDays3>6 && diffInDays3<=8) {
				txt_sta3.setText("Dispatched");
			}else if(diffInDays3>8) {
				txt_sta3.setText("Rejected");
				delete_btn3.setBounds(910, 11, 76, 29);
			}
			
			//***********************************************************************************************************//
			rs.absolute(4);
			txt_date4.setText(rs.getString(1));
			txt_time4.setText(rs.getString(2));
			txt_type4.setText(rs.getString(3));
			Date db_date4 = sf.parse(rs.getString(1));
			
			int diffInDays4 = (int) ((curr_date.getTime() - db_date4.getTime()) / (1000 * 60 * 60 * 24));
			
			if(diffInDays4>3 && diffInDays4<=5) {
				txt_sta4.setText("Under Scrutiny");
			}else if(diffInDays4==6) {
				txt_sta4.setText("Confirmed");
			}else if(diffInDays4>6 && diffInDays4<=8) {
				txt_sta4.setText("Dispatched");
			}else if(diffInDays4>8) {
				txt_sta4.setText("Rejected");
				delete_btn4.setBounds(910, 11, 76, 29);
			}
			
			//**********************************************************************************************************//
			rs.absolute(5);
			txt_date5.setText(rs.getString(1));
			txt_time5.setText(rs.getString(2));
			txt_type5.setText(rs.getString(3));
			Date db_date5 = sf.parse(rs.getString(1));
			
			int diffInDays5 = (int) ((curr_date.getTime() - db_date5.getTime()) / (1000 * 60 * 60 * 24));
			
			if(diffInDays5>3 && diffInDays5<=5) {
				txt_sta5.setText("Under Scrutiny");
			}else if(diffInDays5==6) {
				txt_sta5.setText("Confirmed");
			}else if(diffInDays5>6 && diffInDays5<=8) {
				txt_sta5.setText("Dispatched");
			}else if(diffInDays5>8) {
				txt_sta5.setText("Rejected");
				delete_btn5.setBounds(910, 11, 76, 29);
			}
			
			conn.close();
		
			
		}catch(Exception e1) {
			//System.out.println(e1);
		}
		
//****************************************************************************************************************************//
		
//*************************************************DELETE ACTIONS*****************************************************************//
		
		delete_btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			try {	
				
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "modagrospark";
				String driver = "com.mysql.cj.jdbc.Driver";
				String userName = "root";
				String password = "lagad@11";
				Class.forName(driver).newInstance();
				conn5 = DriverManager.getConnection(url+dbName,userName,password);
				
				String Query = "DELETE from sales_purchase_orders where date =? and time =? and order_type =?";
				PreparedStatement stmt1 = conn5.prepareStatement(Query);
				stmt1.setString(1, txt_date1.getText());
				stmt1.setString(2, txt_time1.getText());
				stmt1.setString(3, txt_type1.getText());
				stmt1.executeUpdate();
				
				txt_date1.setText(null);
				txt_time1.setText(null);
				txt_type1.setText(null);
				txt_sta1.setText(null);
	
				
				delete_btn1.setBounds(0,0,0,0);
				
				conn5.close();
			}catch(Exception e1){
				
	
			}
			}
		});
		
		delete_btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {	
					
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn5 = DriverManager.getConnection(url+dbName,userName,password);
					
					String Query = "DELETE from sales_purchase_orders where date =? and time =? and order_type =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_date2.getText());
					stmt1.setString(2, txt_time2.getText());
					stmt1.setString(3, txt_type2.getText());
					stmt1.executeUpdate();
					
					txt_date2.setText(null);
					txt_time2.setText(null);
					txt_type2.setText(null);
					txt_sta2.setText(null);
					
					delete_btn2.setBounds(0,0,0,0);
					
					conn5.close();
				}catch(Exception e1){
					
		
				}
				
			}
		});
		
		delete_btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {	
					
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn5 = DriverManager.getConnection(url+dbName,userName,password);
					
					String Query = "DELETE from sales_purchase_orders where date =? and time =? and order_type =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_date3.getText());
					stmt1.setString(2, txt_time3.getText());
					stmt1.setString(3, txt_type3.getText());
					stmt1.executeUpdate();
					
					txt_date3.setText(null);
					txt_time3.setText(null);
					txt_type3.setText(null);
					txt_sta3.setText(null);
					
					delete_btn3.setBounds(0,0,0,0);
					
					conn5.close();
				}catch(Exception e1){
					
		
				}
				
			}
		});
		
		delete_btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {	
					
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn5 = DriverManager.getConnection(url+dbName,userName,password);
					
					String Query = "DELETE from sales_purchase_orders where date =? and time =? and order_type =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_date4.getText());
					stmt1.setString(2, txt_time4.getText());
					stmt1.setString(3, txt_type4.getText());
					stmt1.executeUpdate();
					
					txt_date4.setText(null);
					txt_time4.setText(null);
					txt_type4.setText(null);
					txt_sta4.setText(null);
					
					delete_btn4.setBounds(0,0,0,0);
					
					conn5.close();
				}catch(Exception e1){
					
		
				}
				
			}
		});
		
		delete_btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {	
					
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn5 = DriverManager.getConnection(url+dbName,userName,password);
					
					String Query = "DELETE from sales_purchase_orders where date =? and time =? and order_type =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_date5.getText());
					stmt1.setString(2, txt_time5.getText());
					stmt1.setString(3, txt_type5.getText());
					stmt1.executeUpdate();
					
					txt_date5.setText(null);
					txt_time5.setText(null);
					txt_type5.setText(null);
					txt_sta5.setText(null);
					
					delete_btn5.setBounds(0,0,0,0);
					
					conn5.close();
				}catch(Exception e1){
					//System.out.println(e1);
		
				}
				
			}
		});
	
		
//******************************************************************************************************************************//
		
	}
}
