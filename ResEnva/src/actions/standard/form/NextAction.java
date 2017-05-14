package actions.standard.form;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import form.StandardForm;

public class NextAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private StandardForm standardForm;

	public NextAction(StandardForm standardForm) {
	//	putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/next.gif")));
		putValue(SHORT_DESCRIPTION, "Sledeci");
		this.standardForm=standardForm;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		next();
	}
	
	public void next() {
		JTable table = standardForm.getTable();
		int index = table.getSelectedRow();
		if(index!=-1){
		if(index==table.getRowCount()-1)
			table.setRowSelectionInterval(0, 0);
		else
			table.setRowSelectionInterval(index++, index++);
		return;
		}
	}
}
