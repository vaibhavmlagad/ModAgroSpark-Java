import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Panel;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextArea;

public class ForecastingWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	static int x = 0;
	static int posX=0;
	static int posY=0;
	
	static String avg_temp;
	static String avg_hum;
	static String avg_moist;
	static String avg_air;
	static String avg_sun;
	static String avg_heat;
	
	int itemp, ihum, imoist, iair, isun, iheat;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForecastingWindow frame = new ForecastingWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	public ForecastingWindow() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ForecastingWindow.class.getResource("/Images/forcast 40.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 10, 1200, 675);
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
				Component dialog = SwingUtilities.getRoot(component);
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});
		panel.setLayout(null);
		panel.setBackground(new Color(110, 89, 222));
		panel.setBounds(0, 0, 1200, 58);
		contentPane.add(panel);
		
		
//*****************************************************CALCULATE AVERAGE VALUES****************************************************//
		try {
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "modagrospark";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "lagad@11";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
		
			String sql = "SELECT AVG(temperature), AVG(humidity), AVG(moisture), AVG(air_quality), AVG(sunlight), AVG(heat_index) "
					+ "from sensor_readings where Date > (DATE(NOW()) - INTERVAL 10 DAY)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			double atemp, ahum, amoist, aair, asun, aheat;
			
			if(rs.next()) {
		
				atemp = Double.parseDouble(rs.getString(1));
				itemp = (int)atemp;
				avg_temp = Integer.toString(itemp);
				
				ahum = Double.parseDouble(rs.getString(2));
				ihum = (int)ahum;
				avg_hum = Integer.toString(ihum);
				
				amoist = Double.parseDouble(rs.getString(3));
				imoist = (int)amoist;
				avg_moist = Integer.toString(imoist);
				
				aair = Double.parseDouble(rs.getString(4));
				iair = (int)aair;
				avg_air = Integer.toString(iair);
				
				asun = Double.parseDouble(rs.getString(5));
				isun = (int)asun;
				avg_sun = Integer.toString(isun);
				
				aheat = Double.parseDouble(rs.getString(6));
				iheat = (int)aheat;
				avg_heat = Integer.toString(iheat);
			
			
			}
	
			conn.close();
		}catch(Exception err) {
			System.out.println(err);
	
		}
//************************************************************************************************************************************//

		
		JLabel lblForecastingWindow = new JLabel("Forecasting Window");
		lblForecastingWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblForecastingWindow.setForeground(Color.WHITE);
		lblForecastingWindow.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblForecastingWindow.setBounds(436, 0, 325, 58);
		panel.add(lblForecastingWindow);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ForecastingWindow.class.getResource("/Images/forcast 40.png")));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(10, 11, 60, 34);
		panel.add(label_1);
		
//***************************************************CLOSE BUTTON***************************************************************//
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
		label_2.setBounds(1165, 0, 35, 31);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(54, 33, 89));
		panel_1.setBounds(0, 58, 1200, 618);
		contentPane.add(panel_1);
		
		JPanel status_panel = new JPanel();
		status_panel.setLayout(null);
		status_panel.setBackground(new Color(85, 65, 118));
		status_panel.setBounds(965, 11, 225, 586);
		panel_1.add(status_panel);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblStatus.setBounds(10, 0, 192, 36);
		status_panel.add(lblStatus);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(10, 130, 205, 76);
		status_panel.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 171, 169));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(ForecastingWindow.class.getResource("/Images/humidity 40.png")));
		label_6.setBounds(10, 11, 40, 53);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("Humidity");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_7.setBounds(69, 38, 126, 38);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel();
		label_8.setText(avg_hum);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_8.setBounds(69, 0, 65, 42);
		panel_4.add(label_8);
		
		JLabel status_hum = new JLabel();
		status_hum.setHorizontalAlignment(SwingConstants.LEFT);
		if(ihum<15) {
			status_hum.setText("Low");
		}else if(ihum<30) {
			status_hum.setText("Medium");
		}else if(ihum<65) {
			status_hum.setText("Moderate");
		}else if(ihum<=80) {
			status_hum.setText("High");
		}else if(ihum>80) {
			status_hum.setText("Very High");
		}
		status_hum.setForeground(Color.WHITE);
		status_hum.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		status_hum.setBounds(130, 13, 65, 26);
		panel_4.add(status_hum);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(10, 42, 205, 76);
		status_panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 102, 255));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ForecastingWindow.class.getResource("/Images/temperature 40.png")));
		label.setBounds(10, 11, 40, 53);
		panel_3.add(label);
		
		JLabel label_3 = new JLabel("Temperature");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_3.setBounds(69, 38, 126, 38);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel();
		label_4.setText(avg_temp);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_4.setBounds(69, 0, 70, 42);
		panel_3.add(label_4);
		
		JLabel status_temp = new JLabel();
		if(itemp<7) {
			status_temp.setText("Low");
		}else if(itemp<20) {
			status_temp.setText("Medium");
		}else if(itemp<35) {
			status_temp.setText("Moderate");
		}else if(itemp<=50) {
			status_temp.setText("High");
		}else if(itemp>50) {
			status_temp.setText("Very High");
		}
		status_temp.setHorizontalAlignment(SwingConstants.LEFT);
		status_temp.setForeground(Color.WHITE);
		status_temp.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		status_temp.setBounds(125, 13, 70, 26);
		panel_3.add(status_temp);
		
		Panel panel_5 = new Panel();
		panel_5.setBounds(10, 223, 205, 76);
		status_panel.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(102, 153, 0));
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(ForecastingWindow.class.getResource("/Images/moisture 40.png")));
		label_10.setBounds(10, 11, 40, 53);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Moisture");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_11.setBounds(69, 38, 126, 38);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel();
		label_12.setText(avg_moist);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_12.setBounds(69, 0, 62, 42);
		panel_5.add(label_12);
		
		JLabel status_moist = new JLabel();
		status_moist.setHorizontalAlignment(SwingConstants.LEFT);
		if(imoist<15) {
			status_moist.setText("Low");
		}else if(imoist<30) {
			status_moist.setText("Medium");
		}else if(imoist<65) {
			status_moist.setText("Moderate");
		}else if(imoist<=80) {
			status_moist.setText("High");
		}else if(imoist>80) {
			status_moist.setText("Very High");
		}
		status_moist.setForeground(Color.WHITE);
		status_moist.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		status_moist.setBounds(133, 11, 62, 26);
		panel_5.add(status_moist);
		
		Panel panel_6 = new Panel();
		panel_6.setBounds(10, 313, 205, 76);
		status_panel.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(204, 102, 51));
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(ForecastingWindow.class.getResource("/Images/air qualty 40.png")));
		label_14.setBounds(10, 11, 40, 53);
		panel_6.add(label_14);
		
		JLabel label_15 = new JLabel("Air Quality");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_15.setBounds(76, 38, 119, 38);
		panel_6.add(label_15);
		
		JLabel label_16 = new JLabel();
		label_16.setText(avg_air);
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_16.setBounds(76, 0, 49, 42);
		panel_6.add(label_16);
		
		JLabel status_air = new JLabel();
		status_air.setHorizontalAlignment(SwingConstants.LEFT);
		if(iair<30) {
			status_air.setText("Polluted");
		}else if(iair<50) {
			status_air.setText("Bad");
		}else if(iair<65) {
			status_air.setText("Moderate");
		}else if(iair<=80) {
			status_air.setText("Pure");
		}else if(iair>80) {
			status_air.setText("Very Pure");
		}
		status_air.setForeground(Color.WHITE);
		status_air.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		status_air.setBounds(135, 11, 60, 26);
		panel_6.add(status_air);
		
		Panel panel_7 = new Panel();
		panel_7.setBounds(10, 408, 205, 76);
		status_panel.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 102, 102));
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(ForecastingWindow.class.getResource("/Images/sunlight 40.png")));
		label_18.setBounds(10, 11, 40, 53);
		panel_7.add(label_18);
		
		JLabel label_19 = new JLabel("Sunlight");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_19.setBounds(69, 38, 126, 38);
		panel_7.add(label_19);
		
		JLabel label_20 = new JLabel();
		label_20.setText(avg_sun);
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_20.setBounds(70, 0, 62, 42);
		panel_7.add(label_20);
		
		JLabel status_sun = new JLabel();
		if(isun<15) {
			status_sun.setText("Low");
		}else if(isun<30) {
			status_sun.setText("Medium");
		}else if(isun<65) {
			status_sun.setText("Moderate");
		}else if(isun<=80) {
			status_sun.setText("High");
		}else if(isun>80) {
			status_sun.setText("Very High");
		}
		status_sun.setHorizontalAlignment(SwingConstants.LEFT);
		status_sun.setForeground(Color.WHITE);
		status_sun.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		status_sun.setBounds(133, 13, 62, 26);
		panel_7.add(status_sun);
		
		Panel panel_15 = new Panel();
		panel_15.setLayout(null);
		panel_15.setBackground(new Color(153, 153, 51));
		panel_15.setBounds(10, 500, 205, 76);
		status_panel.add(panel_15);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(ForecastingWindow.class.getResource("/Images/heat 40.png")));
		label_5.setBounds(10, 11, 40, 53);
		panel_15.add(label_5);
		
		JLabel lblHeatIndex = new JLabel("Heat Index");
		lblHeatIndex.setForeground(Color.WHITE);
		lblHeatIndex.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblHeatIndex.setBounds(69, 38, 126, 38);
		panel_15.add(lblHeatIndex);
		
		JLabel label_13 = new JLabel();
		label_13.setText(avg_heat);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_13.setBounds(70, 0, 62, 42);
		panel_15.add(label_13);
		
		JLabel status_heat = new JLabel();
		if(iheat<7) {
			status_heat.setText("Low");
		}else if(iheat<20) {
			status_heat.setText("Medium");
		}else if(iheat<35) {
			status_heat.setText("Moderate");
		}else if(iheat<=50) {
			status_heat.setText("High");
		}else if(iheat>50) {
			status_heat.setText("Very High");
		}
		status_heat.setHorizontalAlignment(SwingConstants.LEFT);
		status_heat.setForeground(Color.WHITE);
		status_heat.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		status_heat.setBounds(133, 13, 62, 26);
		panel_15.add(status_heat);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(85, 65, 118));
		panel_8.setBounds(0, 0, 0, 0);
		panel_1.add(panel_8);
		
		Panel panel_9 = new Panel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(204, 102, 255));
		panel_9.setBounds(10, 42, 205, 76);
		panel_8.add(panel_9);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(10, 11, 40, 53);
		panel_9.add(label_23);
		
		JLabel label_24 = new JLabel("Temperature");
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_24.setBounds(69, 38, 126, 38);
		panel_9.add(label_24);
		
		JLabel label_25 = new JLabel();
		label_25.setText("29");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_25.setBounds(69, 0, 100, 42);
		panel_9.add(label_25);
		
		JLabel label_26 = new JLabel("Celci");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_26.setBounds(142, 11, 39, 26);
		panel_9.add(label_26);
		
		Panel panel_10 = new Panel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(0, 171, 169));
		panel_10.setBounds(238, 42, 205, 76);
		panel_8.add(panel_10);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(10, 11, 40, 53);
		panel_10.add(label_27);
		
		JLabel label_28 = new JLabel("Humidity");
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_28.setBounds(69, 38, 126, 38);
		panel_10.add(label_28);
		
		JLabel label_29 = new JLabel();
		label_29.setText("67");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_29.setBounds(69, 0, 105, 42);
		panel_10.add(label_29);
		
		JLabel label_30 = new JLabel("%");
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_30.setBounds(154, 11, 20, 26);
		panel_10.add(label_30);
		
		Panel panel_11 = new Panel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(102, 153, 0));
		panel_11.setBounds(474, 42, 205, 76);
		panel_8.add(panel_11);
		
		JLabel label_31 = new JLabel("");
		label_31.setBounds(10, 11, 40, 53);
		panel_11.add(label_31);
		
		JLabel label_32 = new JLabel("Moisture");
		label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_32.setBounds(69, 38, 126, 38);
		panel_11.add(label_32);
		
		JLabel label_33 = new JLabel();
		label_33.setText("52");
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_33.setBounds(69, 0, 99, 42);
		panel_11.add(label_33);
		
		JLabel label_34 = new JLabel("%");
		label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_34.setBounds(147, 13, 21, 26);
		panel_11.add(label_34);
		
		Panel panel_12 = new Panel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(204, 102, 51));
		panel_12.setBounds(704, 42, 205, 76);
		panel_8.add(panel_12);
		
		JLabel label_35 = new JLabel("");
		label_35.setBounds(10, 11, 40, 53);
		panel_12.add(label_35);
		
		JLabel label_36 = new JLabel("Air Quality");
		label_36.setForeground(Color.WHITE);
		label_36.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_36.setBounds(76, 38, 119, 38);
		panel_12.add(label_36);
		
		JLabel label_37 = new JLabel();
		label_37.setText("78");
		label_37.setForeground(Color.WHITE);
		label_37.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_37.setBounds(76, 0, 49, 42);
		panel_12.add(label_37);
		
		JLabel label_38 = new JLabel("%");
		label_38.setForeground(Color.WHITE);
		label_38.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_38.setBounds(137, 13, 20, 26);
		panel_12.add(label_38);
		
		Panel panel_13 = new Panel();
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(255, 102, 102));
		panel_13.setBounds(938, 42, 205, 76);
		panel_8.add(panel_13);
		
		JLabel label_39 = new JLabel("");
		label_39.setBounds(10, 11, 40, 53);
		panel_13.add(label_39);
		
		JLabel label_40 = new JLabel("Sunlight");
		label_40.setForeground(Color.WHITE);
		label_40.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_40.setBounds(69, 38, 126, 38);
		panel_13.add(label_40);
		
		JLabel label_41 = new JLabel();
		label_41.setText("63");
		label_41.setForeground(Color.WHITE);
		label_41.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_41.setBounds(70, 0, 94, 42);
		panel_13.add(label_41);
		
		JLabel label_42 = new JLabel("Lux");
		label_42.setHorizontalAlignment(SwingConstants.CENTER);
		label_42.setForeground(Color.WHITE);
		label_42.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_42.setBounds(143, 11, 39, 26);
		panel_13.add(label_42);
		
		JLabel label_43 = new JLabel("Parameter values (selected entry)");
		label_43.setForeground(Color.WHITE);
		label_43.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label_43.setBounds(10, 0, 444, 36);
		panel_8.add(label_43);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(110, 89, 222));
		panel_14.setBounds(0, 608, 1200, 10);
		panel_1.add(panel_14);
		
		JPanel prediction_panel = new JPanel();
		prediction_panel.setLayout(null);
		prediction_panel.setBackground(new Color(85, 65, 118));
		prediction_panel.setBounds(10, 11, 327, 586);
		panel_1.add(prediction_panel);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(102, 153, 0));
		panel_2.setBounds(10, 10, 306, 171);
		prediction_panel.add(panel_2);
		
		JLabel txt_disease1 = new JLabel();
		txt_disease1.setForeground(Color.WHITE);
		txt_disease1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txt_disease1.setBounds(84, 28, 212, 27);
		panel_2.add(txt_disease1);
		
		JLabel label_21 = new JLabel();
		label_21.setText("Prediction 1");
		label_21.setHorizontalAlignment(SwingConstants.LEFT);
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_21.setBounds(10, 0, 126, 26);
		panel_2.add(label_21);
		
		JLabel lblName = new JLabel();
		lblName.setText("Name :");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		lblName.setBounds(10, 33, 92, 20);
		panel_2.add(lblName);
		
		JLabel lblType = new JLabel();
		lblType.setText("Type :");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		lblType.setBounds(10, 59, 92, 20);
		panel_2.add(lblType);
		
		JLabel txt_type1 = new JLabel();
		txt_type1.setForeground(Color.WHITE);
		txt_type1.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		txt_type1.setBounds(84, 48, 212, 38);
		panel_2.add(txt_type1);
		
		JLabel lblTemperature = new JLabel();
		lblTemperature.setText("Temperature :");
		lblTemperature.setHorizontalAlignment(SwingConstants.LEFT);
		lblTemperature.setForeground(Color.WHITE);
		lblTemperature.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblTemperature.setBounds(10, 97, 92, 20);
		panel_2.add(lblTemperature);
		
		JLabel lblHumidity = new JLabel();
		lblHumidity.setText("Humidity :");
		lblHumidity.setHorizontalAlignment(SwingConstants.LEFT);
		lblHumidity.setForeground(Color.WHITE);
		lblHumidity.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblHumidity.setBounds(10, 128, 78, 20);
		panel_2.add(lblHumidity);
		
		JLabel lblMoisture = new JLabel();
		lblMoisture.setText("Moisture :");
		lblMoisture.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoisture.setForeground(Color.WHITE);
		lblMoisture.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblMoisture.setBounds(170, 97, 65, 20);
		panel_2.add(lblMoisture);
		
		JLabel lblAirQuality = new JLabel();
		lblAirQuality.setText("Air Quality :");
		lblAirQuality.setHorizontalAlignment(SwingConstants.LEFT);
		lblAirQuality.setForeground(Color.WHITE);
		lblAirQuality.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblAirQuality.setBounds(170, 128, 86, 20);
		panel_2.add(lblAirQuality);
		
		JLabel label_61 = new JLabel();
		label_61.setText(avg_temp+" Celc");
		label_61.setHorizontalAlignment(SwingConstants.LEFT);
		label_61.setForeground(Color.WHITE);
		label_61.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_61.setBounds(110, 97, 58, 20);
		panel_2.add(label_61);
		
		JLabel label_62 = new JLabel();
		label_62.setText(avg_hum+" %");
		label_62.setHorizontalAlignment(SwingConstants.LEFT);
		label_62.setForeground(Color.WHITE);
		label_62.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_62.setBounds(110, 128, 50, 20);
		panel_2.add(label_62);
		
		JLabel label_63 = new JLabel();
		label_63.setText(avg_moist+" %");
		label_63.setHorizontalAlignment(SwingConstants.LEFT);
		label_63.setForeground(Color.WHITE);
		label_63.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_63.setBounds(254, 97, 42, 20);
		panel_2.add(label_63);
		
		JLabel label_64 = new JLabel();
		label_64.setText(avg_air+" %");
		label_64.setHorizontalAlignment(SwingConstants.LEFT);
		label_64.setForeground(Color.WHITE);
		label_64.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_64.setBounds(254, 128, 52, 20);
		panel_2.add(label_64);
		
		Panel panel_16 = new Panel();
		panel_16.setLayout(null);
		panel_16.setBackground(new Color(0, 171, 169));
		panel_16.setBounds(10, 208, 306, 171);
		prediction_panel.add(panel_16);
		
		JLabel label_45 = new JLabel();
		label_45.setText("Prediction 2");
		label_45.setHorizontalAlignment(SwingConstants.LEFT);
		label_45.setForeground(Color.WHITE);
		label_45.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_45.setBounds(10, 0, 126, 26);
		panel_16.add(label_45);
		
		JLabel label_22 = new JLabel();
		label_22.setText("Name :");
		label_22.setHorizontalAlignment(SwingConstants.LEFT);
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_22.setBounds(10, 32, 92, 20);
		panel_16.add(label_22);
		
		JLabel txt_disease2 = new JLabel();
		txt_disease2.setForeground(Color.WHITE);
		txt_disease2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txt_disease2.setBounds(84, 27, 212, 27);
		panel_16.add(txt_disease2);
		
		JLabel label_46 = new JLabel();
		label_46.setText("Type :");
		label_46.setHorizontalAlignment(SwingConstants.LEFT);
		label_46.setForeground(Color.WHITE);
		label_46.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_46.setBounds(10, 58, 92, 20);
		panel_16.add(label_46);
		
		JLabel txt_type2 = new JLabel();
		txt_type2.setForeground(Color.WHITE);
		txt_type2.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		txt_type2.setBounds(84, 47, 212, 38);
		panel_16.add(txt_type2);
		
		JLabel label_53 = new JLabel();
		label_53.setText("Temperature :");
		label_53.setHorizontalAlignment(SwingConstants.LEFT);
		label_53.setForeground(Color.WHITE);
		label_53.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_53.setBounds(10, 96, 92, 20);
		panel_16.add(label_53);
		
		JLabel label_54 = new JLabel();
		label_54.setText("Humidity :");
		label_54.setHorizontalAlignment(SwingConstants.LEFT);
		label_54.setForeground(Color.WHITE);
		label_54.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_54.setBounds(10, 127, 78, 20);
		panel_16.add(label_54);
		
		JLabel label_55 = new JLabel();
		label_55.setText("Moisture :");
		label_55.setHorizontalAlignment(SwingConstants.LEFT);
		label_55.setForeground(Color.WHITE);
		label_55.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_55.setBounds(170, 96, 65, 20);
		panel_16.add(label_55);
		
		JLabel label_56 = new JLabel();
		label_56.setText("Air Quality :");
		label_56.setHorizontalAlignment(SwingConstants.LEFT);
		label_56.setForeground(Color.WHITE);
		label_56.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_56.setBounds(170, 127, 86, 20);
		panel_16.add(label_56);
		
		JLabel label_65 = new JLabel();
		label_65.setText(avg_temp+" Celc");
		label_65.setHorizontalAlignment(SwingConstants.LEFT);
		label_65.setForeground(Color.WHITE);
		label_65.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_65.setBounds(110, 96, 57, 20);
		panel_16.add(label_65);
		
		JLabel label_66 = new JLabel();
		label_66.setText(avg_hum+" %");
		label_66.setHorizontalAlignment(SwingConstants.LEFT);
		label_66.setForeground(Color.WHITE);
		label_66.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_66.setBounds(110, 127, 57, 20);
		panel_16.add(label_66);
		
		JLabel label_67 = new JLabel();
		label_67.setText(avg_moist+" %");
		label_67.setHorizontalAlignment(SwingConstants.LEFT);
		label_67.setForeground(Color.WHITE);
		label_67.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_67.setBounds(254, 96, 52, 20);
		panel_16.add(label_67);
		
		JLabel label_68 = new JLabel();
		label_68.setText(avg_air+" %");
		label_68.setHorizontalAlignment(SwingConstants.LEFT);
		label_68.setForeground(Color.WHITE);
		label_68.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_68.setBounds(254, 127, 52, 20);
		panel_16.add(label_68);
		
		Panel panel_17 = new Panel();
		panel_17.setLayout(null);
		panel_17.setBackground(new Color(204, 102, 51));
		panel_17.setBounds(10, 406, 306, 171);
		prediction_panel.add(panel_17);
		
		JLabel label_48 = new JLabel();
		label_48.setText("Prediction 3");
		label_48.setHorizontalAlignment(SwingConstants.LEFT);
		label_48.setForeground(Color.WHITE);
		label_48.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_48.setBounds(10, 0, 126, 26);
		panel_17.add(label_48);
		
		JLabel label_49 = new JLabel();
		label_49.setText("Name :");
		label_49.setHorizontalAlignment(SwingConstants.LEFT);
		label_49.setForeground(Color.WHITE);
		label_49.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_49.setBounds(10, 33, 92, 20);
		panel_17.add(label_49);
		
		JLabel txt_disease3 = new JLabel();
		txt_disease3.setForeground(Color.WHITE);
		txt_disease3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txt_disease3.setBounds(84, 28, 212, 27);
		panel_17.add(txt_disease3);
		
		JLabel label_51 = new JLabel();
		label_51.setText("Type :");
		label_51.setHorizontalAlignment(SwingConstants.LEFT);
		label_51.setForeground(Color.WHITE);
		label_51.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_51.setBounds(10, 59, 92, 20);
		panel_17.add(label_51);
		
		JLabel txt_type3 = new JLabel();
		txt_type3.setForeground(Color.WHITE);
		txt_type3.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		txt_type3.setBounds(84, 48, 212, 38);
		panel_17.add(txt_type3);
		
		JLabel label_57 = new JLabel();
		label_57.setText("Temperature :");
		label_57.setHorizontalAlignment(SwingConstants.LEFT);
		label_57.setForeground(Color.WHITE);
		label_57.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_57.setBounds(10, 98, 92, 20);
		panel_17.add(label_57);
		
		JLabel label_58 = new JLabel();
		label_58.setText("Humidity :");
		label_58.setHorizontalAlignment(SwingConstants.LEFT);
		label_58.setForeground(Color.WHITE);
		label_58.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_58.setBounds(10, 129, 78, 20);
		panel_17.add(label_58);
		
		JLabel label_59 = new JLabel();
		label_59.setText("Moisture :");
		label_59.setHorizontalAlignment(SwingConstants.LEFT);
		label_59.setForeground(Color.WHITE);
		label_59.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_59.setBounds(170, 98, 65, 20);
		panel_17.add(label_59);
		
		JLabel label_60 = new JLabel();
		label_60.setText("Air Quality :");
		label_60.setHorizontalAlignment(SwingConstants.LEFT);
		label_60.setForeground(Color.WHITE);
		label_60.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_60.setBounds(170, 129, 86, 20);
		panel_17.add(label_60);
		
		JLabel label_69 = new JLabel();
		label_69.setText(avg_temp+" Celc");
		label_69.setHorizontalAlignment(SwingConstants.LEFT);
		label_69.setForeground(Color.WHITE);
		label_69.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_69.setBounds(110, 98, 57, 20);
		panel_17.add(label_69);
		
		JLabel label_70 = new JLabel();
		label_70.setText(avg_hum+" %");
		label_70.setHorizontalAlignment(SwingConstants.LEFT);
		label_70.setForeground(Color.WHITE);
		label_70.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_70.setBounds(110, 129, 57, 20);
		panel_17.add(label_70);
		
		JLabel label_71 = new JLabel();
		label_71.setText(avg_moist+" %");
		label_71.setHorizontalAlignment(SwingConstants.LEFT);
		label_71.setForeground(Color.WHITE);
		label_71.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_71.setBounds(254, 98, 52, 20);
		panel_17.add(label_71);
		
		JLabel label_72 = new JLabel();
		label_72.setText(avg_air+" %");
		label_72.setHorizontalAlignment(SwingConstants.LEFT);
		label_72.setForeground(Color.WHITE);
		label_72.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_72.setBounds(254, 129, 52, 20);
		panel_17.add(label_72);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(71, 65, 121));
		panel_18.setBounds(347, 11, 608, 187);
		panel_1.add(panel_18);
		panel_18.setLayout(null);
		
		JLabel label_75 = new JLabel("X");
		label_75.setBounds(1165, 0, 35, 31);
		label_75.setHorizontalAlignment(SwingConstants.CENTER);
		label_75.setForeground(Color.WHITE);
		label_75.setFont(new Font("Arial Black", Font.BOLD, 21));
		panel_18.add(label_75);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(303, 11, 19, 165);
		panel_18.add(separator);
		
		JLabel lblSymptoms = new JLabel();
		lblSymptoms.setText("Symptoms");
		lblSymptoms.setHorizontalAlignment(SwingConstants.LEFT);
		lblSymptoms.setForeground(Color.WHITE);
		lblSymptoms.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblSymptoms.setBounds(10, 0, 126, 26);
		panel_18.add(lblSymptoms);
		
		JLabel lblPreventions = new JLabel();
		lblPreventions.setText("Preventions");
		lblPreventions.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreventions.setForeground(Color.WHITE);
		lblPreventions.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblPreventions.setBounds(313, 0, 126, 26);
		panel_18.add(lblPreventions);
		
		JTextArea txt_prevention1 = new JTextArea();
		txt_prevention1.setEditable(false);
		txt_prevention1.setWrapStyleWord(true);
		txt_prevention1.setTabSize(2);
		txt_prevention1.setLineWrap(true);
		txt_prevention1.setForeground(Color.WHITE);
		txt_prevention1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txt_prevention1.setBackground(new Color(71, 65, 121));
		txt_prevention1.setBounds(332, 26, 266, 161);
		panel_18.add(txt_prevention1);
		
		JTextArea txt_symptoms1 = new JTextArea();
		txt_symptoms1.setEditable(false);
		txt_symptoms1.setWrapStyleWord(true);
		txt_symptoms1.setTabSize(2);
		txt_symptoms1.setLineWrap(true);
		txt_symptoms1.setForeground(Color.WHITE);
		txt_symptoms1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txt_symptoms1.setBackground(new Color(71, 65, 121));
		txt_symptoms1.setBounds(20, 26, 273, 161);
		panel_18.add(txt_symptoms1);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(107, 98, 173));
		panel_19.setBounds(347, 416, 608, 181);
		panel_1.add(panel_19);
		panel_19.setLayout(null);
		
		JLabel label_76 = new JLabel("X");
		label_76.setBounds(1165, 0, 35, 31);
		label_76.setHorizontalAlignment(SwingConstants.CENTER);
		label_76.setForeground(Color.WHITE);
		label_76.setFont(new Font("Arial Black", Font.BOLD, 21));
		panel_19.add(label_76);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(302, 11, 19, 159);
		panel_19.add(separator_2);
		
		JLabel lblSymptoms_2 = new JLabel();
		lblSymptoms_2.setText("Symptoms");
		lblSymptoms_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSymptoms_2.setForeground(Color.WHITE);
		lblSymptoms_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblSymptoms_2.setBounds(10, 0, 126, 26);
		panel_19.add(lblSymptoms_2);
		
		JLabel lblPreventions_2 = new JLabel();
		lblPreventions_2.setText("Preventions");
		lblPreventions_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreventions_2.setForeground(Color.WHITE);
		lblPreventions_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblPreventions_2.setBounds(313, 0, 126, 26);
		panel_19.add(lblPreventions_2);
		
		JTextArea txt_symptoms3 = new JTextArea();
		txt_symptoms3.setEditable(false);
		txt_symptoms3.setWrapStyleWord(true);
		txt_symptoms3.setTabSize(2);
		txt_symptoms3.setLineWrap(true);
		txt_symptoms3.setForeground(Color.WHITE);
		txt_symptoms3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txt_symptoms3.setBackground(new Color(107, 98, 173));
		txt_symptoms3.setBounds(20, 26, 272, 155);
		panel_19.add(txt_symptoms3);
		
		JTextArea txt_prevention3 = new JTextArea();
		txt_prevention3.setEditable(false);
		txt_prevention3.setWrapStyleWord(true);
		txt_prevention3.setTabSize(2);
		txt_prevention3.setLineWrap(true);
		txt_prevention3.setForeground(Color.WHITE);
		txt_prevention3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txt_prevention3.setBackground(new Color(107, 98, 173));
		txt_prevention3.setBounds(331, 26, 267, 155);
		panel_19.add(txt_prevention3);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(86, 77, 147));
		panel_20.setBounds(347, 209, 608, 196);
		panel_1.add(panel_20);
		panel_20.setLayout(null);
		
		JLabel label_78 = new JLabel("X");
		label_78.setBounds(1165, 0, 35, 31);
		label_78.setHorizontalAlignment(SwingConstants.CENTER);
		label_78.setForeground(Color.WHITE);
		label_78.setFont(new Font("Arial Black", Font.BOLD, 21));
		panel_20.add(label_78);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(303, 11, 19, 174);
		panel_20.add(separator_1);
		
		JLabel lblSymptoms_1 = new JLabel();
		lblSymptoms_1.setText("Symptoms");
		lblSymptoms_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSymptoms_1.setForeground(Color.WHITE);
		lblSymptoms_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblSymptoms_1.setBounds(10, 0, 126, 26);
		panel_20.add(lblSymptoms_1);
		
		JLabel lblPreventions_1 = new JLabel();
		lblPreventions_1.setText("Preventions");
		lblPreventions_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreventions_1.setForeground(Color.WHITE);
		lblPreventions_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblPreventions_1.setBounds(314, 0, 126, 26);
		panel_20.add(lblPreventions_1);
		
		JTextArea txt_symptoms2 = new JTextArea();
		txt_symptoms2.setEditable(false);
		txt_symptoms2.setWrapStyleWord(true);
		txt_symptoms2.setTabSize(2);
		txt_symptoms2.setLineWrap(true);
		txt_symptoms2.setForeground(Color.WHITE);
		txt_symptoms2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txt_symptoms2.setBackground(new Color(86, 77, 147));
		txt_symptoms2.setBounds(20, 25, 273, 171);
		panel_20.add(txt_symptoms2);
		
		JTextArea txt_prevention2 = new JTextArea();
		txt_prevention2.setEditable(false);
		txt_prevention2.setWrapStyleWord(true);
		txt_prevention2.setTabSize(2);
		txt_prevention2.setLineWrap(true);
		txt_prevention2.setForeground(Color.WHITE);
		txt_prevention2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txt_prevention2.setBackground(new Color(86, 77, 147));
		txt_prevention2.setBounds(332, 25, 266, 171);
		panel_20.add(txt_prevention2);
		
		
		//**********************************************************FETCHING DISEASE DATA******************************************************//
		
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
					String sql = "SELECT disease_name, type, symptoms, preventions from diseases WHERE "
							+ "(temp_from < "+itemp+" and temp_to > "+itemp+") OR (hum_from < "+ihum+" and hum_to > "+ihum+") AND "
							+ "(moist_from < "+imoist+" and moist_to > "+imoist+")";
					
					
					
					ResultSet rs = stmt.executeQuery(sql);
					
					rs.absolute(1);
					txt_disease1.setText(rs.getString(1));
					txt_type1.setText(rs.getString(2));
					txt_symptoms1.setText(rs.getString(3));
					txt_prevention1.setText(rs.getString(4));
					
					rs.absolute(2);
					txt_disease2.setText(rs.getString(1));
					txt_type2.setText(rs.getString(2));
					txt_symptoms2.setText(rs.getString(3));
					txt_prevention2.setText(rs.getString(4));
					
					rs.absolute(3);
					txt_disease3.setText(rs.getString(1));
					txt_type3.setText(rs.getString(2));
					txt_symptoms3.setText(rs.getString(3));
					txt_prevention3.setText(rs.getString(4));
					
					conn.close();
				
					
				}catch(Exception e1) {
					//System.out.println(e1);
				}
				
		//*************************************************MOUSE EVENTS*******************************************************//
		

				txt_disease1.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						diseaseDescription.main(new String[] {txt_disease1.getText()});
						
					}
				});
				

				txt_disease2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						diseaseDescription.main(new String[] {txt_disease2.getText()});
						
					}
				});
				

				txt_disease3.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						diseaseDescription.main(new String[] {txt_disease3.getText()});
						
					}
				});
		
	}
}
