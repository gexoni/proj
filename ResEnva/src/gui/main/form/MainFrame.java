package gui.main.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		setBackground(Color.lightGray);
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
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); //2016/11/16
		
	}

	private void setUpMenu(){
		menuBar = new JMenuBar();
		JMenu Meni = new JMenu("Clients");
		JMenuItem ClientList = new JMenuItem("Water Data Clients");
		JButton UpcomingEvent = new JButton("Upcoming Events");
		ClientList.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KlijentStandardForm form = new KlijentStandardForm();
				form.setVisible(true);
			}
		});
		JMenuItem eeClients = new JMenuItem("EE - Clients");
		JMenuItem bioClients = new JMenuItem("Bio - Clients");
		JMenuItem hydroClients = new JMenuItem("Hydro - Clients");
		JMenuItem RESClients = new JMenuItem("RES - Clients");
		JMenuItem tourisamClients = new JMenuItem("Tourisam - Clients");
		JMenuItem itClients = new JMenuItem("IT/Telekom - Clients");
		JMenuItem smeClients = new JMenuItem("SME- Clients");
		JMenuItem mediaClients = new JMenuItem("Media - Clients");
		JMenuItem solarnaClients = new JMenuItem("Solar Walley - Clients");
		JMenuItem wasteCl = new JMenuItem("Waste - Clients");
		JMenuItem institutionsCl = new JMenuItem("Institutions");
		
		Meni.addSeparator();

		Meni.add(ClientList);
		Meni.addSeparator();
		Meni.add(eeClients);
		Meni.addSeparator();
		Meni.add(bioClients);
		Meni.addSeparator();
		Meni.add(hydroClients);
		Meni.addSeparator();
		Meni.add(RESClients);
		Meni.addSeparator();
		Meni.add(tourisamClients);
		Meni.addSeparator();
		Meni.add(itClients);
		Meni.addSeparator();
		Meni.add(smeClients);
		Meni.addSeparator();
		Meni.add(mediaClients);
		Meni.addSeparator();
		Meni.add(solarnaClients);
		Meni.addSeparator();
		Meni.add(wasteCl);
		Meni.addSeparator();
		Meni.add(institutionsCl);
		Meni.addSeparator();
		menuBar.add(Meni);
		menuBar.add(UpcomingEvent);
		
		
		
	}
	

	public static MainFrame getInstance(){
		if (instance==null)
			instance=new MainFrame();
		return instance;

	}

	
	
}