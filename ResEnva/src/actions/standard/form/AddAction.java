package actions.standard.form;

import form.StandardForm;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;



public class AddAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	//kada se napravi genericka forma, staviti tu klasu umesto JDialog
	private StandardForm standardForm;
	
	public AddAction(StandardForm standardForm) {
		putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/add.gif")));
		putValue(SHORT_DESCRIPTION, "ADD NEW");
		this.standardForm=standardForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		standardForm.setMode(2);
		standardForm.getTable().clearSelection();
		
	}
}
