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
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.border.LineBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class sensor_settingWindow extends JFrame {

	private JPanel contentPane;

	static int x=0;
	static int posX=0;
	static int posY=0;
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sensor_settingWindow frame = new sensor_settingWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public sensor_settingWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(sensor_settingWindow.class.getResource("/Images/setting.png")));
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
		
		JLabel lblDhttemperature = new JLabel("DHT-22 (Temperature) :");
		lblDhttemperature.setForeground(Color.WHITE);
		lblDhttemperature.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblDhttemperature.setBackground(Color.WHITE);
		lblDhttemperature.setBounds(298, 32, 230, 29);
		panel.add(lblDhttemperature);
		
		JLabel lblDhthumidity = new JLabel("DHT-22 (Humidity) :");
		lblDhthumidity.setForeground(Color.WHITE);
		lblDhthumidity.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblDhthumidity.setBackground(Color.WHITE);
		lblDhthumidity.setBounds(298, 90, 230, 29);
		panel.add(lblDhthumidity);
		
		JLabel lblMoisture = new JLabel("Moisture :");
		lblMoisture.setForeground(Color.WHITE);
		lblMoisture.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblMoisture.setBackground(Color.WHITE);
		lblMoisture.setBounds(298, 150, 230, 29);
		panel.add(lblMoisture);
		
		JLabel lblLdr = new JLabel("MQ-135 (Air Quality) :");
		lblLdr.setForeground(Color.WHITE);
		lblLdr.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblLdr.setBackground(Color.WHITE);
		lblLdr.setBounds(298, 208, 230, 29);
		panel.add(lblLdr);
		
		JLabel lblLdrsunlight = new JLabel("LDR (Sunlight) :");
		lblLdrsunlight.setForeground(Color.WHITE);
		lblLdrsunlight.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblLdrsunlight.setBackground(Color.WHITE);
		lblLdrsunlight.setBounds(298, 268, 230, 29);
		panel.add(lblLdrsunlight);
		
		JLabel lblDhtheatIndex = new JLabel("DHT-22 (Heat Index) :");
		lblDhtheatIndex.setForeground(Color.WHITE);
		lblDhtheatIndex.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblDhtheatIndex.setBackground(Color.WHITE);
		lblDhtheatIndex.setBounds(298, 323, 230, 29);
		panel.add(lblDhtheatIndex);
		
		JLabel lblReadingsDuration = new JLabel("Readings Duration in seconds :");
		lblReadingsDuration.setForeground(Color.WHITE);
		lblReadingsDuration.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblReadingsDuration.setBackground(Color.WHITE);
		lblReadingsDuration.setBounds(298, 377, 291, 29);
		panel.add(lblReadingsDuration);
		
		JComboBox combo_duration = new JComboBox();
		combo_duration.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "30"}));
		combo_duration.setForeground(Color.WHITE);
		combo_duration.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		combo_duration.setBackground(new Color(54, 33, 89));
		combo_duration.setBounds(624, 374, 110, 32);
		panel.add(combo_duration);
		
		JLabel lblChangeSettings = new JLabel("Change Settings");
		lblChangeSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeSettings.setForeground(Color.WHITE);
		lblChangeSettings.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblChangeSettings.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblChangeSettings.setBackground(new Color(85, 65, 118));
		lblChangeSettings.setBounds(190, 442, 349, 34);
		panel.add(lblChangeSettings);
		
		JLabel label_3 = new JLabel("Close");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					 Component component = (Component) e.getSource();
				     JFrame win = (JFrame) SwingUtilities.getRoot(component);
				     win.dispose();
			}
		});
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label_3.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_3.setBounds(568, 442, 257, 34);
		panel.add(label_3);
		
		JComboBox btn_temp = new JComboBox();
		btn_temp.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		btn_temp.setForeground(Color.WHITE);
		btn_temp.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_temp.setBackground(new Color(54, 33, 89));
		btn_temp.setBounds(624, 30, 110, 34);
		panel.add(btn_temp);
		
		JComboBox btn_hum = new JComboBox();
		btn_hum.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		btn_hum.setForeground(Color.WHITE);
		btn_hum.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_hum.setBackground(new Color(54, 33, 89));
		btn_hum.setBounds(624, 88, 110, 34);
		panel.add(btn_hum);
		
		JComboBox btn_moist = new JComboBox();
		btn_moist.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		btn_moist.setForeground(Color.WHITE);
		btn_moist.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_moist.setBackground(new Color(54, 33, 89));
		btn_moist.setBounds(624, 148, 110, 34);
		panel.add(btn_moist);
		
		JComboBox btn_air = new JComboBox();
		btn_air.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		btn_air.setForeground(Color.WHITE);
		btn_air.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_air.setBackground(new Color(54, 33, 89));
		btn_air.setBounds(624, 208, 110, 34);
		panel.add(btn_air);
		
		JComboBox btn_sun = new JComboBox();
		btn_sun.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		btn_sun.setForeground(Color.WHITE);
		btn_sun.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_sun.setBackground(new Color(54, 33, 89));
		btn_sun.setBounds(624, 266, 110, 34);
		panel.add(btn_sun);
		
		JComboBox btn_heat = new JComboBox();
		btn_heat.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		btn_heat.setForeground(Color.WHITE);
		btn_heat.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btn_heat.setBackground(new Color(54, 33, 89));
		btn_heat.setBounds(624, 321, 110, 34);
		panel.add(btn_heat);
		
		
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
		
		JLabel lblMyProfile = new JLabel("Sensor Setting");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(428, 0, 211, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(sensor_settingWindow.class.getResource("/Images/sensor setting alert 40.png")));
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
		
		


		//*********************************************************************SHOW DATA FROM DATABASE******************************************************//
				try {
					Connection conn1 = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "modagrospark";
					String driver = "com.mysql.cj.jdbc.Driver";
					String userName = "root";
					String password = "lagad@11";
					Class.forName(driver).newInstance();
					conn1 = DriverManager.getConnection(url+dbName,userName,password);
					String sta_temp, sta_hum, sta_moist, sta_air, sta_sun,sta_heat;
					
					String sql = "SELECT * from sensor_setting where id =1";
					 PreparedStatement stmt = conn1.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					
				
					if(rs.next()) {
						sta_temp = rs.getString(2);
						if(sta_temp =="ON") {
							btn_temp.setSelectedItem("OFF");
							btn_temp.setForeground(Color.RED);
						}else if(sta_temp =="OFF") {
							btn_temp.setSelectedItem("ON");
							btn_temp.setForeground(Color.GREEN);
						}
						
						sta_hum = rs.getString(3);
						if(sta_hum =="ON") {
							btn_hum.setSelectedItem("OFF");
							btn_hum.setForeground(Color.RED);
						}else if(sta_hum =="OFF") {
							btn_hum.setSelectedItem("ON");
							btn_hum.setForeground(Color.GREEN);
						}
						
						sta_moist = rs.getString(4);
						if(sta_moist =="ON") {
							btn_moist.setSelectedItem("OFF");
							btn_moist.setForeground(Color.RED);
						}else if(sta_moist =="OFF") {
							btn_moist.setSelectedItem("ON");
							btn_moist.setForeground(Color.GREEN);
						}
						
						sta_air = rs.getString(5);
						if(sta_air =="ON") {
							btn_air.setSelectedItem("OFF");
							btn_air.setForeground(Color.RED);
						}else if(sta_air =="OFF") {
							btn_air.setSelectedItem("ON");
							btn_air.setForeground(Color.GREEN);
						}
						
						sta_sun = rs.getString(6);
						if(sta_sun =="ON") {
							btn_sun.setSelectedItem("OFF");
							btn_sun.setForeground(Color.RED);
						}else if(sta_sun =="OFF") {
							btn_sun.setSelectedItem("ON");
							btn_sun.setForeground(Color.GREEN);
						}
						
						sta_heat = rs.getString(7);
						if(sta_heat =="ON") {
							btn_heat.setSelectedItem("OFF");
							btn_heat.setForeground(Color.RED);
						}else if(sta_heat =="OFF") {
							btn_heat.setSelectedItem("ON");
							btn_heat.setForeground(Color.GREEN);
						}
						
						combo_duration.setSelectedItem(rs.getString(7));
					}
					
					conn1.close();
					
				}catch(Exception err) {
					  
					JOptionPane.showMessageDialog(null,
							"Something wents wrong, Try again later..!!");
					
				}
		//**********************************************CHANGE SETTING BUTTON*********************************************************//
				

				lblChangeSettings.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						try {
							
							Connection conn6 = null;
							String url = "jdbc:mysql://localhost:3306/";
							String dbName = "modagrospark";
							String driver = "com.mysql.cj.jdbc.Driver";
							String userName = "root";
							String password = "lagad@11";
							Class.forName(driver).newInstance();
							conn6 = DriverManager.getConnection(url+dbName,userName,password);
						
						
							PreparedStatement ps=conn6.prepareStatement("UPDATE sensor_setting set temperature =?, humidity =?, moisture =?, air =?, sunlight =?, heat =?, duration =? WHERE id = 1");
							
							ps.setString(1, (String) btn_temp.getSelectedItem());
							ps.setString(2, (String) btn_hum.getSelectedItem());
							ps.setString(3, (String) btn_moist.getSelectedItem());
							ps.setString(4, (String) btn_air.getSelectedItem());
							ps.setString(5, (String) btn_sun.getSelectedItem());
							ps.setString(6, (String) btn_heat.getSelectedItem());
							ps.setString(7, (String) combo_duration.getSelectedItem());
						
							ps.executeUpdate();
							
							conn6.close();
							
							
							JOptionPane.showMessageDialog(null,
									"Settings changed successfully..!");
							
					
						}catch(Exception e1) {
							
							JOptionPane.showMessageDialog(null,
									"Something wents wrong..! Try again later");
							
						}
						
					}
				});
		
		//*********************************************************************SHOW DATA FROM DATABASE******************************************************//
		try {
			Connection conn1 = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "modagrospark";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "lagad@11";
			Class.forName(driver).newInstance();
			conn1 = DriverManager.getConnection(url+dbName,userName,password);
			
			
			String sql = "SELECT * from sensor_setting where id =1";
			PreparedStatement stmt = conn1.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				btn_temp.setSelectedItem(rs.getString(2));
				btn_hum.setSelectedItem(rs.getString(3));
				btn_moist.setSelectedItem(rs.getString(4));
				btn_air.setSelectedItem(rs.getString(5));
				btn_sun.setSelectedItem(rs.getString(6));
				btn_heat.setSelectedItem(rs.getString(7));
				combo_duration.setSelectedItem(rs.getString(8));
			}
			
			conn1.close();
			
		}catch(Exception err) {
			  
			JOptionPane.showMessageDialog(null,
					"Something wents wrong, Try again later..!!");
			
		}
		
	}
}
