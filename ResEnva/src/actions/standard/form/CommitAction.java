package actions.standard.form;


import form.StandardForm;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;



public class CommitAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private StandardForm standardForm;
	
	public CommitAction(StandardForm standardForm) {
		putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/commit.gif")));
		putValue(SHORT_DESCRIPTION, "Commit");
		this.standardForm=standardForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(standardForm.getMode()==3){
			try {
				standardForm.search();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			standardForm.setMode(1);
		}
		else if(standardForm.getMode()==2) {
			standardForm.addRow();
		}
		else {
			standardForm.updateRow();

		}
	}
}

