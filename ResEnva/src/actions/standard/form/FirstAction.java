package actions.standard.form;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import form.StandardForm;


public class FirstAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private StandardForm standardForm;

	public FirstAction(StandardForm standardForm) {
	//	putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/first.gif")));
		putValue(SHORT_DESCRIPTION, "Pocetak");
		this.standardForm=standardForm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		first();
	}
	
	public void first(){
		JTable table = standardForm.getTable();
		int index = table.getSelectedRow();
		if(index!=-1){
			table.setRowSelectionInterval(0,0);
		return;
		}
	}
}
