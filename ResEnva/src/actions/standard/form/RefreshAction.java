package actions.standard.form;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import form.StandardForm;

public class RefreshAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private StandardForm standardForm;

	public RefreshAction(StandardForm standardForm) {
	//	putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/img/refresh.gif")));
		putValue(SHORT_DESCRIPTION, "Refresh");
		this.standardForm = standardForm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			standardForm.refresh();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
