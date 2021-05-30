import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import net.proteanit.sql.DbUtils;
import java.awt.Toolkit;

public class SensorGraph {
	
	static int x = 0;
	static int posX=0;
	static int posY=0;
	private static JTable table;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	//public static void main() {
		
		// create and configure the window
//		random_generator.main(null);
		
		JFrame window = new JFrame();
		window.setIconImage(Toolkit.getDefaultToolkit().getImage(SensorGraph.class.getResource("/Images/monitor 40.png")));
		window.setBackground(new Color(44, 44, 44));
		window.setForeground(new Color(54, 33, 89));
		window.setTitle("Sensor Graph GUI");
		window.setBounds(40, 10, 1200, 675);
		window.getContentPane().setLayout(null);
		window.setUndecorated(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//**********************************************************ADDING MAIN-PANEL HERE******************************************************//
		
		Panel main_panel = new Panel();	
		main_panel.setBackground(new Color(49, 49, 49));
		main_panel.setBounds(0, 0, 1200, 676);
		window.getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		Panel title_panel = new Panel();
		title_panel.setBackground(new Color(110, 89, 222));
		title_panel.setBounds(0, 0, 1200, 60);
		main_panel.add(title_panel);
		title_panel.setLayout(null);
		
		title_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
			    posY=e.getY();
			}
		});
		title_panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				window.setLocation (e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});
		
		
		
		JLabel label = new JLabel("X");
		label.setBounds(1165, 0, 35, 31);
		title_panel.add(label);
		//************************************************************CLOSE BUTTON*****************************************************************//
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						 Component component = (Component) e.getSource();
					     JFrame win = (JFrame) SwingUtilities.getRoot(component);
					     win.dispose();
					}
				});
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Arial Black", Font.BOLD, 21));
				
				JLabel lblFieldMonitor = new JLabel(" Field Monitor");
				lblFieldMonitor.setIcon(new ImageIcon(SensorGraph.class.getResource("/Images/monitor 40.png")));
				lblFieldMonitor.setForeground(Color.WHITE);
				lblFieldMonitor.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
				lblFieldMonitor.setBounds(10, 9, 268, 44);
				title_panel.add(lblFieldMonitor);
		
				
		// create the line graph
		XYSeries series = new XYSeries("Temperature Readings");
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart("", "", "in degree celsi", dataset);
		ChartPanel chartpan = new ChartPanel(chart);
		chartpan.setBounds(0, 60, 596, 196);
		chartpan.setBackground(new Color(0, 171, 169));
		main_panel.add(chartpan);
		//window.add(new ChartPanel(chart), BorderLayout.CENTER);
		final XYPlot plot = chart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint( 0 , Color.RED);
		renderer.setSeriesStroke( 0 , new BasicStroke( 0.8f ) );
		plot.setRenderer( renderer );
		plot.setRangeGridlinesVisible(true);
		plot.setBackgroundPaint(new Color(0, 171, 169));
	    plot.setRangeGridlinePaint(Color.WHITE);
	    plot.setDomainGridlinesVisible(false);
	    plot.setDomainGridlinePaint(Color.WHITE);
	    
	    
	    XYSeries hum_series = new XYSeries("Humidity Readings");
		XYSeriesCollection hum_dataset = new XYSeriesCollection(hum_series);
		JFreeChart hum_chart = ChartFactory.createXYLineChart("", "", "in percentage(%)", hum_dataset);
		ChartPanel hum_chartpan = new ChartPanel(hum_chart);
		hum_chartpan.setBounds(602, 60, 598, 196);
		hum_chartpan.setBackground(new Color(0, 171, 169));
		main_panel.add(hum_chartpan);
		//window.add(new ChartPanel(chart), BorderLayout.CENTER);
		final XYPlot hum_plot = hum_chart.getXYPlot( );
		XYLineAndShapeRenderer hum_renderer = new XYLineAndShapeRenderer( );
		hum_renderer.setSeriesPaint( 0 , Color.RED);
		hum_renderer.setSeriesStroke( 0 , new BasicStroke( 0.8f ) );
		hum_plot.setRenderer( hum_renderer );
		hum_plot.setRangeGridlinesVisible(true);
		hum_plot.setBackgroundPaint(new Color(0, 171, 169));
		hum_plot.setRangeGridlinePaint(Color.WHITE);
		hum_plot.setDomainGridlinesVisible(false);
		hum_plot.setDomainGridlinePaint(Color.WHITE);
		
		
		 XYSeries moist_series = new XYSeries("Moisture Readings");
			XYSeriesCollection moist_dataset = new XYSeriesCollection(moist_series);
			JFreeChart moist_chart = ChartFactory.createXYLineChart("", "", "in percentage(%)", moist_dataset);
			ChartPanel moist_chartpan = new ChartPanel(moist_chart);
			moist_chartpan.setBounds(0, 262, 596, 197);
			moist_chartpan.setBackground(new Color(0, 171, 169));
			main_panel.add(moist_chartpan);
			//window.add(new ChartPanel(chart), BorderLayout.CENTER);
			final XYPlot moist_plot = moist_chart.getXYPlot( );
			XYLineAndShapeRenderer moist_renderer = new XYLineAndShapeRenderer( );
			moist_renderer.setSeriesPaint( 0 , Color.RED);
			moist_renderer.setSeriesStroke( 0 , new BasicStroke( 0.8f ) );
			moist_plot.setRenderer( moist_renderer );
			moist_plot.setRangeGridlinesVisible(true);
			moist_plot.setBackgroundPaint(new Color(0, 171, 169));
			moist_plot.setRangeGridlinePaint(Color.WHITE);
			moist_plot.setDomainGridlinesVisible(false);
			moist_plot.setDomainGridlinePaint(Color.WHITE);
			
			 XYSeries sun_series = new XYSeries("Sunlight Readings");
				XYSeriesCollection sun_dataset = new XYSeriesCollection(sun_series);
				JFreeChart sun_chart = ChartFactory.createXYLineChart("", "", "in luminous(lux)", sun_dataset);
				ChartPanel sun_chartpan = new ChartPanel(sun_chart);
				sun_chartpan.setBounds(602, 262, 598, 197);
				sun_chartpan.setBackground(new Color(0, 171, 169));
				main_panel.add(sun_chartpan);
				//window.add(new ChartPanel(chart), BorderLayout.CENTER);
				final XYPlot sun_plot = sun_chart.getXYPlot( );
				XYLineAndShapeRenderer sun_renderer = new XYLineAndShapeRenderer( );
				sun_renderer.setSeriesPaint( 0 , Color.RED);
				sun_renderer.setSeriesStroke( 0 , new BasicStroke( 0.8f ) );
				sun_plot.setRenderer( sun_renderer );
				sun_plot.setRangeGridlinesVisible(true);
				sun_plot.setBackgroundPaint(new Color(0, 171, 169));
				sun_plot.setRangeGridlinePaint(Color.WHITE);
				sun_plot.setDomainGridlinesVisible(false);
				sun_plot.setDomainGridlinePaint(Color.WHITE);
				
				 XYSeries air_series = new XYSeries("Air-Quality Readings");
					XYSeriesCollection air_dataset = new XYSeriesCollection(air_series);
					JFreeChart air_chart = ChartFactory.createXYLineChart("", "", "in percentage(%)", air_dataset);
					ChartPanel air_chartpan = new ChartPanel(air_chart);
					air_chartpan.setBounds(0, 465, 596, 212);
					air_chartpan.setBackground(new Color(0, 171, 169));
					main_panel.add(air_chartpan);
					//window.add(new ChartPanel(chart), BorderLayout.CENTER);
					final XYPlot air_plot = air_chart.getXYPlot( );
					XYLineAndShapeRenderer air_renderer = new XYLineAndShapeRenderer( );
					air_renderer.setSeriesPaint( 0 , Color.RED);
					air_renderer.setSeriesStroke( 0 , new BasicStroke( 0.8f ) );
					air_plot.setRenderer( air_renderer );
					air_plot.setRangeGridlinesVisible(true);
					air_plot.setBackgroundPaint(new Color(0, 171, 169));
					air_plot.setRangeGridlinePaint(Color.WHITE);
					air_plot.setDomainGridlinesVisible(false);
					air_plot.setDomainGridlinePaint(Color.WHITE);
	
				//***************************************************************SHOW DIGIT VALUE PANEL**************************************************//						
				Panel digits_panel = new Panel();
				digits_panel.setBackground(new Color(10, 10, 10));
				digits_panel.setBounds(595, 465, 285, 212);
				main_panel.add(digits_panel);
				digits_panel.setLayout(null);
				
				Panel panel_2 = new Panel();
				panel_2.setBackground(new Color(0, 171, 169));
				panel_2.setBounds(10, 10, 167, 42);
				digits_panel.add(panel_2);
				panel_2.setLayout(null);
				
				JLabel lblTemperature = new JLabel("  Temperature");
				lblTemperature.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
				lblTemperature.setForeground(new Color(255, 255, 255));
				lblTemperature.setBounds(0, 0, 167, 42);
				panel_2.add(lblTemperature);
				
				Panel panel_3 = new Panel();
				panel_3.setBackground(new Color(0, 171, 169));
				panel_3.setBounds(184, 10, 91, 42);
				digits_panel.add(panel_3);
				panel_3.setLayout(null);
				
				JLabel label_2 = new JLabel();
				label_2.setFont(new Font("Arial Black", Font.PLAIN, 22));
				label_2.setForeground(new Color(255, 255, 255));
				label_2.setBounds(10, 0, 81, 42);
				panel_3.add(label_2);
				
				JLabel lblc = new JLabel("Celc");
				lblc.setHorizontalAlignment(SwingConstants.CENTER);
				lblc.setForeground(Color.WHITE);
				lblc.setFont(new Font("Segoe UI", Font.ITALIC, 14));
				lblc.setBounds(58, 13, 33, 26);
				panel_3.add(lblc);
				
				Panel panel = new Panel();
				panel.setBackground(new Color(204, 102, 255));
				panel.setBounds(10, 58, 167, 42);
				digits_panel.add(panel);
				panel.setLayout(null);
				
				JLabel lblHumidity = new JLabel("  Humidity");
				lblHumidity.setForeground(Color.WHITE);
				lblHumidity.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
				lblHumidity.setBounds(0, 0, 167, 42);
				panel.add(lblHumidity);
				
				Panel panel_1 = new Panel();
				panel_1.setBackground(new Color(204, 102, 255));
				panel_1.setBounds(184, 58, 91, 42);
				digits_panel.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel label_4 = new JLabel();
				label_4.setBounds(10, 0, 81, 42);
				panel_1.add(label_4);
				label_4.setForeground(Color.WHITE);
				label_4.setFont(new Font("Arial Black", Font.PLAIN, 22));
				
				JLabel label_5 = new JLabel("%");
				label_5.setBounds(71, 13, 20, 26);
				panel_1.add(label_5);
				label_5.setForeground(Color.WHITE);
				label_5.setFont(new Font("Segoe UI", Font.ITALIC, 14));
				
				Panel panel_4 = new Panel();
				panel_4.setBackground(new Color(102, 153, 0));
				panel_4.setBounds(10, 106, 167, 42);
				digits_panel.add(panel_4);
				panel_4.setLayout(null);
				
				JLabel lblMoisture = new JLabel("  Moisture");
				lblMoisture.setForeground(Color.WHITE);
				lblMoisture.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
				lblMoisture.setBounds(0, 0, 167, 42);
				panel_4.add(lblMoisture);
				
				Panel panel_5 = new Panel();
				panel_5.setBackground(new Color(102, 153, 0));
				panel_5.setBounds(184, 106, 91, 42);
				digits_panel.add(panel_5);
				panel_5.setLayout(null);
				
				JLabel label_8 = new JLabel("%");
				label_8.setBounds(70, 11, 21, 26);
				panel_5.add(label_8);
				label_8.setForeground(Color.WHITE);
				label_8.setFont(new Font("Segoe UI", Font.ITALIC, 14));
				
				JLabel label_7 = new JLabel();
				label_7.setBounds(10, -2, 81, 42);
				panel_5.add(label_7);
				label_7.setForeground(Color.WHITE);
				label_7.setFont(new Font("Arial Black", Font.PLAIN, 22));
				
				Panel panel_6 = new Panel();
				panel_6.setBackground(new Color(51, 204, 153));
				panel_6.setBounds(10, 154, 167, 42);
				digits_panel.add(panel_6);
				panel_6.setLayout(null);
				
				JLabel lblAirQuality = new JLabel("  Air Quality");
				lblAirQuality.setForeground(Color.WHITE);
				lblAirQuality.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
				lblAirQuality.setBounds(0, 0, 167, 42);
				panel_6.add(lblAirQuality);
				
				Panel panel_7 = new Panel();
				panel_7.setBackground(new Color(51, 204, 153));
				panel_7.setBounds(184, 154, 91, 42);
				digits_panel.add(panel_7);
				panel_7.setLayout(null);
				
				JLabel label_11 = new JLabel("%");
				label_11.setBounds(71, 11, 20, 26);
				panel_7.add(label_11);
				label_11.setForeground(Color.WHITE);
				label_11.setFont(new Font("Segoe UI", Font.ITALIC, 14));
				
				JLabel label_10 = new JLabel();
				label_10.setBounds(10, -2, 81, 42);
				panel_7.add(label_10);
				label_10.setForeground(Color.WHITE);
				label_10.setFont(new Font("Arial Black", Font.PLAIN, 22));
				
		//*******************************************************TABLE VALUE PANEL*********************************************//
				
				Panel table_panel = new Panel();
				table_panel.setFont(new Font("Consolas", Font.ITALIC, 18));
				table_panel.setBackground(new Color(10, 10, 10));
				table_panel.setBounds(803, 464, 397, 212);
				main_panel.add(table_panel);
				table_panel.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(78, 0, 319, 212);
				table_panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setForeground(new Color(255, 255, 255));
				table.setBackground(new Color(10, 10, 10));
			
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
					String sql = "SELECT temperature AS Tempe, humidity AS Humid, moisture AS Moist, air_quality AS Air, sunlight AS SunL from sensor_readings ORDER BY id DESC";
					ResultSet rs = stmt.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					conn.close();
					sleep(5000);
					
				}catch(Exception e) {
					
				}
						}
					}
				};
				t.start();
				
				
//**************************************************************************************************************************************//
	    
					Thread thread = new Thread(){
						@Override public void run() {
							for(;;) {
							try {
							Connection conn2 = null;
							String url = "jdbc:mysql://localhost:3306/";
							String dbName = "modagrospark";
							String driver = "com.mysql.cj.jdbc.Driver";
							String userName = "root";
							String password = "lagad@11";
							Class.forName(driver).newInstance();
							conn2 = DriverManager.getConnection(url+dbName,userName,password);
							
							Statement stmt = conn2.createStatement();
							String sql = "SELECT * FROM( SELECT id, temperature, humidity, moisture, air_quality, sunlight FROM sensor_readings ORDER BY id DESC LIMIT 10 ) sub ORDER BY id ASC";
							ResultSet rs = stmt.executeQuery(sql);
						
							Float temp, hum, moist, sunl;
							int ids, air_q;
							
							while (rs.next()) {
								ids = Integer.parseInt(rs.getString(1));
								temp = Float.parseFloat(rs.getString(2));
								hum = Float.parseFloat(rs.getString(3));
								moist = Float.parseFloat(rs.getString(4));
								air_q = Integer.parseInt(rs.getString(5));
								sunl = Float.parseFloat(rs.getString(6));
								
								label_2.setText(Float.toString(temp));
								label_4.setText(Float.toString(hum));
								label_7.setText(Float.toString(moist));
								label_10.setText(Float.toString(air_q));
								
								series.add(ids, temp);
								hum_series.add(ids, hum);
								moist_series.add(ids, moist);
								air_series.add(ids, air_q);
								sun_series.add(ids, sunl);
							}
							conn2.close();
							sleep(8000);
							
							}catch(Exception err) {
								
							}
					
						}
						}
					};
					thread.start();
			
		
		
		// show the window
		window.setVisible(true);
	}
}
