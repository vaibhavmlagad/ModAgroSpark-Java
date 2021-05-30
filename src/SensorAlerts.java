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
import java.awt.Panel;
import java.awt.Toolkit;

public class SensorAlerts extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	static int x=0;
	static int posX=0;
	static int posY=0;
	
	Connection conn5 = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorAlerts frame = new SensorAlerts();
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
	@SuppressWarnings("deprecation")
	public SensorAlerts() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SensorAlerts.class.getResource("/Images/alert 50.png")));
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
		
		JLabel lblSensorAlerts = new JLabel("Sensor Alerts");
		lblSensorAlerts.setHorizontalAlignment(SwingConstants.CENTER);
		lblSensorAlerts.setForeground(Color.WHITE);
		lblSensorAlerts.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblSensorAlerts.setBounds(428, 0, 211, 58);
		panel.add(lblSensorAlerts);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SensorAlerts.class.getResource("/Images/alert 50.png")));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(12, 6, 60, 47);
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
		
		JLabel txt_param1 = new JLabel();
		txt_param1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_param1.setForeground(Color.WHITE);
		txt_param1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_param1.setBounds(20, 11, 126, 29);
		panel_3.add(txt_param1);
		
		JLabel txt_value1 = new JLabel();
		txt_value1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_value1.setForeground(Color.GREEN);
		txt_value1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_value1.setBounds(180, 11, 103, 29);
		panel_3.add(txt_value1);
		
		JLabel txt_status1 = new JLabel();
		txt_status1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_status1.setForeground(Color.RED);
		txt_status1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_status1.setBounds(325, 11, 126, 29);
		panel_3.add(txt_status1);
		
		JLabel txt_date1 = new JLabel();
		txt_date1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date1.setForeground(Color.WHITE);
		txt_date1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date1.setBounds(513, 11, 126, 29);
		panel_3.add(txt_date1);
		
		JLabel txt_time1 = new JLabel();
		txt_time1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time1.setForeground(Color.WHITE);
		txt_time1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time1.setBounds(705, 11, 126, 29);
		panel_3.add(txt_time1);
		
		JLabel delete_btn1 = new JLabel();
		delete_btn1.setText("Delete");
		delete_btn1.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn1.setForeground(Color.WHITE);
		delete_btn1.setFont(new Font("Bookman Old Style", Font.ITALIC, 14));
		delete_btn1.setBorder(new LineBorder(new Color(255, 255, 255)));
		delete_btn1.setBounds(910, 11, 76, 29);
		panel_3.add(delete_btn1);
		
		JLabel lblDate = new JLabel();
		lblDate.setText("Date");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblDate.setBounds(580, 22, 72, 26);
		panel_1.add(lblDate);
		
		JLabel lblTime = new JLabel();
		lblTime.setText("Time");
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblTime.setBounds(772, 22, 54, 26);
		panel_1.add(lblTime);
		
		JLabel lblParameter = new JLabel();
		lblParameter.setText("Parameter");
		lblParameter.setHorizontalAlignment(SwingConstants.LEFT);
		lblParameter.setForeground(Color.WHITE);
		lblParameter.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblParameter.setBounds(69, 22, 85, 26);
		panel_1.add(lblParameter);
		
		JLabel lblValue = new JLabel();
		lblValue.setText("Value");
		lblValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblValue.setForeground(Color.WHITE);
		lblValue.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblValue.setBounds(240, 22, 72, 26);
		panel_1.add(lblValue);
		
		JLabel lblStatus = new JLabel();
		lblStatus.setText("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblStatus.setBounds(382, 22, 72, 26);
		panel_1.add(lblStatus);
		
		Panel panel_4 = new Panel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(80, 65, 118));
		panel_4.setBounds(26, 133, 996, 51);
		panel_1.add(panel_4);
		
		JLabel txt_param2 = new JLabel();
		txt_param2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_param2.setForeground(Color.WHITE);
		txt_param2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_param2.setBounds(20, 11, 126, 29);
		panel_4.add(txt_param2);
		
		JLabel txt_value2 = new JLabel();
		txt_value2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_value2.setForeground(Color.GREEN);
		txt_value2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_value2.setBounds(180, 11, 103, 29);
		panel_4.add(txt_value2);
		
		JLabel txt_status2 = new JLabel();
		txt_status2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_status2.setForeground(Color.RED);
		txt_status2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_status2.setBounds(325, 11, 126, 29);
		panel_4.add(txt_status2);
		
		JLabel txt_date2 = new JLabel();
		txt_date2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date2.setForeground(Color.WHITE);
		txt_date2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date2.setBounds(513, 11, 126, 29);
		panel_4.add(txt_date2);
		
		JLabel txt_time2 = new JLabel();
		txt_time2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time2.setForeground(Color.WHITE);
		txt_time2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time2.setBounds(705, 11, 126, 29);
		panel_4.add(txt_time2);
		
		JLabel delete_btn2 = new JLabel("Delete");
		delete_btn2.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn2.setForeground(Color.WHITE);
		delete_btn2.setFont(new Font("Bookman Old Style", Font.ITALIC, 14));
		delete_btn2.setBorder(new LineBorder(new Color(255, 255, 255)));
		delete_btn2.setBounds(910, 11, 76, 29);
		panel_4.add(delete_btn2);
		
		Panel panel_5 = new Panel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(80, 65, 118));
		panel_5.setBounds(26, 208, 996, 51);
		panel_1.add(panel_5);
		
		JLabel txt_param3 = new JLabel();
		txt_param3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_param3.setForeground(Color.WHITE);
		txt_param3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_param3.setBounds(20, 11, 126, 29);
		panel_5.add(txt_param3);
		
		JLabel txt_value3 = new JLabel();
		txt_value3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_value3.setForeground(Color.GREEN);
		txt_value3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_value3.setBounds(180, 11, 103, 29);
		panel_5.add(txt_value3);
		
		JLabel txt_status3 = new JLabel();
		txt_status3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_status3.setForeground(Color.RED);
		txt_status3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_status3.setBounds(325, 11, 126, 29);
		panel_5.add(txt_status3);
		
		JLabel txt_date3 = new JLabel();
		txt_date3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date3.setForeground(Color.WHITE);
		txt_date3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date3.setBounds(513, 11, 126, 29);
		panel_5.add(txt_date3);
		
		JLabel txt_time3 = new JLabel();
		txt_time3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time3.setForeground(Color.WHITE);
		txt_time3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time3.setBounds(705, 11, 126, 29);
		panel_5.add(txt_time3);
		
		JLabel delete_btn3 = new JLabel("Delete");
		delete_btn3.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn3.setForeground(Color.WHITE);
		delete_btn3.setFont(new Font("Bookman Old Style", Font.ITALIC, 14));
		delete_btn3.setBorder(new LineBorder(new Color(255, 255, 255)));
		delete_btn3.setBounds(910, 11, 76, 29);
		panel_5.add(delete_btn3);
		
		Panel panel_6 = new Panel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(80, 65, 118));
		panel_6.setBounds(26, 282, 996, 51);
		panel_1.add(panel_6);
		
		JLabel txt_param4 = new JLabel();
		txt_param4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_param4.setForeground(Color.WHITE);
		txt_param4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_param4.setBounds(20, 11, 126, 29);
		panel_6.add(txt_param4);
		
		JLabel txt_value4 = new JLabel();
		txt_value4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_value4.setForeground(Color.GREEN);
		txt_value4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_value4.setBounds(180, 11, 103, 29);
		panel_6.add(txt_value4);
		
		JLabel txt_status4 = new JLabel();
		txt_status4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_status4.setForeground(Color.RED);
		txt_status4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_status4.setBounds(325, 11, 126, 29);
		panel_6.add(txt_status4);
		
		JLabel txt_date4 = new JLabel();
		txt_date4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date4.setForeground(Color.WHITE);
		txt_date4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date4.setBounds(513, 11, 126, 29);
		panel_6.add(txt_date4);
		
		JLabel txt_time4 = new JLabel();
		txt_time4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time4.setForeground(Color.WHITE);
		txt_time4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time4.setBounds(705, 11, 126, 29);
		panel_6.add(txt_time4);
		
		JLabel delete_btn4 = new JLabel("Delete");
		delete_btn4.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn4.setForeground(Color.WHITE);
		delete_btn4.setFont(new Font("Bookman Old Style", Font.ITALIC, 14));
		delete_btn4.setBorder(new LineBorder(new Color(255, 255, 255)));
		delete_btn4.setBounds(910, 11, 76, 29);
		panel_6.add(delete_btn4);
		
		Panel panel_7 = new Panel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(80, 65, 118));
		panel_7.setBounds(26, 355, 996, 51);
		panel_1.add(panel_7);
		
		JLabel txt_param5 = new JLabel();
		txt_param5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_param5.setForeground(Color.WHITE);
		txt_param5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_param5.setBounds(20, 11, 126, 29);
		panel_7.add(txt_param5);
		
		JLabel txt_value5 = new JLabel();
		txt_value5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_value5.setForeground(Color.GREEN);
		txt_value5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_value5.setBounds(180, 11, 103, 29);
		panel_7.add(txt_value5);
		
		JLabel txt_status5 = new JLabel();
		txt_status5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_status5.setForeground(Color.RED);
		txt_status5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_status5.setBounds(325, 11, 126, 29);
		panel_7.add(txt_status5);
		
		JLabel txt_date5 = new JLabel();
		txt_date5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date5.setForeground(Color.WHITE);
		txt_date5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date5.setBounds(513, 11, 126, 29);
		panel_7.add(txt_date5);
		
		JLabel txt_time5 = new JLabel();
		txt_time5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time5.setForeground(Color.WHITE);
		txt_time5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time5.setBounds(705, 11, 126, 29);
		panel_7.add(txt_time5);
		
		JLabel delete_btn5 = new JLabel("Delete");
		delete_btn5.setHorizontalAlignment(SwingConstants.CENTER);
		delete_btn5.setForeground(Color.WHITE);
		delete_btn5.setFont(new Font("Bookman Old Style", Font.ITALIC, 14));
		delete_btn5.setBorder(new LineBorder(new Color(255, 255, 255)));
		delete_btn5.setBounds(910, 11, 76, 29);
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
			String sql = "SELECT parameter, value, status, date, time FROM sensor_alerts ORDER BY id DESC LIMIT 5";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.absolute(1);
			txt_param1.setText(rs.getString(1));
			txt_value1.setText(rs.getString(2));
			txt_status1.setText(rs.getString(3));
			txt_date1.setText(rs.getString(4));
			txt_time1.setText(rs.getString(5));
			
			rs.absolute(2);
			txt_param2.setText(rs.getString(1));
			txt_value2.setText(rs.getString(2));
			txt_status2.setText(rs.getString(3));
			txt_date2.setText(rs.getString(4));
			txt_time2.setText(rs.getString(5));
			
			rs.absolute(3);
			txt_param3.setText(rs.getString(1));
			txt_value3.setText(rs.getString(2));
			txt_status3.setText(rs.getString(3));
			txt_date3.setText(rs.getString(4));
			txt_time3.setText(rs.getString(5));
			
			rs.absolute(4);
			txt_param4.setText(rs.getString(1));
			txt_value4.setText(rs.getString(2));
			txt_status4.setText(rs.getString(3));
			txt_date4.setText(rs.getString(4));
			txt_time4.setText(rs.getString(5));
			
			rs.absolute(5);
			txt_param5.setText(rs.getString(1));
			txt_value5.setText(rs.getString(2));
			txt_status5.setText(rs.getString(3));
			txt_date5.setText(rs.getString(4));
			txt_time5.setText(rs.getString(5));
			
			JPanel panel_8 = new JPanel();
			panel_8.setBackground(new Color(110, 89, 222));
			panel_8.setBounds(0, 0, 10, 496);
			panel_1.add(panel_8);
			
			JPanel panel_9 = new JPanel();
			panel_9.setBackground(new Color(110, 89, 222));
			panel_9.setBounds(1042, 0, 10, 496);
			panel_1.add(panel_9);
			
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
				
				String Query = "DELETE from sensor_alerts where parameter =? and value =? and time =?";
				PreparedStatement stmt1 = conn5.prepareStatement(Query);
				stmt1.setString(1, txt_param1.getText());
				stmt1.setString(2, txt_value1.getText());
				stmt1.setString(3, txt_time1.getText());
				stmt1.executeUpdate();
				
				txt_param1.setText(null);
				txt_value1.setText(null);
				txt_status1.setText(null);
				txt_date1.setText(null);
				txt_time1.setText(null);
				
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
					
					String Query = "DELETE from sensor_alerts where parameter =? and value =? and time =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_param2.getText());
					stmt1.setString(2, txt_value2.getText());
					stmt1.setString(3, txt_time2.getText());
					stmt1.executeUpdate();
					
					txt_param2.setText(null);
					txt_value2.setText(null);
					txt_status2.setText(null);
					txt_date2.setText(null);
					txt_time2.setText(null);
					
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
					
					String Query = "DELETE from sensor_alerts where parameter =? and value =? and time =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_param3.getText());
					stmt1.setString(2, txt_value3.getText());
					stmt1.setString(3, txt_time3.getText());
					stmt1.executeUpdate();
					
					txt_param3.setText(null);
					txt_value3.setText(null);
					txt_status3.setText(null);
					txt_date3.setText(null);
					txt_time3.setText(null);
					
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
					
					String Query = "DELETE from sensor_alerts where parameter =? and value =? and time =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_param4.getText());
					stmt1.setString(2, txt_value4.getText());
					stmt1.setString(3, txt_time4.getText());
					stmt1.executeUpdate();
					
					txt_param4.setText(null);
					txt_value4.setText(null);
					txt_status4.setText(null);
					txt_date4.setText(null);
					txt_time4.setText(null);
					
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
					
					String Query = "DELETE from sensor_alerts where parameter =? and value =? and time =?";
					PreparedStatement stmt1 = conn5.prepareStatement(Query);
					stmt1.setString(1, txt_param5.getText());
					stmt1.setString(2, txt_value5.getText());
					stmt1.setString(3, txt_time5.getText());
					stmt1.executeUpdate();
					
					txt_param5.setText(null);
					txt_value5.setText(null);
					txt_status5.setText(null);
					txt_date5.setText(null);
					txt_time5.setText(null);
					
					delete_btn5.setBounds(0,0,0,0);
					
					conn5.close();
				}catch(Exception e1){
					
		
				}
				
			}
		});
	
		
//******************************************************************************************************************************//
		
	}
}
