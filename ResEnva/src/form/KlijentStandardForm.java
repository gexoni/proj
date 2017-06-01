package form;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import table.model.KlijentTableModel;
import actions.standard.form.CommitAction;
import actions.standard.form.RollbackAction;

public class KlijentStandardForm extends StandardForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int mode;
	
	private JTextField CompName = new JTextField(20);
	private JTextField ContactName = new JTextField(20);
	private JTextField Address = new JTextField(20);
	private JTextField City = new JTextField(15);
	private JTextField CounReg = new JTextField(15);
	private JTextField ContactTitle = new JTextField(20);
	private JTextField Phone = new JTextField(15);
	private JTextField Email = new JTextField(15);
	private JTextArea Comments = new JTextArea();
	private JTextField NextActivity = new JTextField(20);
	
	
	
	private JButton btnRollback, btnCommit;
	private JTable tblGrid = new JTable(); 
	KlijentTableModel tableModel;
	
	public KlijentStandardForm(){


		setTitle("Klijenti");
		initTable();
		initGui();
		
		
	}
	
	
	
private void initTable(){
		
		
		//Omogućavanje skrolovanja ubacivanjem tabele u ScrollPane
		JScrollPane scrollPane = new JScrollPane(tblGrid);
		add(scrollPane, "grow, wrap");
		// Kreiranje TableModel-a, parametri: header-i kolona i broj redova
		tableModel = new KlijentTableModel(new String[] {"Company Name, Contact , Address, City , Country-Region, Contact Title, Phone Number , E-mail, Comments, Next Activity ",}, 0);
		tblGrid.setModel(tableModel);
		try {
			tableModel.open();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Dozvoljeno selektovanje redova
		tblGrid.setRowSelectionAllowed(true);
		//Ali ne i selektovanje kolona
		tblGrid.setColumnSelectionAllowed(false);
		//Dozvoljeno selektovanje samo jednog reda u jedinici vremena
		tblGrid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblGrid.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					return;
				sync();
			}
		});
	}
	
	
	
	/**
	 * 
	 */
	private void initGui(){
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new MigLayout("fillx"));
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new MigLayout("gapx 15px"));

		JPanel buttonsPanel = new JPanel();
		btnCommit = new JButton(new CommitAction(this));
		btnRollback = new JButton(new RollbackAction(this));


		JLabel lblCompName = new JLabel ("Company Name:");
		JLabel lblContactName = new JLabel("Contact Name:");
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblCity= new JLabel("City:");
		JLabel lblCountry= new JLabel("Country-Region:");
		JLabel lblContactTitle= new JLabel("Contact Title:");
		JLabel lblPhone= new JLabel("Phone Number:");
		JLabel lblEmail= new JLabel("E-mail:");
		JLabel lblComments = new JLabel("Comments:");
		JLabel lblNextActivity = new JLabel("Next Activity:");

		dataPanel.add(lblCompName);
		dataPanel.add(CompName,"wrap");
		
		dataPanel.add(lblContactName);
		dataPanel.add(ContactName,"wrap");
		
		dataPanel.add(lblAddress);
		dataPanel.add(Address,"wrap");
		
		dataPanel.add(lblCity);
		dataPanel.add(City,"wrap");
		
		dataPanel.add(lblCountry);
		dataPanel.add(CounReg,"wrap");
		
		
		dataPanel.add(lblContactTitle);
		dataPanel.add(ContactTitle,"wrap");
		
		dataPanel.add(lblPhone);
		dataPanel.add(Phone,"wrap");
		
		
		dataPanel.add(lblEmail);
		dataPanel.add(Email,"wrap");
		
		dataPanel.add(lblComments);
		dataPanel.add(Comments,"wrap");
		
		dataPanel.add(lblNextActivity);
		dataPanel.add(NextActivity,"wrap");
		
		
		
		
		bottomPanel.add(dataPanel);


		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		buttonsPanel.add(btnRollback);
		bottomPanel.add(buttonsPanel,"dock east");

		add(bottomPanel, "grow, wrap");
		setMode(1);
	}

	@Override
	public JTable getTable() {
		// TODO Auto-generated method stub
		return tblGrid;
	}
	private void sync() {
		int index = tblGrid.getSelectedRow();
		if (index < 0) {
			CompName.setText("");
			ContactName.setText("");
			Address.setText("");
			City.setText("");
			CounReg.setText("");
			ContactTitle.setText("");
			Phone.setText("");
			Email.setText("");
			Comments.setText("");
			NextActivity.setText("");
			
		
		return;
		}
		
		String CompName1 = (String)tableModel.getValueAt(index, 0);
		String naziv = (String)tableModel.getValueAt(index, 1);
		String naziv1 = (String)tableModel.getValueAt(index, 2);
		String naziv2 = (String)tableModel.getValueAt(index, 3);
		String naziv3 = (String)tableModel.getValueAt(index, 4);
		String naziv4 = (String)tableModel.getValueAt(index, 5);
		String naziv5 = (String)tableModel.getValueAt(index, 6);
		String naziv6 = (String)tableModel.getValueAt(index, 7);
		String naziv7 = (String)tableModel.getValueAt(index, 8);
		String naziv8 = (String)tableModel.getValueAt(index, 9);
		
		
		CompName.setText(CompName1);
		ContactName.setText(naziv);
		Address.setText(naziv1);
		City.setText(naziv2);
		CounReg.setText(naziv3);
		ContactTitle.setText(naziv4);
		Phone.setText(naziv5);
		Email.setText(naziv6);
		Comments.setText(naziv7);
		NextActivity.setText(naziv8);
		
	}


	



	@Override
	public int getMode() {
		// TODO Auto-generated method stub
		return mode;
	}
	
	




	@Override
	public void setMode(int mode) {
		// TODO Auto-generated method stub
		if(mode==1){
			this.mode = MODE_EDIT;
			CompName.setEditable(false);
			CompName.setText("");
			ContactName.setText("");
			Address.setText("");
			ContactName.setText("");
			City.setText("");
			CounReg.setText("");
			ContactTitle.setText("");
			Phone.setText("");
			Email.setText("");
			Comments.setText("");
			NextActivity.setText("");
		}
		else if(mode==2){
			this.mode = MODE_ADD;
			CompName.setText("");
			ContactName.setText("");
			Address.setText("");
			ContactName.setText("");
			City.setText("");
			CounReg.setText("");
			ContactTitle.setText("");
			Phone.setText("");
			Email.setText("");
			Comments.setText("");
			NextActivity.setText("");
			
			CompName.setEditable(true);

			CompName.requestFocus();
		}
		else if(mode==3){
			this.mode = MODE_SEARCH;
			CompName.setText("");
			ContactName.setText("");
			Address.setText("");
			ContactName.setText("");
			City.setText("");
			CounReg.setText("");
			ContactTitle.setText("");
			Phone.setText("");
			Email.setText("");
			Comments.setText("");
			NextActivity.setText("");
			CompName.setEditable(true);
			CompName.requestFocus();
		}
		else{
			CompName.setEditable(false);
			ContactName.setEditable(false);
			Address.setEditable(false);
			ContactName.setEditable(false);
			City.setEditable(false);
			CounReg.setEditable(false);
			ContactTitle.setEditable(false);
			Phone.setEditable(false);
			Email.setEditable(false);
			Comments.setEditable(false);
			NextActivity.setEditable(false);
		}
	}


	


	@Override
		public void removeRow() {
			// TODO Auto-generated method stub
			int index = tblGrid.getSelectedRow();
			if (index == -1) //Ako nema selektovanog reda (tabela prazna)
			return; // izlazak
			//kada obrisemo tekuci red, selektovacemo sledeci (newindex):
			int newIndex = index;
			if(JOptionPane.showConfirmDialog(this,
						"Da li ste sigurni?", "Pitanje",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			//sem ako se obrise poslednji red, tada selektujemo prethodni
			if (index == tableModel.getRowCount() - 1)
			newIndex--;
			try {
				KlijentTableModel ktm = (KlijentTableModel)tblGrid.getModel();
				ktm.deleteRow(index);
			if (tableModel.getRowCount() > 0)
			tblGrid.setRowSelectionInterval(newIndex, newIndex);
			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska",
			JOptionPane.ERROR_MESSAGE);
			}
			}
		}



	@Override
	public void addRow() {
		// TODO Auto-generated method stub
	
		
		String Compname = CompName.getText().trim();
		String naziv = ContactName.getText().trim();
		String naziv1 = Address.getText().trim();
		String naziv2 = City.getText().trim();
		String naziv3 = CounReg.getText().trim();
		String naziv4 = ContactTitle.getText().trim();
		String naziv5 = Phone.getText().trim();
		String naziv6 = Email.getText().trim();
		String naziv7 = Comments.getText().trim();
		String naziv8 = NextActivity.getText().trim();
		
		
		
		
		try {
		KlijentTableModel ktm = (KlijentTableModel)tblGrid.getModel();
		int index = ktm.insertRow(Compname,naziv,naziv1,naziv2,naziv3,naziv4,naziv5,naziv6,naziv7, naziv8);
		tblGrid.setRowSelectionInterval(index, index);
		
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(this, ex.getMessage(),
		"Greska", JOptionPane.ERROR_MESSAGE);
		this.setMode(2);
		}
	
		this.setMode(1);
		
	}



	@Override
	public void updateRow() {
		int index = tblGrid.getSelectedRow();
		if (index == -1) //Ako nema selektovanog reda (tabela prazna)
		return;
		String Compname = CompName.getText().trim();
		String naziv = ContactName.getText().trim();
		String naziv1 = Address.getText().trim();
		String naziv2 = City.getText().trim();
		String naziv3 = CounReg.getText().trim();
		String naziv4 = ContactTitle.getText().trim();
		String naziv5 = Phone.getText().trim();
		String naziv6 = Email.getText().trim();
		String naziv7 = Comments.getText().trim();
		String naziv8 = NextActivity.getText().trim();
		
		
		try {
			KlijentTableModel ktm = (KlijentTableModel)tblGrid.getModel();
		int index1 = ktm.updateRow(Compname,naziv,naziv1,naziv2,naziv3,naziv4,naziv5,naziv6,naziv7,naziv8, index);
		tblGrid.setRowSelectionInterval(index1, index1);
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(this, ex.getMessage(),
		"Greska", JOptionPane.ERROR_MESSAGE);
		}
	
	}



	@Override
	public void search() throws SQLException {
		String Compname = CompName.getText().trim();
		String naziv = ContactName.getText().trim();
		String naziv1 = Address.getText().trim();
		String naziv2 = City.getText().trim();
		String naziv3 = CounReg.getText().trim();
		String naziv4 = ContactTitle.getText().trim();
		String naziv5 = Phone.getText().trim();
		String naziv6 = Email.getText().trim();
		String naziv7 = Comments.getText().trim();
		String naziv8 = NextActivity.getText().trim();
		if(!Compname.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE CompanyName='"+Compname+"';");

		}
		else if(!naziv.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE ContactName='"+naziv+"';");

		}
		else if(!naziv1.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE Address='"+naziv1+"';");

		}
		else if(!naziv2.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE City='"+naziv2+"';");

		}
		else if(!naziv3.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE Country/Region='"+naziv3+"';");

		}
		else if(!naziv4.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE ContactTitle="+naziv4+";");

		}
		else if(!naziv5.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE PhoneNumber='"+naziv5+"';");

		}
		else if(!naziv6.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE E-Mail='"+naziv6+"';");
			

		}
		else if(!naziv7.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE Comments='"+naziv7+"';");

		}
		else if(!naziv8.equals("")){
			((KlijentTableModel) getTable().getModel()).search(" WHERE NextActivity='"+naziv8+"';");

		}
		
	}



	@Override
	public void refresh() throws SQLException {
		((KlijentTableModel) getTable().getModel()).open();

		
	}




}
