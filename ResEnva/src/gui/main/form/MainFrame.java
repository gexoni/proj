package gui.main.form;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import form.KlijentStandardForm;



public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static MainFrame instance;
	private JMenuBar menuBar;

	public MainFrame(){

		setSize(new Dimension(800,600));
		setLocationRelativeTo(null);
		setTitle("ResEnva");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//setExtendedState(MAXIMIZED_BOTH);
		 try {
			 ImageIcon img = new ImageIcon(ImageIO.read(new File("img/resenva.jpg")));
			this.setContentPane(new JLabel(img));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setUpMenu();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(MainFrame.getInstance(),
						"Are You sure?", "!!!",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					/*
					 * Zatvori konekciju
					 */
				//	DBConnection.close(); !!!
					System.exit(0);
				}
			}
		});
		
		setJMenuBar(menuBar);

	}

	private void setUpMenu(){
		menuBar = new JMenuBar();

		JButton ClientList = new JButton("Client List");
		JButton UpcomingEvent = new JButton("Upcoming Events");
		ClientList.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KlijentStandardForm form = new KlijentStandardForm();
				form.setVisible(true);
			}
		});
		

		menuBar.add(ClientList);
		menuBar.add(UpcomingEvent);
		
		
		
	}



	public static MainFrame getInstance(){
		if (instance==null)
			instance=new MainFrame();
		return instance;

	}

}