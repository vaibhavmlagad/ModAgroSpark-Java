import java.util.Calendar;
import java.util.Random;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class random_generator {

	@SuppressWarnings("deprecation")
	public static void main(String [] args) {
	//public static void main() {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				
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
					//System.out.println("Connected to the database");
					
					
					float temp, hum, moist, sunl, h_index;
					int air;
					
					String sta_temp, sta_hum, sta_moist, sta_air, sta_heat;
					int val_temp, val_hum, val_moist, val_air, val_heat;
					
		//*********************************************GENERATION OF VALUES******************************************************//			
					Random sam = new Random();
					temp = sam.nextInt(3)+29;  //(minimum 35 to 29+3)
					hum = sam.nextInt(5)+36;
					moist = sam.nextInt(3)+10;
					air = sam.nextInt(8)+69;
					sunl = sam.nextInt(8)+65;
					h_index = sam.nextInt(2)+23;
					
		//**********************************************INSERTING IN DATABASE********************************************************//
					
					java.util.Date date=new java.util.Date();
					
					java.sql.Date sqlDate=new java.sql.Date(date.getTime());
					PreparedStatement ps=conn.prepareStatement("insert into sensor_readings values(?,?,?,?,?,?,?,?)");
					Statement stmt = conn.createStatement();
					
					String sql = "SELECT MAX(id) from sensor_readings";
					ResultSet rs = stmt.executeQuery(sql);
					int max_id = 0;
					while (rs.next()) {
						max_id = rs.getInt(1);
					}
					
					ps.setInt(1, (max_id + 1));
					ps.setDate(2, sqlDate);
					ps.setFloat(3, temp);
					ps.setFloat(4, hum);
					ps.setFloat(5, moist);
					ps.setInt(6, air);
					ps.setFloat(7, sunl);
					ps.setFloat(8, h_index);
					
					ps.executeUpdate();
				
//*********************************************CUTRRENT DATE AND TIME***************************************************************//
					
					java.util.Date current_date = Calendar.getInstance().getTime();
					DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy"); 
					DateFormat dateFormat2 = new SimpleDateFormat("hh:mm a");
					String now_date = dateFormat1.format(current_date);
					String now_time = dateFormat2.format(current_date);
					
//***********************************************ALERT GENERATION FOR TEMPERATURE**************************************************//
					
					if((temp<7) || (temp>40 && temp<=50) || (temp>50)) {
						
						sta_temp = null;
						if(temp<7) {
							sta_temp = "Low";
						}else if(temp>40 && temp<=50) {
							sta_temp = "High";
						}else if(temp>50) {
							sta_temp = "Very High";
						}
						
						val_temp = (int)temp; 
						
						PreparedStatement ps2=conn.prepareStatement("insert into sensor_alerts (date, time, parameter, value, status) values(?,?,?,?,?)");
					
						ps2.setString(1, now_date);
						ps2.setString(2, now_time);
						ps2.setString(3, "Temperature");
						ps2.setString(4, Integer.toString(val_temp));
						ps2.setString(5, sta_temp);
					
						ps2.executeUpdate();
					
					}
					
//*******************************************ALERT GENERATION FOR HUMIDITY***************************************************//
					
					if((hum<15) || (hum>70 && hum<=80) || (hum>80)) {
						
						sta_hum = null;
						if(hum<15) {
							sta_hum = "Low";
						}else if(hum>70 && hum<=80) {
							sta_hum = "High";
						}else if(hum>80) {
							sta_hum = "Very High";
						}
						
						val_hum = (int)hum; 
						
						PreparedStatement ps3=conn.prepareStatement("insert into sensor_alerts (date, time, parameter, value, status) values(?,?,?,?,?)");
					
						ps3.setString(1, now_date);
						ps3.setString(2, now_time);
						ps3.setString(3, "Humidity");
						ps3.setString(4, Integer.toString(val_hum));
						ps3.setString(5, sta_hum);
					
						ps3.executeUpdate();
					
					}
					
//*********************************************ALERT GENERATION FOR MOISTURE*********************************************************//
					
					if((moist<10) || (moist>75 && moist<=80) || (moist>80)) {
						
						sta_moist = null;
						if(moist<10) {
							sta_moist = "Low";
						}else if(moist>75 && moist<=80) {
							sta_moist = "High";
						}else if(moist>80) {
							sta_moist = "Very High";
						}
						
						val_moist = (int)moist; 
						
						PreparedStatement ps4=conn.prepareStatement("insert into sensor_alerts (date, time, parameter, value, status) values(?,?,?,?,?)");
					
						ps4.setString(1, now_date);
						ps4.setString(2, now_time);
						ps4.setString(3, "Moisture");
						ps4.setString(4, Integer.toString(val_moist));
						ps4.setString(5, sta_moist);
					
						ps4.executeUpdate();
					
					}

//****************************************************ALERT GENERATION FOR HEAT INDEX********************************************//
					
					if((h_index<7) || (h_index>50 && h_index<=60) || (h_index>60)) {
						
						sta_heat = null;
						if(h_index<7) {
							sta_heat = "Low";
						}else if(h_index>50 && h_index<=60) {
							sta_heat = "High";
						}else if(h_index>60) {
							sta_heat = "Very High";
						}
						
						val_heat = (int)h_index; 
						
						PreparedStatement ps5=conn.prepareStatement("insert into sensor_alerts (date, time, parameter, value, status) values(?,?,?,?,?)");
					
						ps5.setString(1, now_date);
						ps5.setString(2, now_time);
						ps5.setString(3, "Heat Index");
						ps5.setString(4, Integer.toString(val_heat));
						ps5.setString(5, sta_heat);
					
						ps5.executeUpdate();
					
					}
					
//***************************************************ALERT GENERATION FOR AIR QUALITY**********************************************//
					
					if((air<=20) || (air>20 && air<40)) {
						
						sta_air = null;
						if(air<=20) {
							sta_air = "Highly Polluted";
						}else if(air>20 && air<40) {
							sta_air = "Polluted";
						}
						val_air = air; 
						
						PreparedStatement ps6=conn.prepareStatement("insert into sensor_alerts (date, time, parameter, value, status) values(?,?,?,?,?)");
					
						ps6.setString(1, now_date);
						ps6.setString(2, now_time);
						ps6.setString(3, "Air Quality");
						ps6.setString(4, Integer.toString(val_air));
						ps6.setString(5, sta_air);
					
						ps6.executeUpdate();
					
					}
//************************************************************************************************************************************//
					
					conn.close();
					sleep(8000);
					
				}catch(Exception e) {
					
					System.out.println(e);
				}
				
				}
				
				
			}
		};
		t.start();
		

	}

}
