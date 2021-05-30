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
import javax.swing.JTextField;
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
public class fieldsettingWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txt_fieldsize;
	private JTextField txt_dateofcultivation;
	private JTextField txt_crop;
	private JTextField txt_cropvariety;

	static int x=0;
	static int posX=0;
	static int posY=0;
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fieldsettingWindow frame = new fieldsettingWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public fieldsettingWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(fieldsettingWindow.class.getResource("/Images/setting.png")));
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
		
		JLabel lblName = new JLabel("Field Size : (in Hects)");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(210, 31, 169, 14);
		panel.add(lblName);
		
		JLabel lblCity = new JLabel("Soil Type :");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblCity.setBackground(Color.WHITE);
		lblCity.setBounds(210, 101, 82, 14);
		panel.add(lblCity);
		
		JLabel lblLocation = new JLabel("Crop :");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblLocation.setBackground(Color.WHITE);
		lblLocation.setBounds(210, 243, 94, 14);
		panel.add(lblLocation);
		
		JLabel lblState = new JLabel("Crop Type :");
		lblState.setForeground(Color.WHITE);
		lblState.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblState.setBackground(Color.WHITE);
		lblState.setBounds(210, 171, 129, 14);
		panel.add(lblState);
		
		JLabel lblPin = new JLabel("Variety of Crop :");
		lblPin.setForeground(Color.WHITE);
		lblPin.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblPin.setBackground(Color.WHITE);
		lblPin.setBounds(564, 243, 129, 14);
		panel.add(lblPin);
		
		JLabel lblEmail = new JLabel("Type of Irrigation :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(564, 101, 201, 14);
		panel.add(lblEmail);
		
		JLabel lblMobileNo = new JLabel("Date of Cultivation :");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblMobileNo.setBackground(Color.WHITE);
		lblMobileNo.setBounds(210, 313, 169, 14);
		panel.add(lblMobileNo);
		
		txt_fieldsize = new JTextField();
		txt_fieldsize.setHorizontalAlignment(SwingConstants.CENTER);
		txt_fieldsize.setForeground(Color.WHITE);
		txt_fieldsize.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_fieldsize.setColumns(10);
		txt_fieldsize.setBackground(new Color(85, 65, 118));
		txt_fieldsize.setBounds(210, 56, 635, 34);
		panel.add(txt_fieldsize);
		
		txt_dateofcultivation = new JTextField();
		txt_dateofcultivation.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dateofcultivation.setForeground(Color.WHITE);
		txt_dateofcultivation.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_dateofcultivation.setColumns(10);
		txt_dateofcultivation.setBackground(new Color(85, 65, 118));
		txt_dateofcultivation.setBounds(210, 338, 281, 34);
		panel.add(txt_dateofcultivation);
		
		txt_crop = new JTextField();
		txt_crop.setHorizontalAlignment(SwingConstants.CENTER);
		txt_crop.setForeground(Color.WHITE);
		txt_crop.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_crop.setColumns(10);
		txt_crop.setBackground(new Color(85, 65, 118));
		txt_crop.setBounds(210, 268, 281, 34);
		panel.add(txt_crop);
		
		txt_cropvariety = new JTextField();
		txt_cropvariety.setHorizontalAlignment(SwingConstants.CENTER);
		txt_cropvariety.setForeground(Color.WHITE);
		txt_cropvariety.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_cropvariety.setColumns(10);
		txt_cropvariety.setBackground(new Color(85, 65, 118));
		txt_cropvariety.setBounds(564, 268, 281, 34);
		panel.add(txt_cropvariety);
		
		JComboBox txt_irrigation = new JComboBox();
		txt_irrigation.setModel(new DefaultComboBoxModel(new String[] {"Surface Irrigation", "Drip Irrigation", "Sprinkler Irrigation", "Sub-Irrigation", "Center Pivote Irrigation"}));
		txt_irrigation.setForeground(Color.WHITE);
		txt_irrigation.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_irrigation.setBackground(new Color(54, 33, 89));
		txt_irrigation.setBounds(564, 126, 281, 36);
		panel.add(txt_irrigation);
		
		JComboBox txt_croptype = new JComboBox();
		txt_croptype.setModel(new DefaultComboBoxModel(new String[] {"Grains", "Pulses", "Fruit Plants", "Fruit vegetables", "Leafy vegetables", "Flowering Plants"}));
		txt_croptype.setForeground(Color.WHITE);
		txt_croptype.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_croptype.setBackground(new Color(54, 33, 89));
		txt_croptype.setBounds(210, 196, 281, 36);
		panel.add(txt_croptype);
		
		JComboBox txt_soiltype = new JComboBox();
		txt_soiltype.setModel(new DefaultComboBoxModel(new String[] {"Sandy Soil", "Clay Soil", "Red Soil", "Peat Soil", "Silt Soil", "Chalk Soil", "Loam Soil"}));
		txt_soiltype.setForeground(Color.WHITE);
		txt_soiltype.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		txt_soiltype.setBackground(new Color(54, 33, 89));
		txt_soiltype.setBounds(210, 126, 281, 36);
		panel.add(txt_soiltype);
		
//**************************************************UPDATE DATABASE BUTTON*******************************************************//
		
		JLabel update_button = new JLabel("Update Settings");
		update_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					
						Connection conn = null;
						String url = "jdbc:mysql://localhost:3306/";
						String dbName = "modagrospark";
						String driver = "com.mysql.cj.jdbc.Driver";
						String userName = "root";
						String password = "lagad@11";
						Class.forName(driver).newInstance();
						conn = DriverManager.getConnection(url+dbName,userName,password);
					
					
						PreparedStatement ps=conn.prepareStatement("UPDATE field_setting set field_size =?, soil_type =?, irrigation =?, crop_type =?, crop_name =?, crop_variety =?, date_of_cultivation =? WHERE id = 1");
						
						
					
						ps.setString(1, txt_fieldsize.getText());
						ps.setString(2, (String) txt_soiltype.getSelectedItem());
						ps.setString(3, (String) txt_irrigation.getSelectedItem());
						ps.setString(4, (String) txt_croptype.getSelectedItem());
						ps.setString(5, txt_crop.getText());
						ps.setString(6, txt_cropvariety.getText());
						ps.setString(7, txt_dateofcultivation.getText());
					
						ps.executeUpdate();
						
						conn.close();
						
						
						JOptionPane.showMessageDialog(null,
								"Settings updated successfully..!");
						
				
					}catch(Exception e1) {
						
						JOptionPane.showMessageDialog(null,
								"Something wents wrong..! Try again later");
						
					}
				
			}
		});
		
//***********************************************************************************************************************************//
		update_button.setBackground(new Color(85, 65, 118));
		update_button.setHorizontalAlignment(SwingConstants.CENTER);
		update_button.setForeground(Color.WHITE);
		update_button.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		update_button.setBorder(new LineBorder(new Color(255, 255, 255)));
		update_button.setBounds(210, 439, 349, 34);
		panel.add(update_button);
		
		JLabel cancel_button = new JLabel("Close");
		cancel_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Component component = (Component) e.getSource();
			     JFrame win = (JFrame) SwingUtilities.getRoot(component);
			     win.dispose();
				
			}
		});
		cancel_button.setHorizontalAlignment(SwingConstants.CENTER);
		cancel_button.setForeground(Color.WHITE);
		cancel_button.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		cancel_button.setBorder(new LineBorder(new Color(255, 255, 255)));
		cancel_button.setBounds(588, 439, 257, 34);
		panel.add(cancel_button);

//*********************************************************************SHOW DATA FROM DATABASE******************************************************//
		try {
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "modagrospark";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "lagad@11";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			
			String sql = "SELECT * from field_setting WHERE id = 1";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
		
			if(rs.next()) {
				txt_fieldsize.setText(rs.getString(2));
				txt_soiltype.setSelectedItem((rs.getString(3)));
				txt_irrigation.setSelectedItem((rs.getString(4)));
				txt_croptype.setSelectedItem((rs.getString(5)));
				txt_crop.setText(rs.getString(6));
				txt_cropvariety.setText(rs.getString(7));
				txt_dateofcultivation.setText(rs.getString(8));
				
			}
	
			conn.close();
		}catch(Exception err) {
			  
			JOptionPane.showMessageDialog(null,
					"Something wents wrong, Try again later..!!");
			
		}
//*******************************************************************************************************************************//
		
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
		
		JLabel lblMyProfile = new JLabel("Field Setting");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblMyProfile.setBounds(428, 0, 211, 58);
		panel_1.add(lblMyProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(fieldsettingWindow.class.getResource("/Images/sensor setting alert 40.png")));
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
	}
}
