package app;
import java.sql.*;
import javax.swing.*;
public class SqliteConnection {
	
	Connection conn = null;
	
	public static Connection dbConnector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Dragan\\Desktop\\res\\clientdb.sqlite");
			System.out.println("USPESNA KONEKCIJA");
			return conn;
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	
}
