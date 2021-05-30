import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

public class reportWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	//public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportWindow frame = new reportWindow();
					//frame.setBounds(0, 0, 1280, 720);
					frame.getContentPane().setLayout(null);
					//frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	@SuppressWarnings("deprecation")
	public reportWindow() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(reportWindow.class.getResource("/Images/report 40.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 10, 1200, 675);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		
//***********************************************************CALCULATING AVERAGE VALUES*************************************************//
		
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
					+ "from sensor_readings where Date > (DATE(NOW()) - INTERVAL 7 DAY)";
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
		
//****************************************************************MOVE WINDOW*******************************************************************//
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
//*************************************************************************************************************************************************//
		panel.setBackground(new Color(110, 89, 222));
		panel.setBounds(0, 0, 1200, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAnalysisWindow = new JLabel("Reports");
		lblAnalysisWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalysisWindow.setIcon(null);
		lblAnalysisWindow.setForeground(Color.WHITE);
		lblAnalysisWindow.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblAnalysisWindow.setBounds(504, 0, 211, 58);
		panel.add(lblAnalysisWindow);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(reportWindow.class.getResource("/Images/report 40.png")));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(10, 11, 60, 47);
		panel.add(label_1);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(54, 33, 89));
		panel_1.setBounds(0, 58, 1200, 618);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		
//***************************************************************WEEKLY AVERAGE PANEL************************************************************//
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(85, 65, 118));
		panel_2.setBounds(23, 11, 422, 51);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblToday = new JLabel();
		lblToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblToday.setText("Today");
		lblToday.setForeground(new Color(153, 204, 204));
		lblToday.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblToday.setBounds(10, 0, 92, 51);
		panel_2.add(lblToday);
		
		JLabel lblWeek = new JLabel();
		lblWeek.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeek.setText("Week");
		lblWeek.setForeground(new Color(153, 204, 204));
		lblWeek.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblWeek.setBounds(112, 0, 92, 51);
		panel_2.add(lblWeek);
		
		JLabel lblMonth = new JLabel();
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setText("Month");
		lblMonth.setForeground(new Color(153, 204, 204));
		lblMonth.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblMonth.setBounds(214, 0, 92, 51);
		panel_2.add(lblMonth);
		
		JLabel lblSelect = new JLabel();
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setText("Custom");
		lblSelect.setForeground(Color.WHITE);
		lblSelect.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblSelect.setBounds(316, 0, 92, 51);
		panel_2.add(lblSelect);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(107, 11, 15, 29);
		panel_2.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.LIGHT_GRAY);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(206, 11, 15, 29);
		panel_2.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.WHITE);
		separator_3.setBackground(Color.LIGHT_GRAY);
		separator_3.setBounds(310, 11, 15, 29);
		panel_2.add(separator_3);
		

		
		Panel table_panel = new Panel();
		table_panel.setFont(new Font("Consolas", Font.ITALIC, 18));
		table_panel.setBackground(new Color(204, 102, 255));
		table_panel.setBounds(24, 156, 680, 439);
		panel_1.add(table_panel);
		table_panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 680, 439);
		table_panel.add(scrollPane);
//**********************************************************************TABLE CREATION************************************************************//
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(54, 33, 89));
	
	
		
		JLabel button_ViewData = new JLabel("View data");
		button_ViewData.setHorizontalAlignment(SwingConstants.CENTER);
		button_ViewData.setForeground(Color.WHITE);
		button_ViewData.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		button_ViewData.setBorder(new LineBorder(new Color(255, 255, 255)));
		button_ViewData.setBounds(578, 107, 126, 26);
		panel_1.add(button_ViewData);
		
		
//***********************************************************************BAR CHART*****************************************************************//		
		Panel report_panel = new Panel();
		report_panel.setBackground(new Color(107, 98, 173));
		report_panel.setBounds(732, 12, 448, 583);
		panel_1.add(report_panel);
		report_panel.setLayout(null);
		
		Panel panel_3 = new Panel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(85, 65, 118));
		panel_3.setBounds(10, 10, 428, 88);
		report_panel.add(panel_3);
		
		JLabel lblTemperature = new JLabel();
		lblTemperature.setText("Temperature");
		lblTemperature.setHorizontalAlignment(SwingConstants.LEFT);
		lblTemperature.setForeground(Color.WHITE);
		lblTemperature.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblTemperature.setBounds(10, 0, 126, 26);
		panel_3.add(lblTemperature);
		
		JLabel lblAverage = new JLabel();
		lblAverage.setText("Average :");
		lblAverage.setHorizontalAlignment(SwingConstants.LEFT);
		lblAverage.setForeground(Color.WHITE);
		lblAverage.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAverage.setBounds(69, 30, 92, 20);
		panel_3.add(lblAverage);
		
		JLabel txt_avg_temp = new JLabel();
		txt_avg_temp.setHorizontalAlignment(SwingConstants.LEFT);
		txt_avg_temp.setForeground(Color.WHITE);
		txt_avg_temp.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_avg_temp.setBounds(148, 30, 192, 20);
		panel_3.add(txt_avg_temp);
		
		JLabel lblMinimun = new JLabel();
		lblMinimun.setText("Minimun :");
		lblMinimun.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinimun.setForeground(Color.WHITE);
		lblMinimun.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMinimun.setBounds(69, 57, 78, 20);
		panel_3.add(lblMinimun);
		
		JLabel txt_min_temp = new JLabel();
		txt_min_temp.setHorizontalAlignment(SwingConstants.LEFT);
		txt_min_temp.setForeground(Color.WHITE);
		txt_min_temp.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_min_temp.setBounds(148, 57, 58, 20);
		panel_3.add(txt_min_temp);
		
		JLabel lblMaximum = new JLabel();
		lblMaximum.setText("Maximum :");
		lblMaximum.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaximum.setForeground(Color.WHITE);
		lblMaximum.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMaximum.setBounds(254, 57, 86, 20);
		panel_3.add(lblMaximum);
		
		JLabel txt_max_temp = new JLabel();
		txt_max_temp.setHorizontalAlignment(SwingConstants.LEFT);
		txt_max_temp.setForeground(Color.WHITE);
		txt_max_temp.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_max_temp.setBounds(344, 57, 58, 20);
		panel_3.add(txt_max_temp);
		
		Panel panel_4 = new Panel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(85, 65, 118));
		panel_4.setBounds(10, 104, 428, 88);
		report_panel.add(panel_4);
		
		JLabel lblHumidity = new JLabel();
		lblHumidity.setText("Humidity");
		lblHumidity.setHorizontalAlignment(SwingConstants.LEFT);
		lblHumidity.setForeground(Color.WHITE);
		lblHumidity.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblHumidity.setBounds(10, 0, 126, 26);
		panel_4.add(lblHumidity);
		
		JLabel label_3 = new JLabel();
		label_3.setText("Average :");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_3.setBounds(69, 30, 92, 20);
		panel_4.add(label_3);
		
		JLabel txt_avg_hum = new JLabel();
		txt_avg_hum.setHorizontalAlignment(SwingConstants.LEFT);
		txt_avg_hum.setForeground(Color.WHITE);
		txt_avg_hum.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_avg_hum.setBounds(148, 30, 192, 20);
		panel_4.add(txt_avg_hum);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Minimun :");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_5.setBounds(69, 57, 78, 20);
		panel_4.add(label_5);
		
		JLabel txt_min_hum = new JLabel();
		txt_min_hum.setHorizontalAlignment(SwingConstants.LEFT);
		txt_min_hum.setForeground(Color.WHITE);
		txt_min_hum.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_min_hum.setBounds(148, 57, 58, 20);
		panel_4.add(txt_min_hum);
		
		JLabel label_7 = new JLabel();
		label_7.setText("Maximum :");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_7.setBounds(254, 57, 86, 20);
		panel_4.add(label_7);
		
		JLabel txt_max_hum = new JLabel();
		txt_max_hum.setHorizontalAlignment(SwingConstants.LEFT);
		txt_max_hum.setForeground(Color.WHITE);
		txt_max_hum.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_max_hum.setBounds(344, 57, 58, 20);
		panel_4.add(txt_max_hum);
		
		Panel panel_5 = new Panel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(85, 65, 118));
		panel_5.setBounds(10, 198, 428, 88);
		report_panel.add(panel_5);
		
		JLabel lblMoisture = new JLabel();
		lblMoisture.setText("Moisture");
		lblMoisture.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoisture.setForeground(Color.WHITE);
		lblMoisture.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblMoisture.setBounds(10, 0, 126, 26);
		panel_5.add(lblMoisture);
		
		JLabel label_10 = new JLabel();
		label_10.setText("Average :");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_10.setBounds(69, 30, 92, 20);
		panel_5.add(label_10);
		
		JLabel txt_avg_moist = new JLabel();
		txt_avg_moist.setHorizontalAlignment(SwingConstants.LEFT);
		txt_avg_moist.setForeground(Color.WHITE);
		txt_avg_moist.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_avg_moist.setBounds(148, 30, 192, 20);
		panel_5.add(txt_avg_moist);
		
		JLabel label_12 = new JLabel();
		label_12.setText("Minimun :");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_12.setBounds(69, 57, 78, 20);
		panel_5.add(label_12);
		
		JLabel txt_min_moist = new JLabel();
		txt_min_moist.setHorizontalAlignment(SwingConstants.LEFT);
		txt_min_moist.setForeground(Color.WHITE);
		txt_min_moist.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_min_moist.setBounds(148, 57, 58, 20);
		panel_5.add(txt_min_moist);
		
		JLabel label_14 = new JLabel();
		label_14.setText("Maximum :");
		label_14.setHorizontalAlignment(SwingConstants.LEFT);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_14.setBounds(254, 57, 86, 20);
		panel_5.add(label_14);
		
		JLabel txt_max_moist = new JLabel();
		txt_max_moist.setHorizontalAlignment(SwingConstants.LEFT);
		txt_max_moist.setForeground(Color.WHITE);
		txt_max_moist.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_max_moist.setBounds(344, 57, 58, 20);
		panel_5.add(txt_max_moist);
		
		Panel panel_6 = new Panel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(85, 65, 118));
		panel_6.setBounds(10, 292, 428, 88);
		report_panel.add(panel_6);
		
		JLabel lblAirQuality = new JLabel();
		lblAirQuality.setText("Air Quality");
		lblAirQuality.setHorizontalAlignment(SwingConstants.LEFT);
		lblAirQuality.setForeground(Color.WHITE);
		lblAirQuality.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblAirQuality.setBounds(10, 0, 126, 26);
		panel_6.add(lblAirQuality);
		
		JLabel label_17 = new JLabel();
		label_17.setText("Average :");
		label_17.setHorizontalAlignment(SwingConstants.LEFT);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_17.setBounds(69, 30, 92, 20);
		panel_6.add(label_17);
		
		JLabel txt_avg_air = new JLabel();
		txt_avg_air.setHorizontalAlignment(SwingConstants.LEFT);
		txt_avg_air.setForeground(Color.WHITE);
		txt_avg_air.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_avg_air.setBounds(148, 30, 192, 20);
		panel_6.add(txt_avg_air);
		
		JLabel label_19 = new JLabel();
		label_19.setText("Minimun :");
		label_19.setHorizontalAlignment(SwingConstants.LEFT);
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_19.setBounds(69, 57, 78, 20);
		panel_6.add(label_19);
		
		JLabel txt_min_air = new JLabel();
		txt_min_air.setHorizontalAlignment(SwingConstants.LEFT);
		txt_min_air.setForeground(Color.WHITE);
		txt_min_air.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_min_air.setBounds(148, 57, 58, 20);
		panel_6.add(txt_min_air);
		
		JLabel label_21 = new JLabel();
		label_21.setText("Maximum :");
		label_21.setHorizontalAlignment(SwingConstants.LEFT);
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_21.setBounds(254, 57, 86, 20);
		panel_6.add(label_21);
		
		JLabel txt_max_air = new JLabel();
		txt_max_air.setHorizontalAlignment(SwingConstants.LEFT);
		txt_max_air.setForeground(Color.WHITE);
		txt_max_air.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_max_air.setBounds(344, 57, 58, 20);
		panel_6.add(txt_max_air);
		
		Panel panel_7 = new Panel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(85, 65, 118));
		panel_7.setBounds(10, 386, 428, 88);
		report_panel.add(panel_7);
		
		JLabel lblSunlight = new JLabel();
		lblSunlight.setText("Sunlight");
		lblSunlight.setHorizontalAlignment(SwingConstants.LEFT);
		lblSunlight.setForeground(Color.WHITE);
		lblSunlight.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblSunlight.setBounds(10, 0, 126, 26);
		panel_7.add(lblSunlight);
		
		JLabel label_24 = new JLabel();
		label_24.setText("Average :");
		label_24.setHorizontalAlignment(SwingConstants.LEFT);
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_24.setBounds(69, 30, 92, 20);
		panel_7.add(label_24);
		
		JLabel txt_avg_sunL = new JLabel();
		txt_avg_sunL.setHorizontalAlignment(SwingConstants.LEFT);
		txt_avg_sunL.setForeground(Color.WHITE);
		txt_avg_sunL.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_avg_sunL.setBounds(148, 30, 192, 20);
		panel_7.add(txt_avg_sunL);
		
		JLabel label_26 = new JLabel();
		label_26.setText("Minimun :");
		label_26.setHorizontalAlignment(SwingConstants.LEFT);
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_26.setBounds(69, 57, 78, 20);
		panel_7.add(label_26);
		
		JLabel txt_min_sunL = new JLabel();
		txt_min_sunL.setHorizontalAlignment(SwingConstants.LEFT);
		txt_min_sunL.setForeground(Color.WHITE);
		txt_min_sunL.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_min_sunL.setBounds(148, 57, 58, 20);
		panel_7.add(txt_min_sunL);
		
		JLabel label_28 = new JLabel();
		label_28.setText("Maximum :");
		label_28.setHorizontalAlignment(SwingConstants.LEFT);
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_28.setBounds(254, 57, 86, 20);
		panel_7.add(label_28);
		
		JLabel txt_max_sunL = new JLabel();
		txt_max_sunL.setHorizontalAlignment(SwingConstants.LEFT);
		txt_max_sunL.setForeground(Color.WHITE);
		txt_max_sunL.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_max_sunL.setBounds(344, 57, 58, 20);
		panel_7.add(txt_max_sunL);
		
		Panel panel_8 = new Panel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(85, 65, 118));
		panel_8.setBounds(10, 480, 428, 88);
		report_panel.add(panel_8);
		
		JLabel lblHeatIndex = new JLabel();
		lblHeatIndex.setText("Heat Index");
		lblHeatIndex.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeatIndex.setForeground(Color.WHITE);
		lblHeatIndex.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblHeatIndex.setBounds(10, 0, 126, 26);
		panel_8.add(lblHeatIndex);
		
		JLabel label_31 = new JLabel();
		label_31.setText("Average :");
		label_31.setHorizontalAlignment(SwingConstants.LEFT);
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_31.setBounds(69, 30, 92, 20);
		panel_8.add(label_31);
		
		JLabel txt_avg_heat = new JLabel();
		txt_avg_heat.setHorizontalAlignment(SwingConstants.LEFT);
		txt_avg_heat.setForeground(Color.WHITE);
		txt_avg_heat.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_avg_heat.setBounds(148, 30, 192, 20);
		panel_8.add(txt_avg_heat);
		
		JLabel label_33 = new JLabel();
		label_33.setText("Minimun :");
		label_33.setHorizontalAlignment(SwingConstants.LEFT);
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_33.setBounds(69, 57, 78, 20);
		panel_8.add(label_33);
		
		JLabel txt_min_heat = new JLabel();
		txt_min_heat.setHorizontalAlignment(SwingConstants.LEFT);
		txt_min_heat.setForeground(Color.WHITE);
		txt_min_heat.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_min_heat.setBounds(148, 57, 58, 20);
		panel_8.add(txt_min_heat);
		
		JLabel label_35 = new JLabel();
		label_35.setText("Maximum :");
		label_35.setHorizontalAlignment(SwingConstants.LEFT);
		label_35.setForeground(Color.WHITE);
		label_35.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_35.setBounds(254, 57, 86, 20);
		panel_8.add(label_35);
		
		JLabel txt_max_heat = new JLabel();
		txt_max_heat.setHorizontalAlignment(SwingConstants.LEFT);
		txt_max_heat.setForeground(Color.WHITE);
		txt_max_heat.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txt_max_heat.setBounds(344, 57, 58, 20);
		panel_8.add(txt_max_heat);

		JLabel lblFrom = new JLabel("From :");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		lblFrom.setBounds(23, 83, 207, 20);
		panel_1.add(lblFrom);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		lblTo.setBounds(297, 83, 207, 20);
		panel_1.add(lblTo);
		
		String da = "2019-05-01";
		java.util.Date da2 = new SimpleDateFormat("yyyy-MM-dd").parse(da);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setDate(da2);
		dateChooser.setBounds(23, 107, 253, 28);
		dateChooser.setFont(new Font("Consolas", Font.ITALIC, 18));
		panel_1.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setDate(da2);
		dateChooser_1.setFont(new Font("Consolas", Font.ITALIC, 18));
		dateChooser_1.setBounds(297, 107, 253, 28);
		panel_1.add(dateChooser_1);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(110, 89, 222));
		panel_14.setBounds(0, 0, 10, 618);
		panel_1.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(110, 89, 222));
		panel_15.setBounds(1190, 0, 10, 618);
		panel_1.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(110, 89, 222));
		panel_16.setBounds(0, 608, 1200, 10);
		panel_1.add(panel_16);
		

//**************************************************TABLE DATA BY DATE**************************************************************//
	
//************************************************************CLOSE BUTTON*****************************************************************************//
				JLabel label_2 = new JLabel("X");
				label_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						 Component component = (Component) e.getSource();
					     JFrame win = (JFrame) SwingUtilities.getRoot(component);
					     win.dispose();
						
					}
				});
				
		//******************************************************************************************************************************************************//
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setForeground(Color.WHITE);
				label_2.setFont(new Font("Arial Black", Font.BOLD, 21));
				label_2.setBounds(1165, 0, 35, 31);
				panel.add(label_2);
				
//**************************************************MOUSE EVENTS**********************************************************************//
//**********************************************************TODAY******************************************************************//
				
				lblToday.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						lblWeek.setForeground(new Color(153, 204, 204));
						lblToday.setForeground(Color.WHITE);
						lblMonth.setForeground(new Color(153, 204, 204));
						lblSelect.setForeground(new Color(153, 204, 204));
						
						lblFrom.setBounds(0,0,0,0);
						lblTo.setBounds(0,0,0,0);
						dateChooser.setBounds(0,0,0,0);
						dateChooser_1.setBounds(0,0,0,0);
						button_ViewData.setBounds(0,0,0,0);
						
						table_panel.setBounds(24, 82, 680, 513);
						scrollPane.setBounds(0, 0, 680, 513);
						
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
							String sql = "SELECT id, Date, temperature, humidity, moisture, air_quality, sunlight, heat_index "
									+ "from sensor_readings WHERE Date <= DATE(NOW()) AND Date > (DATE(NOW()) - INTERVAL 1 DAY) ";
								
							ResultSet rs = stmt.executeQuery(sql);
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							
							Statement stmt2 = conn.createStatement();
							String sql2 = "SELECT AVG(temperature), AVG(humidity), AVG(moisture), AVG(air_quality), AVG(sunlight), AVG(heat_index), "
									+ "MAX(temperature), MAX(humidity), MAX(moisture), MAX(air_quality), MAX(sunlight), MAX(heat_index), "
									+ "MIN(temperature), MIN(humidity), MIN(moisture), MIN(air_quality), MIN(sunlight), MIN(heat_index) "
									+ "from sensor_readings WHERE Date <= DATE(NOW()) AND Date > (DATE(NOW()) - INTERVAL 1 DAY) ";
								
							ResultSet rs2 = stmt2.executeQuery(sql2);
							if(rs2.next()) {
								
								txt_avg_temp.setText(rs2.getString(1));
								txt_avg_hum.setText(rs2.getString(2));
								txt_avg_moist.setText(rs2.getString(3));
								txt_avg_air.setText(rs2.getString(4));
								txt_avg_sunL.setText(rs2.getString(5));
								txt_avg_heat.setText(rs2.getString(6));
								
								txt_max_temp.setText(rs2.getString(7));
								txt_max_hum.setText(rs2.getString(8));
								txt_max_moist.setText(rs2.getString(9));
								txt_max_air.setText(rs2.getString(10));
								txt_max_sunL.setText(rs2.getString(11));
								txt_max_heat.setText(rs2.getString(12));
								
								txt_min_temp.setText(rs2.getString(13));
								txt_min_hum.setText(rs2.getString(14));
								txt_min_moist.setText(rs2.getString(15));
								txt_min_air.setText(rs2.getString(16));
								txt_min_sunL.setText(rs2.getString(17));
								txt_min_heat.setText(rs2.getString(18));
							
								
							}
							
							
							conn.close();
						
							
						}catch(Exception err) {
							
						}
						
					}
				});
				
//**********************************************************WEEK************************************************************************//
				

				lblWeek.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						lblWeek.setForeground(Color.WHITE);
						lblToday.setForeground(new Color(153, 204, 204));
						lblMonth.setForeground(new Color(153, 204, 204));
						lblSelect.setForeground(new Color(153, 204, 204));
						
						lblFrom.setBounds(0,0,0,0);
						lblTo.setBounds(0,0,0,0);
						dateChooser.setBounds(0,0,0,0);
						dateChooser_1.setBounds(0,0,0,0);
						button_ViewData.setBounds(0,0,0,0);
						
						table_panel.setBounds(24, 82, 680, 513);
						scrollPane.setBounds(0, 0, 680, 513);
						
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
							String sql = "SELECT id, Date, temperature, humidity, moisture, air_quality, sunlight, heat_index "
									+ "from sensor_readings WHERE Date < DATE(NOW()) AND Date > (DATE(NOW()) - INTERVAL 7 DAY) ";
								
							ResultSet rs = stmt.executeQuery(sql);
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							Statement stmt2 = conn.createStatement();
							String sql2 = "SELECT AVG(temperature), AVG(humidity), AVG(moisture), AVG(air_quality), AVG(sunlight), AVG(heat_index), "
									+ "MAX(temperature), MAX(humidity), MAX(moisture), MAX(air_quality), MAX(sunlight), MAX(heat_index), "
									+ "MIN(temperature), MIN(humidity), MIN(moisture), MIN(air_quality), MIN(sunlight), MIN(heat_index) "
									+ "from sensor_readings WHERE Date <= DATE(NOW()) AND Date > (DATE(NOW()) - INTERVAL 7 DAY) ";
								
							ResultSet rs2 = stmt2.executeQuery(sql2);
							if(rs2.next()) {
								
								txt_avg_temp.setText(rs2.getString(1));
								txt_avg_hum.setText(rs2.getString(2));
								txt_avg_moist.setText(rs2.getString(3));
								txt_avg_air.setText(rs2.getString(4));
								txt_avg_sunL.setText(rs2.getString(5));
								txt_avg_heat.setText(rs2.getString(6));
								
								txt_max_temp.setText(rs2.getString(7));
								txt_max_hum.setText(rs2.getString(8));
								txt_max_moist.setText(rs2.getString(9));
								txt_max_air.setText(rs2.getString(10));
								txt_max_sunL.setText(rs2.getString(11));
								txt_max_heat.setText(rs2.getString(12));
								
								txt_min_temp.setText(rs2.getString(13));
								txt_min_hum.setText(rs2.getString(14));
								txt_min_moist.setText(rs2.getString(15));
								txt_min_air.setText(rs2.getString(16));
								txt_min_sunL.setText(rs2.getString(17));
								txt_min_heat.setText(rs2.getString(18));
							
							}
							conn.close();
						
							
						}catch(Exception err) {
							
						}
						
					}
				});
				
//**********************************************************MONTH***********************************************************************//
				

				lblMonth.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						lblWeek.setForeground(new Color(153, 204, 204));
						lblToday.setForeground(new Color(153, 204, 204));
						lblMonth.setForeground(Color.WHITE);
						lblSelect.setForeground(new Color(153, 204, 204));
						
						lblFrom.setBounds(0,0,0,0);
						lblTo.setBounds(0,0,0,0);
						dateChooser.setBounds(0,0,0,0);
						dateChooser_1.setBounds(0,0,0,0);
						button_ViewData.setBounds(0,0,0,0);
						
						table_panel.setBounds(24, 82, 680, 513);
						scrollPane.setBounds(0, 0, 680, 513);
						
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
							String sql = "SELECT id, Date, temperature, humidity, moisture, air_quality, sunlight, heat_index "
									+ "from sensor_readings WHERE Date < DATE(NOW()) AND Date > (DATE(NOW()) - INTERVAL 30 DAY) ";
								
							ResultSet rs = stmt.executeQuery(sql);
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							Statement stmt2 = conn.createStatement();
							String sql2 = "SELECT AVG(temperature), AVG(humidity), AVG(moisture), AVG(air_quality), AVG(sunlight), AVG(heat_index), "
									+ "MAX(temperature), MAX(humidity), MAX(moisture), MAX(air_quality), MAX(sunlight), MAX(heat_index), "
									+ "MIN(temperature), MIN(humidity), MIN(moisture), MIN(air_quality), MIN(sunlight), MIN(heat_index) "
									+ "from sensor_readings WHERE Date <= DATE(NOW()) AND Date > (DATE(NOW()) - INTERVAL 30 DAY) ";
								
							ResultSet rs2 = stmt2.executeQuery(sql2);
							if(rs2.next()) {
								
								txt_avg_temp.setText(rs2.getString(1));
								txt_avg_hum.setText(rs2.getString(2));
								txt_avg_moist.setText(rs2.getString(3));
								txt_avg_air.setText(rs2.getString(4));
								txt_avg_sunL.setText(rs2.getString(5));
								txt_avg_heat.setText(rs2.getString(6));
								
								txt_max_temp.setText(rs2.getString(7));
								txt_max_hum.setText(rs2.getString(8));
								txt_max_moist.setText(rs2.getString(9));
								txt_max_air.setText(rs2.getString(10));
								txt_max_sunL.setText(rs2.getString(11));
								txt_max_heat.setText(rs2.getString(12));
								
								txt_min_temp.setText(rs2.getString(13));
								txt_min_hum.setText(rs2.getString(14));
								txt_min_moist.setText(rs2.getString(15));
								txt_min_air.setText(rs2.getString(16));
								txt_min_sunL.setText(rs2.getString(17));
								txt_min_heat.setText(rs2.getString(18));
							
							}
							
							conn.close();
						
							
						}catch(Exception err) {
							
						}
						
					}
				});
				
//***********************************************************CUSTOM*********************************************************************//
				
				lblSelect.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						lblWeek.setForeground(new Color(153, 204, 204));
						lblToday.setForeground(new Color(153, 204, 204));
						lblMonth.setForeground(new Color(153, 204, 204));
						lblSelect.setForeground(Color.WHITE);
						
						lblFrom.setBounds(23, 83, 207, 20);
						lblTo.setBounds(297, 83, 207, 20);
						dateChooser.setBounds(23, 107, 253, 28);
						dateChooser_1.setBounds(297, 107, 253, 28);
						button_ViewData.setBounds(578, 107, 126, 28);
						
						table_panel.setBounds(24, 156, 680, 439);
						scrollPane.setBounds(0, 0, 680, 439);
						
						
					}
				});
				
//**********************************************************VIEW DATA BUTTON*********************************************************//
				button_ViewData.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String from = df.format(dateChooser.getDate());
						String to = df.format(dateChooser_1.getDate());
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
							String sql = "SELECT id, Date, temperature, humidity, moisture, air_quality, sunlight, heat_index "
									+ "from sensor_readings WHERE Date >= '"+from+"' AND Date <= '"+to+"' "
											+ "ORDER BY id ASC";
							ResultSet rs = stmt.executeQuery(sql);
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							Statement stmt2 = conn.createStatement();
							String sql2 = "SELECT AVG(temperature), AVG(humidity), AVG(moisture), AVG(air_quality), AVG(sunlight), AVG(heat_index), "
									+ "MAX(temperature), MAX(humidity), MAX(moisture), MAX(air_quality), MAX(sunlight), MAX(heat_index), "
									+ "MIN(temperature), MIN(humidity), MIN(moisture), MIN(air_quality), MIN(sunlight), MIN(heat_index) "
									+ "from sensor_readings WHERE Date >= '"+from+"' AND Date <= '"+to+"'";
								
							ResultSet rs2 = stmt2.executeQuery(sql2);
							if(rs2.next()) {
								
								txt_avg_temp.setText(rs2.getString(1));
								txt_avg_hum.setText(rs2.getString(2));
								txt_avg_moist.setText(rs2.getString(3));
								txt_avg_air.setText(rs2.getString(4));
								txt_avg_sunL.setText(rs2.getString(5));
								txt_avg_heat.setText(rs2.getString(6));
								
								txt_max_temp.setText(rs2.getString(7));
								txt_max_hum.setText(rs2.getString(8));
								txt_max_moist.setText(rs2.getString(9));
								txt_max_air.setText(rs2.getString(10));
								txt_max_sunL.setText(rs2.getString(11));
								txt_max_heat.setText(rs2.getString(12));
								
								txt_min_temp.setText(rs2.getString(13));
								txt_min_hum.setText(rs2.getString(14));
								txt_min_moist.setText(rs2.getString(15));
								txt_min_air.setText(rs2.getString(16));
								txt_min_sunL.setText(rs2.getString(17));
								txt_min_heat.setText(rs2.getString(18));
							
							}
							
							conn.close();
						
							
						}catch(Exception e1) {
							
						}
						
						
					}
				});
				
	}
}
