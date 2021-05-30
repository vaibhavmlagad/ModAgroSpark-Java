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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Panel;
import java.awt.Toolkit;

public class user_accessWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	static String uname;
	
	static int x=0;
	static int posX=0;
	static int posY=0;
	
	Connection conn5 = null;
	
	public static void main(String[] args) {
		
		uname = args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_accessWindow frame = new user_accessWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings("deprecation")
	public user_accessWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(user_accessWindow.class.getResource("/Images/login Span.png")));
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
		
		JLabel lblSensorAlerts = new JLabel("Access Information");
		lblSensorAlerts.setHorizontalAlignment(SwingConstants.CENTER);
		lblSensorAlerts.setForeground(Color.WHITE);
		lblSensorAlerts.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblSensorAlerts.setBounds(346, 0, 326, 58);
		panel.add(lblSensorAlerts);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(user_accessWindow.class.getResource("/Images/contact dealers 40.png")));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(10, 11, 60, 34);
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
		txt_date1.setForeground(Color.GREEN);
		txt_date1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date1.setBounds(0, 11, 314, 29);
		panel_3.add(txt_date1);
		
		JLabel txt_time1 = new JLabel();
		txt_time1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time1.setForeground(Color.GREEN);
		txt_time1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time1.setBounds(359, 11, 281, 29);
		panel_3.add(txt_time1);
		
		JLabel txt_type1 = new JLabel();
		txt_type1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type1.setForeground(Color.GREEN);
		txt_type1.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type1.setBounds(710, 11, 200, 29);
		panel_3.add(txt_type1);
		
		//**************************************************************************************************************//
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(110, 89, 222));
		panel_8.setBounds(0, 0, 10, 496);
		panel_1.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(110, 89, 222));
		panel_9.setBounds(1042, 0, 10, 496);
		panel_1.add(panel_9);
		
		JLabel lblParameter = new JLabel();
		lblParameter.setText("Date");
		lblParameter.setHorizontalAlignment(SwingConstants.LEFT);
		lblParameter.setForeground(Color.WHITE);
		lblParameter.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblParameter.setBounds(144, 22, 85, 26);
		panel_1.add(lblParameter);
		
		JLabel lblValue = new JLabel();
		lblValue.setText("Access Period");
		lblValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblValue.setForeground(Color.WHITE);
		lblValue.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblValue.setBounds(479, 22, 98, 26);
		panel_1.add(lblValue);
		
		JLabel lblStatus = new JLabel();
		lblStatus.setText("LogOut Time");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblStatus.setBounds(794, 22, 140, 26);
		panel_1.add(lblStatus);
		
		Panel panel_4 = new Panel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(80, 65, 118));
		panel_4.setBounds(26, 133, 996, 51);
		panel_1.add(panel_4);
		
		JLabel txt_date2 = new JLabel();
		txt_date2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date2.setForeground(Color.WHITE);
		txt_date2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date2.setBounds(20, 11, 242, 29);
		panel_4.add(txt_date2);
		
		JLabel txt_time2 = new JLabel();
		txt_time2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time2.setForeground(new Color(255, 255, 255));
		txt_time2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time2.setBounds(356, 11, 284, 29);
		panel_4.add(txt_time2);
		
		JLabel txt_type2 = new JLabel();
		txt_type2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type2.setForeground(new Color(255, 255, 255));
		txt_type2.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type2.setBounds(709, 11, 204, 29);
		panel_4.add(txt_type2);
		
		Panel panel_5 = new Panel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(80, 65, 118));
		panel_5.setBounds(26, 208, 996, 51);
		panel_1.add(panel_5);
		
		JLabel txt_date3 = new JLabel();
		txt_date3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date3.setForeground(Color.WHITE);
		txt_date3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date3.setBounds(20, 11, 242, 29);
		panel_5.add(txt_date3);
		
		JLabel txt_time3 = new JLabel();
		txt_time3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time3.setForeground(new Color(255, 255, 255));
		txt_time3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time3.setBounds(356, 11, 284, 29);
		panel_5.add(txt_time3);
		
		JLabel txt_type3 = new JLabel();
		txt_type3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type3.setForeground(new Color(255, 255, 255));
		txt_type3.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type3.setBounds(712, 11, 203, 29);
		panel_5.add(txt_type3);
		
		Panel panel_6 = new Panel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(80, 65, 118));
		panel_6.setBounds(26, 282, 996, 51);
		panel_1.add(panel_6);
		
		JLabel txt_date4 = new JLabel();
		txt_date4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date4.setForeground(Color.WHITE);
		txt_date4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date4.setBounds(20, 11, 242, 29);
		panel_6.add(txt_date4);
		
		JLabel txt_time4 = new JLabel();
		txt_time4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time4.setForeground(new Color(255, 255, 255));
		txt_time4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time4.setBounds(359, 11, 281, 29);
		panel_6.add(txt_time4);
		
		JLabel txt_type4 = new JLabel();
		txt_type4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type4.setForeground(new Color(255, 255, 255));
		txt_type4.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type4.setBounds(711, 11, 205, 29);
		panel_6.add(txt_type4);
		
		Panel panel_7 = new Panel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(80, 65, 118));
		panel_7.setBounds(26, 355, 996, 51);
		panel_1.add(panel_7);
		
		JLabel txt_date5 = new JLabel();
		txt_date5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_date5.setForeground(Color.WHITE);
		txt_date5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_date5.setBounds(20, 11, 242, 29);
		panel_7.add(txt_date5);
		
		JLabel txt_time5 = new JLabel();
		txt_time5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_time5.setForeground(new Color(255, 255, 255));
		txt_time5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_time5.setBounds(358, 11, 282, 29);
		panel_7.add(txt_time5);
		
		JLabel txt_type5 = new JLabel();
		txt_type5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type5.setForeground(new Color(255, 255, 255));
		txt_type5.setFont(new Font("Consolas", Font.PLAIN, 18));
		txt_type5.setBounds(710, 11, 206, 29);
		panel_7.add(txt_type5);
		
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
			String sql = "SELECT date, access_period, logout_time FROM user_access_info "
					+ "WHERE username = '"+uname+"' ORDER BY id DESC LIMIT 5";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			//*******************************************************************************************************//
			rs.absolute(1);
			txt_date1.setText(rs.getString(1)+" (Last Login)");
			txt_time1.setText(rs.getString(2));
			txt_type1.setText(rs.getString(3));
			
			//**********************************************************************************************************//
			rs.absolute(2);
			txt_date2.setText(rs.getString(1));
			txt_time2.setText(rs.getString(2));
			txt_type2.setText(rs.getString(3));
		
			//**********************************************************************************************************//
			rs.absolute(3);
			txt_date3.setText(rs.getString(1));
			txt_time3.setText(rs.getString(2));
			txt_type3.setText(rs.getString(3));
			
		
			//***********************************************************************************************************//
			rs.absolute(4);
			txt_date4.setText(rs.getString(1));
			txt_time4.setText(rs.getString(2));
			txt_type4.setText(rs.getString(3));
		
			
			//**********************************************************************************************************//
			rs.absolute(5);
			txt_date5.setText(rs.getString(1));
			txt_time5.setText(rs.getString(2));
			txt_type5.setText(rs.getString(3));
		
			
			conn.close();
		
			
		}catch(Exception e1) {
			//System.out.println(e1);
		}
	
		
//******************************************************************************************************************************//
		
	}
}
