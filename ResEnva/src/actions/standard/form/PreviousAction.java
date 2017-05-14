package actions.standard.form;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import form.StandardForm;

public class PreviousAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private StandardForm standardForm;

	public PreviousAction(StandardForm standardForm) {
		//putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/prev.gif")));
		putValue(SHORT_DESCRIPTION, "Prethodni");
		this.standardForm=standardForm;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		previous();
	}
	
	public void previous() {
		JTable table = standardForm.getTable();
		int index = table.getSelectedRow();
		if(index!=-1){
		if(index==0)
			table.setRowSelectionInterval(table.getRowCount()-1,table.getRowCount()-1);
		else
			table.setRowSelectionInterval(index--, index--);
		return;
		}
	}
}
