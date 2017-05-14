package actions.standard.form;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import form.*;
import form.StandardForm;


public class PickupAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private StandardForm standardForm;
	private String sifra;
	private StandardForm zoom;
	
	public String getSifra() {
		return sifra;
	}

	public PickupAction(StandardForm standardForm) {
	//	putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/zoom-pickup.gif")));
		putValue(SHORT_DESCRIPTION, "Zoom pickup");
		this.standardForm = standardForm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int index = standardForm.getTable().getSelectedRow();
		if(index>=0){
		zoom = standardForm.getCallerForm();
		if(zoom!=null){
		if(standardForm instanceof KlijentStandardForm){
			String sifra = (String)standardForm.getTable().getValueAt(index, 0);
			String name=(String)standardForm.getTable().getValueAt(index, 1);
			zoom.setKeyFromKlijent(sifra,name);
		}
		
		
		standardForm.setPickup(true);
		standardForm.dispose();
		zoom.setVisible(true);
		
		}
		}
	}
}
