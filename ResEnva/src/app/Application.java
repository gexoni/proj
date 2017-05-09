package app;

import gui.main.form.MainFrame;

import javax.swing.UIManager;

public class Application {
	
	public static void main (String[] args){
		UIManager.put("OptionPane.yesButtonText", "Yes");
		UIManager.put("OptionPane.noButtonText", "No");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		
		MainFrame.getInstance().setVisible(true);
	}

}
