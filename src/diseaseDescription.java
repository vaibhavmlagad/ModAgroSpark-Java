import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;

public class diseaseDescription extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	static String disease_name;
	
	static int x=0;
	static int posX=0;
	static int posY=0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		disease_name=args[0];
		
		try {
			diseaseDescription dialog = new diseaseDescription();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("deprecation")
	public diseaseDescription() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(diseaseDescription.class.getResource("/Images/news 40.png")));
		
		setUndecorated(true);
		setBounds(100, 100, 652, 402);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
			}
		});
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				Component component = (Component) e.getSource();
				JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
			     //dialog.dispose();
				dialog.setLocation(e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});
		contentPanel.setBackground(new Color(110, 89, 222));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54, 33, 89));
		panel.setBounds(10, 11, 632, 347);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDiseaseName = new JLabel("Disease Name :");
		lblDiseaseName.setForeground(Color.WHITE);
		lblDiseaseName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblDiseaseName.setBounds(28, 11, 121, 34);
		panel.add(lblDiseaseName);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblType.setBounds(332, 11, 121, 34);
		panel.add(lblType);
		
		JLabel lblPossibleRanges = new JLabel("Possible Ranges");
		lblPossibleRanges.setForeground(Color.WHITE);
		lblPossibleRanges.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 14));
		lblPossibleRanges.setBounds(28, 56, 121, 34);
		panel.add(lblPossibleRanges);
		
		JLabel lblTemperature = new JLabel("Temperature :");
		lblTemperature.setForeground(Color.WHITE);
		lblTemperature.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblTemperature.setBounds(28, 80, 103, 34);
		panel.add(lblTemperature);
		
		JLabel lblPlantsAffected = new JLabel("Plants Affected :");
		lblPlantsAffected.setForeground(Color.WHITE);
		lblPlantsAffected.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblPlantsAffected.setBounds(10, 170, 142, 34);
		panel.add(lblPlantsAffected);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 14));
		lblFrom.setBounds(220, 56, 121, 34);
		panel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 14));
		lblTo.setBounds(415, 56, 121, 34);
		panel.add(lblTo);
		
		JLabel lblHumidity = new JLabel("Humidity :");
		lblHumidity.setForeground(Color.WHITE);
		lblHumidity.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblHumidity.setBounds(28, 104, 103, 34);
		panel.add(lblHumidity);
		
		JLabel lblMoisture = new JLabel("Moisture :");
		lblMoisture.setForeground(Color.WHITE);
		lblMoisture.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblMoisture.setBounds(28, 125, 103, 34);
		panel.add(lblMoisture);
		
		JLabel label_3 = new JLabel();
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		label_3.setBounds(190, 80, 103, 34);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel();
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		label_4.setBounds(190, 104, 103, 34);
		panel.add(label_4);
		
		JLabel label_6 = new JLabel();
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		label_6.setBounds(190, 125, 103, 34);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel();
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		label_7.setBounds(380, 80, 103, 34);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel();
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		label_8.setBounds(380, 104, 103, 34);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel();
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		label_9.setBounds(380, 125, 103, 34);
		panel.add(label_9);
		
		JLabel lblSymptoms = new JLabel("Symptoms :");
		lblSymptoms.setForeground(Color.WHITE);
		lblSymptoms.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblSymptoms.setBounds(209, 170, 142, 34);
		panel.add(lblSymptoms);
		
		JLabel lblPreventions = new JLabel("Preventions :");
		lblPreventions.setForeground(Color.WHITE);
		lblPreventions.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblPreventions.setBounds(432, 170, 142, 34);
		panel.add(lblPreventions);
		
		JLabel lblTemperature_1 = new JLabel();
		lblTemperature_1.setForeground(Color.WHITE);
		lblTemperature_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTemperature_1.setBounds(148, 11, 181, 34);
		panel.add(lblTemperature_1);
		
		JLabel lblTemperature_2 = new JLabel();
		lblTemperature_2.setForeground(Color.WHITE);
		lblTemperature_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTemperature_2.setBounds(392, 11, 230, 34);
		panel.add(lblTemperature_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText((String) null);
		textArea.setTabSize(2);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBackground(new Color(54, 33, 89));
		textArea.setBounds(10, 201, 181, 135);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText((String) null);
		textArea_1.setTabSize(2);
		textArea_1.setLineWrap(true);
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(54, 33, 89));
		textArea_1.setBounds(209, 201, 202, 135);
		panel.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		textArea_2.setText((String) null);
		textArea_2.setTabSize(2);
		textArea_2.setLineWrap(true);
		textArea_2.setForeground(Color.WHITE);
		textArea_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textArea_2.setEditable(false);
		textArea_2.setBackground(new Color(54, 33, 89));
		textArea_2.setBounds(432, 201, 190, 135);
		panel.add(textArea_2);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(423, 201, 19, 135);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(200, 201, 19, 135);
		panel.add(separator_1);
		
		JLabel label = new JLabel("Close");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Component component = (Component) e.getSource();
				 JDialog win = (JDialog) SwingUtilities.getRoot(component);
			     win.dispose();
				
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(54, 33, 89));
		label.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		label.setBorder(new LineBorder(new Color(255, 255, 255)));
		label.setBounds(511, 369, 131, 26);
		contentPanel.add(label);
		
		JLabel lblOk = new JLabel("Ok");
		lblOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Component component = (Component) e.getSource();
				 JDialog win = (JDialog) SwingUtilities.getRoot(component);
			     win.dispose();
				
			}
		});
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setForeground(new Color(54, 33, 89));
		lblOk.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblOk.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblOk.setBounds(418, 369, 83, 26);
		contentPanel.add(lblOk);
		
		
//***********************************************FETCHING DATA FROM TABLE************************************************************//
		
		try {
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "modagrospark";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "lagad@11";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
	
			String sql = "SELECT * from diseases where disease_name = ?";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setString(1, disease_name);
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				lblTemperature_1.setText(rs.getString(2));
				lblTemperature_2.setText(rs.getString(3));
				label_3.setText(rs.getString(4));
				label_7.setText(rs.getString(5));
				label_4.setText(rs.getString(6));
				label_8.setText(rs.getString(7));
				label_6.setText(rs.getString(8));
				label_9.setText(rs.getString(9));
				textArea.setText(rs.getString(10));
				textArea_1.setText(rs.getString(11));
				textArea_2.setText(rs.getString(12));
			
				
			}
	
			conn.close();
		}catch(Exception err) {
			  
			JOptionPane.showMessageDialog(null,
					"Something wents wrong, Try again later..!!");
			
		}
		
	}
}
