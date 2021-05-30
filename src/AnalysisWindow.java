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
import java.text.SimpleDateFormat;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

public class AnalysisWindow extends JFrame {

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
					AnalysisWindow frame = new AnalysisWindow();
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
	 */
	@SuppressWarnings("deprecation")
	public AnalysisWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnalysisWindow.class.getResource("/Images/analy 40.png")));
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
		
		JLabel lblAnalysisWindow = new JLabel("Analysis Window");
		lblAnalysisWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalysisWindow.setIcon(null);
		lblAnalysisWindow.setForeground(Color.WHITE);
		lblAnalysisWindow.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblAnalysisWindow.setBounds(504, 0, 211, 58);
		panel.add(lblAnalysisWindow);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/analy 40.png")));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(10, 11, 60, 34);
		panel.add(label_1);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(54, 33, 89));
		panel_1.setBounds(0, 58, 1200, 618);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		
//***************************************************************WEEKLY AVERAGE PANEL************************************************************//
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(85, 65, 118));
		panel_2.setBounds(23, 11, 1154, 128);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
//*************************************************************************************************************************************************//
		
//******************************************************************PARAMETER VALUE PANEL*************************************************************//
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(85, 65, 118));
		//panel_8.setBounds(23, 11, 1154, 128);
		panel_1.add(panel_8);
				
//*****************************************************************************************************************************************************//
				
		Panel panel_3 = new Panel();
		panel_3.setBounds(10, 42, 205, 76);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 102, 255));
		

		
		Panel table_panel = new Panel();
		table_panel.setFont(new Font("Consolas", Font.ITALIC, 18));
		table_panel.setBackground(new Color(204, 102, 255));
		table_panel.setBounds(24, 208, 680, 400);
		panel_1.add(table_panel);
		table_panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 680, 399);
		table_panel.add(scrollPane);
//**********************************************************************TABLE CREATION************************************************************//
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(54, 33, 89));
	
		Thread t = new Thread(){
			@Override public void run() {
				for(;;) {
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
			String sql = "SELECT id AS No, Date, temperature AS Temperature, humidity AS Humidity, moisture AS Moisture, air_quality AS Air_Quality, sunlight AS Sunlight, heat_index AS Heat_Index from sensor_readings ORDER BY id ASC";
			ResultSet rs = stmt.executeQuery(sql);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			conn.close();
			sleep(500000);
			
		}catch(Exception e) {
			
		}
				}
			}
		};
		t.start();
		
		
//*************************************************************************************************************************************************//
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/temperature 40.png")));
		label.setBounds(10, 11, 40, 53);
		panel_3.add(label);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setForeground(Color.WHITE);
		lblTemperature.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTemperature.setBounds(69, 38, 126, 38);
		panel_3.add(lblTemperature);
		
		JLabel label_3 = new JLabel();
		label_3.setText(avg_temp);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_3.setBounds(69, 0, 100, 42);
		panel_3.add(label_3);
		
		JLabel label_5 = new JLabel("Celci");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_5.setBounds(142, 13, 39, 26);
		panel_3.add(label_5);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(238, 42, 205, 76);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 171, 169));
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/humidity 40.png")));
		label_4.setBounds(10, 11, 40, 53);
		panel_4.add(label_4);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setForeground(Color.WHITE);
		lblHumidity.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblHumidity.setBounds(69, 38, 126, 38);
		panel_4.add(lblHumidity);
		
		JLabel label_7 = new JLabel();
		label_7.setText(avg_hum);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_7.setBounds(69, 0, 85, 42);
		panel_4.add(label_7);
		
		JLabel label_9 = new JLabel("%");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_9.setBounds(151, 13, 20, 26);
		panel_4.add(label_9);
		
		Panel panel_5 = new Panel();
		panel_5.setBounds(474, 42, 205, 76);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(102, 153, 0));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/moisture 40.png")));
		label_6.setBounds(10, 11, 40, 53);
		panel_5.add(label_6);
		
		JLabel lblMoisture = new JLabel("Moisture");
		lblMoisture.setForeground(Color.WHITE);
		lblMoisture.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblMoisture.setBounds(69, 38, 126, 38);
		panel_5.add(lblMoisture);
		
		JLabel label_11 = new JLabel();
		label_11.setText(avg_moist);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_11.setBounds(69, 0, 86, 42);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("%");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_12.setBounds(148, 13, 21, 26);
		panel_5.add(label_12);
		
		Panel panel_6 = new Panel();
		panel_6.setBounds(704, 42, 205, 76);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(204, 102, 51));
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/air qualty 40.png")));
		label_8.setBounds(10, 11, 40, 53);
		panel_6.add(label_8);
		
		JLabel lblAirQuality = new JLabel("Air Quality");
		lblAirQuality.setForeground(Color.WHITE);
		lblAirQuality.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAirQuality.setBounds(76, 38, 119, 38);
		panel_6.add(lblAirQuality);
		
		JLabel label_13 = new JLabel();
		label_13.setText(avg_air);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_13.setBounds(76, 0, 49, 42);
		panel_6.add(label_13);
		
		JLabel label_14 = new JLabel("%");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_14.setBounds(135, 11, 20, 26);
		panel_6.add(label_14);
		
		Panel panel_7 = new Panel();
		panel_7.setBounds(938, 42, 205, 76);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 102, 102));
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/sunlight 40.png")));
		label_10.setBounds(10, 11, 40, 53);
		panel_7.add(label_10);
		
		JLabel lblSunlight = new JLabel("Sunlight");
		lblSunlight.setForeground(Color.WHITE);
		lblSunlight.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSunlight.setBounds(69, 38, 126, 38);
		panel_7.add(lblSunlight);
		
		JLabel label_15 = new JLabel();
		label_15.setText(avg_sun);
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_15.setBounds(70, 0, 80, 42);
		panel_7.add(label_15);
		
		JLabel lblLux = new JLabel("Lux");
		lblLux.setHorizontalAlignment(SwingConstants.CENTER);
		lblLux.setForeground(Color.WHITE);
		lblLux.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		lblLux.setBounds(128, 13, 39, 26);
		panel_7.add(lblLux);
		
		JLabel lblAverageValuesthis = new JLabel("Average values (this week)");
		lblAverageValuesthis.setBounds(10, 0, 321, 36);
		panel_2.add(lblAverageValuesthis);
		lblAverageValuesthis.setForeground(Color.WHITE);
		lblAverageValuesthis.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		
		JLabel button_ViewData = new JLabel("View data");
		button_ViewData.setHorizontalAlignment(SwingConstants.CENTER);
		button_ViewData.setForeground(Color.WHITE);
		button_ViewData.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		button_ViewData.setBorder(new LineBorder(new Color(255, 255, 255)));
		button_ViewData.setBounds(578, 174, 126, 26);
		panel_1.add(button_ViewData);

	
		Panel panel_9 = new Panel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(204, 102, 255));
		panel_9.setBounds(10, 42, 205, 76);
		panel_8.add(panel_9);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/temperature 40.png")));
		label_16.setBounds(10, 11, 40, 53);
		panel_9.add(label_16);
		
		JLabel label_17 = new JLabel("Temperature");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_17.setBounds(69, 38, 126, 38);
		panel_9.add(label_17);
		
		JLabel label_temp = new JLabel();
		label_temp.setText("29");
		label_temp.setForeground(Color.WHITE);
		label_temp.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_temp.setBounds(69, 0, 100, 42);
		panel_9.add(label_temp);
		
		JLabel label_19 = new JLabel("Celci");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_19.setBounds(142, 11, 39, 26);
		panel_9.add(label_19);
		
		Panel panel_10 = new Panel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(0, 171, 169));
		panel_10.setBounds(238, 42, 205, 76);
		panel_8.add(panel_10);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/humidity 40.png")));
		label_20.setBounds(10, 11, 40, 53);
		panel_10.add(label_20);
		
		JLabel label_21 = new JLabel("Humidity");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_21.setBounds(69, 38, 126, 38);
		panel_10.add(label_21);
		
		JLabel label_hum = new JLabel();
		label_hum.setText("67");
		label_hum.setForeground(Color.WHITE);
		label_hum.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_hum.setBounds(69, 0, 105, 42);
		panel_10.add(label_hum);
		
		JLabel label_23 = new JLabel("%");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_23.setBounds(154, 11, 20, 26);
		panel_10.add(label_23);
		
		Panel panel_11 = new Panel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(102, 153, 0));
		panel_11.setBounds(474, 42, 205, 76);
		panel_8.add(panel_11);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/moisture 40.png")));
		label_24.setBounds(10, 11, 40, 53);
		panel_11.add(label_24);
		
		JLabel label_25 = new JLabel("Moisture");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_25.setBounds(69, 38, 126, 38);
		panel_11.add(label_25);
		
		JLabel label_moist = new JLabel();
		label_moist.setText("52");
		label_moist.setForeground(Color.WHITE);
		label_moist.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_moist.setBounds(69, 0, 99, 42);
		panel_11.add(label_moist);
		
		JLabel label_27 = new JLabel("%");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_27.setBounds(147, 13, 21, 26);
		panel_11.add(label_27);
		
		Panel panel_12 = new Panel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(204, 102, 51));
		panel_12.setBounds(704, 42, 205, 76);
		panel_8.add(panel_12);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/air qualty 40.png")));
		label_28.setBounds(10, 11, 40, 53);
		panel_12.add(label_28);
		
		JLabel label_29 = new JLabel("Air Quality");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_29.setBounds(76, 38, 119, 38);
		panel_12.add(label_29);
		
		JLabel label_air = new JLabel();
		label_air.setText("78");
		label_air.setForeground(Color.WHITE);
		label_air.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_air.setBounds(76, 0, 49, 42);
		panel_12.add(label_air);
		
		JLabel label_31 = new JLabel("%");
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_31.setBounds(137, 13, 20, 26);
		panel_12.add(label_31);
		
		Panel panel_13 = new Panel();
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(255, 102, 102));
		panel_13.setBounds(938, 42, 205, 76);
		panel_8.add(panel_13);
		
		JLabel label_32 = new JLabel("");
		label_32.setIcon(new ImageIcon(AnalysisWindow.class.getResource("/Images/sunlight 40.png")));
		label_32.setBounds(10, 11, 40, 53);
		panel_13.add(label_32);
		
		JLabel label_33 = new JLabel("Sunlight");
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label_33.setBounds(69, 38, 126, 38);
		panel_13.add(label_33);
		
		JLabel label_sunl = new JLabel();
		label_sunl.setText("63");
		label_sunl.setForeground(Color.WHITE);
		label_sunl.setFont(new Font("Arial Black", Font.PLAIN, 28));
		label_sunl.setBounds(70, 0, 94, 42);
		panel_13.add(label_sunl);
		
		JLabel label_35 = new JLabel("Lux");
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setForeground(Color.WHITE);
		label_35.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		label_35.setBounds(143, 11, 39, 26);
		panel_13.add(label_35);
		
		JLabel lblParameterValuesselected = new JLabel("Parameter values (selected entry)");
		lblParameterValuesselected.setForeground(Color.WHITE);
		lblParameterValuesselected.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblParameterValuesselected.setBounds(10, 0, 444, 36);
		panel_8.add(lblParameterValuesselected);
		
		
//***********************************************************************BAR CHART*****************************************************************//		
		Panel barchart_panel = new Panel();
		barchart_panel.setBounds(730, 164, 448, 444);
		panel_1.add(barchart_panel);
		barchart_panel.setLayout(null);
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		dcd.setValue(itemp, "Average values (this week)", "Temper");
		dcd.setValue(ihum, "Average values (this week)", "Humidity");
		dcd.setValue(imoist, "Average values (this week)", "Moisture");
		dcd.setValue(iair, "Average values (this week)", "AirQua");
		dcd.setValue(isun, "Average values (this week)", "Sunlight");
		dcd.setValue(iheat, "Average values (this week)", "Heat");

		JFreeChart jchart = ChartFactory.createBarChart("", "", "", dcd, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot p = jchart.getCategoryPlot();
		p.setBackgroundPaint(new Color(153, 153, 51));
		p.setOutlinePaint(Color.white);
		jchart.setBackgroundPaint(new Color(153, 153, 51));
		jchart.getLegend().setItemPaint(Color.white);
		jchart.getLegend().setItemFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		jchart.getLegend().setBackgroundPaint(new Color(153, 153, 51));
		ChartPanel chartpan1 = new ChartPanel(jchart);
		chartpan1.setBounds(0, 0, 448, 443);
		barchart_panel.add(chartpan1);
		
		JSeparator separator = new JSeparator();
		chartpan1.add(separator);
		
		JLabel lblFrom = new JLabel("From :");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		lblFrom.setBounds(23, 150, 207, 20);
		panel_1.add(lblFrom);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		lblTo.setBounds(297, 150, 207, 20);
		panel_1.add(lblTo);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(23, 174, 253, 28);
		dateChooser.setFont(new Font("Consolas", Font.ITALIC, 18));
		panel_1.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setFont(new Font("Consolas", Font.ITALIC, 18));
		dateChooser_1.setBounds(297, 174, 253, 28);
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
		
		
		
//****************************************************************TABLE OPERATIONS************************************************************************//
	
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			       DefaultTableModel model = (DefaultTableModel)table.getModel();

			       
			       int selectedRowIndex = table.getSelectedRow();
			       
			     
			       label_temp.setText(model.getValueAt(selectedRowIndex, 2).toString());
			       label_hum.setText(model.getValueAt(selectedRowIndex, 3).toString());
			       label_moist.setText(model.getValueAt(selectedRowIndex, 4).toString());
			       label_air.setText(model.getValueAt(selectedRowIndex, 5).toString());
			       label_sunl.setText(model.getValueAt(selectedRowIndex, 6).toString());
			       
			       panel_2.setBounds(0, 0, 0, 0);
			       panel_8.setBounds(23, 11, 1154, 128);
		
			}
		});
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 panel_8.setBounds(0, 0, 0, 0);
			     panel_2.setBounds(23, 11, 1154, 128);
				
			}
		});
		
		
//**************************************************TABLE DATA BY DATE**************************************************************//
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
					String sql = "SELECT id, Date, temperature, humidity, moisture, air_quality, sunlight, heat_index from sensor_readings "
							+ "WHERE Date >= '"+from+"' AND Date <= '"+to+"' "
							+ "ORDER BY id ASC";
					ResultSet rs = stmt.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					conn.close();
				
					
				}catch(Exception e1) {
					
				}
				
				
			}
		});
//************************************************************CLOSE BUTTON*****************************************************************************//
				JLabel label_2 = new JLabel("X");
				label_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						 Component component = (Component) e.getSource();
					     JFrame win = (JFrame) SwingUtilities.getRoot(component);
					     t.suspend();
					     win.dispose();
						
					}
				});
				
		//******************************************************************************************************************************************************//
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setForeground(Color.WHITE);
				label_2.setFont(new Font("Arial Black", Font.BOLD, 21));
				label_2.setBounds(1165, 0, 35, 31);
				panel.add(label_2);
				
		
	}
}
