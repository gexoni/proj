package table.model;

import help.classes.SortUtils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import app.SqliteConnection;;

public class KlijentTableModel extends DefaultTableModel {

	private String basicQuery = "SELECT CompanyName , ContactName , Address , "
			+ "City, CountryRegion , ContactTitle, PhoneNumber, "
			+ "Email, Comments, NextActivity FROM WaterData ";
	private String orderBy = " ORDER BY CompanyName";
	private String whereStmt = "";
	public KlijentTableModel(Object[] colNames, int rowCount) {
		
		super(colNames, rowCount);
	}
//Otvaranje upita
public void open() throws SQLException {
	fillData(basicQuery + whereStmt + orderBy);
}

private void fillData(String sql) throws SQLException {
	//PROVERA I OZNAKA DATUMA ZA AKTIVNOSTI
	setRowCount(0);
	Statement stmt = SqliteConnection.dbConnector().createStatement();
	ResultSet rset = stmt.executeQuery(sql);
	while (rset.next()) {
		
	String CompName = rset.getString("CompanyName");
	String naziv = rset.getString("ContactName");
	String naziv2 = rset.getString("Address");
	String naziv3 = rset.getString("City");
	String naziv4 = rset.getString("CountryRegion");
	String naziv5 = rset.getString("ContactTitle");
	String naziv6 = rset.getString("PhoneNumber");
	String naziv7 = rset.getString("Email");
	String naziv8 = rset.getString("Comments");
	String naziv9 = rset.getString("NextActivity");
//	System.out.println(CompName + "-----"+ naziv  + "-----"+  naziv2  + "-----"+  naziv3 + "-----"+  naziv4 + "-----"+ naziv5 + "-----"+  naziv6 + "-----"+  naziv7 + "-----"+  naziv8 + "-----"+  naziv9);
	addRow(new String[]{CompName, naziv ,naziv2 ,naziv3 ,naziv4,naziv5,naziv6,naziv7,naziv8,naziv9});
	
	}
	
	rset.close();
	stmt.close();
	fireTableDataChanged();
	
	
	
	}
public int insertRow(String CompName, String naziv, String naziv1, String naziv2,
		String naziv3, String naziv4, String naziv5, String naziv6,String naziv7, String naziv8)  throws SQLException {
	// TODO Auto-generated method stub
	int retVal = 0;
	PreparedStatement stmt =
	SqliteConnection.dbConnector().prepareStatement(
	"INSERT INTO WaterData (CompanyName, ContactName, Address, City, CountryRegion, ContactTitle, PhoneNumber, Email, Comments, NextActivity) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,?, ?)");
	stmt.setString(1, CompName);
	stmt.setString(2, naziv);
	stmt.setString(3, naziv1);
	stmt.setString(4, naziv2);
	stmt.setString(5, naziv3);	
	stmt.setString(6, naziv4);
	stmt.setString(7, naziv5);
	stmt.setString(8, naziv6);
	stmt.setString(9, naziv7);
	stmt.setString(10, naziv8);
	int rowsAffected = stmt.executeUpdate();
	stmt.close();
	//Unos sloga u bazu
	SqliteConnection.dbConnector().commit();
	if (rowsAffected > 0) {
	// i unos u TableModel
	retVal = sortedInsert(CompName,naziv,naziv1,naziv2,naziv3,naziv4,naziv5,naziv6,naziv7,naziv8);
	fireTableDataChanged();
	}
	return retVal;
}


private int sortedInsert(String CompName, String naziv, String naziv1, String naziv2,
		String naziv3, String naziv4, String naziv5, String naziv6,String naziv7, String naziv8) {
	int left = 0;
	int right = getRowCount() - 1;
	int mid = (left + right) / 2;
	while (left <= right ) {
	mid = (left + right) / 2;
	String aSifra = (String)getValueAt(mid, 0);
	if (SortUtils.getLatCyrCollator().compare(CompName, aSifra) > 0)
	left = mid + 1;
	else if (SortUtils.getLatCyrCollator().compare(CompName, aSifra) < 0)
	right = mid - 1;
	else
	// ako su jednaki: to ne moze da se desi ako tabela ima primarni kljuc
	break;
	}
	insertRow(left, new String[] {CompName, naziv,naziv1, naziv2,naziv3,naziv4,naziv5,naziv6,naziv7,naziv8});
	return left;
	}


public void deleteRow(int index) throws SQLException {
	PreparedStatement stmt =
	SqliteConnection.dbConnector().prepareStatement(
	"DELETE FROM WaterData WHERE CompanyName=?");
	String sifra = (String)getValueAt(index, 0);
	stmt.setString(1, sifra);
	//Brisanje iz baze
	int rowsAffected = stmt.executeUpdate();
	stmt.close();
	SqliteConnection.dbConnector().commit();
	if (rowsAffected > 0) {
	// i brisanje iz TableModel-a
	removeRow(index);
	fireTableDataChanged();
	}
	}

	public int updateRow(String CompName, String naziv, String naziv1, String naziv2,
			String naziv3, String naziv4, String naziv5,String naziv6,String naziv7, String naziv8, int index ) throws SQLException {
	int retVal = 0;
	PreparedStatement stmt =	SqliteConnection.dbConnector().prepareStatement(
			"UPDATE WaterData SET ContactName = ? , Address = ? , City = ? , Country/Region = ? , ContactTitle = ? , PhoneNumber = ? , E-Mail = ?, Comments=? , NextActivity=?"
					+ " WHERE CompanyName=?");
	stmt.setString(0, CompName);
	stmt.setString(1, naziv);
	stmt.setString(2, naziv1);
	stmt.setString(3, naziv2);
	stmt.setString(4, naziv3);
	stmt.setString(5, naziv4);
	stmt.setString(6, naziv5);
	stmt.setString(7, naziv6);
	stmt.setString(8, naziv7);
	stmt.setDate(9, Date.valueOf(naziv8));
			//Unos sloga u bazu
	int rowsAffected = stmt.executeUpdate();
	stmt.close();
	//Unos sloga u bazu
	SqliteConnection.dbConnector().commit();
	
	if (rowsAffected > 0) {
		// i unos u TableModel
		removeRow(index);
		retVal = sortedInsert(CompName,naziv,naziv1,naziv2,naziv3,naziv4,naziv5,naziv6,naziv7, naziv8 );
		fireTableDataChanged();
		}
	
		return retVal;
	}

	public void search(String where) throws SQLException{
		String basic ="SELECT CompanyName, ContactName, Address, City, CountryRegion, ContactTitle, PhoneNumber, Email, Comments, NextActivity FROM WaterData";
		String order = "";
		fillData(basic+order+where);
	}

	public void activitySearch(String where)throws SQLException{
		
	
	}
	
	
	
	
}