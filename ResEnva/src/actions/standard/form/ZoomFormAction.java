/*package actions.standard.form;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import form.StandardForm;


public class ZoomFormAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	
	String tableToOpen;
	int indexOfCallerColumn; 
	int indexOfRow; 
	private StandardForm standardForm;
	private StandardForm ZoomForm;
	private String sifra;


	public ZoomFormAction(StandardForm standardForm,StandardForm ZoomForm) {
		putValue(SHORT_DESCRIPTION, "Zoom");
		putValue(NAME, "...");
		this.form = form;
		this.tableToOpen = tableToOpen;
		this.ZoomForm=ZoomForm;
		this.standardForm = standardForm;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {		
			StandardForm form = MainFrame.getFormInstanceByTableName(tableToOpen);
			form.setTheCallerForm(this.form);
			form.setIndexOfCallerColumn(indexOfCallerColumn);
			form.setVisible(true);
			
		
		
		
			standardForm.getTable().clearSelection();
			ZoomForm.setCallerForm(standardForm);
		
			ZoomForm.setVisible(true);
			
		
	}

}*/