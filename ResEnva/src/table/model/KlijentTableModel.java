package table.model;

import help.classes.SortUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import database.DBConnection;

public class KlijentTableModel extends DefaultTableModel {

	private String basicQuery = "SELECT K_PIB, K_NAZIV, K_ADRESA, K_EMAIL, K_WEB, K_TELEFON, K_FAX, K_FIZICKO_LICE_ FROM KLIJENT";
	private String orderBy = " ORDER BY K_PIB";
	private String whereStmt = "";
	public KlijentTableModel(Object[] colNames, int rowCount) {
		super(colNames, rowCount);
	}
//Otvaranje upita
public void open() throws SQLException {
	fillData(basicQuery + whereStmt + orderBy);
}

private void fillData(String sql) throws SQLException {
	setRowCount(0);
	Statement stmt = DBConnection.getConnection().createStatement();
	ResultSet rset = stmt.executeQuery(sql);
	while (rset.next()) {
	String sifra = rset.getString("K_PIB");
	String naziv = rset.getString("K_NAZIV");
	String naziv2 = rset.getString("K_ADRESA");
	String naziv3 = rset.getString("K_EMAIL");
	String naziv4 = rset.getString("K_WEB");
	String naziv5 = rset.getString("K_TELEFON");
	String naziv6 = rset.getString("K_FAX");
	String naziv7 = rset.getString("K_FIZICKO_LICE_");
	String fizicko = "";
	if(naziv7.equals("0"))
		fizicko = "Ne";
	else
		fizicko = "Da";
	addRow(new String[]{sifra, naziv,naziv2,naziv3,naziv4,naziv5,naziv6,fizicko});
	}
	rset.close();
	stmt.close();
	fireTableDataChanged();
	}
public int insertRow(String sifra, String naziv, String naziv1, String naziv2,
		String naziv3, String naziv4, String naziv5, String naziv6)  throws SQLException {
	// TODO Auto-generated method stub
	int retVal = 0;
	PreparedStatement stmt =
	DBConnection.getConnection().prepareStatement(
	"INSERT INTO KLIJENT (K_PIB, K_NAZIV, K_ADRESA, K_EMAIL, K_WEB, K_TELEFON, K_FAX, K_FIZICKO_LICE_) VALUES (? ,? ,? ,? ,? ,? ,? ,?)");
	stmt.setString(1, sifra);
	stmt.setString(2, naziv);
	stmt.setString(3, naziv1);
	stmt.setString(4, naziv2);
	stmt.setString(5, naziv3);	
	stmt.setString(6, naziv4);
	stmt.setString(7, naziv5);
	if(naziv6.equals("Da"))
		stmt.setBoolean(8, true);
	else
		stmt.setBoolean(8, false);
	int rowsAffected = stmt.executeUpdate();
	stmt.close();
	//Unos sloga u bazu
	DBConnection.getConnection().commit();
	if (rowsAffected > 0) {
	// i unos u TableModel
	retVal = sortedInsert(sifra,naziv,naziv1,naziv2,naziv3,naziv4,naziv5,naziv6);
	fireTableDataChanged();
	}
	return retVal;
}


private int sortedInsert(String sifra, String naziv, String naziv1, String naziv2,
		String naziv3, String naziv4, String naziv5, String naziv6) {
	int left = 0;
	int right = getRowCount() - 1;
	int mid = (left + right) / 2;
	while (left <= right ) {
	mid = (left + right) / 2;
	String aSifra = (String)getValueAt(mid, 0);
	if (SortUtils.getLatCyrCollator().compare(sifra, aSifra) > 0)
	left = mid + 1;
	else if (SortUtils.getLatCyrCollator().compare(sifra, aSifra) < 0)
	right = mid - 1;
	else
	// ako su jednaki: to ne moze da se desi ako tabela ima primarni kljuc
	break;
	}
	insertRow(left, new String[] {sifra, naziv,naziv1, naziv2,naziv3,naziv4,naziv5,naziv6});
	return left;
	}


public void deleteRow(int index) throws SQLException {
	PreparedStatement stmt =
	DBConnection.getConnection().prepareStatement(
	"DELETE FROM KLIJENT WHERE K_PIB=?");
	String sifra = (String)getValueAt(index, 0);
	stmt.setString(1, sifra);
	//Brisanje iz baze
	int rowsAffected = stmt.executeUpdate();
	stmt.close();
	DBConnection.getConnection().commit();
	if (rowsAffected > 0) {
	// i brisanje iz TableModel-a
	removeRow(index);
	fireTableDataChanged();
	}
	}

	public int updateRow(String sifra, String naziv, String naziv1, String naziv2,
			String naziv3, String naziv4, String naziv5,String naziv6,int index) throws SQLException {
	int retVal = 0;
	PreparedStatement stmt =	DBConnection.getConnection().prepareStatement(
			"UPDATE klijent SET K_NAZIV=?, K_ADRESA=?, K_EMAIL=?, K_WEB=?, K_TELEFON=?, K_FAX=?, K_FIZICKO_LICE_=?"
					+ " WHERE K_PIB=?");
	stmt.setString(8, sifra);
	stmt.setString(1, naziv);
	stmt.setString(2, naziv1);
	stmt.setString(3, naziv2);
	stmt.setString(4, naziv3);
	stmt.setString(5, naziv4);
	stmt.setString(6, naziv5);
	if(naziv6.equals("Da"))
		stmt.setBoolean(7, true);
	else
		stmt.setBoolean(7, false);
			//Unos sloga u bazu
	int rowsAffected = stmt.executeUpdate();
	stmt.close();
	//Unos sloga u bazu
	DBConnection.getConnection().commit();
	
	if (rowsAffected > 0) {
		// i unos u TableModel
		removeRow(index);
		retVal = sortedInsert(sifra,naziv,naziv1,naziv2,naziv3,naziv4,naziv5,naziv6);
		fireTableDataChanged();
		}
		return retVal;
	}

public void search(String where) throws SQLException{
	String basic ="SELECT K_PIB, K_NAZIV, K_ADRESA, K_EMAIL, K_WEB, K_TELEFON, K_FAX, K_FIZICKO_LICE_ FROM KLIJENT";
	String order = "";
	fillData(basic+order+where);
}


}

