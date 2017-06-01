package form;


import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JToolBar;

import actions.standard.form.AddAction;
import actions.standard.form.DeleteAction;
import actions.standard.form.FirstAction;
import actions.standard.form.HelpAction;
import actions.standard.form.LastAction;
import actions.standard.form.NextAction;
import actions.standard.form.PreviousAction;
import actions.standard.form.RefreshAction;
import actions.standard.form.SearchAction;
import gui.main.form.MainFrame;
import net.miginfocom.swing.MigLayout;

public abstract class StandardForm extends JFrame {
	
	protected static final int MODE_EDIT = 1;
	protected static final int MODE_ADD = 2;
	protected static final int MODE_SEARCH = 3;
	
	
	public abstract  int getMode() ;
	public abstract void setMode(int mode);
	
	private JToolBar toolBar;
	private JButton btnAdd, btnDelete, btnFirst, btnLast, btnHelp, btnNext, btnNextForm,
	btnPickup, btnRefresh,  btnSearch, btnPrevious;
	public JButton getBtnNextForm() {
		return btnNextForm;
	}

	public JButton btnZoom;
	public boolean pickup;
	public String key;
	public StandardForm callerForm;

	
	public StandardForm getCallerForm() {
		return callerForm;
	}


	public void setCallerForm(StandardForm callerForm) {
		this.callerForm = callerForm;
	}

	
	public abstract void removeRow();
	public abstract void addRow();
	public abstract void updateRow();
	public abstract void search() throws SQLException;
	public abstract void refresh() throws SQLException;

	
	
	public void setPickup(boolean pickup) {
		this.pickup = pickup;
	}


	public boolean isPickup() {
		return pickup;
	}


	public abstract JTable getTable();


	public StandardForm(){
		setLayout(new MigLayout("fill"));
		setSize(new Dimension(1024, 1000));
		setLocationRelativeTo(MainFrame.getInstance());
		
		
		initToolbar();
	}
	
	
	
	
	
	private void initToolbar(){

		toolBar = new JToolBar();
		btnSearch = new JButton(new SearchAction(this));
		toolBar.add(btnSearch);
		try {
			ImageIcon img = new ImageIcon(ImageIO.read(new File("img/resenva.jpg")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		btnRefresh = new JButton(new RefreshAction(this));
		toolBar.add(btnRefresh);


		//btnHelp = new JButton(new HelpAction());
		//toolBar.add(btnHelp);

		toolBar.addSeparator();

		btnFirst = new JButton(new FirstAction(this));
		toolBar.add(btnFirst);

		btnPrevious = new JButton(new PreviousAction(this));
		toolBar.add(btnPrevious);

		btnNext = new JButton(new NextAction(this));
		toolBar.add(btnNext);

		btnLast = new JButton(new LastAction(this));
		toolBar.add(btnLast);

		toolBar.addSeparator();


		btnAdd = new JButton(new AddAction(this));
		toolBar.add(btnAdd);

		btnDelete = new JButton(new DeleteAction(this));
		toolBar.add(btnDelete);

		toolBar.addSeparator();

		
		

		add(toolBar, "dock north");
		
		
	}
	
	
	

	
	

}
