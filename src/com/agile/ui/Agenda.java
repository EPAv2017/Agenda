package com.agile.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class Agenda {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JWindow splash = new JWindow();
			Container container = splash.getContentPane();
			container.add(new JLabel("", new ImageIcon(new URL("http://www.midorax.ro/uploads/produse/mare/14270574597794786.jpg")), SwingConstants.CENTER));
			splash.setBounds(500, 150, 375, 375);
			splash.setVisible(true);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			splash.setVisible(false);
			Agenda window = new Agenda();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(536, 420);
		shell.setText("Agenda telefonica");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");

		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);

		final MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.setText("Open");
		mntmOpen.setEnabled(false);

		final MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setText("Save");
		mntmSave.setEnabled(false);

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText("Exit");

		final MenuItem mntmAbonati = new MenuItem(menu, SWT.CASCADE);
		mntmAbonati.setText("Abonati");
		mntmAbonati.setEnabled(false);
		
		Menu menu_2 = new Menu(mntmAbonati);
		mntmAbonati.setMenu(menu_2);

		MenuItem mntmAdauga = new MenuItem(menu_2, SWT.NONE);
		mntmAdauga.setText("Adauga");

		MenuItem mntmCauta = new MenuItem(menu_2, SWT.NONE);
		mntmCauta.setText("Cauta");

		MenuItem mntmSterge = new MenuItem(menu_2, SWT.NONE);
		mntmSterge.setText("Sterge");

		MenuItem mntmModifica = new MenuItem(menu_2, SWT.NONE);
		mntmModifica.setText("Modifica");

		final MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");

		Menu menu_3 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_3);

		MenuItem mntmInregistrare = new MenuItem(menu_3, SWT.NONE);
		mntmInregistrare.setText("Inregistrare");

		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmAbout = new MenuItem(menu, SWT.NONE);
		mntmAbout.setText("About");
		
		ScrolledForm scrldfrmListingabonati = formToolkit.createScrolledForm(shell);
		scrldfrmListingabonati.setBounds(36, 37, 456, 297);
		formToolkit.paintBordersFor(scrldfrmListingabonati);
		scrldfrmListingabonati.setText("Abonati");
		
		table = new Table(scrldfrmListingabonati.getBody(), SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(20, 10, 404, 244);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNume = new TableColumn(table, SWT.NONE);
		tblclmnNume.setWidth(100);
		tblclmnNume.setText("Nume");
		
		TableColumn tblclmnPrenume = new TableColumn(table, SWT.NONE);
		tblclmnPrenume.setWidth(100);
		tblclmnPrenume.setText("Prenume");

		TableColumn tblclmnCnp = new TableColumn(table, SWT.NONE);
		tblclmnCnp.setWidth(100);
		tblclmnCnp.setText("CNP");
		
		TableColumn tblclmnNrtelefon = new TableColumn(table, SWT.NONE);
		tblclmnNrtelefon.setWidth(100);
		tblclmnNrtelefon.setText("Nr.Telefon");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		formToolkit.adapt(tableCursor);
		formToolkit.paintBordersFor(tableCursor);

		//on INREGISTRARE
		mntmInregistrare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JPanel inregistrare = new JPanel();
				JPanel labels = new JPanel(new GridLayout(0,1,2,2));
				labels.add(new JLabel("Cod inregistrare", SwingConstants.RIGHT));
				inregistrare.add(labels, BorderLayout.WEST);
				JPanel controls = new JPanel(new GridLayout(0,1,2,2));
			    JPasswordField codInregistrare = new JPasswordField(15);
			    controls.add(codInregistrare);
			    inregistrare.add(controls, BorderLayout.CENTER);
			    int result = JOptionPane.showConfirmDialog(null, inregistrare, "Inregistrare", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) {
			    	char [] parola = codInregistrare.getPassword();
			    	if(parola[0] == 'c' && parola[1] == 'o' && parola[2] == 'd' && parola[3] == '@') {
//					if(codInregistrare.getPassword().equals("codInregistrare")) {
						mntmOpen.setEnabled(true);
						mntmSave.setEnabled(true);
						mntmAbonati.setEnabled(true);
						mntmHelp.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(inregistrare, "Cod de inregistrare invalid!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		//on EXIT
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Doriti sa parasiti aplicatia?", "EXIT", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}

}
