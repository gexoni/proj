package app;
import java.sql.*;

import gui.main.form.MainFrame;

import javax.swing.UIManager;
import javax.swing.*;
public class Application {
	static Connection connect = null;
	public static void main (String[] args){
		UIManager.put("OptionPane.yesButtonText", "Yes");
		UIManager.put("OptionPane.noButtonText", "No");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		
		MainFrame.getInstance().setVisible(true);
		
		connect = SqliteConnection.dbConnector();
		
		try{
			String querry = "SELECT ContactName from WaterData where CountryRegion = 'Spain'";
			PreparedStatement pst = connect.prepareStatement(querry);
			ResultSet rs= pst.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
				
			
		} 
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
}
