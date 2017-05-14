/*package actions.standard.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import form.KlijentStandardForm;
import form.StandardForm;



public class NextFormAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private StandardForm standardForm;
	private int index;
	
	public NextFormAction(StandardForm standardForm) {
		putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/nextform.gif")));
		putValue(SHORT_DESCRIPTION, "Sledeća forma");
		this.standardForm  = standardForm;
		
	}
	
	ActionListener al = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String form = ((JMenuItem) e.getSource()).getText();
		index = standardForm.getTable().getSelectedRow();
		if(standardForm instanceof BankaStandardForm){
		String sifra = (String)standardForm.getTable().getValueAt(index, 0);
		String ime = (String)standardForm.getTable().getValueAt(index, 1);
		if(form.equals("Kursna lista")){
			KursnaListaStandardForm forma = new KursnaListaStandardForm();
			try {
				((KursnaListaTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE PIB ="+sifra+" ;");
				forma.setKeyFromBanka(sifra, ime,true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(form.equals("Kurs u valuti")){
			KursUValutiStandardForm forma = new KursUValutiStandardForm();
			try {
				((KursUValutiTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE PIB ="+sifra+" ;");
				forma.setKeyFromBanka(sifra, ime,true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(form.equals("Analitika preseka")){
			AnalitikaPresekaStandardForm forma = new AnalitikaPresekaStandardForm();
			try {
				((AnalitikaPresekaTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE PIB ="+sifra+" ;");
				forma.setKeyFromBanka(sifra, ime,true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(form.equals("Racuni lica")){
			RacuniLicaStandardForm forma = new RacuniLicaStandardForm();
			try {
				((RacuniLicaTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE PIB ="+sifra+" ;");
				forma.setKeyFromBanka(sifra, ime,true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	      }
		if(standardForm instanceof RacuniLicaStandardForm){
			String sifra = (String)standardForm.getTable().getValueAt(index, 1);
			String datum = (String)standardForm.getTable().getValueAt(index, 4);
			if(form.equals("Analitika izvoda")){
				AnalitikaIzvodaStandardForm forma = new AnalitikaIzvodaStandardForm();
				try {
					((AnalitikaIzvodaTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE BAR_RACUN ="+sifra+" ;");
					forma.setKeyFromRacun(sifra,datum,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(form.equals("Prenos izvoda")){
				
				PrenosIzvodaStandardForm forma = new PrenosIzvodaStandardForm();
				try {
					((PrenosIzvodaTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE BAR_RACUN ="+sifra+" ;");
					forma.setKeyFromRacun(sifra,datum,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(form.equals("Dnevno stanje racuna")){
				DnevnoStanjeRacunaStandardForm forma = new DnevnoStanjeRacunaStandardForm();
				try {
					((DnevnoStanjeRacunaTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE BAR_RACUN ="+sifra+" ;");
					forma.setKeyFromRacun(sifra, datum,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
			
	
		if(standardForm instanceof DrzavaStandardForm){
			String sifra = (String)standardForm.getTable().getValueAt(index, 0);
			String ime = (String)standardForm.getTable().getValueAt(index, 1);
			if(form.equals("Valute")){
				ValuteStandardForm forma = new ValuteStandardForm();
				try {
					((ValuteTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE DR_SIFRA ='"+sifra+"' ;");
					forma.setKeyFromDrzava(sifra, ime,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(form.equals("Naseljeno mesto")){
				NaseljenoMestoStandardForm forma = new NaseljenoMestoStandardForm();
				try {
					((NaseljenoMestoTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE naseljeno_mesto.DR_SIFRA ='"+sifra+"' ;");
					forma.setKeyFromDrzava(sifra, ime,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(standardForm instanceof ValuteStandardForm){
			String sifra = (String)standardForm.getTable().getValueAt(index, 2);
			String ime = (String)standardForm.getTable().getValueAt(index, 1);
			if(form.equals("Racuni lica")){
				RacuniLicaStandardForm forma = new RacuniLicaStandardForm();
				try {
					((RacuniLicaTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE VA_IFRA ="+sifra+" ;");
					forma.setKeyFromValuta(sifra, ime,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(form.equals("Analitika izvoda")){
				AnalitikaIzvodaStandardForm forma = new AnalitikaIzvodaStandardForm();
				try {
					((AnalitikaIzvodaTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE VA_IFRA ="+sifra+";");
					forma.setKeyFromValuta(sifra, ime,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(form.equals("Kurs u valuti (osnovna valuta)")){
				KursUValutiStandardForm forma = new KursUValutiStandardForm();
				try {
					((KursUValutiTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE VA_IFRA ="+sifra+";");
					forma.setKeyFromValuta(sifra, ime,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(form.equals("Kurs u valuti (prema valuti)")){
				KursUValutiStandardForm forma = new KursUValutiStandardForm();
				try {
					((KursUValutiTableModel) forma.getTable().getModel()).
					openAsChildForm(" WHERE VAL_VA_IFRA ="+sifra+";");
					forma.setKeyFromValuta1(sifra, ime,true);
					forma.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	};
	

	@Override
	public void actionPerformed(ActionEvent e) {
		index = standardForm.getTable().getSelectedRow();
		JPopupMenu popup = new JPopupMenu();

		if(index>=0){
		if(standardForm instanceof BankaStandardForm){
			JMenuItem m = new JMenuItem("Kursna lista");
		    m.addActionListener(al);
		    popup.add(m);
		    JMenuItem m1 = new JMenuItem("Kurs u valuti");
		    m1.addActionListener(al);
		    popup.add(m1);
		    JMenuItem m2 = new JMenuItem("Analitika preseka");
		    m2.addActionListener(al);
		    popup.add(m2);
		    JMenuItem m3 = new JMenuItem("Racuni lica");
		    m3.addActionListener(al);
		    popup.add(m3);
		    popup.show(standardForm.getBtnNextForm(),0,0);
			
		}
		else if(standardForm instanceof NaseljenoMestoStandardForm){
			index = standardForm.getTable().getSelectedRow();
			String sifra = (String)standardForm.getTable().getValueAt(index, 3);
			String ime = (String)standardForm.getTable().getValueAt(index, 2);
			AnalitikaIzvodaStandardForm forma = new AnalitikaIzvodaStandardForm();
			try {
				((AnalitikaIzvodaTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE NM_SIFRA ="+sifra+" ;");
				forma.setKeyFromNaseljenoMesto(sifra, ime,true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(standardForm instanceof DrzavaStandardForm){
			   JMenuItem m2 = new JMenuItem("Naseljeno mesto");
			    m2.addActionListener(al);
			    popup.add(m2);
			    JMenuItem m3 = new JMenuItem("Valute");
			    m3.addActionListener(al);
			    popup.add(m3);
			    popup.show(standardForm.getBtnNextForm(),0,0);
		}
		else if(standardForm instanceof ValuteStandardForm){
			   JMenuItem m2 = new JMenuItem("Racuni lica");
			    m2.addActionListener(al);
			    popup.add(m2);
			    JMenuItem m3 = new JMenuItem("Analitika izvoda");
			    m3.addActionListener(al);
			    popup.add(m3);
			    JMenuItem m4 = new JMenuItem("Kurs u valuti (osnovna valuta)");
			    m4.addActionListener(al);
			    popup.add(m4);
			    JMenuItem m5 = new JMenuItem("Kurs u valuti (prema valuti)");
			    m5.addActionListener(al);
			    popup.add(m5);
			    popup.show(standardForm.getBtnNextForm(),0,0);
		}
		else if(standardForm instanceof KursnaListaStandardForm){
			index = standardForm.getTable().getSelectedRow();
			String sifra = (String)standardForm.getTable().getValueAt(index, 1);
			KursUValutiStandardForm forma = new KursUValutiStandardForm();
			try {
				((KursUValutiTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE KL_DATUM ="+sifra+" ;");
				forma.setKeyFromKursnaLista(sifra,true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(standardForm instanceof RacuniLicaStandardForm){
			   JMenuItem m2 = new JMenuItem("Prenos izvoda");
			    m2.addActionListener(al);
			    popup.add(m2);
			    JMenuItem m3 = new JMenuItem("Analitika izvoda");
			    m3.addActionListener(al);
			    popup.add(m3);
			    JMenuItem m4 = new JMenuItem("Dnevno stanje racuna");
			    m4.addActionListener(al);
			    popup.add(m4);
			   
			    popup.show(standardForm.getBtnNextForm(),0,0);
		}
		else if(standardForm instanceof KlijentStandardForm){
			index = standardForm.getTable().getSelectedRow();
			String sifra = (String)standardForm.getTable().getValueAt(index, 0);
			String naziv = (String)standardForm.getTable().getValueAt(index, 1);

			RacuniLicaStandardForm forma = new RacuniLicaStandardForm();
			try {
				((RacuniLicaTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE K_PIB ="+sifra+" ;");
				forma.setKeyFromValuta1(sifra,naziv,true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(standardForm instanceof PrenosIzvodaStandardForm){
			index = standardForm.getTable().getSelectedRow();
			String pib = (String)standardForm.getTable().getValueAt(index, 0);
			String racun = (String)standardForm.getTable().getValueAt(index, 1);
			String datum = (String)standardForm.getTable().getValueAt(index, 2);
			String presek = (String)standardForm.getTable().getValueAt(index, 3);
			
			AnalitikaPresekaStandardForm forma = new AnalitikaPresekaStandardForm();
			try {
				((AnalitikaPresekaTableModel) forma.getTable().getModel()).
				openAsChildForm(" WHERE PIB ="+pib+" AND"
						+ " PRE_BAR_RACUN="+racun+" AND"
								+ ""
										+ " BNP_PRESEK="+presek+";");
				forma.setKeyFromPrenosIzvoda(pib,racun,datum,presek,"",true);
				forma.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		}
	}
	}
	
	
		
		
		
	
	
	
	



	*/